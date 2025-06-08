SELECT * 
FROM vehicles v
JOIN inventory i ON v.VIN = i.VIN
WHERE i.DealershipID = 1;