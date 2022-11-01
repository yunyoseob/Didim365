# day_5_jdbc_coding
day5  jdbc 코딩 maven project 수정본 입니다.

## day5-jdbc : 코딩

작성일 2022.07.26

작성자 윤요섭 인턴

## day5 과제

 java jdbc에 를 사용하여 csv file을 db테이블에 insert하고 select하는 프로젝트 (maven 사용)를 짜고/수행하고 제출하세요. 


<hr>

## 이슈3 : day5_jdbc_coding 수정사항

1. [apach-maven-3.8.6-bin.zip](https://maven.apache.org/download.cgi)을 다운로드하여 환경 변수 세팅을 하였습니다.

```
C:\Users\rwk>mvn -version
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: C:\Downloads\apache-maven-3.8.6
Java version: 1.8.0_202, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_202\jre
Default locale: ko_KR, platform encoding: MS949
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

2. cmd에서 maven project를 생성하였습니다.

```
mvn archetype:generate
```

3. day5_jdbc_coding-1.0-SNAPSHOT.jar파일을 만든 뒤, 테스트 하였습니다.

```
mvn package

java -cp target\day5_jdbc_coding-1.0-SNAPSHOT.jar com.day5_jdbc_coding.App

// Hello World! 출력
```

4. 이클립스에서 File ➡ import ➡ Maven ➡ Existing Maven Projects 생성한 Maven Project가 있는 경로 입력하여, import하였습니다.

5. 이후, pom.xml에서 &lt;maven.compiler.source&gt; 태그의 텍스트를 1.7에서 1.8로 수정한 뒤, Update하였습니다.

6. 이후, day5_jdbc_coding repo를 github에서 생성한 뒤, 이클립스에서 remote하여 작업한 java source와 porm.xml을 커밋한 뒤, push하였습니다.


## 구성 내용

1. [day5_jdbc_coding/src/main/java/com/day5_jdbc_coding/SQLConnectionTest.java](https://github.com/yunyoseob/RedWoodK/blob/master/assignment/internship/day_5_jdbc_coding/day_5_jdbc_coding-master/src/main/java/com/day5_jdbc_coding/SQLConnectionTest.java)

```
Mysql을 설치 후, [인턴교육] DB 접속 정보에 따라, ip, port, id, pw 입력 후, 접속하였습니다.

이후, mysql-connector-java.jar 파일을 통해, java jdbc를 사용하여 연결이 되었는지 확인하는 코드입니다.

- 수행 결과 : 드라이버 로딩과 연결이 성공적으로 이루어졌습니다.
```

2. [day5_jdbc_coding/src/main/java/com/day5_jdbc_coding/MysqlConnProperty.java](https://github.com/yunyoseob/RedWoodK/blob/master/assignment/internship/day_5_jdbc_coding/day_5_jdbc_coding-master/src/main/java/com/day5_jdbc_coding/MysqlConnProperty.java)

```
jdbc를 통해, Eclipse와 Mysql을 연동한 뒤, java.sql 패키지에 있는 Connection과 DriverManager 클래스를 통해 연결하는 추상 클래스를 생성하였습니다.

또한, jdbc 코딩을 통해 TEST 테이블에 Insert, Select를 한 뒤, 연결을 중단하고, Connection 클래스, PreparedStatement 클래스, ResultSet 클래스의 참조변수를 초기화하는 함수를 만들었습니다.
```

3. [day5_jdbc_coding/src/main/java/com/day5_jdbc_coding/TESTQueryMap.java](https://github.com/yunyoseob/RedWoodK/blob/master/assignment/internship/day_5_jdbc_coding/day_5_jdbc_coding-master/src/main/java/com/day5_jdbc_coding/TESTQueryMap.java)

```
eclipse에서 쿼리문을 입력하는 추상클래스를 만든 뒤, testSelectAll(), testSelect(), testInsert() 함수를 만들어 쿼리문을 작성한 파일입니다.
```

4. [day5_jdbc_coding/src/main/java/com/day5_jdbc_coding/day5_jdbc_coding/TESTVO.java](https://github.com/yunyoseob/RedWoodK/blob/master/assignment/internship/day_5_jdbc_coding/day_5_jdbc_coding-master/src/main/java/com/day5_jdbc_coding/TESTVO.java)

```
eclipse에서 변수를 저장하고, setter/getter 메서드를 하는 VO클래스입니다.

TEST 테이블에 있는 칼럼 5개와 기본 생성자, 매개변수가 있는 생성자, setter method, getter method가 있습니다.
```

5. [day5_jdbc_coding/src/main/java/com/day5_jdbc_coding/TESTScr.java](https://github.com/yunyoseob/RedWoodK/blob/master/assignment/internship/day_5_jdbc_coding/day_5_jdbc_coding-master/src/main/java/com/day5_jdbc_coding/TESTScr.java)

```
main 함수가 있는 클래스로, java.util 패키지에 있는 Scanner 클래스를 통해, 사용자가 값을 직접 입력한 뒤, DB테이블에 값을 입력하고, 전체 조회 및 조건 조회를 할 수 있는 소스코드가 담긴 클래스입니다.
```
