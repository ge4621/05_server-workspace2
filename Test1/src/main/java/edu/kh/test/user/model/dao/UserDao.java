package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.user.common.JDBCTemplate;
import edu.kh.test.user.model.vo.User;

public class UserDao {
	
	public User selectUser(Connection conn, int userNo) {
		//select문 => ResultSet객체 필요 => 한행 조회 => User객체
		
		//1)JDBC용 객체 생성 + 필요한 객체 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		User user = null;
		
		//2) sql쿼리 작성
		String sql = "SELECT * FROM TB_USER WHERE USER_NO=?";
		
		//3) pstmt, rset 채워넣기
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo); //자료형에 따라서 setInt setString구분
			
			rset = pstmt.executeQuery(); //rset에는 뭐라고 있거나 | null이다.
			
			if(rset.next()) {
				user = new User(rset.getInt("user_no"),
								rset.getString("user_id"),
								rset.getString("user_name"),
								rset.getInt("user_age"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return user;
	}
	
	public User selectUser1(Connection conn,String userId,int userAge) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		User user = null;
		
		String sql = "SELECT * FROM TB_USER WHERE USER_ID=? AND USER_AGE=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, userAge);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				user = new User(rset.getInt("user_no"),
								rset.getString("user_id"),
								rset.getString("user_name"),
								rset.getInt("user_age"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return user;
		
		
		
	}
	
	public User loginMember(Connection conn, String userName, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		User king = null;
		
		String sql = "SELECT * FROM TB_USER WHERE USER_NAME=? AND USER_NO=?";
		
		try {
			pstmt=conn.prepareStatement(sql); //위의 커리 => 미완서 커리 그렇기 때문에 아래 나오는 코드를 이용해서 완성 시켜줘야 됨
			pstmt.setString(1, userName);
			pstmt.setInt(2, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				king = new User(rset.getInt("user_no"),
								rset.getString("user_id"),
								rset.getString("user_name"),
								rset.getInt("user_age"));	
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return king;
		
		
	}
	
	
	
	
	
}
