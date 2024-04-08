## day7-javascript문법 : 보고서 

작성일 2022.07.21

작성자 윤요섭 인턴

## day7 과제

<hr>

## 3-Tier, Web Server, WAS(Web Application Server)

<img src="/image/3tier.PNG" alt="no-image">

3-Tier는 프리젠테이션 레이어, 비즈니스 레이어, 데이터베이스 레이어가 있습니다.

이 중에서 프리젠테이션 레이어는 클라이언트로부터 데이터를 입력받거나, 요청된 데이터를 출력해주는 계층입니다.

웹 프리젠테이션 계층은 일반적으로 HTML, CSS, JavaScript를 사용하여 개발됩니다.

<img src="/image/webserver-vs-was.png" alt="no-image">

Web Server는 프리젠 테이션 계층이며 사용자 인터페이스를 제공합니다. 일반적으로 HTML, CSS 및 JavaScript를 사용하여 개발합니다.

Web Server의 Page는 Static Pages(정적 페이지)입니다. 정적 페이지란 바뀌지 않는 페이지를 의미하며, 항상 동일한 페이지를 반환합니다.

Web Application Server(WAS)는 Web Server와는 달리 Dynamic Pages(동적 페이지)입니다.

동적 페이지는 인자의 내용에 맞게 Contents를 반환합니다. 자바의 경우 Servlet, JSP 등이 WAS에 해당합니다.

오늘 주제인 JavaScript는 정적 페이지에서 WAS를 거치지 않고 바로 자원을 제공할 때 쓰이는 Web Server에 해당하는 언어입니다.

## 브라우저의 기본 구조와 자바스크립트, ECMAScript

<hr>

**✔ 브라우저의 기본 구조와 자바스크립트**

참고 페이지 : [How browsers work](https://taligarsiel.com/Projects/howbrowserswork1.htm), [브라우저는 어떻게 동작하는가?](https://d2.naver.com/helloworld/59361)

브라우저의 주요 구성 요소
1. 사용자 인터페이스
2. 브라우저 엔진
3. 랜더링 엔진
4. 통신
5. UI 백엔드
6. 자바스크립트 해석기
7. 자료 저장소

자바스크립트는 브라우저에 따라 엔진이 다릅니다. 자바 스크립트는 웹 브라우저에서 자바스크립트 소스를 읽고 처리하는 해석기로 구동됩니다.

자바스크립트는 웹 문서에서 &lt; script &gt; 태그를 이용해서 작성합니다.

**✔ ECMAScript**

ECMAScript는 [ECMA](https://www.ecma-international.org/)라는 기관이 만든 script 언어이며, [ECMA-262](https://www.ecma-international.org/publications-and-standards/standards/ecma-262/) 표준을 따르고 있습니다.

- 참고 페이지 : [ECMA Standards](https://www.ecma-international.org/publications-and-standards/standards/)

JavaScript는 ECMAScript의 표준 사양을 가장 잘 구현한 언어로 인정받고 있으며, ECMAScript 5(ES5)까지는 대부분의 브라우저에서 기본적으로 지원되었으나, ECMAScript 6 이후부터는 브라우저 호환성을 위해, 트랜스파일러로 컴파일됩니다.

- 참고 페이지 : [위키백과 : JavaScript](https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8)


## JavaScript 변수

<hr>

JavaScript는 동적 언어로, 변수의 자료형이 실행과정에서 결정됩니다. 따라서, JavaScript에서는 데이터 타입을 사용하지 않습니다.

```
정적 언어 : 컴파일 할 때, 자료형이 결정됨. 그래서 변수를 선언할 때 반드시 변수에 들어가는 값의 자료형을 지정해주어야함. (ex : Java)

동적 언어 : 변수의 자료형이 실행과정에서 결정됨. 그래서 따로 선언할 필요가 없음. (ex : JavaScript)
```

JavaScript에서 변수는 var, let, const 키워드를 사용하여 정의할 수 있습니다.

```javascript
// JavaScript 변수
let x
var y
const z 
```

JavaScript의 자료형은 크게 원시 타입과 객체 타입으로 나눌 수 있습니다. 

원시타입은 숫자, 문자, undefined, null으로 나눌 수 있습니다.

반면, 객체 타입은 객체, 배열, 함수로 나눌 수 있습니다.

**✔ var**

JavaScript에서 var는 Variable의 약자로, var 데이터 타입에 변수명을 선언하고, 데이터 타입을 대입하면 JavaScript 엔진이 알아서 데이터 타입을 맞추어서 생성해 줍니다.

- 데이터 타입은 typeOf() 함수를 통해 확인하여 볼 수 있습니다.

**✔ let**
블록 스코프 지역 변수를 선언. 추가로 동시에 값을 초기화.

**✔ const**
블록 스코프 읽기 전용 상수를 선언.


**🤔 let vs const**

JavaScript에서 ES6 업데이트 이후로 추가된 변수 선언 방식인 let은 같은 변수를 두 번이상 선언할 수 없는 변수입니다. let은 변수에 재할당이 가능하지만, const는 변수에 재할당이 불가합니다.

**✔ 변수 실습 코드**

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaScript 변수</title>
<script type="text/javascript">
	var i=0;
	console.log("i >>> : "+i);
	// i >>> : 0
	console.log("typeof(i) >>> : "+typeof(i));
	// typeof(i) >>> : number
	
	var c='a';
	console.log("c >>> : "+c);
	// c >>> : a
	console.log("typeof(c) >>> : "+typeof(c));
	// typeof(c) >>> : string
	
	var b=false;
	console.log("b >>> : "+b);
	// b >>> : false
	console.log("typeof(b) >>> : "+typeof(b));
	// typeof(b) >>> : boolean

	var s="가나다라마바사";
	console.log("s >>> : "+s);
	// s >>> : 가나다라마바사
	console.log("typeof(s) >>> : "+typeof(s));
	// typeof(s) >>> : string
	
	var f=3.141592;
	console.log("f >>> : "+f);
	// f >>> : 3.141592
	console.log("typeof(f) >>> : "+typeof(f));
	// typeof(f) >>> : number
	
	var l=[1,2,3,4,5];
	console.log("l >>> : "+l);
	// l >>> : 1,2,3,4,5
	console.log("typeof(l) >>> : "+typeof(l));
	// typeof(l) >>> : object
	
	var card = {suit:"하트", rank:"A"};
	var card1 = {"suit":"하트", "rank":"A"};
	console.log("typeof(card) >>> : " + typeof(card));
	// typeof(card) >>> : object
	console.log("typeof(card1) >>> : " + typeof(card1));
	// typeof(card1) >>> : object
	console.log("card.suit >>> : " + card.suit);
	// card.suit >>> : 하트
	console.log("card1.rank >>> : " + card1.rank);
	// card1.suit >>> : A
	
	var t=(1,2,3,4,5);
	console.log("t >>> : "+t);
	// t >>> : 5
	console.log("typeof(t) >>> : "+typeof(t));
	// typeof(t) >>> : number
	
	var n=null;
	console.log("n >>> : "+n);
	// n >>> : null
	console.log("typeof(n) >>> : "+typeof(n));
	// typeOf(n) >>> : object
	
	var u;
	console.log("u >>> : "+u);
	// u >>> : undefined
	console.log("typeof(u) >>> : "+typeof(u));
	// typeOf(u) >>> : undefined
	
	//=================
	let lt=2;
	console.log("lt >>> : "+lt);
	// lt >>> : 2
	console.log("typeof(lt) >>> : "+typeof(lt));
	// typeof(lt) >>> : number
	
	lt="3";
	console.log("lt >>> : "+lt);
	// lt >>> : 3
	console.log("typeof(lt) >>> : "+typeof(lt));
	// typeof(lt) >>> : string
	
	//=================
	const cst=3;
	console.log("cst >>> : "+cst);
	// cst >>> : 3
	console.log("typeof(cst) >>>  :"+typeof(cst));
	// typeof(cst) >>>  :number
	
	cst="4";
	console.log("cst >>> : "+cst);
	// Uncaught TypeError: Assignment to constant variable.
</script>
</head>
<body>
	JavaScript Variable, let, const 연습
</body>
</html>
```

## JavaScript 함수

<hr>

함수를 선언할 때는 function 예약어와 중괄호{}를 사용합니다.

1. 함수선언문

```javascript
function 함수명(){명령문;}
function 함수명(변수) {명령문;}
```

함수 호출 또는 함수 실행
함수명() 또는 함수명(변수)

2. 익명 함수 선언

익명 함수 : 함수 이름이 없는 함수

```javascript
function(){}
var 변수 = function(){}
// 함수를 리터럴로 정의
```

3. 즉시 실행 함수

한 번만 실행하는 함수

```javascript
(function(){명령}());
(function(매개변수){명령}(인수));
```

4. 화살표 함수

(매개변수) => {함수 내용}

```javascript
// 매개변수가 없는 경우
const hi = () => {return "안녕하세요"};

// 매개변수가 1개인 함수
let hi = user => {document.writer(user+"안녕하세요");}

// 메개변수가 2개 이상인 경우
let sum = (a,b) => a+b;
```

**✔ 함수 실습 코드**

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    //함수 선언 
    function fun_1() {
    	return  1 + 2;
    }	
    var f_1 = fun_1();
    console.log("f_1 >>> : " + f_1);
    // f_1 >>> : 3
    
    // 매개변수 있는 함수
    function fun_2(a, b) {
    	return  a + b;
    }	
    
    var f_2 = fun_2(1, 2);
    console.log("f_2 >>> : " + f_2);
    // f_2 >>> : 3
    
    // 익명 함수 
    var f_3 = function(a, b) {
    	return a + b;
    }
    document.write("f_3(1, 2) >>> : " + f_3(1, 2));
    // f_3(1, 2) >>> : 3
    
    // 즉시 실행 함수
    (function() { console.log("즉시 실행 함수 ")}());
    // 즉시 실행 함수 
    
    // 화살표 함수 
    var hi = () => { return "안녕하세요 화살표 함수 ";}
    console.log("hi() >>> : " + hi());
    // hi() >>> : 안녕하세요 화살표 함수 
    
    let say = () => console.log("hi!!");
    say();
    // hi!!
    
    let d = n => n * 2;
    console.log("d(3) >>> : " + d(3));
    /*
    	let d = function(n) {
    		return n * 2;
    	}
    */
    // d(3) >>> : 6
    
    var sum = (a, b) => a + b;
    /*
    	var sum = function (a, b) {
    		return a + b;
    	} 
    */
    console.log("sum(1, 2) >>> : " + sum(1, 2));
    // sum(1, 2) >>> : 3
</script>
</head>
<body>
	<p id="function_practice">JavaScript</p>
	<script>
		document.getElementById('function_practice').innerHTML="자바스크립트 함수 예제";
	</script>
</body>
</html>
```

## JavaScript 제어 흐름과 오류처리 실습

<hr>

```javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어 흐름과 오류 처리</title>
<script type="text/javascript">
	// 반복문
	var x=0;
	while(x<3){
		x++;
		console.log("x >>> : "+x);
		/*
		x >>> : 1
		x >>> : 2
		x >>> : 3
		*/
	}
	
	// 조건문
	if(x===3){
		console.log("x는 10이고 데이터타입도 같습니다.");
		// x는 10이고 데이터타입도 같습니다.
	}else{
		console.log("x는 10이 아니거나 데이터타입도 다릅니다.");
	}
	
	// 예외처리문 
	var arr=[1,2,3];
	try{
		console.log(asrr[1]);
	}catch(e){
		console.log("error입니다.");
		// error입니다.
	}
</script>
</head>
<body>
	JavaScript 제어 흐름과 오류 처리
</body>
</html>
```

## JavaScript : 객체

<hr>

자바스크립트에서의 객체는 프로그램에서 인식할 수 있는 모든 대사을 가리킵니다.

**✔ JavaScript 객체 종류**

1. 문서 객체 모델 : Document Object Model :DOM
- 웹 문서 자체 document, 이미지(img), 링크(link) 등등...
2. 브라우저 관련 객체 : Browser Model Object : BOM
- 웹 브라우저에서 사용하는 정보
- screen, navigater, history, location, document 등
3. 내장 객체 : 웹 프로그래밍에서 자주 사용하는 요소들
- Object, String, Number, Boolean, XMLHttpRequest, RegExp 등등
4. 기타 객체
- JSON 등
5. 사용자 정의
- 사용자 정의로 만드는 객체

```
JavaScript 객체는 참조 형태로 사용한다.

객체 자체가 아닌 인스턴스(instance) 형태로 만들어서 사용한다.

인스턴스 할 때는 new 예약어를 사용한다.

new 객체명

var date = new Date();
```

## JavaScript : BOM(Browser Model Object)

<hr>

|BOM|Describe|
|:--:|:--:|
|window|브라우저 창이 열릴 때마다 하나씩 만들어진다. 최상위 요소|
|screen|현재 사용하는 화면 정보|
|navigator|현재 사용하는 브라우저의 정보|
|history|현재 창에서 사용자의 방문 기록을 저장|
|location|현재 페이지의 URL 정보|
|document|웹 문서마다 하나씩 있으며, body 태그를 만나면      만들어진다.|
  	

**✔ window 객체 예시**

```javascript
setInterval(function(){ 자바스크립트 코드 }, 일정시간 간격)
// 일정 시간이 지난 후에 함수를 실행

setTimeout(function(){ 자바스크립트 코드 }, 일정시간 간격)
// 일정 시간 간격을 두고 함수를 실행
```

**✔ navigator 객체 예시**

```javascript
navigator.userAgent	브라우저와 운영체제 정보
```

**✔ history 객체 예시**

```javascript
history.length		방문 기록에 저장된 목록의 개수
history.back(n)		이전 방문 사이트로 이동
history.forward()	다음 방문 사이트로 이동
history.go(n)		n 번째로 이동, +, -
```

**✔ location 객체 예시**

```javascript
location.href		URL을 반환한다
location.hash		URL	해시값(#에 명시된 값)
location.hostname	호스트 이름
location.host		호스트 이름, 포트번호
location.protocol	프로토콜
location.search		쿼리스트링
loactin.reload()	브라우저 F5 새로고침 기능
```

**✔ screen 객체**

```javascript
screen.width		화면 너비
screen.height		화면 높이
screen.availWidth	작업표시줄 제외한 화면 너비
screen.availHeight	작업표시줄 제외한 화면 높이
screen.colorDepth	사용자 모니터 컬러 bit
```

## JavaScript : DOM(Document Model Object)

<hr>

자바스크립트를 이용해서 웹 문서에 접근하고 제어할 수 있도록 객체를 사용해 웹 문서를 체계적으로 정리하는 방법이다.

DOM은 웹 문서를 하나의 객체로 정의한다.

**✔ DOM 트리**

DOM은 웹 문서의 요소를 부모요소와 자식요소로 구분하며 요소를 부모와 자식 구조로 표시한다.
- DOM 트리에서 각 항목을 노드(node)라고 한다.

**✔ DOM 요소에 접근하기**

HTML 요소(HTMLCollection)를 가져오는 함수들

```javascript
id 선택자
	document.getElementById("id명")

class 선택자
	document.getElementsByClassName("클래스명")

tag 이름 선택자
	document.getElementsByTagName("태그명")
```

**✔ 웹 요소의 내용을 수정하는 innerText, innerHTML property**

자바스크립트에서 웹 요소의 내용을 수정
innerText 프로퍼티는 텍스트 내용을 표시 
innerHTML 프로퍼티는 HTML 태그까지 반영하여 표시 

```javascript
요소명.innerText = 내용;
요소명.innerHTML = 내용;
```

**✔ 속성을 가져오거나 수정하는 getAttribute(), setAttribute()**

```javascript
getAttribute("속성명");
setAttribute("속성명", "값")
```
## JavaScript : 이벤트 처리

<hr>

1. 마우스 이벤트

```javascript
click		사용자가 HTML 요소르 클릭할 때 이벤트가 발생
mousedown	사용자가 요소 위에서 마우스 버튼을 눌렀을 때 이벤트가 발생
```

2. 키보드 이벤트

```javascript
keydown		사용자가 키를 누르는 동안 이벤트가 발생
keypress	사용자가 키를 눌렀을 때 이벤트가 발생
keyup		사용자가 키에서 손을 뗄 때 이벤트가 발생
```

3. 문서로딩 이벤트

```javascript
load	문서 로딩이 끝나면 이벤트가 발생
resize	문서 화면 크기가 바뀌었을 때 이벤트가 발생
scroll	문서 화면이 스크롤되었을 때 이벤트가 발생
```

4. 폼 이벤트

```javascript
blur	폼 요소에 포커스를 잃었을 때 이벤트가 발생
change	<input>, <select>, <textarea> 태그에서
		목록이나 체크 상태들이 변경되면 이벤트가 발생
focus	폼 요소에 포커스가 놓였을 때 이벤트가 발생
		<label>, <select>, <textarea>, <button> 태그에서 사용
reset	폼이 리셋되었을 때 이벤트가 발생
submit	submit 버튼을 클릭했을 때 이벤트가 발생
```

**✔ 이벤트 처리 및 처리 방법**

```javascript
이벤트 처리기 이벤트 핸들러 
===================================================
HTML 태그 안에서 'on' 다음에 '이벤트명'을 붙여서 속성이름을 만들고
===================================================
실행할 이벤트 처리기의 함수명을 작성한다.
<태그 on이벤트명 = "함수명">

이벤트 처리방법

1. HTML 요소의 이벤트 처리기 속성에 설정하는 방법
	<input type="button" onclick="changeColor();">
2. DOM 요소 객체의 이벤트 처리기 프로퍼티에 설정하는 방법
	vat btn = document.getElementById("button");
	btn.onclick = changeColor();
3. addEventListener 메서드를 사용하는 방법
	vat btn = document.getElementById("button");
	btn.addEventListener("click", changeColor, false);
```