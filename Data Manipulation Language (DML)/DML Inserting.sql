-- DML Exercise
USE MovieCatalogue;

-- INSERTING INTO THE QUERIES
INSERT INTO Actor VALUES(1, 'Bill','Murray','1950-09-21');
INSERT INTO Actor(FirstName,LastName,Birthdate)
	VALUES('Dan','Aykroyd','1952-07-01'),
    ('John','Candy','1950-10-31'),
    ('Steve','Martin',NULL),
    ('Sylvester','Stallone',NULL);
    
    
INSERT INTO Director VALUES(1,'Ivan','Reitman','1946-10-27');
INSERT INTO Director(FirstName,LastName,BirthDate)
	VALUES('Ted','Kotcheff',NULL);
    
    
INSERT INTO Rating VALUES(1, 'G');
INSERT INTO Rating(RatingName)
	VALUES('PG'),
    ('PG-13'),
    ('R');
    

INSERT INTO Genre VALUES (1,'Action');
INSERT INTO Genre (GenreName)
	VALUES('Comedy'),
    ('Drame'),
    ('Horror');

INSERT INTO Movie VALUES(1,1,2,4,'Rambo: First Blood','1982-10-22'),
(2,2,NULL,4,'Planes, Trains, & Automobiles', '1987-11-25'),
(3,2,1,2,'Ghostbusters',NULL),
(4,2,NULL,2,'The Great Outdoors','1988-06-17');

INSERT INTO CastMembers VALUES(1,5,1,'John Rambo'),
(2,4,2,'Neil Page'),
(3,3,2,'Del Griffith'),
(4,1,3,'Dr. Peter Venkman'),
(5,2,3,'Dr. Raymond Stanz'),
(6,2,4, 'Roman Craig'),
(7,3,4, 'Chet Ripley');
