/*
 * DDL
 * 		- Data Definition Language : 데이터 정의어
 * 		- 객체를 정의하기 위한 CREATE(생성), ALTER(수정), DROP(제거) 구문이 있다.
 * 		- 오라클에서 사용하는 객체는 TABLE, VIEW, SEQUENCE, INDEX, FUNCTION, PROCEDUAL, USER, ... 등이 있다.
 */ 

/*
CREATE TABLE 테이블명 (
	   컬럼명 테이터타입(크기) [제약조건]
	 , ...	
);
*/

CREATE TABLE sample_t (
	   u_id NUMBER		 --PRIMARY KEY
	 , JUMIN CHAR(13)    --UNIQUE  
	 , name VARCHAR2(50) NOT NULL
	 , age NUMBER(3)	 DEFAULT(0)
	 , gender CHAR(1)    CHECK(GENDER IN('M', 'F'))
	 , birth_day DATE	 DEFAULT(SYSDATE)
	 , REF_COL NUMBER	 --REFERENCES REF_T(R_ID)
	 , CONSTRAINT PK_SAMPLE_T_U_ID PRIMARY KEY(U_ID)
	 , CONSTRAINT UK_SAMPLE_T_UK_JUMIN UNIQUE(JUMIN)
	 , CONSTRAINT FK_SMAPLE_T_REF_COL FOREIGN key(ref_col) REFERENCES REF_T(r_id)
);

CREATE TABLE REF_T (
	   R_ID NUMBER PRIMARY KEY
	  , NOTE VARCHAR2(100) 
);

DROP TABLE SAMPLE_T;
DROP TABLE REF_T;

ALTER TABLE sample_t ADD (nickname VARCHAR2(100));
ALTER TABLE sample_t MODIFY (nickname VARCHAR2(200));
ALTER TABLE sample_t RENAME COLUMN nickname TO n_name;
ALTER TABLE sample_t DROP COLUMN n_name;
ALTER TABLE sample_t RENAME TO sam_t;
ALTER TABLE ref_t DROP COLUMN r_id CASCADE CONSTRAINT;


ALTER TABLE ref_t ADD UNIQUE(note);
ALTER TABLE ref_t ADD CONSTRAINT UK_REF_T UNIQUE(note);

--컬럼 레벨로만 제약 조건을 추가하는 NOT NULL, CHECK 는 modify 로 추가/삭제
ALTER TABLE ref_t MODIFY note VARCHAR2(100) NOT NULL; -- NOT NULL 제약으로 수정으로 제약조건 추가 됨.
ALTER TABLE ref_t MODIFY note VARCHAR2(100) NULL;     -- NULL 은 수정으로 제약조건 제거.
ALTER TABLE ref_t MODIFY note CHECK(note IN('h', 'k'));
ALTER TABLE ref_t DROP CONSTRAINT SYS_C0022356;


ALTER TABLE ref_t DROP CONSTRAINT UK_REF_T_NOTE 
                  DROP CONSTRAINT SYS_C0022347; -- 기본키 삭제
ALTER TABLE ref_t ADD PRIMARY KEY(r_id, note); -- 제약조건을 수정하기 위해서 기존 제약조건을 삭제 후 추가.


--테이블 레벨로 제약 조건을 추가할 수 있는 PRIMARY KEY, UNIQUE, FOREIGN KEY 는 ADD, DROP 을 사용.

ALTER TABLE ref_t RENAME CONSTRAINT UK_REF_T TO UK_REF_T_NOTE;


ALTER TABLE sample_t DROP CONSTRAINT FK_SAMPLE_T_REF_COL;
ALTER TABLE ref_t DROP COLUMN r_id;

SELECT * FROM user_constraints WHERE table_name = 'REF_T';

COMMENT ON COLUMN sample_t.u_id IS '사용자 구분 아이디';
COMMENT ON COLUMN sample_t.name IS '사용자 이름';
COMMENT ON COLUMN sample_t.age IS '사용자 나이';
COMMENT ON COLUMN sample_t.gender IS '사용자 성별(M:남자, F:여자)';
COMMENT ON COLUMN sample_t.birth_day IS '사용자 생년월일';


SELECT * FROM SAMPLE_T;
SELECT * FROM USER_ALL_TABLES WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'SAMPLE_T';
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'SAMPLE_T'; 
SELECT * FROM user_constraints WHERE table_name = 'SAMPLE_T';
SELECT * FROM user_constraints WHERE table_name = 'REF_T';