DECLARE
	x NUMBER;
	Y NUMBER := 0; --변수할당
	z CONSTANT NUMBER := 20;
BEGIN
	x := 10;
	-- z := 30; 
	DBMS_OUTPUT.PUT_LINE('변수 x ->' || x);
	DBMS_OUTPUT.PUT_LINE('변수 y ->' || y);
	DBMS_OUTPUT.PUT_LINE('변수 z ->' || z);
END;



DECLARE
	str VARCHAR2(10);
BEGIN 
	str := 'Hello';
	DBMS_OUTPUT.PUT_LINE(str);
END;

DECLARE
	EMP_ID  NUMBER;
	EMP_NAME VARCHAR2(100);
	EMP_LNAME VARCHAR2(100);
BEGIN 
	SELECT EMPLOYEE_ID
		 , FIRST_NAME
		 , LAST_NAME                   -- INTO는 최종적으로 얻고자 하는값
	  INTO EMP_ID, EMP_NAME, EMP_LNAME -- 변수를 해당 컬럼에 담기위함. 셀렉트 순서에 맞게 들어간다.
	  FROM EMPLOYEES 
	 WHERE EMPLOYEE_ID = 100;
	DBMS_OUTPUT.PUT_LINE(EMP_ID || '/' || EMP_NAME || '/' || EMP_LNAME);
END;	



DECLARE
	EMP_ID   EMPLOYEES.EMPLOYEE_ID%TYPE; --제약조건 정하기 어려울때 참조테이블 타입에 맞게 알아서 지정하는법
	EMP_NAME EMPLOYEES.FIRST_NAME%TYPE;
	EMP_LNAME VARCHAR2(100);
BEGIN 
	SELECT EMPLOYEE_ID
		 , FIRST_NAME
		 , LAST_NAME
	  INTO EMP_ID, EMP_NAME, EMP_LNAME -- 변수를 해당 컬럼에 담기위함 셀렉트 순서에 맞게 들어간다.
	  FROM EMPLOYEES 
	 WHERE EMPLOYEE_ID = 100;
	DBMS_OUTPUT.PUT_LINE(EMP_ID || '/' || EMP_NAME || '/' || EMP_LNAME);
END;	


DECLARE
    EMP   EMPLOYEES%ROWTYPE; -- 참조테이블의 모든 컬럼조회 로우타입은 한행타입만 저장가능
BEGIN 
	SELECT *
	  INTO EMP -- 변수를 해당 컬럼에 담기위함 셀렉트 순서에 맞게 들어간다.
	  FROM EMPLOYEES 
	 WHERE EMPLOYEE_ID = 100; -- 한개행만 조회가능하니 조건을 한개행만 나오게끔 설정한다.
	DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.FIRST_NAME);
	DBMS_OUTPUT.PUT_LINE(EMP.SALARY || '/' || EMP.PHONE_NUMBER);
END;

--- 반복문 문법
DECLARE
    EMP   EMPLOYEES%ROWTYPE;
    ID NUMBER := 100;
BEGIN 
	LOOP		
	  SELECT *
	  	INTO EMP 
	  	FROM EMPLOYEES 
	   WHERE EMPLOYEE_ID = ID;
	  
		IF(NVL(EMP.COMMISSION_PCT, 0) = 0) THEN 
			DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY);
	    ELSE
	     	DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY * (1 + EMP.COMMISSION_PCT));
	    END IF;
	    
		ID := ID + 1;
	
		IF(ID >= 150) THEN
			EXIT;
		END IF;
	END LOOP;
END;

DECLARE
    EMP   EMPLOYEES%ROWTYPE;
    ID NUMBER := 100;
BEGIN 
	LOOP		
	  SELECT *
	  	INTO EMP 
	  	FROM EMPLOYEES 
	   WHERE EMPLOYEE_ID = ID;
	  
		IF(NVL(EMP.COMMISSION_PCT, 0) = 0) THEN 
			DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY);
	    ELSIF(NVL(EMP.COMMISSION_PCT, 0) > 0) THEN
	     	DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY * (1 + EMP.COMMISSION_PCT));
	    END IF;
	    
		ID := ID + 1;
	
		IF(ID >= 150) THEN
			EXIT;
		END IF;
	END LOOP;
END;

--내가 원하는 범위 내에서 반복시키겠다.
DECLARE
    EMP   EMPLOYEES%ROWTYPE;
BEGIN 
	FOR ID IN 100..150 LOOP		-- IN 앞에 REVERSE를 추가하면 역순으로 반복한다.
	  SELECT *
	  	INTO EMP 
	  	FROM EMPLOYEES 
	   WHERE EMPLOYEE_ID = ID;
	  
		IF(NVL(EMP.COMMISSION_PCT, 0) = 0) THEN 
			DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY);
	    ELSIF(NVL(EMP.COMMISSION_PCT, 0) > 0) THEN
	     	DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY * (1 + EMP.COMMISSION_PCT));
	    END IF;
	    
		ID := ID + 1;
	END LOOP;
END;



DECLARE
    EMP   EMPLOYEES%ROWTYPE;
   ID NUMBER := 100;
BEGIN 
	WHILE ID < 150 LOOP		
	  SELECT *
	  	INTO EMP 
	  	FROM EMPLOYEES 
	   WHERE EMPLOYEE_ID = ID;
	  
		IF(NVL(EMP.COMMISSION_PCT, 0) = 0) THEN 
			DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY);
	    ELSIF(NVL(EMP.COMMISSION_PCT, 0) > 0) THEN
	     	DBMS_OUTPUT.PUT_LINE(EMP.EMPLOYEE_ID || '/' || EMP.SALARY * (1 + EMP.COMMISSION_PCT));
	    END IF;
	    
		ID := ID + 1;
	END LOOP;
END;


