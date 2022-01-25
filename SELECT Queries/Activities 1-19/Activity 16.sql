-- Activity 16
SELECT FirstName, LastName, City FROM client
WHERE (LastName LIKE 'L%' OR LastName LIKE 'M%' OR LastName LIKE 'N%') AND City = 'LaPlace';