package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/delete.no")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전달값=>글 번호
//		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
//		Notice n = new NoticeService().selectNotice(noticeNo);
//		
//		int result = new NoticeService().deleteNotice(n);
//		
//		if(result >0) {//성공
//			 
//         	//삭제 구현해보기
//         	//url - mapping 맘대로
//         	
//         	//요청 성공시 => 공지사항 목록페이지 alert(공지사항이 성공적으로 삭제 되었습니다.) url재요청
//         	//요청 실패시 => 에러 문구 보여지는 에러 페이지
//			request.getSession().setAttribute("alertMsg", "공지사항이 성공적으로 삭제되었습니다.");
//			response.sendRedirect(request.getContextPath() + "/list.no");
//		
//		}else {//실패
//			request.setAttribute("errorMsg", "공지사항 삭제에 실패했습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
//			view.forward(request, response);
//
//		}
//		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
