USE PremierProducts;

-- Question 1
SELECT PartNum, Price
FROM Part
WHERE Price >= (SELECT AVG(Price) FROM Part);

-- Question 2
SELECT c.CustomerName
FROM Customer c
WHERE EXISTS (
				SELECT o.CustomerNum
				FROM Orders o
				WHERE c.CustomerNum = o.CustomerNum AND o.OrderDate < '2010-10-22'
			);

-- Question 3
SELECT c.CustomerName
FROM Customer c
WHERE EXISTS (
				SELECT r.RepNum
				FROM Rep r
				WHERE c.RepNum = r.RepNum 
				AND r.FirstName + ' ' + r.LastName = 'Valerie Kaiser'
			);

-- Question 4
SELECT CustomerName, Balance
FROM Customer
WHERE Balance > (
					SELECT Balance
					FROM Customer
					WHERE CustomerName = 'Brookings Direct'
				);