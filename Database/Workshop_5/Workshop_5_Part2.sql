USE NEWS_DATABASE;

-- Question 1: Show category of the news that published on date 22 February 2021 or published by cnn website

SELECT n.Title, c.Category_Name, n.Published_Date, w.Name
FROM News n 
JOIN Category c ON n.Category_ID = c.Category_ID 
JOIN Website w ON n.Website_ID = w.Website_ID
WHERE n.Published_Date = '2021-02-21' OR w.Name = 'cnn'

-- Question 2: Show Author who write the title with category name 'NEWS' and have the best rating in review
SELECT a.Author_Firstname + ' ' + a.Author_Lastname as Fullname, c.Category_Name, n.Title,r.Rating
FROM News n 
JOIN Category c ON n.Category_ID = c.Category_ID
JOIN Author a ON n.Author_ID = a.Author_ID
JOIN Review r ON n.News_ID = r.News_ID
WHERE CHARINDEX('NEWS',c.Category_Name) > 0 AND r.Rating = 5
GROUP BY a.Author_Firstname, a.Author_Lastname, c.Category_Name, n.Title,r.Rating

-- Question 3: Show the Author fullname, title, category name, website name and average rating from author and review
SELECT a.Author_Firstname + ' ' + a.Author_Lastname as Author_Fullname, n.Title as News_Title,c.Category_Name,w.Name as Website_Name,(a.Rating + r.Rating)/2 as Average_Rating
FROM News n 
JOIN Review r ON n.News_ID = r.News_ID
JOIN Author a ON n.Author_ID = a.Author_ID
JOIN Category c ON n.Category_ID = c.Category_ID
JOIN Website w ON n.Website_ID = w.Website_ID
WHERE a.Rating > 3.5 AND r.Rating > 2
