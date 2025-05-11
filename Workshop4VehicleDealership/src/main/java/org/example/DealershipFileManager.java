package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



    public class DealershipFileManager {

        public static List<Vehicle> getDealership() {

            try {java.io.FileReader fileReader = new java.io.FileReader("src/main/resources/vehicle.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // skip the first line (if there's a header, otherwise remove this line)
                bufferedReader.readLine();

                String input;
                List<Vehicle> vehicles = new ArrayList<>();

                while ((input = bufferedReader.readLine()) != null) {
                    String[] row = input.split("\\|");

                    int vin = Integer.parseInt(row[0]);
                    int year = Integer.parseInt(row[1]);
                    String make = row[2];
                    String model = row[3];
                    VehicleType type = VehicleType.fromString(row[4]);
                    String color = row[5];
                    int odometer = Integer.parseInt(row[6]);
                    double price = Double.parseDouble(row[7]);

                    Vehicle vehicle = new Vehicle(color, make, model, odometer, price, type, vin, year);
                    vehicles.add(vehicle);
                }

                bufferedReader.close();
                return vehicles;
            } catch (IOException ex) {
                System.out.println("Failed to load csv file: " + ex.getMessage());
                return new ArrayList<>();
            }
        }

        public static List<Vehicle> saveDealership() {
            return null;
        }
    }











