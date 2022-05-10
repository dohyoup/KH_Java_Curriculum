--레코드타입
DECLARE
	TYPE MY_TYPE_RECORD IS RECORD ( 
		 ID        EMPLOYEES.EMPLOYEE_ID%TYPE
	   , FNAME     EMPLOYEES.FIRST_NAME%TYPE
	   , LNAME     EMPLOYEES.LAST_NAME%TYPE
	   , SALARY    EMPLOYEES.SALARY%TYPE
	   , DEPT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE
	   ); --레코드타입은 내가 원하는 컬럼만 지정해서 INTO로 넣을 수 있다. 앞에서 ROWDATA가 모든컬럼이었다면 RECORD는 선택적 컬럼이다
	   
	RECORD_DATA   MY_TYPE_RECORD;
	--레코드변수명   --레코드명
BEGIN -- 위의 레코드에 정의한 내가원하는 컬럼만 집어 넣는다 앞의 로우데이타와는 다른방식
	 SELECT E.EMPLOYEE_ID
	 	  , E.FIRST_NAME
	 	  , E.LAST_NAME
	 	  , E.SALARY
	 	  , D.DEPARTMENT_NAME
	  INTO RECORD_DATA
	  FROM EMPLOYEES E JOIN DEPARTMENTS D
	  	ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
	 WHERE EMPLOYEE_ID = 100;
	
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.ID);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.FNAME);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.LNAME);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.SALARY);
	DBMS_OUTPUT.PUT_LINE(RECORD_DATA.DEPT_NAME);
END;

-------------------------------------------------------------------------
--테이블타입 (배열)
DECLARE
	TYPE MY_TYPE_TABLE IS TABLE OF EMPLOYEES.EMPLOYEE_ID%TYPE INDEX BY BINARY_INTEGER; 
	   --테이블타입 = 배열                                       --인덱스 = 숫자타입으로 인덱스 만들겠다
	    TABLE_DATA  MY_TYPE_TABLE;
	    -- 변수명 테이블데이타
	    IDX   NUMBER := 1;
BEGIN
	 FOR D IN (SELECT EMPLOYEE_ID FROM EMPLOYEES) LOOP
			TABLE_DATA(IDX) := D.EMPLOYEE_ID;
			IDX := IDX + 1;
		END LOOP;
		
	 FOR I IN 1..TABLE_DATA.COUNT LOOP	
		 DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I));
	 END LOOP;
END;

-------------------------------------------------------------------------
--같은 테이블타입인데 ROW타입 활용
DECLARE
	TYPE MY_TYPE_TABLE IS TABLE OF EMPLOYEES%ROWTYPE INDEX BY BINARY_INTEGER; 
	   --테이블타입 = 배열                                       --인덱스 = 숫자타입으로 인덱스 만들겠다
	    TABLE_DATA  MY_TYPE_TABLE;
	    -- 변수명 테이블데이타
	    IDX   NUMBER := 1;
BEGIN -- 위의 레코드에 정의한 내가원하는 컬럼만 집어 넣는다 앞의 로우데이타와는 다름방식
	 FOR D IN (SELECT * FROM EMPLOYEES) LOOP
			TABLE_DATA(IDX) := D;
			IDX := IDX + 1;
		END LOOP;
		
	 FOR I IN 1..TABLE_DATA.COUNT LOOP	
		 DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I).EMPLOYEE_ID);
	 END LOOP;
END;

-------------------------------------------------------------------------
DECLARE
    TYPE MY_TYPE_RECORD IS RECORD ( 
		 ID        EMPLOYEES.EMPLOYEE_ID%TYPE
	   , FNAME     EMPLOYEES.FIRST_NAME%TYPE
	   , LNAME     EMPLOYEES.LAST_NAME%TYPE
	   , SALARY    EMPLOYEES.SALARY%TYPE
	   , DEPT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE
	   ); 
	   TYPE MY_TYPE_TABLE IS TABLE OF MY_TYPE_RECORD INDEX BY BINARY_INTEGER; 
	   --테이블타입 = 배열                                       --인덱스 = 숫자타입으로 인덱스 만들겠다
	    TABLE_DATA  MY_TYPE_TABLE;
	    -- 변수명 테이블데이타
	    IDX   NUMBER := 1;
BEGIN -- 위의 레코드에 정의한 내가원하는 컬럼만 집어 넣는다 앞의 로우데이타와는 다름방식
	 FOR D IN (SELECT E.EMPLOYEE_ID 
	                , E.FIRST_NAME
	                , E.LAST_NAME 
	                , E.SALARY 
	                , D.DEPARTMENT_NAME
	             FROM EMPLOYEES E JOIN DEPARTMENTS D
	               ON E.DEPARTMENT_ID = D.DEPARTMENT_ID) LOOP
			TABLE_DATA(IDX) := D;
			IDX := IDX + 1;
		END LOOP;
		
	 FOR I IN 1..TABLE_DATA.COUNT LOOP	
		 DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I).ID);
	 END LOOP;
END;
-------------------------------------------------------------------------
DECLARE
    TYPE MY_TYPE_RECORD IS RECORD ( 
		 ID        EMPLOYEES.EMPLOYEE_ID%TYPE
	   , FNAME     EMPLOYEES.FIRST_NAME%TYPE
	   , LNAME     EMPLOYEES.LAST_NAME%TYPE
	   , SALARY    EMPLOYEES.SALARY%TYPE
	   , DEPT_NAME DEPARTMENTS.DEPARTMENT_NAME%TYPE
	   ); 
	   TYPE MY_TYPE_TABLE IS TABLE OF MY_TYPE_RECORD INDEX BY BINARY_INTEGER; 
	   --테이블타입 = 배열                                       --인덱스 = 숫자타입으로 인덱스 만들겠다
	    TABLE_DATA  MY_TYPE_TABLE;
	    -- 변수명 테이블데이타
	    IDX   NUMBER := 1;
BEGIN -- 위의 레코드에 정의한 내가원하는 컬럼만 집어 넣는다 앞의 로우데이타와는 다름방식
	 FOR D IN (SELECT E.EMPLOYEE_ID 
	                , E.FIRST_NAME
	                , E.LAST_NAME 
	                , E.SALARY 
	                , D.DEPARTMENT_NAME
	             FROM EMPLOYEES E JOIN DEPARTMENTS D
	               ON E.DEPARTMENT_ID = D.DEPARTMENT_ID) LOOP
			TABLE_DATA(IDX) := D;
			IDX := IDX + 1;
		END LOOP;
	
	IDX := TABLE_DATA.FIRST;
	WHILE (IDX IS NOT NULL) LOOP
		DBMS_OUTPUT.PUT_LINE(TABLE_DATA(IDX).FNAME);
		IDX := TABLE_DATA.NEXT(IDX);
    END LOOP;
	
	/*	
	 FOR I IN 1..TABLE_DATA.COUNT LOOP	
		 DBMS_OUTPUT.PUT_LINE(TABLE_DATA(I).ID);
	 END LOOP;
	 */
END;