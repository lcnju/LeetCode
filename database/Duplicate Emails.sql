-- Write a SQL query to find all duplicate emails in a table named Person.

-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- For example, your query should return the following for the above table:

-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+
-- Note: All emails are in lowercase.

-- Subscribe to see which companies asked this question

DROP DATABASE IF EXISTS leetcode;
CREATE DATABASE leetcode;
USE leetcode;

CREATE TABLE Person (
    Id INT,
    Email VARCHAR(64)
);

INSERT INTO Person(Id, Email) VALUE('1', 'a@b.com');
INSERT INTO Person(Id, Email) VALUE('2', 'c@d.com');
INSERT INTO Person(Id, Email) VALUE('3', 'a@b.com');

# Write your MySQL query statement below
SELECT Email
FROM Person
Group by Email
HAVING count(*) > 1;
