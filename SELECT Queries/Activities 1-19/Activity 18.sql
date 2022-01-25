-- Activity 18
SELECT c.ClientId, c.FirstName, c.LastName, l.ClientId, l.EmailAddress, l.PasswordHash
FROM client AS c, login AS l
WHERE (CONCAT(FirstName, LastName) = 'EstrellaBazely' AND c.ClientId = l.ClientId);


