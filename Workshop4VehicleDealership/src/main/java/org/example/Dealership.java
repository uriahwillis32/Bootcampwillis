package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String address;
    private List<Vehicle> inventory;
    private String name;
    private String phone;

    public Dealership(String address, List<Vehicle> inventory, String name, String phone) {
        this.address = address;
        this.inventory = inventory;
        this.name = name;
        this.phone = phone;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }


    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> matchingVehiclesPrice = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                matchingVehiclesPrice.add(vehicle);
            }
        }
        return matchingVehiclesPrice;
    }


    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchingVehiclesMakeModel = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehiclesMakeModel.add(vehicle);
            }
        }
        return matchingVehiclesMakeModel;
    }


    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> matchingVehiclesYear = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                matchingVehiclesYear.add(vehicle);
            }
        }
        return matchingVehiclesYear;
    }


    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> matchingVehiclesColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matchingVehiclesColor.add(vehicle);
            }
        }
        return matchingVehiclesColor;
    }


    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> matchingVehiclesMileage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matchingVehiclesMileage.add(vehicle);
            }
        }
        return matchingVehiclesMileage;
    }


    public List<Vehicle> getVehiclesByType(String typeStr) {
        List<Vehicle> matchingVehiclesType = new ArrayList<>();
        VehicleType type;

        try {
            type = VehicleType.valueOf(typeStr.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return matchingVehiclesType;
        }

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType() == type) {
                matchingVehiclesType.add(vehicle);
            }
        }

        return matchingVehiclesType;
    }

    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }


    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        DealershipFileManager.saveDealership(this);
    }


    public void removeVehicle(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                inventory.remove(vehicle);
                DealershipFileManager.saveDealership(this);
            }
        }
    }


    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
        DealershipFileManager.saveDealership(this);
    }
}
