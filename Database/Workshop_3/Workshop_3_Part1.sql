--Part 1: Write the SQL commands using AGGREGATION Functions to answer the following 5 questions:

--Q1: How many VDOs recorded for each course? 
SELECT COUNT(*) AS Number_of_Videos, c.Course_ID
FROM Course c
LEFT JOIN ElearningVideo ev ON c.Course_ID = ev.Course_ID
GROUP BY c.Course_ID;

--Q2: How many courses taught by each instructor?
SELECT COUNT(c.Course_ID) AS Total_Courses,
i.Instructor_FirstName + ' ' + i.Instructor_LastName AS Instructor_FullName
FROM Instructor i
LEFT JOIN Course c ON i.Instructor_ID = c.Instructor_ID
GROUP BY i.Instructor_FirstName + ' ' + i.Instructor_LastName;

--Q3: Find the average amount of course taught by each instructor whose course amount is greater than 50,000 baht. 
SELECT AVG(c.Course_Amount) AS AVG_Course_Amount,
i.Instructor_FirstName + ' ' + i.Instructor_LastName AS Instructor_FullName
FROM Instructor i
JOIN Course c ON i.Instructor_ID = c.Instructor_ID
WHERE c.Course_Amount > 50000
GROUP BY i.Instructor_FirstName + ' ' + i.Instructor_LastName;

--Q4: Find the most expensive course that students have to pay for enrollment.
SELECT c.Course_Amount,
s.Student_FirstName + ' ' + s.Student_LastName AS Student_FullName
FROM Student s 
JOIN EnrollCourse ec ON s.Student_ID = ec.Student_ID
JOIN Course c ON ec.Course_ID = c.Course_ID
WHERE c.Course_Amount = (SELECT MAX(Course_Amount) FROM Course);

--Q5: Find the average score, maximum score, and minimum score that each student can perform after taking examination.
SELECT s.Student_FirstName + ' ' + s.Student_LastName AS Student_FullName,
AVG(es.Score) AS AVG_Score,
MAX(es.Score) AS MAX_Score,
MIN(es.Score) AS MIN_Score
FROM Student s
JOIN PracticeExam pe ON s.Student_ID = pe.Student_ID
JOIN ExamScore es ON pe.Exam_ID = es.Exam_ID
GROUP BY s.Student_FirstName + ' ' + s.Student_LastName;


