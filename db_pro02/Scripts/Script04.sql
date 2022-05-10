/*
 * 지출내역서 테이블과 지출내역구분 테이블에 데이터를 추가/수정/삭제 하는 작업을 진행 한다.
 * 	-"지출내역구분" 에는 본인의 한 달치 분량의 생활비 내역을 참고하여
 * 	교통비, 식대, 수도세, 전기세 등의 구분명을 추가 한다.
 *  -"지출내역서" 에는 본인의 한 달치 분량의 실제 입출고 내역을 참고하여 
 * 	가계부를 작성하듯 데이터를 추가한다.
 *  -테이블에 추가하는 데이터는 최소 5~10개 정도는 추가하도록 한다.
 */ 
 

      
SELECT  *
FROM 지출내역구분;

SELECT  *
FROM 지출내역서;

INSERT INTO 지출내역구분(구분ID, 구분명) VALUES(1, '교통비'); 
INSERT INTO 지출내역구분(구분ID, 구분명) VALUES(2, '식대'); 
INSERT INTO 지출내역구분(구분ID, 구분명) VALUES(3, '수도세'); 
INSERT INTO 지출내역구분(구분ID, 구분명) VALUES(4, '전기세'); 
INSERT INTO 지출내역구분(구분ID, 구분명) VALUES(5, '핸드폰요금'); 
 
INSERT INTO 지출내역서(날짜, 입금액, 출금액, 비고) VALUES(to_date(2022-04-02), 500000, 10000, '교통비용');
INSERT INTO 지출내역서 VALUES(to_date(20220412), 0, 33000, '핸드폰요금');
INSERT INTO 지출내역서 VALUES(to_date(20220415), 0, 20000, '식대');
INSERT INTO 지출내역서 VALUES(to_date(20220420), 0, 50000, '전기세');
INSERT INTO 지출내역서 VALUES(to_date(20220425), 0, 20000, '수도세');
COMMIT;


/*
 * 위 작업을 모두 마친 후에는 다음의 작업을 추가로 진행 한다.
 * 	- 입금액만을 따로 조회하여 얼마나 입금이 되었는지 통계 조회를 한다.
 *  - 출금액만을 따로 조회하여 얼마나 출금이 되었는지 통계 조회를 한다.
 *  - 위에서 조회한 데이터를 "월별지출내역" 테이블을 새로 만들어 월별로 저장될 수 있게 한다.
 *  - "월별지출내역" 테이블에는 년, 월, 지출구분, 금액 컬럼을 가지게 만들고 지출구분은 '입', '출' 만 저장되도록 한다.
 */

SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , SUM(입금액) AS 입금액
	 , SUM(출금액) AS 출금액
FROM 지출내역서
 WHERE 입금액 > 0
 GROUP BY ROLLUP(EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜));
 

CREATE TABLE 월별지출내역
  AS SELECT EXTRACT(YEAR FROM 날짜) AS 년
	      , EXTRACT(MONTH FROM 날짜) AS 월
	      , '입' AS 지출구분
	      , 입금액 AS 금액
	  FROM 지출내역서
	 WHERE 1 = 0; 

DROP TABLE 월별지출내역;
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = '월별지출내역';
	
	
	
SELECT * FROM 월별지출내역;

INSERT ALL INTO 월별지출내역 VALUES(년, 월, 지출구분, 금액)
SELECT EXTRACT(YEAR FROM 날짜) AS 년
	 , EXTRACT(MONTH FROM 날짜) AS 월
	 , CASE WHEN 입금액 > 0 THEN '입'
	 		WHEN 출금액 > 0 THEN '출'
	   END 지출구분	
	 , SUM(입금액 + 출금액) AS 금액
FROM 지출내역서
 GROUP BY EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜)
 		, CASE WHEN 입금액 > 0 THEN '입'
	 		   WHEN 출금액 > 0 THEN '출'
	      END;	
	   
UPDATE 지출내역서
SET 출금액 = 출금액 + (출금액 * 0.1)
WHERE 출금액 > 0;

UPDATE 월별지출내역
   SET 금액 = 금액 * 1.1
 WHERE 지출구분 = '출';  

INSERT ALL INTO 월별지출내역 VALUES(년, 월, 지출구분, 금액);


	   
	   