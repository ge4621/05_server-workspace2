package com.kh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.model.vo.Member;

/**
 * Servlet implementation class JqAjaxController3
 */
@WebServlet("/JqAjax3.do")
public class JqAjaxController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxController3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("no"));
		
		//Member m = new MemberService().selectMember(); => 원래는 이런식으로 써야 하는데 이 파일은 정보가 없어 했다 가정하고 하기
		//vo를 간략하게 만들어 놓음(db는 없고 오직 vo만 있다.)
		//원래대로 한다면 위의 Member 객체에 각 필드에 조회된 데이터들이 담겨 있을 것 !!
		Member m = new Member(1,"박철수",30,"남");  //db가 있다면 해당 과정 없다. 조회된 데이터가 다음과 같다고 가정하는 것임
		
		//response.getWriter().print(m); //vo객체를 곧바로 응답시 .toString()의 문자열이 응답 => 저괄호 안에 m이 있는데 뒤에 .String이 생략되어있는 거임
		
		//JSONObject{key:value, key:value} 에 직접담기
		/*
		JSONObject jObj = new JSONObject(); //{}
		jObj.put("userNo", m.getUserNo()); 	//{userNo:1}
		jObj.put("userName", m.getUserName()); //{userNo:1 , userName:"박철수"}
		jObj.put("age", m.getAge()); //{userNo:1 , userName:"박철수" ,age:30}
		jObj.put("gender", m.getGender()); //{userNo:1 , userName:"박철수" ,age:30, gender:"남"}
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jObj);
		*/
		
		//더 간단한 방법 : 위의 과정을 알아서 해주는 GSON 라이브러리 사용
		//GSON : Google JSON
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson(); //Gson객체.toJson(응답할 자바객체, 응답할스트림);
		//gson.toJson(응답할 자바객체,응답할스트림);
		gson.toJson(m,response.getWriter());
		//new Gson().toJson(m,response.getWriter());=>한줄 버전
		
		//Gson을 이용해서 vo객체 하나만 응답시 JSONObject{key:valud, key:value,...}형태로 만들어서 응답
		//이때 key는 해당 vo객체의 필드명으로 알아서 세팅
		
		//	자바배열 또는 ArrayList로 응답시 JSONArray[value,value,...]형태로 만들어서 응답
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
