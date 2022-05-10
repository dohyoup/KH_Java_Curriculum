/*
 * 다음의 요구 사항에 맞추어 데이터 베이스 작업을 진행 한다.
 * 		1. 관리자 계정으로 devAdmin 계정을 새로 만들고 원격 접속과 
 * 		   테이블 생성, 수정, 삭제 / 데이터 추가, 수정, 삭제 / 뷰 테이블 생성을
 * 		   할 수 있는 권한을 부여 한다.
 * 		2. devAdmin 계정으로 접속하고 회원관리를 위한 테이블(USER_ACCOUNT)을 생성한다. 테이블에는
 * 		   ID, 회원계정명, 회원패스워드, 회원이름 정보를 관리 할 수 있도록 컬럼을 생성한다.
 * 		3. 2번에서 생성한 데이터베이스와 외래키로 관계를 맺는 회원정보 테이블(USER_INFO)을 생성한다.
 * 		   테이블에는 ID, 성별, 나이, 이메일, 조소, 전화번호 정보를 관리 할 수 있도록 컬럼을 생성한다.
 * 		   ID 컬럼은 USER_ACCOUNT 와 외래키 관계를 가지는 컬럼으로 생성한다.
 * 		4. 2번, 3번에서 생성한 테이블에 데이터를 3개 추가 한다.
 * 		   데이터를 추가 할 떄 ID 컬럼에 대해서는 SEQUENCE 객체를 사용하여 값이 자동으로 생성될 수 있게한다.
 * 		5. VIEW 를 만들어서 두 개의 테이블 정보가 모두 조회될 수 있도록 한다.
 * 		   성별에 대해서는 남성, 여성으로 변환되게 하며, 패스워드는 * 문자로 마스킹 한다.
 */

CREATE TABLE USER_ACCOUNT (
			 ID NUMBER CONSTRAINT PK_USER_ACCOUNT_ID PRIMARY KEY
		   , 회원계정명 VARCHAR2(100) NOT NULL
		   , 회원패스워드 VARCHAR2(100) NOT NULL
		   , 회원이름 VARCHAR2(18) NOT NULL
);


CREATE TABLE USER_INFO (
			 ID NUMBER PRIMARY KEY
		   , 성별 CHAR(1) CHECK(성별 IN('F', 'M'))
		   , 나이 NUMBER(3)
		   , 이메일 VARCHAR2(100)
		   , 주소 VARCHAR2(100)
		   , 전화번호 CHAR(18)
		   , CONSTRAINT FK_USER_INFO_ID FOREIGN KEY(ID) REFERENCES USER_ACCOUNT(ID)
);		   

INSERT INTO USER_ACCOUNT VALUES (USER_ACCOUNT_SEQ.NEXTVAL, 'DOHYOUP', 'EHDUQ0625', '이도엽');
INSERT INTO USER_INFO VALUES (USER_ACCOUNT_SEQ.CURRVAL, 'F', 28, 'dohyoup@naver.com', '강북구 송중동', '010-1234-5678');

INSERT INTO USER_ACCOUNT VALUES (USER_ACCOUNT_SEQ.NEXTVAL, 'JINHO', 'JINHO0223', '김진호');
INSERT INTO USER_INFO VALUES (USER_ACCOUNT_SEQ.CURRVAL, 'M', 25, 'jinho@naver.com', '강남구 연수동', '010-4343-5328');

INSERT INTO USER_ACCOUNT VALUES (USER_ACCOUNT_SEQ.NEXTVAL, 'DOHYOUP', 'MINJI1123', '양민지');
INSERT INTO USER_INFO VALUES (USER_ACCOUNT_SEQ.CURRVAL, 'F', 26, 'minji@naver.com', '강동구 송파동', '010-1435-6548');


CREATE OR REPLACE VIEW V_USER_INFO --테이블이 이미있으면 대체하고 없으면 생성한다.
	AS SELECT A.ID
		    , A.USERNAME
		    , REPLACE(A.)
		    , AGE + 1 AS AGE -- 가상열 - 가상열에 대해서는 작업을 할 수 가 없다.
		FROM SAMPLE_T
	    WHERE AGE BETWEEN 30 AND 35
   WITH CHECK OPTION;






SELECT * FROM USER_ACCOUNT;
SELECT * FROM USER_INFO;
SELECT * FROM USER_CONSTRAINTS WHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE 'USER\_%' ESCAPE '\';






DROP TABLE USER_ACCOUNT;
DROP TABLE USER_INFO;
CREATE SEQUENCE SEQ_TEST NOCACHE;
CREATE SEQUENCE USER_ACCOUNT_SEQ NOCACHE;