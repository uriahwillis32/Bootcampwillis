
package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);


    public UserInterface() {
        init();
    }



    public void display() {
        init();

        int choice;
        boolean on = true;
        while (on) {
            System.out.println("\n \\Welcome to D & B's Used Cars!\\");
            System.out.println("\n Loading Main Menu...");
            System.out.println("1) Find vehicles within a price range ");
            System.out.println("2) Find vehicles by make/model ");
            System.out.println("3) Find vehicles by year range ");
            System.out.println("4) Find vehicles by color ");
            System.out.println("5) Find vehicles by mileage range ");
            System.out.println("6) Find vehicles by type (Truck, SUV, Sedan) ");
            System.out.println("7) List ALL vehicles ");
            System.out.println("8) Add a vehicle ");
            System.out.println("9) Remove a vehicle ");
            System.out.println("10) Exit ");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // TODO: price range search
                    break;
                case 2:
                    // TODO: make/model search
                    break;
                case 3:
                    // TODO: year range search
                    break;
                case 4:
                    // TODO: color search
                    break;
                case 5:
                    // TODO: mileage range search
                    break;
                case 6:
                    // TODO: vehicle type search
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    // TODO: add vehicle
                    break;
                case 9:
                    // TODO: remove vehicle
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    on = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            displayVehicles(vehicles);

        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        System.out.println(" Year | Make | Model | VehicleType | Color | Odometer | Price ");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest() {

    }

    private void processGetByMakeModelRequest() {

    }

    private void processGetByYearRequest() {

    }

    private void processGetByColorRequest() {

    }

    private void processGetByMileageRequest() {

    }

    private void processGetByVehicleTypeRequest() {

    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }


    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        List<Vehicle> vehicles = DealershipFileManager.getDealership();  // load from CSV
        this.dealership = new Dealership("D & B's Used Cars", "123 Main St", "555-1234");

        for (Vehicle vehicle : vehicles) {
            this.dealership.addVehicle(vehicle);
        }
    }
}



