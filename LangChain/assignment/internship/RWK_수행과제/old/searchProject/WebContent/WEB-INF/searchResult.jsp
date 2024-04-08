<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>   
<%
	Logger logger=LogManager.getLogger(this.getClass());
	Object obj=request.getAttribute("result");
	String result=(String)obj;
	// logger.info("String result >>> : \n "+result);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/searchProject/js/check.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>검색 결과 페이지</title>
<script type="text/javascript">
function jsonParsing(){
	console.log("jsonParsing() 함수 시작 >>> : ");
	
	var jsonStr='${result}';
	// console.log("jsonStr >>> : "+jsonStr);
	console.log("typeof(jsonStr) >>> : "+typeof(jsonStr));


	var obj=JSON.parse(jsonStr);
	console.log("json 파싱 >>>  : "+obj);
	
	console.log("obj.results >>> : "+obj.results);
	var results=obj.results;
	console.log("results.common >>> : "+results.common);
	
	// common
	var common=results.common;
	var errorMessage=common.errorMessage;
	console.log("에러메시지 >>> : "+errorMessage);
	var errorCode=common.errorCode;
	console.log("에러코드 >>> : "+errorCode);
	
	// 에러메시지가 정상이 아니거나 에러코드가 0이 아닐 경우, Stop
	if(errorMessage!="정상" || errorCode!=0){ return; }
	
	var totalCount=common.totalCount;
	console.log("총 검색 데이터 수 >>> : "+totalCount);
	
	var currentPage=common.currentPage;
	console.log("현재 페이지 번호 >>> : "+currentPage);
	
	var countPerPage=common.countPerPage;
	console.log("페이지당 출력할 결과 Row수 >>> : "+countPerPage);
	
	// juso 
	// 도로명주소  : roadAddr 
	// 지번 : jibunAddr
	// 영문주소 :: engAddr 
	// 우편번호 :: zipNo 
	var juso=results.juso; 
	
	// juso 배열의 길이
	console.log("juso.length >>> : "+juso.length);
	
	var i;
	var roadAddr;
	var jibunAddr;
	var engAddr
	var zipNo;
		
	if(juso.length==0){
		alert("주소 결과 값이 없습니다.");
		return;
	}

	var div_result=document.getElementById("searchResult");
	var p0=document.createElement('p');
	p0.innerHTML='<p> 현재 페이지 번호는  '+currentPage+'입니다. 페이지당 출력결과 수는 '
				+countPerPage+'입니다. </p><hr>';
	div_result.appendChild(p0);
	
	for(i=0; i<juso.length; i++){
		var p=document.createElement('p');
		console.log("juso의 "+i+" 번째 값 입니다. \n");
		roadAddr=juso[i].roadAddr;
		console.log("전체 도로명 주소 >>> : "+roadAddr);
		
		jibunAddr=juso[i].jibunAddr;
		console.log("지번 정보 >>> : "+jibunAddr);
		
		engAddr=juso[i].engAddr;
		console.log("도로명주소(영문) >>> : "+engAddr);
	
		zipNo=juso[i].zipNo;
		console.log("우편번호 >>> : "+zipNo);
		console.log("typeof(zipNo) >>> : "+typeof(zipNo));
		// string 
		
		p.innerHTML='<p> <b>우편번호 : '+zipNo
					 +'</b></p><p> <b>전체 도로명 주소 : '+roadAddr
					 +'</b></p><p> 지번 정보 : '+jibunAddr
					 +'</p><p> 도로명주소(영문) : '+engAddr
					 +'</p><hr>'
		div_result.appendChild(p);
	}
}

function ajax_search(){
	console.log("ajax로 보내기 시작");
	var currentPage=document.getElementById("currentPage").value;
	var countPerPage=document.getElementById("countPerPage").value;
	var keyword=document.getElementById("keyword").value;
	var resultType=document.getElementById("resultType").value;
	var confmKey=document.getElementById("confmKey").value;
    
	var bool=check(currentPage,countPerPage, keyword);
	alert("검색가능여부 >>> : "+bool);
	
	if(bool){
	    /*
	    alert("currentPage >>> : "+currentPage);
	    alert("countPerPage >>> : "+countPerPage);
	    alert("keyword >>> : "+keyword);
	    alert("resultType >>> : "+resultType);
	    alert("confmKey >>> : "+confmKey);
	    */
	    
	    var mainUrl="/searchProject/main";
	    // alert("mainUrl >>> : "+mainUrl);
	    
	    $.ajax({
	    	url:mainUrl
	    	,type:"GET"
	    	,data:{
	    		"currentPage":currentPage,
	    		"countPerPage":countPerPage,
	    		"keyword":keyword,
	    		"resultType":resultType,
	    		"confmKey":confmKey
	    	}
	    	,dataType:resultType
	    });
	}
}
</script>
</head>
<body onload="jsonParsing()">
<form name="formData" id="formData">
	<table>
		<caption><b>도로명 주소 검색</b></caption>
		<tr>
			<td>현재 페이지 번호</td>
			<td><input type="text" id="currentPage" name="currentPage" required></td>
		</tr>
		<tr>
			<td>페이지당 출력 개수</td>
			<td><input type="text" id="countPerPage" name="countPerPage" required></td>
		</tr>
		<tr>
			<td>키워드</td>
			<td><input type="text" id="keyword" name="keyword" required></td>
		</tr>
		<tr>
			<td colspan="2">
				<button id="btn" onClick="ajax_search()">검색</button>
			</td>
		</tr>
	</table>
	<!-- 검색결과 형식  -->
	<input type="hidden" id="resultType" name="resultType" value="json">
	<!-- api 승인 키 : 사용기간 : 2022-08-10 ~ 2022-08-17 -->
	<input type="hidden" id="confmKey" name="confmKey" value="devU01TX0FVVEgyMDIyMDgxMDExMDY0MjExMjg2NTU=">
	<!-- api key : devU01TX0FVVEgyMDIyMDgxMDExMDY0MjExMjg2NTU= -->
</form>
<br>
<hr>
<br>
<h3>주소 검색 결과</h3>
<div id="searchResult"></div>
</body>
</html>