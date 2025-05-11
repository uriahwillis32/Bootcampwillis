package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
        private String name;
        private String address;
        private String phone;
        private ArrayList<Vehicle> vehicles;


        public Dealership(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.vehicles = new ArrayList<>();
        }


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


        public ArrayList<Vehicle> getAllVehicles() {
            return vehicles;
        }


        public void removeVehicle(int vin) {

        }


        public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
            return null;
        }


        public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
            return null;
        }


        public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
            return null;
        }


        public ArrayList<Vehicle> getVehiclesByColor(String color) {
            return null;
        }


        public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
            return null;
        }


        public ArrayList<Vehicle> getVehiclesByType(String type) {
            return null;
        }


    }









