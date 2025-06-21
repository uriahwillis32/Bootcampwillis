package org.example.VehicleClasses;

import org.example.DAO.VehicleDAO;

import java.util.List;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;
    private  final VehicleDAO vehicleDao;


    public Dealership(String address, String name, String phone, VehicleDAO vehicleDao) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.vehicleDao = vehicleDao;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return vehicleDao.getVehiclesByPrice(min, max);
    }

    public List<Vehicle> getVehiclesByMakeAndModel(String make, String model) {
        return vehicleDao.getVehiclesByMakeModel(make, model);
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return vehicleDao.getVehiclesByYear(min, max);
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return vehicleDao.getVehiclesByColor(color);
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        return vehicleDao.getVehiclesByMileage((int) min, (int) max);
    }

    public List<Vehicle> getVehiclesByType(String type) {
        return vehicleDao.getVehiclesByType(type);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleDao.addVehicle(vehicle.getVin(), vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleDao.removeVehicle(vehicle.getVin());
    }

    public Vehicle getVehicleByVin(int vin) {
        return vehicleDao.getVehicleByVin(vin);
    }
}
