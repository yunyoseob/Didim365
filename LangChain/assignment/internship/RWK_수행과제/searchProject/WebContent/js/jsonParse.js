function jsonParse(jsonStr){
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