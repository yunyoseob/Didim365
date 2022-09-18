// true :: 정상  false :: 비정상
function check(currentPage,countPerPage, keyword){
	try{  
	    /*
	    alert("currentPage >>> : "+currentPage);
	    alert("countPerPage >>> : "+countPerPage);
	    alert("typeof(currentPage) >>> : "+typeof(currentPage));
	    alert("typeof(countPerPage) >>> : "+typeof(countPerPage));
	    */
	    
	    if(currentPage>0 && currentPage>0 && currentPage<=100){
	    	currentPage=parseInt(currentPage);
	    	countPerPage=parseInt(countPerPage);
	    	
			document.getElementById("currentPage").value=currentPage;
			document.getElementById("countPerPage").value=countPerPage;
			
			/*
	    	alert("currentPage >>>> : "+currentPage);
	    	alert("countPerPage >>> : "+countPerPage);
	    	alert("typeof(currentPage) >>> : "+typeof(currentPage));
	    	alert("typeof(countPerPage) >>> : "+typeof(countPerPage));
	    	

	    	var bool1= currentPage%1 == 0
	    	var bool2= countPerPage%1 == 0
	    	
	    	alert("bool1 >>> : "+bool1);
	    	alert("bool2 >>> : "+bool2);
	    	*/
	    	
	    	if(currentPage%1 == 0 && countPerPage%1 == 0){
	    		if(keyword.length <=0){
	    			alert("키워드의 입력값이 존재하지 않습니다.");
	    			return false;
	    		}

	    		// 특수문자 제거
	    		var regExp= /[\{\}\[\]\/?.,;:|\)*~`!^\-+<>@\#$%&\\\=\(\'\"]/gi; 
	    		if (regExp.test(keyword)){
	    			new_keyword=keyword.replace(regExp, "");
	    			document.getElementById("keyword").value=new_keyword
	    		}

	    		//특정문자열 (sql예약어의 앞뒤 공백 포함) 제거
	    		var sqlArray = new Array(
	    			//sql 예약어
	    			"OR", "SELECT", "INSERT", "DELETE", "UPDATE", "CREATE", "DROP", "EXEC",
             		"UNION",  "FETCH", "DECLARE", "TRUNCATE" 
	    		);
	    		var regex;
				//
	    		for(var i=0; i<sqlArray.length; i++){
	    			regex = new RegExp( sqlArray[i] ,"gi") ;
	    			
	    			if (regex.test(keyword) ) {
	    			    alert("\"" + sqlArray[i]+"\"와(과) 같은 특정문자로 검색할 수 없습니다.");
	    				document.getElementById("keyword").value =keyword.replace(regex, "");
	    			}
	    		}
	    		
	    		return true;
	    	}else{
	    		alert("1.현재 페이지 번호는 0보다 큰 정수여야 합니다. 2.페이지당 출력 개수는 0보다 크고 100이하인 정수로 입력해야 합니다."); 
	    		return false;
	    	}
	    }else{
	    	alert("1.현재 페이지 번호는 0보다 큰 정수여야 합니다. 2.페이지당 출력 개수는 0보다 크고 100이하인 정수로 입력해야 합니다."); 
	    	return false;
	    }
	    }catch(error){
	    	alert("error 발생");
			alert(error);
	    }		
}