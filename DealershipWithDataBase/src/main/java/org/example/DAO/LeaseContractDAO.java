package org.example.DAO;
import org.example.ContractFolder.LeaseContract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class LeaseContractDAO {
        private final String connectionString;
        private final String userName;
        private final String password;

        public LeaseContractDAO(String connectionString, String userName, String password) {
            this.connectionString = connectionString;
            this.userName = userName;
            this.password = password;
        }

        public void saveLeaseContract(LeaseContract contract) {
            String sql = "INSERT INTO lease_contracts (customer_name, customer_email, contract_date, vin, total_price, monthly_payment) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(connectionString, userName, password);
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setString(1, contract.getCustomerName());
                stmt.setString(2, contract.getCustomerEmail());
                stmt.setString(3, contract.getDate());
                stmt.setInt(4, contract.getVehicle().getVin());
                stmt.setDouble(5, contract.getTotalPrice());
                stmt.setDouble(6, contract.getMonthlyPayment());

                stmt.executeUpdate();
                System.out.println("Lease contract saved to database.");

            } catch (SQLException e) {
                System.out.println("Error saving lease contract: " + e.getMessage());
            }
        }
    }


