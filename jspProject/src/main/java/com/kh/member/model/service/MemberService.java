package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;


public class MemberService {
	
	public Member loginMember(String userId, String userPwd) {//select문
		//커넥션 객체 생성
		Connection conn = /*JDBCTemplate.*/getConnection();
		//Dao호출
		Member m = new MemberDao().loginMember(conn,userId, userPwd);
		
		/*JDBCTemplate.*/close(conn);
		return m;
	}
	
	public int insertMember(Member m) {//insert문 
		//커넥션 객체 생성
		Connection conn = /*JDBCTemplate.*/getConnection();
		
		int result = new MemberDao().insertMember(conn,m);
		
		//트랜젝션 처리
		if(result > 0) {//성공 
			commit(conn);
		}else {//실패
			rollback(conn);
		}
		//커넥션 반납
		close(conn);
		return result;
	}
	
	public Member updateMember(Member m) {
		
		//커넥션 객체 생성
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn,m);
		
		Member updateMem = null;
		
		//트랜잭션 처리
		if(result >0) {//성공
			commit(conn);
			//갱신된 회원 객체 다시 조회 해오기
			updateMem = new MemberDao().selectMember(conn,m.getUserId());
			
			
		}else {//실패
			rollback(conn);
		}
		//커넥션 반납
		close(conn);
		
		return updateMem;
	}
	
	public Member updatePwd(String userId,String userPwd,String updatePwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwd(conn,userId,userPwd,updatePwd);
		
		Member updateMem = null;
		if(result > 0) { //성공
			commit(conn);
			
			//갱신된 회원 객체 다시 조회해오기
			updateMem = new MemberDao().selectMember(conn, userId);
			
			
		}else {//실패
			rollback(conn);
		}
		close(conn);
		
		return updateMem;
	}
	
	
	public int deleteMember(String userId,String userPwd) {
		//케넥션 생성
		Connection conn = getConnection();
		//Dao 불려오기, Dao에서 커넥션을 돌려야 하기 때문에 conn도 넘겨야 됨
		int result = new MemberDao().deleteMember(conn,userId,userPwd);
		
	
		if(result >0) { //성공시 => 성공하면 값이 1
			commit(conn); //변경된 정보 확졍
		}else {//실패 => 실패하면 값이 0
			rollback(conn); //변경된 정보 원래대로 돌리기
		}
		close(conn); //커넥션 반납 (생성했기 때문에 반납 꼭해야됨)
		return result;
	}
	
	
	
}
