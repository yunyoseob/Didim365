## day6-database : 보고서 

작성일 2022.07.20

작성자 윤요섭 인턴

## day6 과제

<hr>

sql 기본 문법과 ERD를 읽는 방법에 대한 보고서를 제출하세요.

## sql 기본문법

<hr>

sql은 쿼리문을 통해 데이터베이스의 정보를 조회하는 등의
작업을 수행한다.

**✔ SQL Structured Query Language**

SQL에서는 다양한 작업에 대한 명령문을 제공합니다.
- 데이터 Query
- 테이블에서 행 삽입, 갱신 및 삭제
- 객체 생성, 대체, 변경 및 삭제
- 데이터베이스 및 해당 객체에 대한 엑세스 제어
- 데이터베이스 일관성 및 무결성 보장

|질의어|종류|
|:--:|:--:|
|DML|INSERT, SELECT, UPDATE, DELETE, MERGE|
|DDL|CREATE, ALTER, DROP, RENAME, TRUNCATE, COMMIT|
|DCL|GRANT, REVOKE|
|TCL|COMMIT, ROLLBACK, SAVEPOINT|


**✔ SQL 활용 예제 1 : 계정 생성 후, 테이블 만들기**

```sql
-- 계정 생성하기
-- CREATE USER : 계정을 생성하는 키워드
-- IDENTIFIED BY : 비밀번호를 생성하는 키워드
-- CREATE USER 계정명 IDENTIFIED BY 비밀번호
CREATE USER imyoseob  IDENTIFIED BY imyoseob;
-- User IMYOSEOB이(가) 생성되었습니다.

-- User에게 연결 권한 주기
GRANT CREATE SESSION TO imyoseob;
-- Grant을(를) 성공했습니다.

-- User에게 테이블 생성 권한 부여하기
GRANT CREATE TABLE TO imyoseob;
-- Grant을(를) 성공했습니다.

-- TABLE SPACE 생성
-- Oracle Database 안에 table space가 있고, 그 안에 테이블이 있다.
ALTER USER imyoseob QUOTA UNLIMITED ON USERS;
-- User IMYOSEOB이(가) 변경되었습니다.

-- 생성한 계정으로 로그인 해서 테이블 생성하기 
CREATE TABLE TEST_01(
    T1 VARCHAR2(20),
    T2 VARCHAR2(20)
);
-- Table TEST_01이(가) 생성되었습니다.
```

**✔ SQL 활용 예제 2 : 테이블 이름, 속성 바꾸기**

```sql
-- 테이블 이름 바꾸기
RENAME TEST_01 TO TEST_02;
-- 테이블 이름이 변경되었습니다.

-- 테이블 변경 : 칼럼 추가하기
ALTER TABLE TEST_02
ADD T3 VARCHAR2(20);
-- Table TEST_02이(가) 변경되었습니다.

DESC TEST_02;
/*

이름 널? 유형           
-- -- ------------ 
T1    VARCHAR2(20) 
T2    VARCHAR2(20) 
T3    VARCHAR2(20) 
*/

-- 테이블 칼럼 이름 변경
ALTER TABLE TEST_02
RENAME COLUMN T3 TO T3_RENAME;

DESC TEST_02;
/*
이름        널? 유형           
--------- -- ------------ 
T1           VARCHAR2(20) 
T2           VARCHAR2(20) 
T3_RENAME    VARCHAR2(20) 
*/

-- 테이블 컬럼 사이즈 변경
ALTER TABLE TEST_02
MODIFY T3_RENAME VARCHAR2(100);
-- Table TEST_02이(가) 변경되었습니다.

DESC TEST_02;
/*

이름        널? 유형            
--------- -- ------------- 
T1           VARCHAR2(20)  
T2           VARCHAR2(20)  
T3_RENAME    VARCHAR2(100) 
*/

-- 테이블 칼럼 삭제
ALTER TABLE TEST_02
DROP COLUMN T3_RENAME;
DESC TEST_02;
/*
이름 널? 유형           
-- -- ------------ 
T1    VARCHAR2(20) 
T2    VARCHAR2(20) 
*/
```

**✔ SQL DML : INSERT, UPDATE, DELETE**

**DML 특징**

1. DML 쿼리의 경우, 트랜잭션 처리해야 한다.
2. DML은 메모리에 적재된다. 이 때, TCL 명령어인 COMMIT을 하지 않을 경우, 외부 응용프로그램(Eclipse 등)에서는 테이블 내용 중 조회가 불가능하다.
3. TCL 명령어인 COMMIT을 할 경우, 메모리에 적재된 내용을 파일에 적재하므로, 외부 응용프로그램(Eclipse 등)에서 테이블 내용 중 파일에 적재된 내용만 조회 가능하다. 

**✔ SQL 활용 예제 3 : INSERT, UPDATE, DELETE**

```sql
-- 테이블 데이터 입력
INSERT INTO TEST_02(T1, T2)
VALUES ('T1_01', 'T2_01');
-- 1 행 이(가) 삽입되었습니다.

INSERT INTO TEST_02(T1, T2)
VALUES ('T1_02','T2_02');

SELECT*FROM TEST_02;
-- T1        T2
-- T1_01	T2_01
-- T1_02	T2_02

-- 테이블 데이터 수정
UPDATE TEST_02
SET T1='T1_01_1'
WHERE T1='T1_01';
-- 1 행 이(가) 업데이트되었습니다.

SELECT*FROM TEST_02;
-- T1        T2
-- T1_01_1	T2_01
-- T1_02	T2_02


-- 테이블 데이터 삭제
DELETE FROM TEST_02
WHERE T1='T1_01_1';
-- 1 행 이(가) 삭제되었습니다.

SELECT*FROM TEST_02;
-- T1        T2
-- T1_02	T2_02


-- 되돌리기
ROLLBACK;

SELECT*FROM TEST_02;
-- ROLLBACK 하여 아무것도 나오지 않음 

INSERT INTO TEST_02(T1, T2)
VALUES ('T1_03','T2_03');

COMMIT;
ROLLBACK;

-- COMMIT 후 ROLLBACK을 하였기 때문에, 커밋 전 INSERT한 데이터는 조회가 된다.
SELECT*FROM TEST_02;
-- T1        T2
-- T1_03	T2_03

-- TRUNCATE
TRUNCATE TABLE TEST_02;

SELECT*FROM TEST_02;
-- 아무것도 조회되지 않음

-- DROP
DROP TABLE TEST_02;
SELECT*FROM TEST_02;
-- 쿼리문 오류
```

**✔ SQL DML : SELECT**

SQL에서 SELECT 문장은 크게 6개의 절로 구성되어 있다.

```
SELECT : 테이블에서 데이터 질의하는 키워드 

FROM : 데이터를 조회하고 싶은 테이블의 이름을 정하는 키워드

WHERE : 데이터를 조회하는 조건을 적는 키워드

GRUOP BY : 특정 속성을 기준으로 그룹화 하여 검샋할 때 속성 키워드

HAVING : 그룹 함수를 포함한 조건 키워드

ORDER BY : 정렬시 사용하는 키워드
```

SELECT문은 **FROM-WHERE-GROUP BY-HAVING-SELECT-ORDER BY** 순으로 실행됩니다.

**✔ SQL 활용 예제 4 : SELECT**

```sql
-- 채번 쿼리 조회
CREATE TABLE TEST_03(
    T1 VARCHAR2(20),
    T2 VARCHAR2(20)
);

-- 채번 쿼리
SELECT NVL(MAX(SUBSTR(T1, -4)), 0) + 1 AS T3_CHA FROM TEST_03;

-- EMP 테이블 활용 예제

-- 전체 조회
SELECT*FROM EMP;
SELECT*FROM DEPT;

-- 5개 행만 조회
SELECT*FROM EMP WHERE ROWNUM<=5;

-- EMP 테이블에서 연봉순으로 많이 받는 순으로 조회하기
SELECT*FROM EMP ORDER BY SAL DESC;

-- EMP 테이블에서 연봉이 1500이상 조회하기
SELECT*FROM EMP WHERE SAL>=1500;


-- GROUP BY : EMP 테이블에서 부서별 최저 급여와 부서번호 구하기
SELECT MIN(SAL), DEPTNO FROM EMP 
GROUP BY DEPTNO;

-- HAVING : EMP 테이블에서 30번 부서의 최저 급여와 부서번호 구하기
SELECT MIN(SAL), DEPTNO FROM EMP 
GROUP BY DEPTNO
HAVING DEPTNO=30;
```

**✔ SQL Subquery**

Subquery는 다른 Select 문의 절에 포함되는 Select문입니다. 

```
--서브쿼리 
--SELECT : 셀렉트 절 
--    SELECT * FROM DUAL; : 스칼라 서브쿼리 : 셀렉트 절에 SELECT 구문을 사용하는 것 
--      일부 OUTER JOIN 효과가 있다. 
--FROM : 프럼 절 
--    SELECT * FROM DUAL; : 인라인 뷰 서브쿼리 : 프럼 절에 SELECT 구문을 사용하는 것
--      인라인 뷰 서브쿼리를 사용하는 이유는 
--      테이블에 있는 전체 데이터를 사용하지 않고 
--      그 조건에 필요한 컬럼만 먼저 추출해서 사용하기 위해서 
--      파일의 크기를 줄이기 위해서 사용하는 것 
--      INLINE VIEW SUBQUERY 는 INNER JOIN 효과가 있다. 
--WHERE : 웨어 절 
--    SELECT * FROM DUAL; : 서브쿼리 : 웨어 절에 SELECT 구문을 사용하는 것

--서브쿼리 유형
--단일 행(Single-Row) 서브쿼리
--다중 행(Multi-Row) 서브쿼리
--다중 열(컬럼)(Multi-Column) 서브쿼리 
--인라인 뷰(Inline view) 서브쿼리
--스칼라(Scala) 서브쿼리
```

**✔ SQL 활용 예제 5 : SubQuery**

```sql
-- 스칼라 서브쿼리
SELECT A.ENAME, A.DEPTNO, 
                    (SELECT B.DNAME FROM DEPT B WHERE B.DEPTNO=A.DEPTNO) DNAME
FROM EMP A
WHERE A.JOB='MANAGER';

-- INLINE VIEW SUBQUERY AND INNER JOIN
SELECT A.ENAME, B.DNAME, A.DEPTNO
FROM (SELECT*FROM EMP WHERE DEPTNO=20) A, DEPT B
WHERE A.DEPTNO=20
AND A.DEPTNO=B.DEPTNO;

-- 다중행 SUBQUERY  AND INNER JOIN
SELECT A.ENAME, B.DNAME, A.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO
AND A.DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='SMITH');
```
- SELECT 절 안에 ENAME, DNAME은 열 alias로 선택된 열의 이름을 열 머리글로 사용합니다.
- FROM 절 안에 A, B는 테이블 alias로 사용자가 지정한 새 이름입니다.


**✔ SQL JOIN**

조인은 테이블을 합치는 것을 의미한다.

조인 종류

```
1. Natural Join
- USING 절
- ON 절

2. Self-join
3. Nonequijoin
4. OUTER join
- LEFT OUTER join
- RIGHT OUTER join
- FULL OUTER join

5. Cartesian product
- Cross join
```

**✔ SQL 활용 예제 6 : JOIN**

```sql
-- JOIN
SELECT DISTINCT(DEPTNO) FROM EMP;
-- 10, 20, 30
SELECT DISTINCT(DEPTNO) FROM DEPT;
-- 10, 20, 30, 40

SELECT COUNT(DISTINCT(DEPTNO)) FROM EMP;
-- 3
SELECT COUNT(DISTINCT(DEPTNO)) FROM DEPT;
-- 4

-- Natural Join
-- 두 테이블에서 이름이 같은 모든 열 기반
SELECT DEPTNO
FROM EMP
NATURAL JOIN DEPT;
-- 14

-- ON 절을 사용하여 조인 생성
SELECT A.DEPTNO, B.DEPTNO
FROM EMP A
JOIN DEPT B
ON (A.DEPTNO=B.DEPTNO);

-- INNER JOIN
-- 연산자 =를 사용해서 각 테이블에서 동일한 컬럼을 매칭하여 조인
SELECT A.DEPTNO, B.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO;

-- OUTER JOIN
SELECT A.DEPTNO, B.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO(+)=B.DEPTNO;
-- EMP 테이블에는 40번 부서번호가 없다
-- 따라서 마지막 행에 (null), 40 행이 추가된다.

SELECT A.DEPTNO, B.DEPTNO
FROM EMP A, DEPT B
WHERE A.DEPTNO=B.DEPTNO(+);
-- 반면 EMP 테이블에 있는 모든 부서번호는 DEPT 테이블에도
-- 있다
```

**✔ SQL 집합연산자**

집합 연산은 합집합, 교집합, 차집합이 있다.

**✔ SQL 활용 예제 7 : 집합**

```sql
-- 집합 연산자 
--  집합 연산자 (UNION) : 합집합
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=10
UNION
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=20;

-- 집합 연산자 (UNION ALL) : 합집합
-- UNION처럼 합집합의 개념인데, 차이점은 중복된 항목도 모두 조회한다는 것이다.
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=10
UNION ALL
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO=20;

-- 집합 연산자(INTERSECT) : 교집합
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO>=10
INTERSECT
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO>=20;

-- 집합연산자(MINUS) : 차집합
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO>=10
MINUS
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO>=20;
```

## ERD를 읽는 방법

<hr>

ERD(Entity Relationship Diagram)란 개체-관계 모델로 테이블간의 관계를 설명해주는 다이어그램이다.

**✔ 엔티티**

정보가 알려져야 하는 중요한 어떤 측면으로 예시로 사원, 부서 등이 있습니다. (table)

**✔ 속성**

엔티티를 설명하거나 분류하는 것으로 사원 엔티의 경우 사원 번호, 이름, 직책 등이 속성에 포함 될 수 있습니다. (Column)

**✔ 관계**

선택 가능성과 정도를 보여주는 엔티티 간의 명명된 연관을 의미합니다. (PK, FK)

**✔ 엔티티 관계 모델링 규칙**

엔티티

- 단수형 고유이름
- 대문자
- 모서리가 둥근 상자

속성
- 단수형 이름 
- 소문자
- "*"는 필수 사항
- "o"는 선택 사항

**✔ ERD 관계선의 종류**

실선 : 식별 관계
- 부모테이블의 PK가 자식테이블의 FK/PK가 되는 경우
- 부모가 있어야 자식이 생기는 경우

점선 : 비식별 관계
- 부모테이블의 PK가 자식테이블의 일반속성이 되는 경우
- 부모가 없어도 자식이 생기는 경우

**✔ ERD 관계선 : 기호의 종류**

ex) 엔티티가 ERD 다음과 같이 있다고 가정
```
 A  관계선 B 
```
- | : 1:1 관계 
- 한 쪽 닭발 : 1:N 관계
- o + 실선 : 1:1(0) 관계
- o + 한 쪽 닭발 : 1:N(0) 관계

**✔ ERD 기호**

|기호|의미|
|--|--|
|사각형|개체|
|원|속성|
|마름모|관계|
|선|개체 타입과 속성을 연결|

**✔ EMP테이블과 DEPT테이블 ERD 실습**

DB 설계는 크게 논리 모델(Logical)과 물리 모델(Physical)로 나뉜다.

논리 설계는 개념 데이터 모델을 논리적 구조로 정의하여 데이터베이스 관리 시스템과 결부된 논리 데이터 모델로 변환한다.

논리 설계에서 직원테이블(EMP)과 부서테이블(DEPT)의 ERD는 다음과 같다.

<img src="/image/Logical_ERD.PNG" alt="no-image">

한 편, 물리 설계는 논리적 구조로 표현된 데이터 베이스를 물리적 저장장치에 저장 가능한 구조로 변환하는 과정이다.

<img src="/image/Physical_ERD.PNG" alt="no-image">

- Oracle Sql Developer에서 테이블을 클릭하여 Model을 클릭하면, 테이블들의 관계를 볼 수 있다.

직원테이블의 경우 사번이 기본키이며 부서번호가 외래키다.

한 편, 부서테이블은 부서번호가 기본키이다.

두 테이블의 관계를 ERD를 통해 읽어본다면 먼저, 직원 테이블과 부서 테이블은 비식별관계이고, 1:N 관계이다.

```sql
SELECT DISTINCT(DEPTNO) FROM DEPT;
-- 10, 20, 30, 40
SELECT COUNT(DEPTNO) FROM DEPT WHERE DEPTNO=10;
-- 1
-- PK는 NOT NULL && UNIQUE의 특성이 있다.

SELECT COUNT(EMPNO) FROM EMP WHERE DEPTNO=10;
-- 3
```

여기서, 부모 테이블은 부서 테이블이고, 자식 테이블은 사원 테이블이다.

논리/물리 모델을 보면, 사원 테이블의 부서번호는 외래키이고, 부서 테이블에서의 부서번호는 기본키이다.

이처럼 ERD를 보고 Logical일 경우, 주요 엔티티, 속성, 관계를 파악하고
식별/비식별 관계, 1:N 관계의 유무 등을 파악할 수 있으며,

Physical일 경우, 주요 엔티티, 속성, 관계 뿐만 아니라 컬럼의 이름, 데이터 유형, 크기를 파악하고 식별/비식별 관계, 1:N 관계의 유무 등을 파악 할 수 있다.