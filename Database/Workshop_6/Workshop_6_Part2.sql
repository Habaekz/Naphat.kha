USE ALEXAMARA;

--Write a query to show SlipID that does not request for service
SELECT s.SlipID, T.ServiceID
FROM MarinaSlip s
OUTER APPLY
(
	SELECT sr.ServiceID
	FROM ServiceRequest sr
	WHERE s.SlipID = sr.SlipID AND sr.ServiceID IS NULL
) AS T;

--Write a query to display Distinct Status using SET operation WHERE Status is not "Open".
SELECT DISTINCT Status
FROM ServiceRequest
EXCEPT
(
	SELECT Status
	FROM ServiceRequest
	WHERE Status = 'Open'
);

--List all distinct City and State of Owner using SET operation in Descending Order.
SELECT DISTINCT City, T.State
FROM Owner
CROSS APPLY
(
	SELECT DISTINCT State
	FROM Owner
) AS T
ORDER BY City DESC;

--For each Owner and Marina, list all City using SET operation in Ascending Order
SELECT OwnerNum as NumID, City
FROM Owner
UNION
SELECT MarinaNum, City
FROM Marina
ORDER BY OwnerNum;

--For each Owner, get additional column with SlipID and BoatType using APPLY operator
SELECT o.FirstName + ' ' + o.LastName as OwnerName, 
T.SlipID, 
T.BoatType
FROM Owner o
OUTER APPLY
(
	SELECT SlipID, BoatType
	FROM MarinaSlip s
	WHERE o.OwnerNum = s.OwnerNum 
) AS T;

--For each Marina, get Name of Marina and Max rental fee
SELECT m.Name, MAX(T.RentalFee) as MaxRentalFee
FROM Marina m
OUTER APPLY
(
	SELECT RentalFee
	FROM MarinaSlip s
	WHERE m.MarinaNum = s.MarinaNum
) AS T
GROUP BY m.Name;

--For every Slip, list the marina number, slip number, boat name, owner number, owner's first name, and owner's last name.
SELECT s.SlipID, s.MarinaNum, s.SlipNum, s.BoatName, 
T.OwnerNum, T.FirstName, T.LastName
FROM MarinaSlip s
CROSS APPLY
(
	SELECT OwnerNum, FirstName, LastName
	FROM Owner o
	WHERE s.OwnerNum = o.OwnerNum
) AS T;