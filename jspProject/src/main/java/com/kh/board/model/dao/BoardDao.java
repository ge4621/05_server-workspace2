package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
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
		
		ArrayList<Board> list = new ArrayList<Board>(); //여기서 만드러야지 아래 반복문에서 돌아갈 수있다.(ArrayList는 애초에 만드어줘야한다.)
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
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1; //페이징 시작번호 미완성 쿼리 앞"?"
		int endRow = startRow + pi.getBoardLimit() - 1; //페이징 마지막 번호 미완성 쿼리뒤 "?"
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) { //반복문
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
	
	public ArrayList<Category> selectCategoryList(Connection conn){
		//select문 => ResultSet(여러행) => ArrayList<Category>
		ArrayList<Category> list = new ArrayList<Category>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Category(rset.getInt("category_no"),
										rset.getString("category_name")
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
	
	public int insertBoard(Connection conn,Board b) {
		//insert문 => 처리된 행수 => 트랜젝션 처리
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, Integer.parseInt(b.getBoardWriter()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int insertAttachment(Connection conn,Attachment at) {
		//insert문 => 처리된 행수 => 트랜젝션
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int increaseCount(Connection conn,int boardNo) {
		//update문 => 처리된 행수 => 트랜젝션 처리
		int result=0;
		PreparedStatement pstmt =null;
		
		String sql =prop.getProperty("increaseCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public Board selectBoard(Connection conn, int boardNo) {
		//select문 => ResultSet(한행) => Board
		Board b = null;
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {//한행 =>if 여러행 => while 로 생각하자
				b = new Board(rset.getInt("board_no"),
								rset.getString("category_name"),
								rset.getString("board_title"),
								rset.getString("board_content"),
								rset.getString("user_id"),
								rset.getString("create_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return b;
		
	}
	
	public Attachment selectAttachment(Connection conn, int boardNo) {
		//여러행 조회일 때는 ArrayList 한행 조회 일 때는 객체 명
		//select문 => ResultSet(한행) => Attachment 객체
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment();
				
				at.setFileNo(rset.getInt("file_no"));
				at.setOriginName(rset.getString("origin_name"));
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return at;
		
	}
	
}