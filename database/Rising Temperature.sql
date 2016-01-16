-- Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

-- +---------+------------+------------------+
-- | Id(INT) | Date(DATE) | Temperature(INT) |
-- +---------+------------+------------------+
-- |       1 | 2015-01-01 |               10 |
-- |       2 | 2015-01-02 |               25 |
-- |       3 | 2015-01-03 |               20 |
-- |       4 | 2015-01-04 |               30 |
-- +---------+------------+------------------+
-- For example, return the following Ids for the above Weather table:
-- +----+
-- | Id |
-- +----+
-- |  2 |
-- |  4 |
-- +----+
-- Subscribe to see which companies asked this question

DROP DATABASE IF EXISTS leetcode;
CREATE DATABASE leetcode;
USE leetcode

CREATE TABLE Weather (
    Id INT,
    Date DATE,
    Temperature INT
);

INSERT INTO Weather VALUE('1', '2015-01-01', '10');
INSERT INTO Weather VALUE('2', '2015-01-02', '20');
INSERT INTO Weather VALUE('3', '2015-01-04', '25');
INSERT INTO Weather VALUE('4', '2015-01-05', '30');

# Write your MySQL query statement below
SELECT w2.Id
FROM Weather w1 JOIN Weather w2 ON TO_DAYS(w1.Date) - TO_DAYS(w2.Date) = -1
WHERE w1.Temperature < w2.Temperature;
