-- The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

-- +----+-------+--------+-----------+
-- | Id | Name  | Salary | ManagerId |
-- +----+-------+--------+-----------+
-- | 1  | Joe   | 70000  | 3         |
-- | 2  | Henry | 80000  | 4         |
-- | 3  | Sam   | 60000  | NULL      |
-- | 4  | Max   | 90000  | NULL      |
-- +----+-------+--------+-----------+
-- Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

-- +----------+
-- | Employee |
-- +----------+
-- | Joe      |
-- +----------+
-- Subscribe to see which companies asked this question

DROP DATABASE IF EXISTS leetcode;
CREATE DATABASE leetcode;
USE leetcode;

CREATE TABLE Employee (
    Id INT,
    Name VARCHAR(64),
    Salary INT,
    ManagerId INT
);

INSERT INTO Employee(Id, Name, Salary, ManagerId) VALUE('1', 'Joe', '70000', '3');
INSERT INTO Employee(Id, Name, Salary, ManagerId) VALUE('2', 'Henry', '80000', '4');
INSERT INTO Employee(Id, Name, Salary, ManagerId) VALUE('3', 'Sam', '60000', NULL);
INSERT INTO Employee(Id, Name, Salary, ManagerId) VALUE('4', 'Max', '90000', NULL);

# Write your MySQL query statement below
SELECT a.Name
From Employee a join Employee b on a.ManagerId = b.Id
WHERE a.Salary > b.Salary;
