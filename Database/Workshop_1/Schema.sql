-- Check whether the database ICTtutorial already exists or not
IF EXISTS
( select * from sys.databases where name='ICTtutorial'
)
 BEGIN
   PRINT 'Database ICTtutorial already exists.';
   Use Master;					-- Swap database in order to drop 
   DROP DATABASE ICTtutorial;
   PRINT 'Then, it was firstly deleted.';
 END;
  
-- Create Database 
CREATE Database ICTtutorial; 
GO
Use ICTtutorial;
GO

-- Create Tables
CREATE TABLE Seat
(
Seat_ID NVARCHAR(50) NOT NULL,
Course_ID NVARCHAR(50) NOT NULL,
Student_ID NVARCHAR(50) NOT NULL,
Row NVARCHAR(50),
Number INT
); 

CREATE TABLE Student
(
Student_ID NVARCHAR(50) NOT NULL,
Student_Firstname NVARCHAR(50) ,
Student_Lastname NVARCHAR(50) ,
Student_Address NVARCHAR(50),
Student_Birthday date,
Student_Email NVARCHAR(50),
Student_Phone NCHAR(13),
Student_UserID NVARCHAR(20),
Student_Password NVARCHAR(20)
);
 
CREATE TABLE Payment
(
Student_ID NVARCHAR(50) NOT NULL,
Transaction_ID NVARCHAR(50) NOT NULL
);

CREATE TABLE Transaction_
(
Transaction_ID NVARCHAR(50) NOT NULL,
Amount INT 
);

CREATE TABLE ElearningVideo
(
Course_ID NVARCHAR(50) NOT NULL,
Lesson NVARCHAR(50) ,
Details NVARCHAR(200) 
);

CREATE TABLE EnrollCourse
(
Student_ID NVARCHAR(50) NOT NULL,
Course_ID NVARCHAR(50) NOT NULL
);

CREATE TABLE PracticeExam
(
Student_ID NVARCHAR(50) NOT NULL,
Exam_ID NVARCHAR(50) NOT NULL
);

CREATE TABLE ExamScore
(
Exam_ID NVARCHAR(50) NOT NULL,
Score INT 
);

CREATE TABLE BookStocking
(
Book_ID NVARCHAR(50) NOT NULL,
Course_ID NVARCHAR(50) NOT NULL,
BookName NVARCHAR(50),
Author NVARCHAR(50),
Remaining INT,
Price INT
);

CREATE TABLE Course
(
Course_ID NVARCHAR(50) NOT NULL,
Instructor_ID NVARCHAR(50) NOT NULL,
Course_Name NVARCHAR(50),
Course_Amount INT
);

CREATE TABLE Instructor
(
Instructor_ID NVARCHAR(50) NOT NULL,
Instructor_Firstname NVARCHAR(50) ,
Instructor_Lastname NVARCHAR(50) ,
Instructor_Address NVARCHAR(50),
Instructor_Birthday date,
Instructor_Email NVARCHAR(50),
Instructor_Phone NCHAR(13),
Instructor_UserID NVARCHAR(20),
Instructor_Password NVARCHAR(20)
);

CREATE TABLE CheckAttendence
(
Student_ID NVARCHAR(50) NOT NULL,
Week INT,
Day date,
Status NVARCHAR(20)
);


-- Create Primary Key
ALTER TABLE Seat
ADD CONSTRAINT PK_Seat_SeatID PRIMARY KEY(Seat_ID)

ALTER TABLE Student
ADD CONSTRAINT PK_Student_StudentID PRIMARY KEY(Student_ID)

ALTER TABLE Transaction_
ADD CONSTRAINT PK_Transaction_TransactionID PRIMARY KEY(Transaction_ID)

ALTER TABLE ExamScore
ADD CONSTRAINT PK_ExamScore_ExamID PRIMARY KEY(Exam_ID)

ALTER TABLE BookStocking
ADD CONSTRAINT PK_BookStocking_BookID PRIMARY KEY(Book_ID)

ALTER TABLE Course
ADD CONSTRAINT PK_Course_CourseID PRIMARY KEY(Course_ID)

ALTER TABLE Instructor
ADD CONSTRAINT PK_Instructor_InstructorID PRIMARY KEY(Instructor_ID)

-- Create Foreign Key
ALTER TABLE Seat
ADD CONSTRAINT FK_Seat_CourseID FOREIGN KEY(Course_ID)
REFERENCES Course(Course_ID)

ALTER TABLE Seat
ADD CONSTRAINT FK_Seat_StudentID FOREIGN KEY(Student_ID)
REFERENCES Student(Student_ID)

ALTER TABLE Payment
ADD CONSTRAINT FK_Payment_StudentID FOREIGN KEY(Student_ID)
REFERENCES Student(Student_ID)

ALTER TABLE Payment
ADD CONSTRAINT FK_Payment_TransactionID FOREIGN KEY(Transaction_ID)
REFERENCES Transaction_(Transaction_ID)

ALTER TABLE ElearningVideo
ADD CONSTRAINT FK_ElearningVideo_CourseID FOREIGN KEY(Course_ID)
REFERENCES Course(Course_ID)

ALTER TABLE EnrollCourse
ADD CONSTRAINT FK_EnrollCourse_StudentID FOREIGN KEY(Student_ID)
REFERENCES Student(Student_ID)

ALTER TABLE EnrollCourse
ADD CONSTRAINT FK_EnrollCourse_CourseID FOREIGN KEY(Course_ID)
REFERENCES Course(Course_ID)

ALTER TABLE PracticeExam
ADD CONSTRAINT FK_PracticeExam_StudentID FOREIGN KEY(Student_ID)
REFERENCES Student(Student_ID)

ALTER TABLE PracticeExam
ADD CONSTRAINT FK_PracticeExam_ExamID FOREIGN KEY(Exam_ID)
REFERENCES ExamScore(Exam_ID)

ALTER TABLE BookStocking
ADD CONSTRAINT FK_BookStocking_CourseID FOREIGN KEY(Course_ID)
REFERENCES Course(Course_ID)

ALTER TABLE Course
ADD CONSTRAINT FK_Course_InstructorID FOREIGN KEY(Instructor_ID)
REFERENCES Instructor(Instructor_ID)

ALTER TABLE CheckAttendence
ADD CONSTRAINT FK_CheckAttendence_StudentID FOREIGN KEY(Student_ID)
REFERENCES Student(Student_ID)

/*Show the information of constaints*/
-- SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS