package com.ji.practice.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ji.practice.user.common.JDBCTemplate;
import com.ji.practice.user.model.vo.Member;

public class UserDao {
	
	public Member SearchUser(Connection conn,String userId,int userNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member sky = null;
		
		String sql = "SELECT * FROM TB_USER WHERE USER_ID=? AND USER_NO=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,userId);
			pstmt.setInt(2, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sky = new Member(rset.getInt("user_no"),
						rset.getString("user_id"),
						rset.getString("user_name"),
						rset.getInt("user_age"));
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return sky;
		
		
	}

}
