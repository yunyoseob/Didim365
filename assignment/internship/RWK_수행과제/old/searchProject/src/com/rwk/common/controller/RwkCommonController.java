package com.rwk.common.controller;

// java.io
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
// 서블릿
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL
import org.apache.log4j.Logger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


/**
 * Servlet implementation class RwkCommonController
 */
@WebServlet("/main")
public class RwkCommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(RwkCommonController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RwkCommonController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		logger.info("doGet 함수 진입 >>> : ");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int countPerPage=0;
		int currentPage=0;
		String result=null;
		
		try{
		    // 현재 페이지 : 필수
		    // 현재 페이지 번호(n>0)
		    String str_currentPage=request.getParameter("currentPage");
		    if(!str_currentPage.equals("NaN")){
		    	currentPage=Integer.valueOf(str_currentPage);
		    	logger.info("currentPage >>> : "+currentPage);
		    }
		    
		    // 페이지당 출력 개수 :필수
		    // 0<n<100 
		    String str_countPerPage=request.getParameter("countPerPage");
		    if(!str_countPerPage.equals("NaN")) {
		    	countPerPage=Integer.valueOf(str_countPerPage);
		    	logger.info("countPerPage >>> : "+countPerPage);
		    }
		    
		    // 검색 결과 형식 : 선택
		    String resultType=request.getParameter("resultType");
		    logger.info("resultType >>> : "+resultType);
		    
		    // api 승인 키
		    // 신청시 발급받은 승인 키 : 필수
		    String confmKey=request.getParameter("confmKey");
		    logger.info("confmKey >>> : "+confmKey);
		    
		    // 키워드(주소 검색어) : 필수
		    String keyword=request.getParameter("keyword");
		    logger.info("keyword >>> : "+keyword);
		    
		    if(str_currentPage==null || str_countPerPage==null || resultType==null ||  confmKey==null || keyword==null) return;
		    
		    // API 호출
		    String apiUrl="https://business.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey+"&resultType="+resultType;
		    logger.info("apiUrl >> : \n"+apiUrl);
		    
		    URL url=new URL(apiUrl);
		    logger.info("url >>> : \n"+url);
		    
		    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
		    logger.info("BufferedReader br >>> : "+br);
		    	
		    // 내용 받기
		    StringBuffer sb=new StringBuffer();
		    String tempStr=null;
		    
		    while(true){
		    	tempStr=br.readLine();
		    	// logger.info("tempStr >>> \n"+tempStr);
		    	if(tempStr==null) break;
		    	sb.append(tempStr);
		    	// logger.info("StringBuffer sb >>> : "+sb);
		    }
		    logger.info("StringBuffer sb >>> : "+sb);
		    br.close();
		    
		    result=sb.toString();
		    request.setAttribute("result", result);
		    RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/searchResult.jsp");
		    logger.info("rd >>> : "+rd);
		    rd.forward(request, response);
		}catch(Exception e){
			logger.info("Exception e >>> : "+e);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
