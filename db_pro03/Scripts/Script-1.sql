CREATE TABLE my_exercise (
		idx                 NUMBER     PRIMARY KEY
	  ,	EVENT_NAME          VARCHAR2(20)  NOT NULL  
	  , SETS_NUMBER			NUMBER   	  NOT NULL  
	  , E_NUMBER			NUMBER   	  NOT NULL 
	  , P_TIME				VARCHAR2(10)
      , START_DATE   	    DATE 		  NOT NULL 
      , UPDATE_DATE         DATE		  NOT NULL 
);

SELECT * FROM my_exercise;

COMMIT;
CREATE SEQUENCE SEQ_my_exercise
		  START WITH     1
		    MAXVALUE  9999
	    INCREMENT BY     1
	           CYCLE
	        NOCACHE;
	    
DROP SEQUENCE SEQ_my_exercise;