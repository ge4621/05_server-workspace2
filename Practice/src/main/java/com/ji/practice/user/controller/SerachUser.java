package com.ji.practice.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ji.practice.user.model.service.UserService;
import com.ji.practice.user.model.vo.Member;

/**
 * Servlet implementation class SerachUser
 */
@WebServlet("/search.do")
public class SerachUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		//아이디, 회원 번호
		String userId = request.getParameter("userId");
		int userNo = Integer.parseInt("userNo");
		
		Member sky = new UserService().SearchUser(userId, userNo);
		
		if(sky==null) {
			request.setAttribute("eorrorMsg","결과가 없습니다." );
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/fail.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("sky", sky);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/success.jsp");
			view.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
