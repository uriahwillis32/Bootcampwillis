package org.example.DataManagers;

import org.example.VehicleClasses.Dealership;
import org.example.VehicleClasses.Vehicle;
import org.example.VehicleClasses.VehicleType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    private static final String FILE_PATH = "src/main/resources/inventory.csv";

    public static List<Vehicle> getDealership() {
        List<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            bufferedReader.readLine(); // Skip header

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] row = input.split("\\|");

                try {
                    int vin = Integer.parseInt(row[0].trim());
                    int year = Integer.parseInt(row[1].trim());
                    String make = row[2].trim();
                    String model = row[3].trim();
                    VehicleType type = VehicleType.valueOf(row[4].trim().toUpperCase());
                    String color = row[5].trim();
                    int odometer = Integer.parseInt(row[6].trim());
                    double price = Double.parseDouble(row[7].trim());

                    Vehicle vehicle = new Vehicle(color, make, model, odometer, price, type, vin, year);
                    vehicles.add(vehicle);
                } catch (Exception ex) {
                    System.out.println("Skipping malformed row: " + input);
                }
            }

        } catch (IOException ex) {
            System.out.println("Failed to load csv file: " + ex.getMessage());
        }

        return vehicles;
    }

    public static void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {

            writer.println("VIN|Year|Make|Model|Type|Color|Odometer|Price");

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
            }

            System.out.println("Inventory saved successfully.");
        } catch (IOException ex) {
            System.out.println("Error saving dealership file: " + ex.getMessage());
        }
    }
}
