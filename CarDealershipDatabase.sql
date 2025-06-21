
DROP DATABASE IF EXISTS CarDealership;
CREATE DATABASE CarDealership;
USE CarDealership;



-- Dealerships table
CREATE TABLE dealerships (
    dealership_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone VARCHAR(12) NOT NULL
);

-- Vehicles table
CREATE TABLE vehicles (
    vin INT PRIMARY KEY,
    year INT NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    vehicle_type VARCHAR(20) NOT NULL,
    color VARCHAR(30) NOT NULL,
    odometer INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    sold BOOLEAN DEFAULT FALSE
);

-- Inventory table 
CREATE TABLE inventory (
    dealership_id INT,
    vin INT,
    PRIMARY KEY (dealership_id, vin),
    FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id) ON DELETE CASCADE,
    FOREIGN KEY (vin) REFERENCES vehicles(vin) ON DELETE CASCADE
);

-- Sales Contracts
CREATE TABLE sales_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vin INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) NOT NULL,
    sale_date DATE NOT NULL,
    sales_tax DECIMAL(10,2),
    recording_fee DECIMAL(10,2),
    processing_fee DECIMAL(10,2),
    total_price DECIMAL(10,2),
    finance BOOLEAN,
    monthly_payment DECIMAL(10,2),
    FOREIGN KEY (vin) REFERENCES vehicles(vin)
);

-- Lease Contracts 
CREATE TABLE lease_contracts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vin INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(100) NOT NULL,
    lease_date DATE NOT NULL,
    expected_end_value DECIMAL(10,2),
    lease_fee DECIMAL(10,2),
    total_price DECIMAL(10,2),
    monthly_payment DECIMAL(10,2),
    FOREIGN KEY (vin) REFERENCES vehicles(vin)
);


INSERT INTO dealerships (name, address, phone) VALUES
('D & B''s Used Cars', '123 Main St', '555-123-4567'),
('City Auto Group', '456 Elm St', '555-987-6543');

INSERT INTO vehicles (vin, year, make, model, vehicle_type, color, odometer, price, sold) VALUES
(101, 2020, 'Toyota', 'Camry', 'SEDAN', 'Red', 25000, 19999.99, FALSE),
(102, 2021, 'Ford', 'F-150', 'TRUCK', 'Blue', 15000, 28999.99, FALSE),
(103, 2019, 'Honda', 'Civic', 'SEDAN', 'Black', 30000, 15999.99, FALSE),
(104, 2022, 'Jeep', 'Wrangler', 'SUV', 'Green', 12000, 34999.99, FALSE);

INSERT INTO inventory (dealership_id, vin) VALUES
(1, 101),
(1, 102),
(2, 103),
(2, 104);
