--용도 = 보안기능 / 권한이 부여된 상태에서 어떤 계정의 스키마명을 알면 어떤 임의의 컬럼명을 입력했을때 허용된것 이상의 자료를 열람할 수 도 있기때문에 테이블명과 스키마명에 보안을 위해 활용한다.
-- -> 관리자가 동의어를 만들어두고 아래 직원들에게 동의어만 알려줘서 원래의 스키마를 다른사람이 알지 못하게 한다. 스키마뿐만 아니라 테이블 명도 바꿀 수 있다.
--테이블 열람권한 부여
GRANT SELECT ON PUSER2.EMPLOYEES TO DEVADMIN; 

--사전 작업으로 PUSER2, DEVADMIN 계정에 SYNONYM 를 생성할 권한을 부여 --> 시스템(관리자) 계정으로 하는 작업
GRANT CREATE SYNONYM TO PUSER2;
GRANT CREATE SYNONYM TO DEVADMIN;


CREATE SYNONYM EMP FOR PUSER2.EMPLOYEES; --PUSER2에서 동의어로 생성(비공개 동의어)  --> 타 계정에서 접근할때 간편하게 하기위해 긴이름을 짧은 동의어로 바꾸어준것
     -- EMPLOYEES --> EMP로 동의어 생성


SELECT * FROM EMP; --조회할때는 그래도 원래의 계정은 표기해줘야한다. (테이블이 존재하는원래계정.타계정에 생성한 동의어) = 조회가능해짐
  -- PUSER2.EMP 이표기를 더 간단하게 만드는 방법이 있음

SELECT * FROM USER_SYNONYMS;
SELECT * FROM EMPLOYEES;

DROP PUBLIC SYNONYM EMP; -- 지울때는 원래 그 테이블이 있는 계정에서 지워야한다.
DROP SYNONYM EMP; -- 지울때는 원래 그 테이블이 있는 계정에서 지워야한다.


--------------------------------------------------------------------------
CREATE PUBLIC SYNONYM EMP1 FOR PUSER2.EMPLOYEES; --공개 동의어 (PUBLIC 붙으면 공개동의어) ,시스템계정으로만 생성가능

SELECT * FROM EMP1; --공게동의어 조회할땐 원래 테이블명 표기안해도 열람가능

SELECT * FROM ALL_SYNONYMS WHERE SYNONYM_NAME = 'EMP';
SELECT * FROM ALL_SYNONYMS WHERE SYNONYM_NAME = 'EMP1';

DROP public SYNONYM EMP1;


