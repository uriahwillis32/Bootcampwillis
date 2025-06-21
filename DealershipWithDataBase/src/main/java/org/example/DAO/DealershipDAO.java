package org.example.DAO;

import org.example.VehicleClasses.Dealership;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipDAO {

    private final String connectionString;
    private final String userName;
    private final String password;

    public DealershipDAO(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    public List<Dealership> getAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String sql = "SELECT * FROM dealerships";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dealership dealership = new Dealership(
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        null // vehicleDao will be set externally if needed
                );
                dealerships.add(dealership);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching dealerships: " + e.getMessage());
        }
        return dealerships;
    }

    public Dealership getDealershipById(int id) {
        String sql = "SELECT * FROM dealerships WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Dealership(
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        null // You can inject a VehicleDAO if needed
                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching dealership by ID: " + e.getMessage());
        }
        return null;
    }

    public void addDealership(Dealership dealership) {
        String sql = "INSERT INTO dealerships (name, address, phone) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getPhone());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding dealership: " + e.getMessage());
        }
    }

    public void updateDealership(int id, Dealership dealership) {
        String sql = "UPDATE dealerships SET name = ?, address = ?, phone = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getPhone());
            stmt.setInt(4, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating dealership: " + e.getMessage());
        }
    }

    public void deleteDealership(int id) {
        String sql = "DELETE FROM dealerships WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting dealership: " + e.getMessage());
        }
    }
}

