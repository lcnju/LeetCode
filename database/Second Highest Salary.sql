-- Write a SQL query to get the second highest salary from the Employee table.

-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- For example, given the above Employee table, the second highest salary is 200. If there is no second highest salary, then the query should return null.

-- Subscribe to see which companies asked this question

DROP DATABASE IF EXISTS leetcode;
CREATE DATABASE leetcode;
USE leetcode;

CREATE TABLE Employee (
    Id INT,
    Salary INT
);

INSERT INTO Employee VALUE('1', '100');
INSERT INTO Employee VALUE('2', '200');
INSERT INTO Employee VALUE('3', '300');

# Write your MySQL query statement below
SELECT MAX(Salary)
FROM Employee
WHERE Salary < (
    SELECT MAX(Salary)
    FROM Employee
);
