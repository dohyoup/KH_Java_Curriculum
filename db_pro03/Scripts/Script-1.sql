CREATE TABLE my_exercise (
		idx                 NUMBER     PRIMARY KEY
	  ,	EVENT_NAME          VARCHAR2(20)  NOT NULL  
	  , SETS_NUMBER			NUMBER   	  NOT NULL  
	  , E_NUMBER			NUMBER   	  NOT NULL 
	  , P_TIME				VARCHAR2(10)
      , START_DATE   	    DATE 		  NOT NULL 
      , UPDATE_DATE         DATE		  NOT NULL 
);

SELECT * FROM my_exercise;

COMMIT;
CREATE SEQUENCE SEQ_my_exercise
		  START WITH     1
		    MAXVALUE  9999
	    INCREMENT BY     1
	           CYCLE
	        NOCACHE;
	    
DROP SEQUENCE SEQ_my_exercise;


SELECT * FROM LOCATIONS;
SELECT * FROM EMPLOYEES;
SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;w

SELECT *
  FROM(SELECT ROWNUM AS RN
	 , DEPARTMENT_ID
	 , DEPARTMENT_NAME
	 , MANAGER_ID
	 , LOCATION_ID
  FROM DEPARTMENTS
      )
 WHERE RN BETWEEN 20 AND 30; 

SELECT * FROM DEPARTMENTS;
SELECT * FROM JOBS;

SELECT E.EMPLOYEE_ID AS empId
	 , CONCAT(FIRST_NAME, LAST_NAME) AS empName 
	 , LOWER(EMAIL || '@emp.com') AS email
	 , J.JOB_TITLE AS jobName
	 , D.DEPARTMENT_NAME AS deptName
FROM EMPLOYEES E, DEPARTMENTS D, JOBS J
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID 
  AND E.JOB_ID =J.JOB_ID;
 
 SELECT JOB_TITLE AS jobName
		  FROM JOBS;
 
 
 
 
 
 SELECT COUNT(*) FROM DEPARTMENTS
		 WHERE DEPARTMENT_NAME = 'Shipping';
