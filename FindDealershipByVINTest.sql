SELECT * 
FROM dealerships d
JOIN inventory i ON d.DealershipID = i.DealershipID
WHERE i.VIN = '1HGCM82633A004352';