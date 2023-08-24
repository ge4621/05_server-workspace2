package com.kh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JqAjaxController2
 */
@WebServlet("/jqAjax2.do")
public class JqAjaxController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name"); //String 뒤에 있는 name(키)는 ajax할때 쓴 속성명 으로 맞추기
		int age = Integer.parseInt(request.getParameter("age"));
		
		//요청 처리가 다 되었다는 가정하에 응답할 데이터
		//v1. 하나의 문자열
		/*
		String responseData = "이름 : " + name + ", 나이 : " + age;
		
		response.setContentType("text/html; charset=UTF-8"); //응답할 데이터에 한글이 있을 경우에만 사용한다.
		response.getWriter().print(responseData);
		*/
		
		//v2. 응답하는 데이터가 여러개 일 경우
		/*
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(name);
		response.getWriter().print(age);
		=> success:function의 매개변수에 연이어서 하나의 문자열로 담경있다. ex)"차은우20" 
		*/
		
		
		/*
		 * JSON (JavaScript Object Notation : 자바스크립트 객체 표기법)
		 * - ajax 통신시 데이터 전송에 자주 사용되는 포맷형식 중 하나
		 * 
		 * 		>[value, value, value] => 자바스크립트에서의 배열 객체 => JSONArray
		 * 		>{key:value, key:value} => 자바스크립트에서의 일반 객체 => JSONObject
		 * 
		 * 	- 라이브러리 필요 => https://code.google.com/archive/p/json-simple/downloads
		 */
		
		/*
		//JSONArray버전
		JSONArray jArr = new JSONArray(); // [] => 텅빈 상태
		jArr.add(name); // ["차은우"] 
		jArr.add(age); //["차은우",20] 
		
		response.setContentType("application/json; charset=UTF-8"); //JSON으로 데이터를 응답시에는 text/html;말고 application/json;사용
		
		response.getWriter().print(jArr);
		*/
		
		//JSONObject버전
		JSONObject jObj = new JSONObject(); //{}
		jObj.put("name", name); //{name:"차은우"}
		jObj.put("age", age); //{name:"차은우", age:20}
		
		response.setContentType("application/json; charset=UTF-8");
		
		response.getWriter().print(jObj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
