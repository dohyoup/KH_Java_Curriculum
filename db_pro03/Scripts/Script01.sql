/*
 * PL/SQL
 * 		- PROCEDURAL LANGUAGE / SQL
 * 		- 프로그래밍 기능이 추가된 SQL
 * 		- 변수 정의, 조건문, 반복문을 만들어서 SQL 문에 대한 처리 가능
 */

--SET SERVEROUTPUT ON; 비버에서는 사용하지 않아도 출력이 정상적으로된다.
DECLARE
	/*
	 * 변수 선언부 영역
	 */
BEGIN
	/*
	 * 프로그래밍 로직을 작성하는 영역
	 */
	DBMS_OUTPUT.PUT_LINE('Hello PL/SQL');
EXCEPTION
	/*
	 * 예외처리 영역
	 */
END;
--/ 원래는 이렇게 마지막에 슬래쉬까지 써넣어야 실행된다. 비버만 다르다.

