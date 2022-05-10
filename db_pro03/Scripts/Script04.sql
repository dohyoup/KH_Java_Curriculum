/*
 * SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP, ...이걸로만 일단 잘해도 어느정도 가능하긴함
 */

/*
 * 프로시져(PROCEDURE)
 * 	  - PL/SQL 을 사용하여 DBMS 시스템에서 실행 할 프로그램을 만들기 위해 사용하는 객체
 * 	  - 반복 작업 및 복잡한 SQL 구문을 프로시져로 저장하여 재사용하는 용도로 사용될 수 있다.
 * 	  - DBMS 에 컴파일 된 상태로 저장되고 동작하기 때문에 기존 SQL 스크립트 보다는 빠른 독장을 기대할 수 있다. 	
 */
--DROP PROCEDURE PROC_TEST;
CREATE OR REPLACE PROCEDURE PROC_TEST
IS 
BEGIN
	 DBMS_OUTPUT.PUT_LINE('Hello Procedure');
END;
--EXEC PROC_TEST; 비버에서 지원을 안하는 방식
BEGIN
    PROC_TEST;
END;

------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE PROC_INOUT_TEST(n1 IN NUMBER, n2 OUT NUMBER)
IS 
BEGIN 	
	DBMS_OUTPUT.PUT_LINE('n1 -> ' || n1);
	n2 := 10;
END;

DECLARE
	num NUMBER;
BEGIN
	PROC_INOUT_TEST(20, num);
	DBMS_OUTPUT.PUT_LINE('num -> ' || num);
END;
-------------------------------------------------------------------------
CREATE TABLE TEST_TABLE ( -- 테스트용 테이블
	   ID NUMBER
	 , I_DATE DATE  
);

CREATE SEQUENCE TEST_SEQ NOCACHE; --시퀀스

CREATE OR REPLACE PROCEDURE PROC_INSERT_TEST( -- 프로시져생성
	   max_num IN NUMBER  --입력용
	 , res_cnt OUT NUMBER -- 반환용
)
IS 
BEGIN  --프로시져는 일괄 데이터처리를 위해 사용한다.
	res_cnt := 0;
	FOR I IN 1..max_num LOOP 
		INSERT INTO TEST_TABLE VALUES(TEST_SEQ.NEXTVAL, SYSDATE);
		res_cnt := res_cnt + 1;
	END LOOP;
	COMMIT;
END;

DECLARE --프로시져 실행
	res_cnt NUMBER;
BEGIN
	PROC_INSERT_TEST(10, res_cnt);
	DBMS_OUTPUT.PUT_LINE(res_cnt || '개 행이 반영되었습니다.');
END;

SELECT  * FROM TEST_TABLE;

--에러 확인법
SELECT  * FROM ALL_ERRORS WHERE NAME = 'PROC_INSERT_TEST'

	
