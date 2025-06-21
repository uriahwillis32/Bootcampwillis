package org.example.DAO;

import org.example.ContractFolder.SalesContract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesContractDAO {
    private final String connectionString;
    private final String userName;
    private final String password;

    public SalesContractDAO(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public void saveSalesContract(SalesContract contract) {
        String sql = "INSERT INTO sales_contracts (customer_name, customer_email, contract_date, vin, finance, total_price, monthly_payment) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, contract.getCustomerName());
            stmt.setString(2, contract.getCustomerEmail());
            stmt.setString(3, contract.getDate());
            stmt.setInt(4, contract.getVehicle().getVin());
            stmt.setBoolean(5, contract.isFinance());
            stmt.setDouble(6, contract.getTotalPrice());
            stmt.setDouble(7, contract.getMonthlyPayment());

            stmt.executeUpdate();
            System.out.println("Sales contract saved to database.");

        } catch (SQLException e) {
            System.out.println("Error saving sales contract: " + e.getMessage());
        }
    }
}
