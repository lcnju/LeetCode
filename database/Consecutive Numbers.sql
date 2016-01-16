-- Write a SQL query to find all numbers that appear at least three times consecutively.

-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  |  1  |
-- | 2  |  1  |
-- | 3  |  1  |
-- | 4  |  2  |
-- | 5  |  1  |
-- | 6  |  2  |
-- | 7  |  2  |
-- +----+-----+
-- For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

-- Subscribe to see which companies asked this question

DROP DATABASE IF EXISTS leetcode;
CREATE DATABASE leetcode;
USE leetcode

CREATE TABLE Logs (
    Id INT,
    Num INT
);

INSERT INTO Logs VALUE('1', '1');
INSERT INTO Logs VALUE('2', '1');
INSERT INTO Logs VALUE('3', '1');
INSERT INTO Logs VALUE('4', '1');
INSERT INTO Logs VALUE('5', '2');
INSERT INTO Logs VALUE('6', '2');
INSERT INTO Logs VALUE('7', '1');
INSERT INTO Logs VALUE('8', '3');
INSERT INTO Logs VALUE('9', '1');

# Write your MySQL query statement below
SELECT DISTINCT log1.Num
FROM Logs log1 JOIN Logs log2 ON log1.Id = log2.Id - 1 JOIN Logs log3 ON log1.Id = log3.Id - 2
WHERE log1.Num = log2.Num AND log2.Num = log3.Num;
