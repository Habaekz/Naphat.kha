-- Name: Naphat Khaohn-udomrith
-- Section: 1 
-- ID: 6188029

Use ICTtutorial;
GO
-- Insert Value to table Student
INSERT INTO Student
VALUES ('6188001', 'James', 'Smith', '1885 Saint Francis Way', '1990-11-30', 'james.smi@mail.com', '262-983-4571', 'u6188001', '53151')

INSERT INTO Student
VALUES ('6188002', 'David', 'Clark', '806 Gore Street', '1997-07-07', 'david.cla@mail.com', '713-619-5231', 'u6188002', '77478')

INSERT INTO Student
VALUES ('6188003', 'Diane', 'Anderton', '4851 Biddie Lane', '1957-10-16', 'diana.and@mail.com', '804-593-6409', 'u6188003', '23220')

INSERT INTO Student
VALUES ('6188004', 'Earl', 'Gates', '3296 Southside Lane', '1986-04-30', 'earl.gat@mail.com', '323-657-7798', 'u6188004', '90017')

INSERT INTO Student
VALUES ('6188005', 'Lynn', 'Mader', '1868 Powder House Road', '1981-07-14', 'lynn.mad@mail.com', '561-572-8072', 'u6188005', '74023')

INSERT INTO Student
VALUES ('6188006', 'Peggy', 'Richardson', '4230  Twin Willow Lane', '1971-04-28', 'peggy.ric@mail.com', '910-413-8732', 'u6188006', '28412')

INSERT INTO Student
VALUES ('6188007', 'Joyce', 'Duarte', '1065  Doe Meadow Drive', '1990-12-08', 'joyce.dua@mail.com', '301-520-5290', 'u6188007', '20701')

INSERT INTO Student
VALUES ('6188008', 'Sheila', 'Steel', '3821  Lynn Ogden Lane', '1997-09-13', 'sheila.steel@mail.com', '409-749-9554', 'u6188008', '77627')

INSERT INTO Student
VALUES ('6188009', 'James', 'Melo', '4057  Stutler Lane', '1990-09-13', 'james.mel@mail.com', '814-463-4918', 'u6188009', '16322')

INSERT INTO Student
VALUES ('6188010', 'Francisca', 'Dollard', '3118  Twin Willow Lane', '1964-04-07', 'francisca.dol@mail.com', '910-470-9898', 'u6188010', '28405')

-- Insert Value to table Transaction
INSERT INTO Transaction_
VALUES ('00001',78300)

INSERT INTO Transaction_
VALUES ('00002',15500)

INSERT INTO Transaction_
VALUES ('00003',35400)

INSERT INTO Transaction_
VALUES ('00004',65000)

INSERT INTO Transaction_
VALUES ('00005',14500)

INSERT INTO Transaction_
VALUES ('00006',78300)

INSERT INTO Transaction_
VALUES ('00007',45800)

INSERT INTO Transaction_
VALUES ('00008',35000)

INSERT INTO Transaction_
VALUES ('00009',9800)

INSERT INTO Transaction_
VALUES ('00010',26700)

-- Insert Value to table Payment
INSERT INTO Payment
VALUES ('6188001','00001')

INSERT INTO Payment
VALUES ('6188002','00002')

INSERT INTO Payment
VALUES ('6188003','00003')

INSERT INTO Payment
VALUES ('6188004','00004')

INSERT INTO Payment
VALUES ('6188005','00005')

INSERT INTO Payment
VALUES ('6188006','00006')

INSERT INTO Payment
VALUES ('6188007','00007')

INSERT INTO Payment
VALUES ('6188008','00008')

INSERT INTO Payment
VALUES ('6188009','00009')

INSERT INTO Payment
VALUES ('6188010','00010')

-- Insert Value to table ExamScore
INSERT INTO ExamScore
VALUES ('001',70)

INSERT INTO ExamScore
VALUES ('002',88)

INSERT INTO ExamScore
VALUES ('003',42)

INSERT INTO ExamScore
VALUES ('004',34)

INSERT INTO ExamScore
VALUES ('005',72)

INSERT INTO ExamScore
VALUES ('006',78)

INSERT INTO ExamScore
VALUES ('007',92)

INSERT INTO ExamScore
VALUES ('008',25)

INSERT INTO ExamScore
VALUES ('009',67)

INSERT INTO ExamScore
VALUES ('010',38)

-- Insert Value to table Instructor
INSERT INTO Instructor
VALUES ('4888001', 'Heather', 'Sanders', '827  Glendale Avenue', '1959-11-07', 'heather.san@mail.com', '818-707-8651', 'u4888001', '91301')

INSERT INTO Instructor
VALUES ('4888002', 'Charles', 'Prichard', '790  Modoc Alley', '1988-05-19', 'charles.pri@mail.com', '208-858-0780', 'u4888002', '99161')

INSERT INTO Instructor
VALUES ('4888003', 'Allan', 'Harney', '2830  Scenicview Drive', '1995-03-25', 'allan.har@mail.com', '430-807-4542', 'u4888003', '75201')

INSERT INTO Instructor
VALUES ('4888004', 'David', 'Cox', '2262  Karen Lane', '1992-01-22', 'david.cox@mail.com', '503-207-3127', 'u4888004', '97204')

INSERT INTO Instructor
VALUES ('4888005', 'Hannah', 'Honig', '597  Park Avenue', '1956-12-26', 'hannah.hon@mail.com', '916-465-5991', 'u4888005', '95814')

INSERT INTO Instructor
VALUES ('4888006', 'Robert', 'Karlin', '3084  Marshall Street', '1998-05-01', 'robert.kar@mail.com', '410-728-1010', 'u4888006', '21217')

INSERT INTO Instructor
VALUES ('4888007', 'Sylvia', 'Gantt', '874  Skips Lane', '1962-11-03', 'sylvia.gan@mail.com', '928-585-6357', 'u4888007', '62860')

INSERT INTO Instructor
VALUES ('4888008', 'Leonard', 'Deweese', '3666  Cherry Camp Road', '1984-12-06', 'leonard.dew@mail.com', '773-450-3365', 'u4888008', '71270')

INSERT INTO Instructor
VALUES ('4888009', 'Clinton', 'Strauss', '3621  Lochmere Lane', '1968-04-06', 'clinton.str@mail.com', '860-406-8510', 'u4888009', '15758')

INSERT INTO Instructor
VALUES ('4888010', 'Rene', 'Faulkner', '5017  Raoul Wallenberg Place', '1976-11-18', 'rene.fau@mail.com', '203-904-5700', 'u4888010', '06492')

-- Insert Value to table Course
INSERT INTO Course
VALUES ('ITCS100', '4888001', 'English',78300)

INSERT INTO Course
VALUES ('ITCS101', '4888002', 'Mathematics',15500)

INSERT INTO Course
VALUES ('ITCS102', '4888003', 'Science',35400)

INSERT INTO Course
VALUES ('ITCS103', '4888004', 'Design',65000)

INSERT INTO Course
VALUES ('ITCS104', '4888005', 'Computer',14500)

INSERT INTO Course
VALUES ('ITCS105', '4888006', 'Problem solving',78300)

INSERT INTO Course
VALUES ('ITCS106', '4888007', 'Business',45800)

INSERT INTO Course
VALUES ('ITCS107', '4888008', 'Management',35000)

INSERT INTO Course
VALUES ('ITCS108', '4888009', 'Graphic',9800)

INSERT INTO Course
VALUES ('ITCS109', '4888010', 'Security',26700)

-- Insert Value to table BookStocking
INSERT INTO BookStocking
VALUES ('IT001', 'ITCS100', 'Advance English','Tonya J Jarboe',10,300)

INSERT INTO BookStocking
VALUES ('IT002', 'ITCS101', 'Advance Math','Helen T Ball',7,150)

INSERT INTO BookStocking
VALUES ('IT003', 'ITCS102', 'Advance Science','Leroy H Paton',2,500)

INSERT INTO BookStocking
VALUES ('IT004', 'ITCS103', 'Designing for Professional','Marie A Beale',20,100)

INSERT INTO BookStocking
VALUES ('IT005', 'ITCS104', 'Basic for computer programming','Patricia C Fisher',15,175)

INSERT INTO BookStocking
VALUES ('IT006', 'ITCS105', 'Problem solving','Michael T Daniels',2,350)

INSERT INTO BookStocking
VALUES ('IT007', 'ITCS106', 'Basic for Business','Stanley E Beyer',9,200)

INSERT INTO BookStocking
VALUES ('IT008', 'ITCS107', 'IT Management','Sharon C Freed',17,220)

INSERT INTO BookStocking
VALUES ('IT009', 'ITCS108', 'Graphic using AI','Meredith M Steele',5,390)

INSERT INTO BookStocking
VALUES ('IT010', 'ITCS109', 'Cyber Security','Fred M Ryan',8,299)

-- Insert Value to table ClassAttendence
INSERT INTO CheckAttendence
VALUES ('6188001', 1, '2021-01-31','Present')

INSERT INTO CheckAttendence
VALUES ('6188002', 1, '2021-01-31','Absent')

INSERT INTO CheckAttendence
VALUES ('6188003', 1, '2021-01-31','Late')

INSERT INTO CheckAttendence
VALUES ('6188004', 1, '2021-01-31','Present')

INSERT INTO CheckAttendence
VALUES ('6188005', 1, '2021-01-31','Present')

INSERT INTO CheckAttendence
VALUES ('6188006', 1, '2021-01-31','Present')

INSERT INTO CheckAttendence
VALUES ('6188007', 1, '2021-01-31','Absent')

INSERT INTO CheckAttendence
VALUES ('6188008', 1, '2021-01-31','Late')

INSERT INTO CheckAttendence
VALUES ('6188009', 1, '2021-01-31','Present')

INSERT INTO CheckAttendence
VALUES ('6188010', 1, '2021-01-31','Present')

-- Insert Value to table ElearningVideo
INSERT INTO ElearningVideo
VALUES ('ITCS100','English','Active voice and Passive voice')

INSERT INTO ElearningVideo
VALUES ('ITCS101','Mathematics','Tregonometry')

INSERT INTO ElearningVideo
VALUES ('ITCS102','Science','Element')

INSERT INTO ElearningVideo
VALUES ('ITCS103','Design','Designing the first piece')

INSERT INTO ElearningVideo
VALUES ('ITCS104','Computer','Coding')

INSERT INTO ElearningVideo
VALUES ('ITCS105','Problem solving','Solve the problem')

INSERT INTO ElearningVideo
VALUES ('ITCS106','E-Business','Build the Business')

INSERT INTO ElearningVideo
VALUES ('ITCS107','Management','IT with the Management')

INSERT INTO ElearningVideo
VALUES ('ITCS108','Graphic','Make the first project Graphic')

INSERT INTO ElearningVideo
VALUES ('ITCS109','Security','IT with the Security')

-- Insert Value to table EnrollCourse
INSERT INTO EnrollCourse
VALUES ('6188001','ITCS100')

INSERT INTO EnrollCourse
VALUES ('6188002','ITCS101')

INSERT INTO EnrollCourse
VALUES ('6188003','ITCS102')

INSERT INTO EnrollCourse
VALUES ('6188004','ITCS103')

INSERT INTO EnrollCourse
VALUES ('6188005','ITCS104')

INSERT INTO EnrollCourse
VALUES ('6188006','ITCS105')

INSERT INTO EnrollCourse
VALUES ('6188007','ITCS106')

INSERT INTO EnrollCourse
VALUES ('6188008','ITCS107')

INSERT INTO EnrollCourse
VALUES ('6188009','ITCS108')

INSERT INTO EnrollCourse
VALUES ('6188010','ITCS109')

-- Insert Value to table PracticeExam
INSERT INTO PracticeExam
VALUES ('6188001','001')

INSERT INTO PracticeExam
VALUES ('6188002','002')

INSERT INTO PracticeExam
VALUES ('6188003','003')

INSERT INTO PracticeExam
VALUES ('6188004','004')

INSERT INTO PracticeExam
VALUES ('6188005','005')

INSERT INTO PracticeExam
VALUES ('6188006','006')

INSERT INTO PracticeExam
VALUES ('6188007','007')

INSERT INTO PracticeExam
VALUES ('6188008','008')

INSERT INTO PracticeExam
VALUES ('6188009','009')

INSERT INTO PracticeExam
VALUES ('6188010','010')

-- Insert Value to table Seat
INSERT INTO Seat
VALUES ('S001','ITCS100','6188001','1A',1)

INSERT INTO Seat
VALUES ('S002','ITCS101','6188002','2A',2)

INSERT INTO Seat
VALUES ('S003','ITCS102','6188003','3A',3)

INSERT INTO Seat
VALUES ('S004','ITCS103','6188004','4A',4)

INSERT INTO Seat
VALUES ('S005','ITCS104','6188005','5A',5)

INSERT INTO Seat
VALUES ('S006','ITCS105','6188006','1B',6)

INSERT INTO Seat
VALUES ('S007','ITCS106','6188007','2B',7)

INSERT INTO Seat
VALUES ('S008','ITCS107','6188008','3B',8)

INSERT INTO Seat
VALUES ('S009','ITCS108','6188009','4B',9)

INSERT INTO Seat
VALUES ('S010','ITCS109','6188010','5B',10)

/*Show the information of constaints*/
-- SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS