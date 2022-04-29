--단일행 함수

-- 널 값이 있을때 널을 지정해둔 표현으로 출력하는것
SELECT NVL(NULL, 'Default')
  FROM DUAL;
  
SELECT NVL(COMMISSION_PCT, 0)
  FROM EMPLOYEES; 
  
SELECT DECODE(SALARY ,  2000, '일반사원',  3000, '대리', 10000, '이사', NULL)
FROM EMPLOYEES;
 
SELECT DECODE(식, 값1, 반환값1, 값2, 반환값2, 값3, 반환값3, ..., 기본값)

SELECT DECODE(DEPARTMENT_ID, 90, 'A부서', 60, 'B부서', 100, 'C부서', '그 외') 
  FROM EMPLOYEES;  
  
SELECT DECODE(EXTRACT(MONTH FROM HIRE_DATE), 5, '이전사원', '이후사원')
FROM EMPLOYEES;
 
SELECT DECODE(EXTRACT(YEAR FROM HIRE_DATE), 2000, '신규사원', '기존사원')
  FROM EMPLOYEES; 
  
 --IF문이랑 비슷하다고 보면 된다.
SELECT CASE WHEN 조건식 THEN 반환값
            WHEN 조건식 THEN 반환값
            ...
            ELSE 반환값 -- 꼭 안써도됨.
        END
  FROM EMPLOYEES;  
 
 
 SELECT *
 FROM EMPLOYEES;

SELECT CASE WHEN SALARY >= 2000 AND SALARY < 5000 THEN '하위소득'
			WHEN SALARY >= 5000 AND SALARY < 10000 THEN '중위소득'
			WHEN SALARY >= 10000 THEN '고소득'
			ELSE '미분류'
		END AS 급여분류
  FROM EMPLOYEES; 
 
---여기부터 그룹함수 
SELECT SUM(SALARY) AS 총합
     , ROUND(AVG(SALARY),2) AS 평균
     , MAX(SALARY) AS 최대급여액
     , MIN(SALARY) AS 최소급여액
     , COUNT(SALARY) AS 인원수
  FROM EMPLOYEES;   
  
 
 SELECT SUM(SALARY) AS 총합
     , AVG(SALARY) AS 평균
     , MAX(SALARY) AS 최대급여액
     , MIN(SALARY) AS 최소급여액
     , COUNT(SALARY) AS 인원수
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100;

SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100;

-- MAX, MIN 은 꼭 숫자가아니라 문자열이어도 적용할 수 있다. 사전상의 순서로 
SELECT MAX(FIRST_NAME) -- 사전순 가장 뒤 (뒤로갈수록 값이 크니까)
     , MIN(LAST_NAME) -- 사전순 가장 앞 (앞으로갈수록 값이 작으니까)
  FROM EMPLOYEES;     

-- 그냥 행의 숫자를 세어줌 때문에 따로 컬럼을 지정할 필요는 없음
SELECT COUNT(*)
  FROM EMPLOYEES;
 
 
 