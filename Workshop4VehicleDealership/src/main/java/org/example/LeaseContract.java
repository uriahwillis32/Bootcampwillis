package org.example;

public class LeaseContract extends Contract{

    public LeaseContract(String customerEmail, String customerName, String date, Vehicle vehicle) {
        super(customerEmail, customerName, date, vehicle);
    }

    @Override
    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double endingValue = price * 0.5;
        double leaseFee = price * 0.07;

        return endingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double total = getTotalPrice();
        double interestRate = 0.04;
        int leaseTermMonths = 36;

        double monthlyRate = interestRate / 12;
        return total * (monthlyRate * Math.pow(1 + monthlyRate, leaseTermMonths)) /
                (Math.pow(1 + monthlyRate, leaseTermMonths) - 1);
    }
}
