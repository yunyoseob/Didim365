# RedwoodK 수행 과제 #1 

**도로명 주소 검색 API를 활용한 실시간 도로명 주소 검색 서비스 개발**

<hr>

## 수행 과제표

<hr>		

|구분|	내용| 비고|
|:--:|:--:|:--:|
|과제명|	Open Api 를 활용한 검색 서비스 개발	|-|
|과제개요|	공공 데이터 포털의 Open API 서비스를 활용하여 데이터 검색 서비스를 구현|-|	
|과제수행기간|	한달	|-|
|과제수행결과 발표 |-|-|		
|프로그램 요구사항|	● Project<br>- Dynamic Web Project <br>- Java Maven Project<br>● Enviroment <br>- Log4J(Slf4J) 적용<br>- Properties File 구성하여 환경 변수<br>Setting<br>- Servlet(Tomcat 8.x)<br>● 프로그램 구성<br>- UI<br>> HTML + Java Script <br>> 3rd Party Lib 사용안함 (JQuery 등)<br>- Service<br>> Java Script(Ajax) 통신 활용<br>> JSON Data Struct 사용<br>> JAVA Restful Service 활용|-|
|과제 #1 (필수)|● 도로명 주소 검색 API를 활용한 실시간 도로명 주소 검색 서비스 개발<br>- 다양한 조건의 주소검색 조건<br>- 검색 결과보기 기능 구현<br>- 검색결과 형식보기 기능 구현<br>- 검색결과 상세보기 기능 구현|[API체험하기](https://www.juso.go.kr/addrlink/openApi/apiExprn.do)|
|과제 #2 (선택)|● 전국 및 지방자치단체 시내버스 노선 정보를 정류장정보 테이블의 정보를 활용하여 제공하며,노선번호 목록, 노선별 경유 정류소 목록, 노선정보항목 등을 조회함<br>- 도시코드 목록 조회 <br>- 노선정보항목조회<br>- 노선별경유정류소목록조회<br>- 노선번호목록조회|[공공데이터포털 이용가이드](https://www.data.go.kr/ugs/selectPublicDataUseGuideView.do")|
|제출 산출물|● 설계 산출물<br>- 요구사항 정의서(명세서)<br>- 프로그램 설계서<br>> 프로젝트 구성도<br>> 프로그램 순서도 및 Class Diagram<br>> UI/Service 설계서<br>● 개발 산출물<br>- 프로그램 Source<br>- 프로그램 설치 및 구성 매뉴얼<br>- 프로그램 구동/중지 매뉴얼<br>- 개발일지|-|
|평가 참고사항|● 평가 배점<br>- 프로그램 환경구성 : 20%<br>- 프로그램 설계 산출물 : 30%<br>- 프로그램 개발 산출물 : 30%<br>- 발표 : 20%|	프로그램 UI의 디자인적 측면은 평가에 전혀 고려하지 않으나 사용자 UI/UX 측면에서의 사용 편의성 등은 평가에 포함|

## 과제 #1 도로명 주소 검색 API를 활용한 실시간 도로명 주소 검색 서비스 개발

<hr>

### 요구사항 정의서


|No|구분|요구사항ID|요구사항 명|요구사항 상세 설명|요청자<br>(요청부서)|비고|
|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
|1|	프로그램 요구사항|	REQ-001|	Project	|- Dynamic Web Project<br>- Java Maven Project|	RWK	|
|2|	프로그램 요구사항|	REQ-002|Environment	|- Log4J(Slf4J) 적용<br>- Properties File 구성하여 환경 변수 Setting<br>- Servlet(Tomcat 8.x)|RWK|	
|3|프로그램 요구사항|	REQ-003|	프로그램 구성|- 프로그램 구성<br>- UI<br>> HTML + Java Script<br>> 3rd Party Lib 사용안함 (Jquery 등)<br>- Service<br>> Java Script(Ajax) 통신 활용<br>> JSON Data Struct 사용<br>> JAVA Restful Service 활용|RWK	|
|4|Web|	REQ-004|도로명 주소 검색 API를 활용한 실시간 도로명 주소 검색 서비스 개발|- 다양한 조건의 주소검색 조건<br>- 검색 결과보기 기능 구현<br>- 검색결과 상세보기 기능 구현|RWK|	[API체험하기](https://www.juso.go.kr/addrlink/openApi/apiExprn.do)|

### 프로젝트 구성도

![프로젝트구성도](https://user-images.githubusercontent.com/109064073/184071896-ecc200ec-a90e-4af2-bef7-45a0e8abe8f3.png)

### Class Diagram

![image](https://user-images.githubusercontent.com/109064073/184071478-eef601d2-56ef-4ac2-890a-18146260e754.png)
						
						
### 개발일지

|작성자|작성일|작업시간|작업내용|세부사항|
|:--:|:--:|--|:--|:--|
|윤요섭|8월 5일|3시간|Project Environment Setting|- Dynamic Web Project 생성<br>- Log4j적용<br>- Properties File구성하여 환경변수 Setting<br>- Servlet(Tomcat 8.x)|
|윤요섭|8월 10일|8시간|개발|- index.html에서 키워드 입력 후, Servlet에서 검색 API와 통신하여 searchResult.jsp로 결과 전송|
|윤요섭|8월 11일|6시간|개발|- searchResult.jsp에서 결과를 화면으로 출력<br>- searchResult.jsp에서 다시 결과를 입력한 것을 ajax를 통해 다시 Servlet으로 전달 후, 화면에 출력|

## 화면 및 출력 결과

<hr>

**1. 첫 화면(index.html)**

![image](https://user-images.githubusercontent.com/109064073/184072264-db1ff861-6c01-4ee0-a3d1-d2057d78fc0c.png)

**2. 첫 화면 값 입력 (index.html)**

![image](https://user-images.githubusercontent.com/109064073/184073036-73117500-e731-4920-b13d-cedf6cb49e10.png)

**3. 첫 화면 값 입력 후, 검색가능 여부 확인 (index.html, check.js)**

![image](https://user-images.githubusercontent.com/109064073/184072730-79808fca-102d-4dda-b2d5-163da287bd14.png)

**4. Controller를 통해 검색API에서 결과를 조회 한 뒤, 검색결과 화면으로 반환(RwkCommonController.java, searchResult.jsp)**

![image](https://user-images.githubusercontent.com/109064073/184073104-76bc3dee-1085-45bc-aa1a-d3fb396be529.png)

**5. 검색결과화면에서 다시 값을 입력(searchResult.jsp)**

![image](https://user-images.githubusercontent.com/109064073/184073420-d048b9cb-477b-4c37-89d7-7ad8110f7d81.png)

**6. 검색결과 화면 값 입력 후, 검색가능 여부 확인 (searchResult.jsp, check.js)**

![image](https://user-images.githubusercontent.com/109064073/184072730-79808fca-102d-4dda-b2d5-163da287bd14.png)

**7. Controller를 통해 검색API에서 결과를 조회 한 뒤, 검색결과화면으로 반환(RwkCommonController.java, searchResult.jsp)**

![image](https://user-images.githubusercontent.com/109064073/184073613-65b42700-a109-44a0-87a4-400b6f4c21d6.png)