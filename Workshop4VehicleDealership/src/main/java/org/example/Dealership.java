package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
        private String name;
        private String address;
        private String phone;
        private ArrayList<Vehicle> vehicles;

        // Constructor
        public Dealership(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.vehicles = new ArrayList<>();
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        // Add a vehicle to inventory
        public void addVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
        }

        // Get all vehicles in inventory
        public ArrayList<Vehicle> getAllVehicles() {
            return vehicles;
        }

        // Stub: remove a vehicle by VIN
        public void removeVehicle(int vin) {

        }

        // Stub: search vehicles by price range
        public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
            return null;
        }

        // Stub: search vehicles by make and model
        public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
            return null;
        }

        // Stub: search vehicles by year range
        public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
            return null;
        }

        // Stub: search vehicles by color
        public ArrayList<Vehicle> getVehiclesByColor(String color) {
            return null;
        }

        // Stub: search vehicles by mileage range
        public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
            return null;
        }

        // Stub: search vehicles by type
        public ArrayList<Vehicle> getVehiclesByType(String type) {
            return null;
        }


    }









