package org.example.ContractFolder;

import org.example.VehicleClasses.Vehicle;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;

    public Contract(String customerEmail, String customerName, String date, Vehicle vehicle) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.date = date;
        this.vehicle = vehicle;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
}
