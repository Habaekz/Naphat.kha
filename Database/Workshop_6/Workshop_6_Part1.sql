use PremierProducts

-- Question 1

-- APPLY
SELECT CustomerName
FROM Customer
CROSS APPLY
(
	SELECT OrderNum
	FROM Orders
	WHERE Customer.CustomerNum = Orders.CustomerNum
) AS T

-- JOIN
SELECT CustomerName,OrderNum
FROM Customer c
JOIN Orders o ON c.CustomerNum = o.CustomerNum

-- Question 2
SELECT *
FROM Customer
OUTER APPLY
(
	SELECT OrderNum
	FROM Orders
	WHERE Customer.CustomerNum = Orders.CustomerNum
) AS T

-- Question 3
SELECT o.OrderNum
FROM Orders o
JOIN Customer c ON o.CustomerNum = c.CustomerNum
JOIN OrderLine ol ON ol.OrderNum = o.OrderNum
WHERE c.CustomerNum > 400
EXCEPT 
SELECT OrderNum 
FROM OrderLine
WHERE OrderNum = 21617;
