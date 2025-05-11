package org.example;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private VehicleType vehicleType;
    private String color;
    private int odometer;
    private double price;


    public Vehicle(String color, String make, String model, int odometer, double price,  VehicleType vehicleType, int vin, int year) {
        this.color = color;
        this.make = make;
        this.model = model;
        this.odometer = odometer;
        this.price = price;
        this.vehicleType = vehicleType;
        this.vin = vin;
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%d|%d|%s|%s|%s|%s|%,d|%,.2f",
                vin,
                year,
                make,
                model,
                vehicleType,
                color,
                odometer,
                price);
    }
}

