use AdventureWorks;
/*  Student Name Naphat Khajohn-udomrith ID  6188029  */

/*  Q1 Write a query that returns BusinessEntityID, LastName ,
    NationalIDNumber, and JobTitle of all Person.
	[Table: Person, Employee]
 */
-- Your Solution is here!
 
 SELECT e.BusinessEntityID, p.LastName, e.NationalIDNumber, e.JobTitle
 FROM Person.Person p
 LEFT OUTER JOIN HumanResources.Employee e ON p.BusinessEntityID = e.BusinessEntityID;


/*	Q2 Write a query that returns FirstName, LastName and 
	CreditCardID of Person who have credit cards. 
	[Table: Person, PersonCreditCard]	
*/
-- Your Solution is here!

SELECT p.Firstname, p.LastName, pc.CreditCardID
FROM Person.Person p
JOIN Sales.PersonCreditCard pc ON p.BusinessEntityID = pc.BusinessEntityID;


/*	Q3 Write a query that returns Name, LogInID and DepartmentName 
	of Employee who were assigned the department and  loginID.
     [Table: Person, Employee, Department, EmployeeDepartmentHistory]
	*/
-- Your Solution is here! 

SELECT p.FirstName + ' '+ p.LastName as Name,
e.LoginID,
d.Name as DepartmentName
FROM Person.Person p
JOIN HumanResources.Employee e ON p.BusinessEntityID = e.BusinessEntityID
JOIN HumanResources.EmployeeDepartmentHistory dh ON e.BusinessEntityID = dh.BusinessEntityID
JOIN HumanResources.Department d ON dh.DepartmentID = d.DepartmentID;

/*	Q4 Write a query that returns one column called Result and 
	contains the last name of the employee with NationalIDNumber 112457891.
    [Table: Person, Employee]
*/ 
-- Your Solution is here!
 SELECT CONCAT(p.LastName, e.NationalIDNumber) as Result
FROM Person.Person p
JOIN HumanResources.Employee e ON p.BusinessEntityID = e.BusinessEntityID
WHERE e.NationalIDNumber = 112457891;