 CREATE TABLE accounts(
 	  userid	 VARCHAR2(20) PRIMARY KEY
 	, userpw	 VARCHAR2(20)
 	, username   VARCHAR2(20)
 	, gender	 CHAR(1)
 	, age		 NUMBER
 	, createdate DATE
 );

SELECT * FROM accounts;

DELETE FROM accounts;

DROP TABLE accounts;

SELECT * FROM EMPLOYEES; 
 


