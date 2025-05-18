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

                Vehicle v = contract.getVehicle();
                writer.write("Vehicle Info:");
                writer.newLine();
                writer.write("  Year:             " + v.getYear());
                writer.newLine();
                writer.write("  Make:             " + v.getMake());
                writer.newLine();
                writer.write("  Model:            " + v.getModel());
                writer.newLine();
                writer.write("  Type:             " + v.getVehicleType());
                writer.newLine();
                writer.write("  Color:            " + v.getColor());
                writer.newLine();
                writer.write("  Mileage:          " + v.getOdometer() + " miles");
                writer.newLine();
                writer.write("  Price:            " + v.getPrice());
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
            } catch (IOException e) {
                System.out.println("Error saving contract: " + e.getMessage());
            }
        }
    }
