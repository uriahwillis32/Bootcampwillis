
package org.example.Interface;

import org.example.ContractFolder.Contract;
import org.example.ContractFolder.LeaseContract;
import org.example.ContractFolder.SalesContract;
import org.example.DAO.VehicleDAO;
import org.example.DataManagers.ContractDataManager;
import org.example.DataManagers.DealershipFileManager;
import org.example.VehicleClasses.Dealership;
import org.example.VehicleClasses.Vehicle;
import org.example.VehicleClasses.VehicleType;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        init();
    }

    public UserInterface(String connectionString, String dbUsername, String dbPassword) {
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
            System.out.println("7) List all vehicles ");
            System.out.println("8) Add a vehicle ");
            System.out.println("9) Remove a vehicle ");
            System.out.println("10) Sell or Lease vehicle");
            System.out.println("11) Exit ");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    processGetByPriceRequest(scanner);
                    break;
                case 2:
                    processGetByMakeModelRequest(scanner);
                    break;
                case 3:
                    processGetByYearRequest(scanner);
                    break;
                case 4:
                    processGetByColorRequest(scanner);
                    break;
                case 5:
                    processGetByMileageRequest(scanner);
                    break;
                case 6:
                    processGetByVehicleTypeRequest(scanner);
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest(scanner);
                    break;
                case 9:
                    processRemoveVehicleRequest(scanner);
                    break;
                case 10:
                    sellOrLeaseVehicle(scanner);
                    break;
                case 11:
                    DealershipFileManager.saveDealership(dealership);
                    System.out.println("Goodbye!");
                    on = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            displayVehicles(vehicles);
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        System.out.println(" VIN |Year | Make | Model | VehicleType | Color | Odometer | Price ");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void init() {
        VehicleDAO vehicleDao = new VehicleDAO(
                "jdbc:mysql://localhost:3306/dealership",
                "yourUsername",
                "yourPassword"
        );

        this.dealership = new Dealership(
                "D & B's Used Cars",
                "123 Main St",
                "555-123-4567",
                vehicleDao
        );
    }

    private void processGetByPriceRequest(Scanner scanner) {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        displayVehicles(results);
    }

    private void processGetByMakeModelRequest(Scanner scanner) {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByMakeAndModel(make, model);
        displayVehicles(results);
    }

    private void processGetByYearRequest(Scanner scanner) {
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> results = dealership.getVehiclesByYear(min, max);
        displayVehicles(results);
    }

    private void processGetByColorRequest(Scanner scanner) {
        System.out.print("Enter color: ");

        String color = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);
    }

    private void processGetByMileageRequest(Scanner scanner) {
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        displayVehicles(results);
    }

    private void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.print("Enter vehicle type (TRUCK, SUV, SEDAN): ");
        String type = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByType(type);
        if (results.isEmpty()) {
            System.out.println("No vehicles found for that type.");
        } else {
            displayVehicles(results);
        }
    }

    private void processAddVehicleRequest(Scanner scanner) {
        try {
            System.out.print("VIN: ");
            int vin = Integer.parseInt(scanner.nextLine());
            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Make: ");
            String make = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Vehicle type (TRUCK, SUV, SEDAN): ");
            VehicleType type = VehicleType.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Odometer: ");
            int odometer = Integer.parseInt(scanner.nextLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Vehicle vehicle = new Vehicle(color, make, model, odometer, price, type, vin, year);
            dealership.addVehicle(vehicle);
            System.out.println("Vehicle added.");
        } catch (Exception ex) {
            System.out.println("Error adding vehicle. Please check your input.");
        }
    }

    private void processRemoveVehicleRequest(Scanner scanner) {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicle = dealership.getVehicleByVin(vin);
        if (vehicle != null) {
            dealership.removeVehicle(vehicle);
            System.out.println("Vehicle removed.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void sellOrLeaseVehicle(Scanner scanner) {
        System.out.print("Enter VIN of vehicle to sell or lease: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicle = dealership.getVehicleByVin(vin);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Customer email: ");
        String customerEmail = scanner.nextLine();
        System.out.print("Date (MM/DD/YYYY): ");
        String date = scanner.nextLine();

        System.out.println("1. Sell");
        System.out.println("2. Lease");
        System.out.print("Choose option: ");
        String choice = scanner.nextLine();

        Contract contract = null;

        if (choice.equals("1")) {
            System.out.print("Finance? (yes/no): ");
            String financeStr = scanner.nextLine();
            boolean finance = financeStr.equalsIgnoreCase("yes");
            contract = new SalesContract(date, customerName, customerEmail, vehicle, finance);
        } else if (choice.equals("2")) {
            contract = new LeaseContract(date, customerName, customerEmail, vehicle);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        ContractDataManager manager = new ContractDataManager(
                "jdbc:mysql://localhost:3306/dealership",
                "dbUsername",
                "dbPassword"
        );

        manager.saveDataBaseContract(contract);

        System.out.println("Contract saved.");
        System.out.println("Total Price: $" + contract.getTotalPrice());
        System.out.println("Monthly Payment: $" + contract.getMonthlyPayment());


        dealership.removeVehicle(vehicle);
    }
}