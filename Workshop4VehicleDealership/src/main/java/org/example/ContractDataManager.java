package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
        private static final String FILE_NAME = "src/main/resources/contract.csv";

        public void saveContract (Contract contract){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write("==============================================");
                writer.newLine();
                writer.write("Contract Date:      " + contract.getDate());
                writer.newLine();
                writer.write("Customer Name:      " + contract.getCustomerName());
                writer.newLine();
                writer.write("Customer Email:     " + contract.getCustomerEmail());
                writer.newLine();
                writer.write("----------------------------------------------");
                writer.newLine();

                Vehicle vehicle = contract.getVehicle();
                writer.write("Vehicle Info:");
                writer.newLine();
                writer.write("  Year:             " + vehicle.getYear());
                writer.newLine();
                writer.write("  Make:             " + vehicle.getMake());
                writer.newLine();
                writer.write("  Model:            " + vehicle.getModel());
                writer.newLine();
                writer.write("  Type:             " + vehicle.getVehicleType());
                writer.newLine();
                writer.write("  Color:            " + vehicle.getColor());
                writer.newLine();
                writer.write("  Mileage:          " + vehicle.getOdometer() + " miles");
                writer.newLine();
                writer.write("  Price:            " + vehicle.getPrice());
                writer.newLine();
                writer.write("----------------------------------------------");
                writer.newLine();

                if (contract instanceof SalesContract) {
                    SalesContract sc = (SalesContract) contract;
                    writer.write("Contract Type:      SALE");
                    writer.newLine();
                    writer.write("Financed:           " + (sc.isFinance() ? "Yes" : "No"));
                    writer.newLine();
                    writer.write("Monthly Payment:    " + (sc.getMonthlyPayment()));
                } else if (contract instanceof LeaseContract) {
                    LeaseContract lc = (LeaseContract) contract;
                    writer.write("Contract Type:      LEASE");
                    writer.newLine();
                    writer.write("Monthly Payment:    " + (lc.getMonthlyPayment()));
                }
                writer.newLine();
                writer.write("Total Price:        " + (contract.getTotalPrice()));
                writer.newLine();
                writer.write("==============================================");
                writer.newLine();
                writer.newLine();
            } catch (IOException ex) {
                System.out.println("Error saving contract: " + ex.getMessage());
            }
        }
    }
