package org.example;

public enum VehicleType {
    TRUCK,
    SUV,
    SEDAN;

    public static VehicleType fromString(String type) {
            return VehicleType.valueOf(type.trim().toUpperCase());
    }
}
