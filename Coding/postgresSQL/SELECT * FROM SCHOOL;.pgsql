SELECT * FROM SCHOOL;
SELECT * FROM SUBJECTS;
SELECT * FROM STAFF;
SELECT * FROM STAFF_SALARY;
SELECT * FROM CLASSES;
SELECT * FROM STUDENTS;
SELECT * FROM PARENTS;
SELECT * FROM STUDENT_CLASSES;
SELECT * FROM STUDENT_PARENT;
SELECT * FROM ADDRESS;


/* Different SQL Operators:::    = , <, >, >=, <=, <>, !=, BETWEEN, ORDER BY, IN, NOT IN, LIKE, ALIASE, DISTINCT, LIMIT, CASE:
Comparison Operators: =, <>, != , >, <, >=, <=
Arithmetic Operators: +, -, *, /, %
Logical Operators: AND, OR, NOT, IN, BETWEEN, LIKE etc.    */

-- Basic queries
SELECT * FROM STUDENTS;   -- Fetch all columns and all records (rows) from table.
SELECT ID, FIRST_NAME FROM STUDENTS; -- Fetch only ID and FIRST_NAME columns from students table.

-- Comparison Operators
SELECT * FROM SUBJECTS WHERE SUBJECT_NAME = 'Mathematics'; -- Fetch all records where subject name is Mathematics.
SELECT * FROM SUBJECTS WHERE SUBJECT_NAME <> 'Mathematics'; -- Fetch all records where subject name is not Mathematics.
SELECT * FROM SUBJECTS WHERE SUBJECT_NAME != 'Mathematics'; -- same as above. Both "<>" and "!=" are NOT EQUAL TO operator in SQL.
SELECT * FROM STAFF_SALARY WHERE SALARY > 10000; -- All records where salary is greater than 10000.
SELECT * FROM STAFF_SALARY WHERE SALARY < 10000; -- All records where salary is less than 10000.
SELECT * FROM STAFF_SALARY WHERE SALARY < 10000 ORDER BY SALARY; -- All records where salary is less than 10000 and the output is sorted in ascending order of salary.
-- Important
SELECT * FROM STAFF_SALARY WHERE SALARY < 10000 ORDER BY SALARY DESC; -- All records where salary is less than 10000 and the output is sorted in descending order of salary.

SELECT * FROM STAFF_SALARY WHERE SALARY >= 10000; -- All records where salary is greater than or equal to 10000.
SELECT * FROM STAFF_SALARY WHERE SALARY <= 10000; -- All records where salary is less than or equal to 10000.

-- Logical Operators
SELECT * FROM STAFF_SALARY WHERE SALARY BETWEEN 5000 AND 10000; -- Fetch all records where salary is between 5000 and 10000.
SELECT * FROM SUBJECTS WHERE SUBJECT_NAME IN ('Mathematics', 'Science', 'Arts'); -- All records where subjects is either Mathematics, Science or Arts.
SELECT * FROM SUBJECTS WHERE SUBJECT_NAME NOT IN ('Mathematics', 'Science', 'Arts'); -- All records where subjects is not Mathematics, Science or Arts.
SELECT * FROM SUBJECTS WHERE SUBJECT_NAME LIKE 'Computer%'; -- Fetch records where subject name has Computer as prefixed. % matches all characters.
SELECT * FROM SUBJECTS;
SELECT * FROM SUBJECTS WHERE SUBJECT_NAME NOT LIKE 'So%ies'; -- Fetch records where subject name does not have Computer as prefixed. % matches all characters.
SELECT * FROM STAFF WHERE AGE > 50 AND GENDER = 'F'; -- Fetch records where staff is female and is over 50 years of age. AND operator fetches result only if the condition mentioned both on left side and right side of AND operator holds true. In OR operator, atleast any one of the conditions needs to hold true to fetch result.
SELECT * FROM STAFF WHERE FIRST_NAME LIKE 'A%' AND LAST_NAME LIKE 'S%'; -- Fetch record where first name of staff starts with "A" AND last name starts with "S".
SELECT * FROM STAFF WHERE FIRST_NAME LIKE 'A%' OR LAST_NAME LIKE 'S%'; -- Fetch record where first name of staff starts with "A" OR last name starts with "S". Meaning either the first name or the last name condition needs to match for query to return data.
SELECT * FROM STAFF WHERE (FIRST_NAME LIKE 'A%' OR LAST_NAME LIKE 'S%') AND AGE > 50; -- Fetch record where staff is over 50 years of age AND has his first name starting with "A" OR his last name starting with "S".

-- Arithmetic Operators
SELECT (5+2) AS ADDITION;   -- Sum of two numbers. PostgreSQL does not need FROM clause to execute such queries.
SELECT (5-2) AS SUBTRACT;   -- Oracle & MySQL equivalent query would be -->  select (5+2) as Addition FROM DUAL; --> Where dual is a dummy table.
SELECT (5*2) AS MULTIPLY;
SELECT (5/2) AS DIVIDE;   -- Divides 2 numbers and returns whole number.
SELECT (5%2) AS MODULUS;  -- Divides 2 numbers and returns the remainder

SELECT * FROM STAFF;
SELECT STAFF_TYPE FROM STAFF ; -- Returns lot of duplicate data.
SELECT DISTINCT STAFF_TYPE FROM STAFF; -- Returns unique values only.

SELECT STAFF_TYPE
FROM 
    (
        SELECT STAFF_ID, STAFF_TYPE
        FROM STAFF 
        LIMIT 5 OFFSET 10
    ) as any_five
ORDER BY STAFF_ID DESC;

-- CASE statement:  (IF 1 then print True ; IF 0 then print FALSE ; ELSE print -1)
SELECT STAFF_ID, SALARY, 
    CASE WHEN SALARY >= 10000 THEN 'High Salary'
       WHEN SALARY BETWEEN 5000 AND 8000 THEN 'Average Salary'
       WHEN SALARY < 5000 THEN 'Too Low'
       ELSE 'in middle'
    END AS RANGE
FROM STAFF_SALARY
ORDER BY 2;

SELECT * 
FROM (
        SELECT ID, FIRST_NAME, GENDER, AGE,
            CASE
                WHEN age < 7 THEN 'lower'
                WHEN age BETWEEN 7 AND 8 THEN 'middle'
                WHEN age > 8 THEN 'higher'
                ELSE 'invalid'
            END as FUCKING_TEXT
        FROM STUDENTS
        ORDER BY 4
    )
COUNT(1)
GROUP BY FUCKING_TEXT


-- TO_CHAR / TO_DATE:
SELECT * FROM STUDENTS;
SELECT * FROM STUDENTS WHERE TO_CHAR(DOB,'YYYY') = '2014';
SELECT * FROM STUDENTS WHERE DOB = TO_DATE('13-JAN-2014','DD-MON-YYYY');
/*
Format Elements in PostgreSQL:

    DD: Day of the month (01 to 31)
    MM: Month number (01 to 12)
    MON: Abbreviated month name (e.g., JAN, FEB)
    MONTH: Full month name (e.g., JANUARY, FEBRUARY)
    YYYY: Four-digit year
    YY: Two-digit year
    HH24: 24-hour clock (00 to 23)
    MI: Minutes (00 to 59)
    SS: Seconds (00 to 59)
*/

-- JOINS (Two ways to write SQL queries):
-- #1. Using JOIN keyword between tables in FROM clause.
SELECT T1.COLUMN1 AS C1, T1.COLUMN2 C2, T2.COLUMN3 AS C3 -- C1, C2, C3 are aliase to the column
FROM TABLE1 T1
    JOIN TABLE2 AS T2 ON T1.C1 = T2.C1
    AND T1.C2 = T2.C2;
-- T1, T2 are aliases for table names.

-- #2. Using comma "," between tables in FROM clause.
SELECT  T1.COLUMN1 AS C1, T1.COLUMN2 AS C2, T2.COLUMN3 C3
  FROM  TABLE1 AS T1, TABLE2 AS T2
 WHERE  T1.C1 = T2.C1
   AND  T1.C2 = T2.C2;


-- Fetch all the class name where Music is thought as a subject.
SELECT CLS.CLASS_NAME, SUB.SUBJECT_NAME
FROM CLASSES as CLS
    JOIN SUBJECTS as SUB ON SUB.SUBJECT_ID = CLS.SUBJECT_ID
WHERE SUB.subject_name = 'Music';



SELECT CLASS_NAME
FROM SUBJECTS SUB
JOIN CLASSES CLS ON SUB.SUBJECT_ID = CLS.SUBJECT_ID
WHERE SUBJECT_NAME = 'Music';

-- Fetch the full name of all staff who teach Mathematics.
SELECT DISTINCT (STF.FIRST_NAME || ' ' || STF.LAST_NAME) as FULL_NAME,STF.STAFF_ID,SUB.subject_name
FROM STAFF as STF
    JOIN CLASSES as CLS ON CLS.TEACHER_ID = STF.STAFF_ID
    JOIN SUBJECTS as SUB ON SUB.SUBJECT_ID = CLS.SUBJECT_ID
WHERE SUB.SUBJECT_NAME = 'Mathematics';


SELECT DISTINCT (STF.FIRST_NAME || ' ' || STF.LAST_NAME) AS FULL_NAME --, CLS.CLASS_NAME
FROM SUBJECTS SUB
    JOIN CLASSES CLS ON CLS.SUBJECT_ID = SUB.SUBJECT_ID
    JOIN STAFF STF ON CLS.TEACHER_ID = STF.STAFF_ID
WHERE SUB.SUBJECT_NAME = 'Mathematics';


-- Fetch all staff who teach grade 8, 9, 10 and also fetch all the non-teaching
-- staff UNION can be used to merge two differnt queries. UNION returns always
-- unique records so any duplicate data while merging these queries will be
-- eliminated.  UNION ALL displays all records including the duplicate records.
-- When using both UNION, UNION ALL operators, rememeber that noo of columns and
-- their data type must match among the different queries.
SELECT (STF.FIRST_NAME || ' ' || STF.LAST_NAME) as FULL_NAME
,   STF.STAFF_TYPE 
,   STF.age
,  (
    CASE 
        WHEN Gender = 'M' THEN 'Male'
        WHEN Gender = 'F' THEN 'Female'
    END
    ) AS GENDER
FROM STAFF as STF
    JOIN CLASSES as CLS on CLS.TEACHER_ID = STF.STAFF_ID
WHERE CLS.class_name IN ('Grade 8','Grade 9','Grade 10')
AND STF.staff_type = 'Teaching'

UNION ALL

SELECT (STF.FIRST_NAME || ' ' || STF.LAST_NAME) as FULL_NAME
,   STF.STAFF_TYPE 
,   STF.age
,  (
    CASE 
        WHEN STF.Gender = 'M' THEN 'Male'
        WHEN STF.Gender = 'F' THEN 'Female'
    END
    ) AS GENDER
FROM STAFF as STF
WHERE STF.STAFF_TYPE = 'Non-Teaching';



SELECT STF.STAFF_TYPE
,    (STF.FIRST_NAME||' '||STF.LAST_NAME) AS FULL_NAME
,    STF.AGE
,    (CASE WHEN STF.GENDER = 'M' THEN 'Male'
           WHEN STF.GENDER = 'F' THEN 'Female'
      END) AS GENDER
,    STF.JOIN_DATE
FROM STAFF STF
JOIN CLASSES CLS ON STF.STAFF_ID = CLS.TEACHER_ID
WHERE STF.STAFF_TYPE = 'Teaching'
AND   CLS.CLASS_NAME IN ('Grade 8', 'Grade 9', 'Grade 10')
UNION ALL
SELECT STAFF_TYPE
,    (FIRST_NAME||' '||LAST_NAME) AS FULL_NAME, AGE
,    (CASE WHEN GENDER = 'M' THEN 'Male'
           WHEN GENDER = 'F' THEN 'Female'
      END) AS GENDER
,    JOIN_DATE
FROM STAFF
WHERE STAFF_TYPE = 'Non-Teaching';


-- Count no of students in each class
SELECT STD.CLASS_ID, COUNT(1) as NO_OF_STUDENT
FROM STUDENT_CLASSES as STD
GROUP BY STD.class_id
ORDER BY STD.class_id;



SELECT SC.CLASS_ID, COUNT(1) AS "no_of_students"
FROM STUDENT_CLASSES SC
GROUP BY SC.CLASS_ID
ORDER BY SC.CLASS_ID;

-- Return only the records where there are more than 100 students in each class
SELECT SC.CLASS_ID, COUNT(1) AS "no_of_students"
FROM STUDENT_CLASSES SC
GROUP BY SC.CLASS_ID
HAVING COUNT(1) > 100
ORDER BY SC.CLASS_ID;


SELECT SC.CLASS_ID, COUNT(1) AS "no_of_students"
FROM STUDENT_CLASSES SC
GROUP BY SC.CLASS_ID
HAVING COUNT(1) > 100
ORDER BY SC.CLASS_ID;

-- Parents with more than 1 kid in school.
SELECT (P.first_name || ' ' || P.last_name) as FULL_NAME_P, COUNT(1) as NO_OF_KIDS
,   P.gender
,   ARRAY_AGG(STD.first_name) AS STUDENT_NAMES
FROM PARENTS as P
    JOIN STUDENT_PARENT as SP on SP.PARENT_ID = P.id
    JOIN STUDENTS as STD on STD.id = SP.student_id
GROUP BY P.gender, FULL_NAME_P
HAVING COUNT(1)>1
ORDER BY 1;


SELECT PARENT_ID, COUNT(1) AS "no_of_kids"
FROM STUDENT_PARENT SP
GROUP BY PARENT_ID
HAVING COUNT(1) > 1;


--SUBQUERY: Query written inside a query is called subquery.
-- Fetch the details of parents having more than 1 kids going to this school.
-- Also display student details.
SELECT (P.FIRST_NAME||' '||P.LAST_NAME) AS PARENT_NAME
,    (S.FIRST_NAME||' '||S.LAST_NAME) AS STUDENT_NAME
,    S.AGE AS STUDENT_AGE
,    S.GENDER AS STUDENT_GENDER
,    (ADR.STREET||', '||ADR.CITY||', '||ADR.STATE||', '||ADR.COUNTRY) AS ADDRESS
FROM PARENTS P
JOIN STUDENT_PARENT SP ON P.ID = SP.PARENT_ID
JOIN STUDENTS S ON S.ID = SP.STUDENT_ID
JOIN ADDRESS ADR ON P.ADDRESS_ID = ADR.ADDRESS_ID
WHERE P.ID IN (  SELECT PARENT_ID
                   FROM STUDENT_PARENT SP
               GROUP BY PARENT_ID
                 HAVING COUNT(1) > 1)
ORDER BY 1;


SELECT * FROM STAFF_SALARY;

-- Staff details who’s salary is less than 5000
SELECT (STF.FIRST_NAME||' '||STF.LAST_NAME) AS STAFF_NAME
FROM STAFF as STF
WHERE STF.staff_id in (
    SELECT staff_id 
    FROM staff_salary 
    WHERE SALARY < 5000
);



SELECT STAFF_TYPE, FIRST_NAME, LAST_NAME
FROM  STAFF
WHERE STAFF_ID IN (SELECT STAFF_ID
                     FROM STAFF_SALARY
                    WHERE SALARY < 5000);


--Aggregate Functions (AVG, MIN, MAX, SUM, COUNT): Aggregate functions are used to perform calculations on a set of values.

-- AVG: Calculates the average of the given values.
SELECT AVG(SS.SALARY)::NUMERIC(10,2) AS AVG_SAL,STF.staff_type
FROM STAFF_SALARY as SS
    JOIN STAFF as STF on STF.staff_id = SS.staff_id 
GROUP BY STF.staff_type;


SELECT AVG(SS.SALARY)::NUMERIC(10,2) AS AVG_SALARY
FROM STAFF_SALARY SS
JOIN STAFF STF ON STF.STAFF_ID = SS.STAFF_ID
WHERE STF.STAFF_TYPE = 'Teaching';

SELECT STF.STAFF_TYPE, AVG(SS.SALARY)::NUMERIC(10,2) AS AVG_SALARY
FROM STAFF_SALARY SS
JOIN STAFF STF ON STF.STAFF_ID = SS.STAFF_ID
GROUP BY STF.STAFF_TYPE;

/* Note:
“::NUMERIC” is a cast operator which is used to convert values from one data type to another.
In the above query we use it display numeric value more cleanly by restricting the decimal point to only 2.
Here 10 is precision which is the total no of digits allowed.
2 is the scale which is the digits after decimal point.
*/

-- SUM: Calculates the total sum of all values in the given column.

SELECT STF.staff_type
, COUNT(SALARY)
, SUM(SALARY)
, AVG(SALARY)::NUMERIC(10,2)
, MIN(salary)
, MAX(salary)
FROM STAFF_SALARY as SS
    JOIN STAFF as STF on STF.STAFF_ID = SS.staff_id 
GROUP BY STF.staff_type;

SELECT STF.STAFF_TYPE, SUM(SS.SALARY)::NUMERIC(10,2) AS AVG_SALARY
FROM STAFF_SALARY SS
JOIN STAFF STF ON STF.STAFF_ID = SS.STAFF_ID
GROUP BY STF.STAFF_TYPE;

-- MIN: Returns the record with minimun value in the given column.
SELECT STF.STAFF_TYPE, MIN(SS.SALARY)::NUMERIC(10,2) AS AVG_SALARY
FROM STAFF_SALARY SS
JOIN STAFF STF ON STF.STAFF_ID = SS.STAFF_ID
GROUP BY STF.STAFF_TYPE;

-- MAX: Returns the record with maximum value in the given column.
SELECT STF.STAFF_TYPE, MAX(SS.SALARY)::NUMERIC(10,2) AS AVG_SALARY
FROM STAFF_SALARY SS
JOIN STAFF STF ON STF.STAFF_ID = SS.STAFF_ID
GROUP BY STF.STAFF_TYPE;

/*
SQL Joins: There are several types of JOIN but we look at the most commonly used:
1) Inner Join
    - Inner joins fetches records when there are matching values in both tables.
2) Outer Join
    - Left Outer Join
        - Left join fetches all records from left table and the matching records
        from right table.
        - The count of the query will be the count of the Left table.
        - Columns which are fetched from right table and do not have a match
        will be passed as NULL.
    - Right Outer Join
        - Right join fetches all records from right table and the matching
        records from left table.
        - The count of the query will be the count of the right table.
        - Columns which are fetched from left table and do not have a match will
        be passed as NULL.
    - Full Outer Join
        - Full join always return the matching and non-matching records from
        both left and right table.
*/

-- Inner Join: 21 records returned – Inner join always fetches only the matching
-- records present in both right and left table.
-- Inner Join can be represented as eithe "JOIN" or as "INNER JOIN". Both are
-- correct and mean the same.
SELECT DISTINCT COUNT(1) FROM STAFF;
SELECT DISTINCT COUNT(1) FROM STAFF_SALARY;

SELECT DISTINCT COUNT(1)
FROM STAFF as STF
    INNER JOIN STAFF_SALARY as SS on STF.staff_id = SS.staff_id
ORDER BY 1;

SELECT DISTINCT COUNT(1)
FROM STAFF as STF
    LEFT JOIN STAFF_SALARY as SS on STF.staff_id = SS.staff_id
ORDER BY 1;

SELECT COUNT(1)
FROM STAFF as STF
    RIGHT JOIN STAFF_SALARY as SS on STF.staff_id = SS.staff_id
ORDER BY 1;

SELECT COUNT()
FROM STAFF as STF
    FULL OUTER JOIN STAFF_SALARY as SS on STF.staff_id = SS.staff_id;




SELECT COUNT(1)
FROM STAFF STF
JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 1;

SELECT DISTINCT (STF.FIRST_NAME||' '||STF.LAST_NAME) AS FULL_NAME, SS.SALARY
FROM STAFF STF
JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 2;


-- 23 records – 23 records present in left table.
-- All records from LEFT table with be fetched irrespective of whether there is matching record in the RIGHT table.
SELECT COUNT(1)
FROM STAFF STF
LEFT JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 1;

SELECT DISTINCT (STF.FIRST_NAME||' '||STF.LAST_NAME) AS FULL_NAME, SS.SALARY
FROM STAFF STF
LEFT JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 2;


-- 24 records – 24 records in right table.
-- All records from RIGHT table with be fetched irrespective of whether there is matching record in the LEFT table.
SELECT COUNT(1)
FROM STAFF STF
RIGHT JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 1;

SELECT DISTINCT (STF.FIRST_NAME||' '||STF.LAST_NAME) AS FULL_NAME, SS.SALARY
FROM STAFF STF
RIGHT JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 1;


-- 26 records – all records from both tables. 21 matching records + 2 records from left + 3 from right table.
-- All records from both LEFT and RIGHT table with be fetched irrespective of whether there is matching record in both these tables.
SELECT COUNT(1)
FROM STAFF STF
FULL OUTER JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 1;

SELECT DISTINCT (STF.FIRST_NAME||' '||STF.LAST_NAME) AS FULL_NAME, SS.SALARY
FROM STAFF STF
FULL OUTER JOIN STAFF_SALARY SS ON SS.STAFF_ID = STF.STAFF_ID
ORDER BY 1,2;