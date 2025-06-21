package org.example.DAO;

import org.example.VehicleClasses.Vehicle;
import org.example.VehicleClasses.VehicleType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private final String connectionString;
    private final String userName;
    private final String password;

    public VehicleDAO(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }


    public boolean updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET year = ?, make = ?, model = ?, vehicle_type = ?, color = ?, odometer = ?, price = ? WHERE vin = ?";
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicle.getYear());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, vehicle.getModel());
            stmt.setString(4, vehicle.getVehicleType().name());
            stmt.setString(5, vehicle.getColor());
            stmt.setInt(6, vehicle.getOdometer());
            stmt.setDouble(7, vehicle.getPrice());
            stmt.setInt(8, vehicle.getVin());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("Error updating vehicle: " + e.getMessage());
            return false;
        }
    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, minPrice);
            stmt.setDouble(2, maxPrice);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
                vehicles.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching vehicles by price: " + e.getMessage());
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE LOWER(make) = LOWER(?) AND LOWER(model) = LOWER(?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, make);
            stmt.setString(2, model);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
                vehicles.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching vehicles by make/model: " + e.getMessage());
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, minYear);
            stmt.setInt(2, maxYear);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
                vehicles.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching vehicles by year: " + e.getMessage());
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE LOWER(color) = LOWER(?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, color);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
                vehicles.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching vehicles by color: " + e.getMessage());
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, minMileage);
            stmt.setInt(2, maxMileage);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),

                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
                vehicles.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching vehicles by mileage: " + e.getMessage());
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleTypeStr) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE LOWER(vehicle_type) = LOWER(?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicleTypeStr);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
                vehicles.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching vehicles by type: " + e.getMessage());
        }
        return vehicles;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
                vehicles.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all vehicles: " + e.getMessage());
        }
        return vehicles;
    }

    public void addVehicle(int id, Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (vin, year, make, model, vehicle_type, color, odometer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicle.getVin());
            stmt.setInt(2, vehicle.getYear());
            stmt.setString(3, vehicle.getMake());
            stmt.setString(4, vehicle.getModel());
            stmt.setString(5, vehicle.getVehicleType().name());
            stmt.setString(6, vehicle.getColor());
            stmt.setInt(7, vehicle.getOdometer());
            stmt.setDouble(8, vehicle.getPrice());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
        }
    }

    public void removeVehicle(int vin) {
        String sql = "DELETE FROM vehicles WHERE vin = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vin);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error removing vehicle: " + e.getMessage());
        }
    }

    public Vehicle getVehicleByVin(int vin) {
        String sql = "SELECT * FROM vehicles WHERE vin = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vin);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vehicle(
                        rs.getString("color"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase()),
                        rs.getInt("vin"),
                        rs.getInt("year")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error fetching vehicle by VIN: " + e.getMessage());
        }
        return null;
    }
}
