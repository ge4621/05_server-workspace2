package edu.kh.test.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.service.UserService;
import edu.kh.test.user.model.vo.User;

/**
 * Servlet implementation class SelectUserNo
 */
@WebServlet("/practice.do")
public class SelectUserNo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//이름 userName, 회원 번호 userNo
		String userName = request.getParameter("userName");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		User king = new UserService().loginMember(userName,userNo);
		
		if(king ==null) {
			
			request.setAttribute("errorMsg", "조회 결과가 없습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/searchFail.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("king", king);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/searchSuccess1.jsp");
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
