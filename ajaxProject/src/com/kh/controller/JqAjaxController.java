package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.kh.model.vo.Member;

/**
 * Servlet implementation class JqAjaxController
 */
@WebServlet("/jqAjax4.do")
public class JqAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ArrayList<Member> list = new MemberService().selectMemberList();  => 해당 과정 수행했다고 가정
		ArrayList<Member> list = new ArrayList<Member>(); //[] =>JSONArray
		
		list.add(new Member(1,"박철수",30,"남")); //JSONObject{} 
		list.add(new Member(2,"차은우",20,"남"));	//JSONObject{} 
		list.add(new Member(3,"김태리",25,"여"));	//JSONObject{} 
		
		//JSONArray[{},{},{}]
		JsonArray jArr = new JsonArray(); //[]
		
		/*
		for(Member m :list) {
			JSONObject jObj = new JSONObject();
			jObj.put("userNo", m.getUserName());
			jObj.put("userName", m.getUserName());
			jObj.put("age", m.getAge());
			jObj.put("gender", m.getGender());
			
			jArr.add(jObj);
		}
		*/
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list,response.getWriter());
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
