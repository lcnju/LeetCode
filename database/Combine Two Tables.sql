-- Table: Person

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | PersonId    | int     |
-- | FirstName   | varchar |
-- | LastName    | varchar |
-- +-------------+---------+
-- PersonId is the primary key column for this table.
-- Table: Address

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | AddressId   | int     |
-- | PersonId    | int     |
-- | City        | varchar |
-- | State       | varchar |
-- +-------------+---------+
-- AddressId is the primary key column for this table.

-- Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

-- FirstName, LastName, City, State
-- Subscribe to see which companies asked this question

DROP DATABASE IF EXISTS leetcode;
CREATE DATABASE leetcode;
USE leetcode;

CREATE TABLE Person (
    PersonId INT,
    FirstName VARCHAR(64),
    LastName VARCHAR(64)
);

INSERT INTO Person(PersonId, FirstName, LastName) VALUE('1', 'a', 'b');
INSERT INTO Person(PersonId, FirstName, LastName) VALUE('2', 'c', 'd');
INSERT INTO Person(PersonId, FirstName, LastName) VALUE('3', 'e', 'f');

CREATE TABLE Address (
    AddressId INT,
    PersonId INT,
    City VARCHAR(64),
    State VARCHAR(64)
);

INSERT INTO Address(AddressId, PersonId, City, State) VALUE('1', '2', 'g', 'h');
INSERT INTO Address(AddressId, PersonId, City, State) VALUE('2', '3', 'j', 'k');
INSERT INTO Address(AddressId, PersonId, City, State) VALUE('3', '3', 'l', 'm');

# Write your MySQL query statement below
SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address ON Person.PersonId = Address.PersonId;
