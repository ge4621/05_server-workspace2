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
 * Servlet implementation class SelectServlet2
 */
@WebServlet("/login.do")
public class SelectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//필요한 데이터 뽑기
		String userId = request.getParameter("userId");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		
		//서비스 호출 -> 넘기기
		User user1 = new UserService().selectUser1(userId,userAge);
		
		//응답화면 결정
	
		if(user1 == null) {
			request.setAttribute("errorMsg", "조회된 결과가 없습니다.");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/searchFail.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("user1", user1);
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/searchSuccess.jsp");
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
