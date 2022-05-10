DROP TABLE SAMPLE_T;

CREATE TABLE SAMPLE_T (
	   ID NUMBER PRIMARY KEY
	 , NAME VARCHAR(30) NOT NULL
	 , GENDER CHAR(1) CHECK(GENDER IN ('F', 'M'))
	 , AGE NUMBER DEFAULT(0) NOT NULL
);

INSERT INTO SAMPLE_T VALUES(1, '홍길동', 'M', 32);
INSERT INTO SAMPLE_T VALUES(2, '김수정', 'F', 28);
INSERT INTO SAMPLE_T VALUES(3, '박정길', 'M', 30);
	 
CREATE OR REPLACE VIEW V_SAMPLE_T --테이블이 이미있으면 대체하고 없으면 생성한다.
	AS SELECT ID
		    , NAME
		    , GENDER
		    , AGE + 1 AS AGE -- 가상열 - 가상열에 대해서는 작업을 할 수 가 없다.
		FROM SAMPLE_T
	    WHERE AGE BETWEEN 30 AND 35
   WITH CHECK OPTION; -- WHERE 절이랑 같이써야한다. WHERE 조건에 위배되는 수정사항을 진행하려하면 못하게 막는다. 
-- WITH READ ONLY; -- 읽기만 가능 읽기전용뷰로 변형시키는것 아무런 수정불가
	   
SELECT * FROM V_SAMPLE_T;
SELECT * FROM V_SAM
SELECT * FROM USER_VIEWS;

INSERT INTO V_SAMPLE_T VALUES(5,'이기석', 'M', 20); -- 뷰는 NOT NULL로 지정한 컬럼에 대해서는 누락되어선 안된다. / NOT NULL이어도  디폴트값 설정되어 있으면 입력됨.

UPDATE V_SAMPLE_T
   SET AGE = AGE + 1;	
 
DELETE FROM V_SAMPLE_T;  -- 행데이터 지울때
DROP VIEW V_SAMPLE_T; -- 테이블 지울때 

  
  