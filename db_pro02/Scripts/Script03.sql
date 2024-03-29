CREATE TABLE EMP_COMMISSION
AS SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, COMMISSION_PCT 
FROM EMPLOYEES
WHERE 1 = 0;


CREATE TABLE EMP_NO_COMMISSION
AS SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE 1 = 0;

SELECT * FROM EMP_COMMISSION;
SELECT * FROM EMP_NO_COMMISSION;


INSERT INTO EMP_COMMISSION (
	   SELECT EMPLOYEE_ID
	        , FIRST_NAME
	        , LAST_NAME
	        , SALARY
	        , COMMISSION_PCT
	     FROM EMPLOYEES 
	    WHERE COMMISSION_PCT IS NOT NULL 
	    );
	    
INSERT INTO EMP_NO_COMMISSION (
	   SELECT EMPLOYEE_ID
	        , FIRST_NAME
	        , LAST_NAME
	        , SALARY
	     FROM EMPLOYEES 
	    WHERE COMMISSION_PCT IS NULL 
	    );
	   
	   DELETE FROM EMP_NO_COMMISSION;
	   ROLLBACK;
	   COMMIT;
---------------------------------------------------------------------
INSERT ALL
 WHEN COMMISSION_PCT IS NOT NULL THEN
      INTO EMP_COMMISSION VALUES(EMPLOYEE_ID, FIRST_NAME, 이름, SALARY, COMMISSION_PCT)
 WHEN COMMISSION_PCT IS NULL THEN     
      INTO EMP_NO_COMMISSION VALUES(EMPLOYEE_ID, FIRST_NAME, 이름, SALARY)
SELECT EMPLOYEE_ID , LOWER(FIRST_NAME) AS FIRST_NAME , LOWER(LAST_NAME) AS 이름, SALARY, COMMISSION_PCT 
 FROM EMPLOYEES;
COMMIT;

DELETE	FROM EMP_COMMISSION;  
DELETE	FROM EMP_NO_COMMISSION;
ROLLBACK;

SELECT * FROM EMP_COMMISSION;  
SELECT * FROM EMP_NO_COMMISSION;
------------------------------------------------------------------------------------------------------------
/*
 *EMP_COMMISSION 테이블에서 모든 사원에 대해 COMMISSION_PTC 를 0.02 증가 시킨다. 
 */

UPDATE EMP_COMMISSION
SET COMMISSION_PCT  = COMMISSION_PCT + 0.02;

SELECT *FROM EMP_COMMISSION;
COMMIT;
/*
 * EMP_NO_COMMISSION 테이블에서 SALARY가 4000 이하인 사원들에 대해 SALARY를 200 증가 시킨다.
 */
SELECT * FROM EMP_NO_COMMISSION WHERE SALARY <= 4200; 

UPDATE EMP_NO_COMMISSION 
	SET SALARY = SALARY + 200
WHERE SALARY <= 4000;

COMMIT;


----------------------------------------------------------------------------------------

SELECT * FROM EMP_COMMISSION 
WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL);

UPDATE EMP_COMMISSION
   SET SALARY = SALARY + 100
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL);
 
UPDATE EMP_NO_COMMISSION
   SET SALARY = SALARY + 100
 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID IS NOT NULL);


COMMIT;
ROLLBACK;