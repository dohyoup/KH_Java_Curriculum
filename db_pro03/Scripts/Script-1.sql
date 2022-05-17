CREATE TABLE my_exercise (
		EVENT_NAME          VARCHAR2(20)  PRIMARY KEY  
	  , SETS_NUMBER			NUMBER   	  NOT NULL  
	  , E_NUMBER			NUMBER   	  NOT NULL 
	  , P_TIME				VARCHAR2(10)
      , START_DATE   	    DATE 		  NOT NULL 
      , UPDATE_DATE         DATE		  NOT NULL 
);

SELECT * FROM my_exercise;

DROP TABLE my_exercise;
DELETE FROM my_exercise;
COMMIT;
