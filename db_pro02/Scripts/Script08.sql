DROP SEQUENCE SEQ_TEST;
CREATE SEQUENCE SEQ_TEST
		  START WITH 300
	  INCREMENT BY     5
	   MAXVALUE      310
	   MINVALUE      290
	      CYCLE
	    NOCACHE;
	    
SELECT SEQ_TEST.CURRVAL FROM DUAL; -- 현재값가져오라는건데 객체를 생성한 다음 바로 커런트 밸류를 가져오라하면 값이 없기때문에 에러난다.

SELECT SEQ_TEST.NEXTVAL FROM DUAL; -- 반드시 넥스트 벨류부터 써야한다. -- 넥스트로 값을 생성해준다음 커런트를해야 현재값이 출력된다.

SELECT NVL(NULL, '0') FROM DUAL;

CREATE SEQUENCE SEQ_TEST NOCACHE;