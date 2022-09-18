## day8 - 웹어플리케이션:코딩

작성일 2022.07.26

작성자 윤요섭 인턴

## day8 과제

<hr>

웹 어플리케이션(ToDo List)를 작성/수행하고 제출하세요. (jQuery, Vue, React, Angular 등 프레임 웍을 쓰지 마세요.)

[참고링크 : 실습3-2 ToDo 리스트 앱 만들기, HTML, CSS, JavaScript, Bootstrap](https://www.youtube.com/watch?v=sba1gcCQS3w)

## Code

**✔ [todoList.html](https://github.com/Yun-Yoseob/ToDoList/blob/master/todoList.html)**

**✔ todoList.html 전체 코드**

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDo List</title>
<style type="text/css">	
	input{
		height:22px;
		width:150px;
	}
	
	table, tr, td{
		border : 2px solid #ffffff;
	}
	
	h1{
	    text-align:center;
	}
	
	table{
		height:60%;
		width:60%;
		margin : 0px auto;
		text-align:center;
		box-shadow:10px 10px grey;
		background-color:#4dc3ff;
		color:white;
	}
	
	tr{
		width:66%;
		font-weight: bold;
		font-size:13px;
	}
	
	div{
		margin : 10px auto;
	}
	
	
	.input_box{
		text-align:center;
		height:50px;
		margin:auto;
	}
	
	#selectList{
		margin-Top
		height:30px;
		width:200px;
		text-align:center;
		font-size:20px;
	}
	
	#inputText{
		height:22px;
		width:400px;
	} 
	
	#addBtn{
		height:30px;
		width:130px;
	}
	
</style>
<script type="text/javascript">
	function createElement(x, y){
		let new_element=document.getElementById(x);
		let ptag=document.createElement("p");
		// p태그 요소 구성
		// alert("입력값 >>> : "+y);
		text='<input type="text" readonly value="'+y+'">';
		// alert("text >>> : "+text);
		
		// new_element.appendChild(ptag).innerHTML=text;
		new_element.appendChild(ptag).innerHTML=text;
		
		// 수정버튼 만들기
		let upbtn=document.createElement("button");
		upbtn.innerText="수정";
		ptag.appendChild(upbtn);
		
		upbtn.onclick=function(e){
			upbtn.innerText="저장";
			let pnode=e.target.parentNode;
			// alert("readOnly check >> :"+pnode.childNodes[0].readOnly);
			
			let bool=pnode.childNodes[0].readOnly;
			// alert("bool >>> : "+pnode.childNodes[0].readOnly);
			if(bool){
				pnode.childNodes[0].readOnly=false;
			}
			if(!bool){
				pnode.childNodes[0].readOnly=true;
				upbtn.innerText="수정";
			}
		}
		
		// 삭제버튼 만들기
		let delbtn=document.createElement("button");
		delbtn.innerText="삭제";
		ptag.appendChild(delbtn);
		
		delbtn.onclick=function(e){
			let pnode=e.target.parentNode;
			new_element.removeChild(pnode);
		}
	}

	function addItem(){
		let selectList=document.getElementById("selectList");
		let selValue=selectList.value;
		let inputText=document.getElementById("inputText");
		let iVal=inputText.value;
		document.getElementById("inputText").value='';
		document.getElementById("inputText").focus();
		
		if(iVal.length>0){
		    if(selValue=="To do"){
		    	createElement("todo", iVal);
		    }
		    if(selValue=="In progress"){
		    	createElement("inprogress", iVal);
		    }
		    if(selValue=="Done"){
		    	createElement("done", iVal);
		    }
		}
		if(iVal.length==0){
			alert("내용을 입력해주세요. 입력값의 길이 >>> : "+iVal.length);
			document.getElementById("inputText").focus();
		}
	}
</script>
</head>
<body>

<div>
	<h1>ToDo List</h1>
</div>
<hr>

<div class="input_box">
    <select id="selectList">
    	<option>To do</option>
    	<option>In progress</option>
    	<option>Done</option>
    </select>
    
    <input id="inputText" type="text" placeholder="할 일을 입력하세요.">
    
    <button id="addBtn" onClick="addItem()">입력하기</button>
</div>

<hr>

<div>
<table>
	<tr>
		<td style="font-size:26px;">To do</td>
		<td style="font-size:26px;">In progress</td>
		<td style="font-size:26px;">Done</td>
	</tr>
	<tr>
		<td id="todo" style="font-size:13px;">
		</td>
		<td id="inprogress" style="font-size:13px;">
		</td>
		<td id="done" style="font-size:13px;">
		</td>
	</tr>
</table>
</div>
</body>
</html>
```

## 실제 실행 예시 사진

<hr>

<img src="/image/ToDoList.PNG" alt="no-image">

## 코드 설명

**1. 값 입력받기**

```html
<div class="input_box">
    <select id="selectList">
    	<option>To do</option>
    	<option>In progress</option>
    	<option>Done</option>
    </select>
    
    <input id="inputText" type="text" placeholder="할 일을 입력하세요.">
    
    <button id="addBtn" onClick="addItem()">입력하기</button>
</div>
```

select태그, input태그, button태그를 입력하여 To do(앞으로 할 일), In progress(현재 진행중), Done(이미 끝난 일)을 선택 한뒤, 입력칸을 생성하였습니다. 입력하기 버튼은 버튼을 클릭하면 이벤트를 주기 위해 버튼 태그를 사용하였습니다.

**2. table**

```
<table>
	<tr>
		<td style="font-size:26px;">To do</td>
		<td style="font-size:26px;">In progress</td>
		<td style="font-size:26px;">Done</td>
	</tr>
	<tr>
		<td id="todo" style="font-size:13px;">
		</td>
		<td id="inprogress" style="font-size:13px;">
		</td>
		<td id="done" style="font-size:13px;">
		</td>
	</tr>
</table>
```

먼저 3행 2열로 테이블을 만들어, 1행에는 To do(앞으로 해야 할 일), In progress(현재 진행중), Done(이미 끝난 일)로 나누어 입력하였습니다. 2행의 경우, input 태그로 들어온 값을 select, option 태그의 값에 따라 입력시키기 위해 현재, 아무것도 적혀있지 않습니다.

**3. javascript의 addItem() 함수**

```javascript
function addItem(){
		let selectList=document.getElementById("selectList");
		let selValue=selectList.value;
		let inputText=document.getElementById("inputText");
		let iVal=inputText.value;
		document.getElementById("inputText").value='';
		document.getElementById("inputText").focus();
		
		if(iVal.length>0){
		    if(selValue=="To do"){
		    	createElement("todo", iVal);
		    }
		    if(selValue=="In progress"){
		    	createElement("inprogress", iVal);
		    }
		    if(selValue=="Done"){
		    	createElement("done", iVal);
		    }
		}
		if(iVal.length==0){
			alert("내용을 입력해주세요. 입력값의 길이 >>> : "+iVal.length);
			document.getElementById("inputText").focus();
		}
	}
```

select에서 option을 선택 후, input 태그에 값을 입력한 뒤, button 태그(입력하기) 버튼을 클릭하면, addItem() 함수가 실행 됩니다.

- select태그의 값과, 해당 값의 value, input태그의 값과 해당 값의 value를 자바 스크립트 let 변수에 담습니다.

- let 변수에 담았으면, input 태그값을 초기화 하고 커서를 input태그가 있는 곳으로 가게 합니다.

- 만약, 입력받은 값의 길이가 0보다 크면, select태그의 option태그 값에 따라 createElement에 인수를 다르게 입력 시킵니다.

- 만약, 입력받은 값의 길이가 0이면, 내용이 입력되지 않았으므로, 내용을 입력해달라는 메시지와 함께, input 태그가 있는 곳으로 커서를 가게 합니다.

**4. javascript의 createElement(x, y) 함수**

```javascript
function createElement(x, y){
		let new_element=document.getElementById(x);
		let ptag=document.createElement("p");
		// p태그 요소 구성
		// alert("입력값 >>> : "+y);
		text='<input type="text" readonly value="'+y+'">';
		// alert("text >>> : "+text);
		
		// new_element.appendChild(ptag).innerHTML=text;
		new_element.appendChild(ptag).innerHTML=text;
		
		// 수정버튼 만들기
		let upbtn=document.createElement("button");
		upbtn.innerText="수정";
		ptag.appendChild(upbtn);
		
		upbtn.onclick=function(e){
			upbtn.innerText="저장";
			let pnode=e.target.parentNode;
			// alert("readOnly check >> :"+pnode.childNodes[0].readOnly);
			
			let bool=pnode.childNodes[0].readOnly;
			// alert("bool >>> : "+pnode.childNodes[0].readOnly);
			if(bool){
				pnode.childNodes[0].readOnly=false;
			}
			if(!bool){
				pnode.childNodes[0].readOnly=true;
				upbtn.innerText="수정";
			}
		}
		
		// 삭제버튼 만들기
		let delbtn=document.createElement("button");
		delbtn.innerText="삭제";
		ptag.appendChild(delbtn);
		
		delbtn.onclick=function(e){
			let pnode=e.target.parentNode;
			new_element.removeChild(pnode);
		}
	}
```

> **1) 입력 :**

- 매개변수 x에는 select태그의 option태그의 값, y에는 input태그의 값이 입력됩니다. 해당 태그의 아이디를 매칭하여, p태그를 생성합니다. 
- 그 다음, input태그에 text에 y값을 value로 만들어 하나의 문자열을 만든 뒤, 이를 매칭한 태그에 자식태그에 innerHTML로 화면에 출력시킵니다. 
- 이 때, input태그의 속성은 읽을 수만 있고, 수정할 수 없도록 설정합니다.
- 값을 입력시키면서 동시에 수정버튼과 삭제버튼을 만들어 p태그의 자식태그에 생성시킵니다.

> **2) 수정 :** 

- 수정버튼을 클릭하면, 클릭이벤트를 발생시켜, 버튼 태그의 값을 저장으로 바뀌게 만듭니다. 
- 그 다음, 해당 태그의 부모태그를 자바스크립트의 변수로 지정한 뒤, 해당 변수의 자식노드 배열의 0번째 인덱스(input 태그 값)의 속성이 readOnly인지 아닌지 확인합니다.
- 만약, readOnly가 true라면, 수정할 수 없는 상태이므로, 수정가능하도록 설정하여 줍니다.
- 한편, readOnly가 false라면, 수정이 끝나고 저장 후, 다시 수정할 수 없도록 설정하여 줍니다.

> **3) 삭제 :**

- 삭제버튼을 클릭하면 해당 태그의 부모태그를 자바스크립트의 변수로 설정하여 줍니다.
- 그 다음, option 값에 매칭된 태그에서 해당 태그를 삭제하여 줍니다.


**4. css**

```css
<style type="text/css">	
	input{
		height:22px;
		width:150px;
	}
	
	table, tr, td{
		border : 2px solid #ffffff;
	}
	
	h1{
	    text-align:center;
	}
	
	table{
		height:60%;
		width:60%;
		margin : 0px auto;
		text-align:center;
		box-shadow:10px 10px grey;
		background-color:#4dc3ff;
		color:white;
	}
	
	tr{
		width:66%;
		font-weight: bold;
		font-size:13px;
	}
	
	div{
		margin : 10px auto;
	}
	
	
	.input_box{
		text-align:center;
		height:50px;
		margin:auto;
	}
	
	#selectList{
		margin-Top
		height:30px;
		width:200px;
		text-align:center;
		font-size:20px;
	}
	
	#inputText{
		height:22px;
		width:400px;
	} 
	
	#addBtn{
		height:30px;
		width:130px;
	}
	
</style>
```

- input 태그의 높이와 너비를 픽셀로 지정하여 줍니다.

- table, tr, td 태그의 선을 2px solid선으로 #ffffff rgb값으로 지정하여 줍니다.

- h1태그에 있는 텍스트는 중앙 정렬을 하도록 하였습니다.

- table태그의 경우, 추가적으로 높이와 너비를 60%으로 지정해주고, margin은 0px auto로 설정하여 줍니다. 텍스트의 경우 중앙정렬로 해주고, 그림자 효과를 넣어주었습니다. 테이블 배경색을 #4dc3ff로 설정하여 주고, 글자는 하얀색 글자로 색깔을 지정하여 주었습니다.

- tr태그의 경우 66% 너비와 bold체로 13px크기로 설정하였습니다.

- 각 내용이 닮겨있는 div태그의 경우 margin을 10px auto로 설정하였습니다.

- input_box라는 클래스이름을 갖고 있는 div의 텍스트를 중앙으로 정렬하였으며, 높이는 50px, 마진은 auto로 설정하였습니다.

- selectList라는 아이디이름을 갖고 있는 select태그의 경우, margin-Top으로 요소 위에 공백을 넣었으며, 높이와 너비, 텍스트 정렬, 글시체를 설정하여 주었습니다.

- inputText라는 아이디이름을 갖고 있는 input태그와 addBtn이라는 아이디이름을 갖고 있는 버튼 태그의 높이와 너비를 각각 설정하여 주었습니다.