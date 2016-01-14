-- Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

-- Table: Customers.

-- +----+-------+
-- | Id | Name  |
-- +----+-------+
-- | 1  | Joe   |
-- | 2  | Henry |
-- | 3  | Sam   |
-- | 4  | Max   |
-- +----+-------+
-- Table: Orders.

-- +----+------------+
-- | Id | CustomerId |
-- +----+------------+
-- | 1  | 3          |
-- | 2  | 1          |
-- +----+------------+
-- Using the above tables as example, return the following:

-- +-----------+
-- | Customers |
-- +-----------+
-- | Henry     |
-- | Max       |
-- +-----------+
-- Subscribe to see which companies asked this question

DROP DATABASE IF EXISTS leetcode;
CREATE DATABASE leetcode;
USE leetcode;

CREATE TABLE Customers (
    Id INT,
    Name VARCHAR(64)
);

INSERT INTO Customers(Id, Name) VALUE('1', 'Joe');
INSERT INTO Customers(Id, Name) VALUE('2', 'Henry');
INSERT INTO Customers(Id, Name) VALUE('3', 'Sam');
INSERT INTO Customers(Id, Name) VALUE('4', 'Max');

CREATE TABLE Orders (
    Id INT,
    CustomerId INT
);

INSERT INTO Orders(Id, CustomerId) VALUE('1', '3');
INSERT INTO Orders(Id, CustomerId) VALUE('2', '1');

# Write your MySQL query statement below
SELECT Name
FROM Customers c
WHERE c.Id NOT IN  (
    SELECT CustomerId
    FROM Orders
);
