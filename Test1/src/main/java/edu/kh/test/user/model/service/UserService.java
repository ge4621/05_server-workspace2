package edu.kh.test.user.model.service;

import java.sql.Connection;

import edu.kh.test.user.common.JDBCTemplate;
import edu.kh.test.user.model.dao.UserDao;
import edu.kh.test.user.model.vo.User;

public class UserService {
	
	public User selectUser(int userNo) {
		//1. 커넥션 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//2.dao호출 및 결과 받기 => conn도 보내야 한다.
		User user= new UserDao().selectUser(conn,userNo);
		
		//3.커네션 객체 반납
		JDBCTemplate.close(conn);
		
		return user;
		
	}
	
	public User selectUser1(String userId, int userAge) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		User user = new UserDao().selectUser1(conn,userId,userAge);
		
		JDBCTemplate.close(conn);
		
		return user;
		
	}
	
	public User loginMember(String userName, int userNo) {
		//커넥션 생성 
		Connection conn = JDBCTemplate.getConnection();
		
		User king = new UserDao().loginMember(conn, userName, userNo);
		
		JDBCTemplate.close(conn);
		
		return king;
		
		
		
		
		
	}
	
	
	
}
