SELECT FIRST_NAME
	 , LENGTH(FIRST_NAME)
  FROM EMPLOYEES;
  
SELECT LENGTH('Hello') AS Col1
	 , LENGTH('안녕') AS Col2
	 , LENGTHB('Hello') AS Col3
	 , LENGTHB('안녕') AS Col4 -- 바이트수  
	FROM DUAL; --더미테이블이 저장될 수 있는 거 = 임시 테이블정도
	
	
SELECT INSTR('sample@example.com', '@') AS Col1 
-- 인덱스 에스티알 = 공백의 위치가 어디에 위치해 있는가 DB 위치셀때는 1부터 센다. /자바는 0부터 차이
	 , INSTR('sample@example.com', '@', -1) AS Col2
	  -- -1 해주면 오른쪽에서 왼쪽으로 숫자를 세고 안쓰면 자동으로 1로 인식하고 왼쪽에서 오른쪽으로 찾는다.
	 , INSTR('sample@example.com', 'e') AS Col3
	 , INSTR('sample@example.com', 'e', -1) AS Col4
	 , INSTR('sample@example.com', 'e', 1, 2) AS Col5
	 , INSTR('sample@example.com', 'e', -1, 2) AS Col6
  FROM DUAL;
   
 --L트림은 오른쪽에 지정된 문자열을 왼쪽 문자열에서 제거를 해라는 함수이다./ R은 오른쪽부터/ 그냥트림은 싹다제거
 SELECT LTRIM('    smaple@example.com    ', '    ') AS Col1
 	  , RTRIM('    smaple@example.com    ', '    ') Col2
 	  , TRIM('    smaple@example.com    ') AS Col3
 	  , TRIM(LEADING '-' FROM '----saple@example.com----') AS Col4
 	  , TRIM(TRAILING '-' FROM '----saple@example.com----') AS Col5 
 	  , TRIM(BOTH '-' FROM '----saple@example.com----') AS Col6
 	  FROM DUAL;
 	 
 	 --패드문은 여백을 만들고 싶을때 사용한다.
 SELECT '!' || LPAD('A', 4) AS Col1
      ,'!' || LPAD('AB', 4) AS Col2
      ,'!' || LPAD('ABC', 4) AS Col3
      , RPAD('A', 4) || '!' AS Col4
      , RPAD('AB', 4) || '!' AS Col5
      , RPAD('ABC', 4) || '!' AS Col6
      , RPAD('A', 4, '0') || '!' AS Col7
      , RPAD('ABCDE', 4) || '!' AS Col8 --초과되면 결과값이 잘림
     FROM DUAL;
    
    --원하는 문자열을 잘라내는 함수     시작위치, 글자수
 SELECT SUBSTR('smaple@example.com',1, 6) AS Col1
 	  , SUBSTR('smaple@example.com',8, 7) AS Col2
 	  , SUBSTR('smaple@example.com',-18, 6) AS Col3
 	  , SUBSTR('smaple@example.com',-11, 7) AS Col4
 	  , SUBSTR('smaple@example.com',-11) AS Col5 --문자열 길이를 따로 지정하지 않으면 지정한 시작위치부터 끝까지 잘라낸다.
 	 FROM DUAL;
 	
 	
 SELECT LOWER('smaple@example.com') AS Col1 -- 다소문자
      , UPPER('smaple@example.com') AS Col2 -- 다대문자
      , INITCAP('smaple@example.com') AS Col3 -- 단어의 첫번째 이니셜만 대문자
   FROM DUAL;
  
  --합치는거
 SELECT  CONCAT('smaple', '@example.com') AS Col1
   FROM DUAL;
  
  --             원본 문자열           ,  찾을 문자열     ,  변경 문자열
 SELECT REPLACE('smaple@example.com', 'example.com', 'example.co.kr') AS Col1
   FROM DUAL;
  
  --절대값
 SELECT ABS(10) AS Col1
      , ABS(-10) AS Col2
   FROM DUAL;
  
  -- 나머지 계산
 SELECT MOD(10, 3) AS Col1
      , MOD(-10, 3) AS Col2
 	  , MOD(10.5, 3) AS Col3
 	  , MOD(-10.5, 3) AS Col4
  FROM DUAL;
  
 --반올림
 SELECT ROUND(10.4) AS Col1
      , ROUND(10.5) AS Col2
      , ROUND(10.45) AS Col3
      , ROUND(10.45, -1) AS Col4
      , ROUND(10.456, 2) AS Col5
      , ROUND(18.5, -1) AS Col6 -- -1정수 첫째자리까지 표기해라
  FROM DUAL;
 
 SELECT FLOOR (10.34) AS Col1 -- 그냥 반내림
 	  , CEIL(10.34) AS Col2 -- 그냥 반올림
 	  , FLOOR (-10.34) AS Col3
 	  , CEIL(-10.34) AS Col4
   FROM DUAL;
  
  -- 원하는 자리까지 남기고 잘라낸다.
 SELECT TRUNC(10.34) AS Col1
      , TRUNC(10.34, 1) AS Col2
      , TRUNC(10.3456, 2) AS Col3
      , TRUNC(1234, -1) AS Col4
   FROM DUAL;   
  
 SELECT SYSDATE AS Col1
 	  , ADD_MONTHS(SYSDATE, 2) AS Col2 -- 현재 날짜에 2개월을 더해라
 	  , ADD_MONTHS(SYSDATE, -2) AS Col3 -- 현재 날짜에 2개월을 빼라
 	  , LAST_DAY(SYSDATE) AS Col4 -- 현재달의 마지막 날짜 출력 
 	  , NEXT_DAY(SYSDATE, 5) AS Col5 -- 현재날짜를 기준으로 1: 일요일 2: 월요일 ... 6: 금요일, 7 : 토요일
 	  , NEXT_DAY(SYSDATE, '목') AS Col6
 	  , NEXT_DAY(SYSDATE, 5) AS Col7
 	  , ADD_MONTHS(SYSDATE, 5) AS Col8
 	  , LAST_DAY(SYSDATE)
	FROM DUAL; 


 SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 2)) AS Col1 -- 현재 날짜에서 오른쪽 날짜를 빼라
      , MONTHS_BETWEEN(ADD_MONTHS(SYSDATE, 2), SYSDATE) AS Col2
      , MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE , -4)) AS DD-- 이 함수는 몇개월 차이인지만 보여줄 수 있다.
   FROM DUAL;   
   
 SELECT EXTRACT(YEAR FROM SYSDATE) AS Col1 -- 지금 몇년도이냐
      , EXTRACT(MONTH FROM SYSDATE) AS Col2 -- 지금 몇월이냐
      , EXTRACT(DAY FROM SYSDATE) AS Col3 -- 지금 며칠이냐
      , EXTRACT(HOUR FROM SYSTIMESTAMP) AS Col4 -- 지금 몇시냐
      , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS Col5 -- 지금 몇분이냐
      , EXTRACT(SECOND FROM SYSTIMESTAMP) AS Col6 -- 지금 몇초냐
   FROM DUAL;
  
  
 SELECT SYSDATE + 1 AS Col1 -- 현재일자에서 더하기 빼기 해줌 --일자만 가능
      , SYSDATE + 2 AS Col2
      , SYSDATE - 2 AS Col3
      , SYSDATE - 1 AS Col4
      , SYSDATE + INTERVAL '1' DAY AS Col5 -- 하루 플러스 시켜라
      , SYSDATE + INTERVAL '2' DAY AS Col6 -- 이틀 플러스 시켜라
      , SYSDATE - INTERVAL '2' DAY AS Col7 -- 하루 마이너스 시켜라
      , SYSDATE - INTERVAL '2' DAY AS Col8 -- 이틀 마이너스 시켜라
      , SYSDATE + INTERVAL '1' MONTH AS  Col9 -- 이틀 마이너스 시켜라
      , SYSDATE + INTERVAL '1' YEAR AS  Col10 -- 이틀 마이너스 시켜라
      , SYSDATE + INTERVAL '1' HOUR AS  Col11 -- 이틀 마이너스 시켜라
      , SYSDATE + INTERVAL '1' MINUTE AS  Col12 -- 이틀 마이너스 시켜라
      , SYSDATE + INTERVAL '1' SECOND AS  Col13 -- 이틀 마이너스 시켜라
   FROM DUAL;    
  --형변환
 SELECT 1234 AS Col1
      , TO_CHAR(1234) AS Col2 
      , TO_CHAR(1000000, '999,999,999')  
      , TO_CHAR(1000000, 'L999,999,999') -- L 은 통화단위 표기  
      , TO_CHAR(1000000, '000,000,000')  
      , TO_CHAR(1000000, '000,000,000L')  --뒤에다 쓰면 뒤에 표기
      , TO_CHAR(SYSDATE) AS Col3 -- 날짜를 문자열로 변환
      , TO_CHAR(SYSDATE, 'YYYYMMDD') AS Col4 -- 날짜를 문자열로 변환
      , TO_CHAR(SYSDATE, 'YYYY/MM/DD') AS Col5 -- 날짜를 문자열로 변환
      , TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS Col6 -- 날짜를 문자열로 변환
      , TO_CHAR(SYSDATE, 'YYYY.MM.DD') AS Col7 -- 날짜를 문자열로 변환
      , TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일"') AS Col7 -- 날짜를 문자열로 변환
   FROM DUAL; 
 
  -- 숫자를 날짤형식으로 변환
 SELECT TO_DATE(20220425) AS Col1
      , TO_DATE('20220425') AS CoL2
      , TO_DATE('2022/04/25') AS CoL3
      , TO_DATE('2022-04-25') AS CoL4
      , TO_DATE('2022.04.25') AS CoL5
      , TO_DATE('2022년 04월 25일', 'YYYY"년" MM"월" DD"일"') AS CoL6
 FROM DUAL;

	--넘버는 문자열만 입력값으로 받는다.
SELECT TO_NUMBER('12345')
     , TO_NUMBER('123.456')
     , TO_NUMBER('123,456', '999,999')
     , TO_NUMBER('FF', 'XX') -- 16진수이니깐 10진수 형태로 바꾸어라
  FROM DUAL;   
 
 
 -- 날짜를 숫자로 바꾸고싶을 때 
SELECT TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMMDD'))
	FROM DUAL;
   
  