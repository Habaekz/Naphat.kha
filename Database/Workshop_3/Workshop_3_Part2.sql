Use ICTtutorial;
GO

-- Test case 1
INSERT INTO Student
VALUES ('6188000', 'Test', 'Case', 'Test address', '2000-05-22', 'Test.case@hotmail.com', '123-456-7890', 'u6188000', '01234')

-- Question 1
-- List students' ID,first name
SELECT Student_ID, Student_Firstname, Student_Lastname,Year(getdate())-Year(Student_Birthday) as Age, Student_Email
FROM Student 
WHERE CHARINDEX('hotmail',[Student_Email]) > 0

-- Question 2
SELECT Student_ID, Student_Firstname + ' ' + Student_Lastname as [Fullname],Year(getdate())-Year(Student_Birthday) as Age
FROM Student 
WHERE Year(getdate())-Year(Student_Birthday) > 20

-- Question 3
SELECT s.Student_ID, Student_Firstname + ' ' + Student_Lastname as [Fullname], Student_Email, Student_Phone, P.Transaction_ID
FROM Student s Left Join Payment p
on s.Student_ID = p.Student_ID
where ISNULL(P.Transaction_ID, ' ') = ' '

-- Question 4
SELECT s.Student_ID, e.Exam_ID, Student_Firstname + ' ' + Student_Lastname as [Fullname], e.Score, p.Student_ID
FROM PracticeExam p
Inner Join Student s on p.Student_ID = s.Student_ID 
Inner Join ExamScore e on p.Exam_ID = e.Exam_ID 

-- Question 5
SELECT TOP 1  s.Student_ID, e.Exam_ID, Student_Firstname + ' ' + Student_Lastname as [Fullname], e.Score, p.Student_ID
FROM PracticeExam p
Inner Join Student s on p.Student_ID = s.Student_ID 
Inner Join ExamScore e on p.Exam_ID = e.Exam_ID
ORDER by e.Score DESC

-- Question 6
SELECT TOP 1  i.Instructor_Firstname + ' ' + i.Instructor_Lastname as [Fullname], c.Course_Amount
FROM Instructor i Inner Join Course c
on i.Instructor_ID = c.Instructor_ID 
ORDER by c.Course_Amount DESC

-- Question 7
SELECT TOP 5 s.Student_Firstname, c.Course_Amount
FROM EnrollCourse e 
Inner Join Student s on s.Student_ID = e.Student_ID 
Inner Join Course c on e.Course_ID = c.Course_ID 

-- Q8 Test case
INSERT INTO Instructor
VALUES ('4888999', 'Test', 'Case', 'Test Address', '2018-10-01', 'Test.cas@mail.com', '123-456-7890', 'u4888999', '12345')

INSERT INTO Course
VALUES ('ITCS000', '4888999', 'Testcase',1000)

-- Question 8
SELECT c.Course_ID, c.Course_Name, e.Lesson, e.Details
FROM Course c Left Join ElearningVideo e
on c.Course_ID = e.Course_ID
where ISNULL(e.Course_ID,  ' ') = ' '