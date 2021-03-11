-- Check whether the database �myFriends� already exists or not
IF EXISTS
( select * from sys.databases where name='myFriends'
)
 BEGIN
   PRINT 'Database myFriends already exists.';
   Use Master;					-- Swap database in order to drop myFriends
   DROP DATABASE myFriends;
   PRINT 'Then, it was firstly deleted.';
 END;
  
-- Create Database 
CREATE Database myFriends; 
GO
Use myFriends;
GO

-- Create Tables
CREATE TABLE myStudents
(
StudentID INT NOT NULL,
FirstName NVARCHAR(50),
LastName NVARCHAR(50)
) 

CREATE TABLE myFriends
(
FriendID INT NOT NULL,
NickName NVARCHAR(20) NOT NULL,
FirstName NVARCHAR(50) ,
LastName NVARCHAR(50),
PhoneNo NCHAR(13)
);
 
CREATE TABLE myProjects
(
ProjNo INT NOT NULL,
FriendMembers INT NOT NULL,
ProjectName NVARCHAR(200),
DueDate date
);
 
PRINT 'Database myFriends was created successfully.';

/* YOUR SQL Commands can start here!! 
   Instructions:
	1. Assign "FriendID" to be FK for myFriends table, which links to myStudents table.
	2. Assign "FriendMembers" to be FK for myProjects table, which links to myStudent table.
	3. Assign "ProjNo and FriendMembers" to be COMPOSITE PKs for myProjects table.
  4. Assign "studentID" to be PK for myStudents table.
	5. Assign "FriendID and NickName" to be COMPOSITE PKs for myFriends table.
*/

/*3. Assign "ProjNo and FriendMembers" to be COMPOSITE PKs for myProjects table.*/
ALTER TABLE myProjects
ADD CONSTRAINT PK_myProjectsInfo PRIMARY KEY(ProjNo,FriendMembers)

/*5. Assign "FriendID and NickName" to be COMPOSITE PKs for myFriends table.*/
ALTER TABLE myFriends
ADD CONSTRAINT PK_myFriendsInfo PRIMARY KEY(FriendID,NickName)

/*4. Assign "studentID" to be PK for myStudents table.*/
ALTER TABLE myStudents
ADD CONSTRAINT PK_myStudents_StudentID PRIMARY KEY(StudentID)

/*1. Assign "FriendID" to be FK for myFriends table, which links to myStudents table.*/
ALTER TABLE myFriends
ADD CONSTRAINT FK_myFriends_StudentID FOREIGN KEY(FriendID)
REFERENCES myStudents(StudentID)

/*2. Assign "FriendMembers" to be FK for myProjects table, which links to myStudent table.*/
ALTER TABLE myProjects
ADD CONSTRAINT FK_myProjects_StudentID FOREIGN KEY(FriendMembers)
REFERENCES myStudents(StudentID)

/**/
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS