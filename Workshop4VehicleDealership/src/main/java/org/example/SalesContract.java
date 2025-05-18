package org.example;

public class SalesContract extends Contract{
    private boolean finance;

    public SalesContract(String customerEmail, String customerName, String date, Vehicle vehicle, boolean finance) {
        super(customerEmail, customerName, date, vehicle);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    @Override
    public double getTotalPrice(){
        double processingFee = 0;
        double price = getVehicle().getPrice();

        if (price < 10000){
            processingFee = 295.00;
        } else if (price >= 10000) {
            processingFee = 495.00;
        }
        double salesTax = getVehicle().getPrice() * 0.05;
        double recordingFee = 100.00;

        return getVehicle().getPrice() + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance){
            return 0;
        }
        double price = getTotalPrice();
        double interestRate;
        int loanTermMonths;

        if (price >= 10000) {
            interestRate = 0.0425;
            loanTermMonths = 48;
        } else {
            interestRate = 0.0525;
            loanTermMonths = 24;
        }
        double monthlyRate = interestRate / 12;


        double monthlyPayment = (price * (1 + interestRate)) / loanTermMonths;
        return Math.round(monthlyPayment * 100.0) / 100.0;
    }
}
