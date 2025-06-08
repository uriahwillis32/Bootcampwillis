SELECT DISTINCT 
    d.DealershipID, d.name, d.address, d.phone, v.VIN, v.vehicletype, v.make, v.model,
    v.color, v.mileage, v.price, v.sold
FROM dealerships d
JOIN inventory i ON d.DealershipID = i.DealershipID
JOIN vehicles v ON v.VIN = i.VIN
WHERE v.make = 'Nissan' 
  AND v.model = 'Sentra' 
  AND v.color = 'Red';