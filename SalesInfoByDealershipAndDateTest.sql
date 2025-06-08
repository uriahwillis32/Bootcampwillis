SELECT *, d.name AS dealership_name 
FROM sales_contracts sc
JOIN inventory i ON sc.VIN = i.VIN
JOIN dealerships d ON i.DealershipID = d.DealershipID
WHERE d.DealershipID = 2 AND sc.sale_date BETWEEN '2024-11-15' AND '2025-12-31';