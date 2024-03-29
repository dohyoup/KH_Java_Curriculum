-- 직원 테이블
SELECT * FROM EMPLOYEES;

SELECT EMPLOYEE_ID
	   ,FIRST_NAME
	   ,LAST_NAME
	FROM EMPLOYEES;

SELECT EMPLOYEE_ID
	  , FIRST_NAME
	  , LAST_NAME
 FROM EMPLOYEES
WHERE EMPLOYEE_ID >= 200
  AND FIRST_NAME = 'Pat';
 
 
 SELECT EMPLOYEE_ID
	  , FIRST_NAME
	  , LAST_NAME
 FROM EMPLOYEES
WHERE EMPLOYEE_ID >= 200
   OR FIRST_NAME = 'Steven'; -- 문자열 리터럴은 작은 따옴표
  
  
 SELECT EMPLOYEE_ID AS 사번 --컬럼명으로 알 수 없을 때 내가 따로 별칭을 부여
 	 , FIRST_NAME AS 이름
 	 , LAST_NAME 성
 	 , EMAIL AS "이메일 주소" -- 별칭도 띄어쓰기가 들어가면 안된다. 띄어쓸거면 ""로 묶으면 된다.
 	FROM EMPLOYEES;
 
 SELECT EMPLOYEE_ID AS "사번"--3 프롬절 웨얼절 셀렉트절 순으로 해석된다.
 	  , FIRST_NAME AS "이름"
 	  , LAST_NAME AS "성"
   FROM EMPLOYEES --1
  WHERE EMPLOYEE_ID >= 200; --2  
  
  
  SELECT FIRST_NAME || ' ' || LAST_NAME 이름 -- ||는 문자열을 결합할 때 사용
  		,SALARY * 12 AS 연봉
	FROM EMPLOYEES;  


--  조건절에서 사용하는 연산자
-- AND, OR, NOT, IN, NOT IN, BETWEEN ... AND 
-- LIKE, NOT LIKE, IS NULL, IS NOT NULL 
SELECT *
  FROM EMPLOYEES 
 WHERE NOT EMPLOYEE_ID >= 200;

SELECT *
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID IN (200, 201, 202, 203); --소괄호 안에있는 내용만 반영해라
 
 SELECT *
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID NOT IN (200, 201, 202, 203);

SELECT *
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID BETWEEN 200 AND 203;

SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME  LIKE 'S%';--S로 시작하는 이름을 불러옴
 
 SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME  LIKE '%en';--en로 끝나는 이름을 불러옴
 
 
 SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME  LIKE '%ea%';--en로 끝나는 이름을 불러옴
 
 
 SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME  LIKE '_____';--_갯수에 맞춰 글자를 불러온다 _가 5개면 5글자 불러옴
 
 
 SELECT *
  FROM EMPLOYEES 
 WHERE FIRST_NAME  LIKE 'D____';--D는 포함하는 5글자를 불러옴

 
 
 SELECT *
  FROM EMPLOYEES 
 WHERE JOB_ID  LIKE '%\____' ESCAPE '\'; --앞의 글자는 뭐가와도 상관이없고 %_*** 이런 형식의 데이터를 불러오고 싶은것
 
  SELECT *
  FROM EMPLOYEES 
 WHERE JOB_ID NOT LIKE '%$____' ESCAPE '$';

SELECT *
  FORM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL; --해당 테이블의 값이 NULL인 것을 불러와라

SELECT *
  FORM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;

--()로 계산 순서 조정
SELECT *
  FROM EMPLOYEES
 WHERE NOT EMPLOYEE_ID >= 200
 		OR EMPLOYEE_ID = 100;
 	
 SELECT *
  FROM EMPLOYEES
 WHERE NOT (EMPLOYEE_ID >= 200
 		OR EMPLOYEE_ID = 100);	
-- 부서 테이블
SELECT * 
FROM DEPARTMENTS
WHERE NOT (DEPARTMENT_ID  >= 200
		OR DEPARTMENT_ID  = 100);
-- 직급 테이블
SELECT * FROM JOBS;

-- 국가 테이블
SELECT * FROM COUNTRIES;

-- 국가별 지역 테이블
SELECT * FROM LOCATIONS;

-- 대륙 테이블
SELECT * FROM REGIONS;

