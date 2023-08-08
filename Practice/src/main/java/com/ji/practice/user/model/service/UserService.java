package com.ji.practice.user.model.service;

import java.sql.Connection;

import com.ji.practice.user.common.JDBCTemplate;
import com.ji.practice.user.model.dao.UserDao;
import com.ji.practice.user.model.vo.Member;

public class UserService {
	
	public Member SearchUser(String userId,int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member sky = new UserDao().SearchUser(conn,userId,userNo);
		
		JDBCTemplate.close(conn);
		return sky;
		
		
	}
	

}
