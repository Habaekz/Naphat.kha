/* Part 1: Write the SQL commands to answer the following 5 questions: */

-- Test Case for Q1
-- 6188001 is Jame Smith ID

INSERT INTO EnrollCourse
VALUES ('6188001','ITCS101')

INSERT INTO EnrollCourse
VALUES ('6188001','ITCS102')

-- Q1: Show all students' name who enrolled more than 1 course.
SELECT Student_Firstname + ' ' + Student_Lastname as [Fullname]
FROM Student s
Inner Join EnrollCourse e on s.Student_ID = e.Student_ID 
Group by Student_Firstname,Student_Lastname
Having COUNT(*) > 1

-- Q2: Show all students' name who paid the payment costed higher than 50,000.00 baht.
SELECT Student_Firstname + ' ' + Student_Lastname as [Fullname] --,t.Amount /*Just for check output*/
FROM Student s
Inner Join Payment p on s.Student_ID = p.Student_ID 
Inner Join Transaction_ t on p.Transaction_ID = t.Transaction_ID
WHERE t.Amount > 50000

-- Q3: Show all students' name who got the summarized examination score more than the average score of all students.
SELECT Student_Firstname + ' ' + Student_Lastname as [Fullname], e.Score
FROM Student s
Inner Join PracticeExam p on s.Student_ID = p.Student_ID
Inner Join ExamScore e on p.Exam_ID = e.Exam_ID
WHERE e.Score > (SELECT AVG(Score) From ExamScore)
Group by Student_Firstname,Student_Lastname,e.Score

-- Test Case for Q4
-- 4888987 is Test ID
INSERT INTO Instructor
VALUES ('4888987', 'Test2', 'Case2', 'Dont know', '1943-02-01', 'Test.cas@mail.com', '987-654-3210', 'u4888987', '99999')
-- Q4: Show all instructors' full name who didn't teach any courses.
SELECT i.Instructor_Firstname + ' ' + i.Instructor_Lastname as [Fullname] 
FROM Instructor i
Left Join Course c on i.Instructor_ID = c.Instructor_ID
where ISNULL(c.Course_ID, ' ') = ' '

-- Q5: Mr.A is a student who enrolls for a course named "B", show how much money he must pay for all books provided in this course. (Noted that you can change the name of this student and course’s name according to your data)
SELECT Student_Firstname + ' ' + Student_Lastname as [Fullname], SUM(b.Price) as [Price_of_All_Book]
FROM Student s
Join EnrollCourse e on s.Student_ID = e.Student_ID 
Join Course c on e.Course_ID = c.Course_ID
Join BookStocking b on c.Course_ID = b.Course_ID
WHERE s.Student_Firstname = 'James' AND c.Course_Name = 'English'
Group by Student_Firstname,Student_Lastname,Course_Name

/* Part 2: Design your own 5 more questions and write the SQL command to solve your questions. */

-- Test case for Q1
INSERT INTO ElearningVideo
VALUES ('ITCS000','Test','Case'),
('ITCS000','Test','Case'),
('ITCS000','Test','Case'),
('ITCS000','Test','Case'),
('ITCS000','Test','Case'),
('ITCS000','Test','Case')

-- Q1: Show all instructors' name, Course id and Course name who have E-Learning video more than 5 video
SELECT i.Instructor_Firstname + ' ' + i.Instructor_Lastname as [Fullname], c.Course_ID, c.Course_Name
From Instructor i 
Inner Join Course c on i.Instructor_ID = c.Instructor_ID
Inner Join ElearningVideo e on c.Course_ID = e.Course_ID
Group by i.Instructor_Firstname,i.Instructor_Lastname, c.Course_ID, c.Course_Name
Having COUNT(*) > 5

-- Q2: Show all instructors' name who teach the 'Advance' book
SELECT i.Instructor_ID, i.Instructor_Firstname + ' ' + i.Instructor_Lastname as [Fullname], b.BookName
FROM Instructor i
Inner Join Course c on i.Instructor_ID = c.Instructor_ID
Inner join BookStocking b on b.Course_ID = c.Course_ID
WHERE CHARINDEX('Advance',[BookName]) > 0

-- Test case for Q3
INSERT INTO CheckAttendence
VALUES ('6188000', 1, '2021-01-28','Late'),
('6188000', 1, '2021-01-29','Late'),
('6188000', 1, '2021-01-30','Late'),
('6188000', 1, '2021-01-31','Late')

-- Q3: Show students' name who have late for 3 time
SELECT s.Student_Firstname + ' ' + s.Student_Lastname as [Fullname], c.[Status]
From Student s
Inner Join CheckAttendence c on s.Student_ID = c.Student_ID
Group by s.Student_Firstname,s.Student_Lastname,c.[Status]
Having c.[Status] = 'Late' AND COUNT(*) > 3

-- Q4: Show students' name who have exam score less than 50
SELECT s.Student_Firstname + ' ' + s.Student_Lastname as [Fullname], e.Score
From Student s
Inner Join PracticeExam p on s.Student_ID = p.Student_ID
Inner Join ExamScore e on p.Exam_ID = e.Exam_ID
WHERE e.Score < 50 

-- Q5: Show students' name who absent in exam day(Suppose that week 1 is week exam) and have a seat in row 'B'
SELECT s.Student_Firstname + ' ' + s.Student_Lastname as [Fullname], se.[Row],c.[Status]
From Student s
Inner Join Seat se on s.Student_ID = se.Student_ID
Inner Join CheckAttendence c on s.Student_ID = c.Student_ID
WHERE CHARINDEX('B',[Row]) > 0 AND c.[Status] = 'Absent' AND c.Week = 1
