package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;

import static com.kh.common.JDBCTemplate.*;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		try {
			prop.loadFromXML(new FileInputStream(BoardDao.class.getResource("/db/sql/board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		//select문 => ResultSet(값 => 한개) => int
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count"); //"count"는 count(*)의 별칭으로 사용된 것
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			/*JDBCTemplate.*/close(rset);
			close(pstmt);
		}
		return listCount;
		
	}
	
	public ArrayList<Board> selectList(Connection conn,PageInfo pi){
		//select문 => ResultSet(여러행 조회) => ArrayList<Board> 
		
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList"); //미완성
		/*
		 *  currentPage : 1 => 시작값 :  1 | 끝값 : 10
		 *  currentPage : 2 => 시작값 : 11 | 끝값 : 20
		 *  currentPage : 3 => 시작값 : 21 | 끝값 : 30
		 *  
		 *  시작값 : (currentPage - 1 ) * boardLimit + 1
		 *  끝값 : 시작값 + boardLimit - 1
		 */
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1; //페이징 시작번호
		int endRow = startRow + pi.getBoardLimit() - 1; //페이징 마지막 번호
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("board_no"),
									rset.getString("category_name"),
									rset.getString("board_title"),
									rset.getString("user_id"),
									rset.getInt("count"),
									rset.getString("create_date")
									));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
}
