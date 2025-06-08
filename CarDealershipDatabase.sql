CREATE TABLE dealerships (
DealershipID INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(12)
);

CREATE TABLE vehicles (
VIN VARCHAR(17) PRIMARY KEY,
vehicletype VARCHAR(50),
    make VARCHAR(30),
    model VARCHAR(30),
    year INT,
    color VARCHAR(20),
    mileage INT,
    price DOUBLE(10,2),
    sold BOOLEAN
);

CREATE TABLE inventory (
    DealershipID  INT,
    VIN VARCHAR(17),
    PRIMARY KEY (DealershipID, VIN),
    FOREIGN KEY (DealershipID) REFERENCES dealerships(DealershipID),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

CREATE TABLE sales_contracts (
    SaleID INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    sale_date DATE,
    sale_price DECIMAL(10,2),
    customer_name VARCHAR(50),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
    );
    
    
CREATE TABLE lease_contracts (
    LeaseID INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(17),
    monthly_payment DECIMAL(10,2),
    customer_name VARCHAR(50),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

INSERT INTO dealerships (name, address, phone) VALUES
('Auto Galaxy', '123 Star Rd', '555-123-4567'),
('Metro Motors', '456 Main St', '555-987-6543'),
('Sunset Cars', '789 Sunset Blvd', '555-456-7890');


INSERT INTO vehicles (VIN, vehicletype, make, model, year, color, mileage, price, sold) VALUES
('1HGCM82633A004352', 'Sedan', 'Honda', 'Accord', 2020, 'Black', 30000, 18000.00, FALSE),
('1FTFW1ET2EKE12345', 'Truck', 'Ford', 'F-150', 2018, 'Blue', 45000, 25000.00, TRUE),
('2T1BURHE5JC123456', 'Sedan', 'Toyota', 'Corolla', 2021, 'White', 15000, 17000.00, FALSE),
('3N1AB7AP7HY123789', 'Sedan', 'Nissan', 'Sentra', 2019, 'Red', 28000, 14000.00, TRUE),
('5YJ3E1EA7JF123678', 'Electric', 'Tesla', 'Model 3', 2022, 'Silver', 5000, 42000.00, FALSE),
('WDBWK56F14F123999', 'Convertible', 'Mercedes-Benz', 'SLK320', 2004, 'Yellow', 98000, 8900.00, TRUE)
('1C4RJEBG0FC625432', 'SUV', 'Jeep', 'Grand Cherokee', 2015, 'White', 65000, 19000.00, TRUE),
('3FA6P0G72HR216543', 'Sedan', 'Ford', 'Fusion', 2017, 'Silver', 40000, 16000.00, FALSE),
('JH4KB165X6C001245', 'Sedan', 'Acura', 'RL', 2006, 'Black', 110000, 5500.00, TRUE),
('WBA3A5C57DF589321', 'Sedan', 'BMW', '328i', 2013, 'Gray', 72000, 15000.00, TRUE),
('1FTWX31P07ED53985', 'Truck', 'Ford', 'Super Duty F-250', 2007, 'Red', 89000, 16500.00, FALSE),
('2G1FK1EJ4A9173490', 'Coupe', 'Chevrolet', 'Camaro SS', 2010, 'Orange', 55000, 18000.00, TRUE),
('1GCHK23618F129048', 'Truck', 'Chevrolet', 'Silverado 2500HD', 2008, 'Blue', 105000, 15500.00, FALSE),
('WAUFFAFL4FN057321', 'Sedan', 'Audi', 'A4', 2015, 'White', 60000, 19500.00, TRUE),
('5UXWX9C58F0D65432', 'SUV', 'BMW', 'X3', 2015, 'Black', 50000, 22000.00, FALSE),
('KMHDH4AE6GU578901', 'Sedan', 'Hyundai', 'Elantra', 2016, 'Silver', 43000, 13500.00, FALSE),
('4T1BF1FK7GU267432', 'Sedan', 'Toyota', 'Camry', 2016, 'Green', 37000, 15500.00, TRUE),
('JN8AS5MT4CW401234', 'SUV', 'Nissan', 'Rogue', 2012, 'Brown', 87000, 9800.00, TRUE),
('YV4952DL5D2265432', 'SUV', 'Volvo', 'XC60', 2013, 'Blue', 61000, 17200.00, FALSE),
('JTEBU5JR2E5182734', 'SUV', 'Toyota', '4Runner', 2014, 'Gray', 74000, 21500.00, TRUE);


INSERT INTO inventory (DealershipID, VIN) VALUES
(1, '1HGCM82633A004352'),
(1, '5YJ3E1EA7JF123678'),
(2, '1FTFW1ET2EKE12345'),
(2, '2T1BURHE5JC123456'),
(3, '3N1AB7AP7HY123789'),
(3, 'WDBWK56F14F123999');
(1, '1C4RJEBG0FC625432'),
(1, '3FA6P0G72HR216543'),
(1, 'JH4KB165X6C001245'),
(1, 'WBA3A5C57DF589321'),
(2, '1FTWX31P07ED53985'),
(2, '2G1FK1EJ4A9173490'),
(2, '1GCHK23618F129048'),
(2, 'WAUFFAFL4FN057321'),
(3, '5UXWX9C58F0D65432'),
(3, 'KMHDH4AE6GU578901'),
(3, '4T1BF1FK7GU267432'),
(3, 'JN8AS5MT4CW401234'),
(3, 'YV4952DL5D2265432'),
(3, 'JTEBU5JR2E5182734');


INSERT INTO sales_contracts (VIN, sale_date, sale_price, customer_name) VALUES
('1FTFW1ET2EKE12345', '2024-12-15', 24500.00, 'John Smith'),
('3N1AB7AP7HY123789', '2025-01-20', 13800.00, 'Lisa Green'),
('WDBWK56F14F123999', '2025-03-10', 8500.00, 'Carlos Perez');

INSERT INTO lease_contracts (VIN, monthly_payment, customer_name) VALUES
('1HGCM82633A004352', 320.00, 'Rachel Kim'),
('2T1BURHE5JC123456', 275.00, 'Derek Young'),
('5YJ3E1EA7JF123678', 499.00, 'Maya Thompson');


