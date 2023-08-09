package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;


public class MemberService {
	
	public Member loginMember(String userId, String userPwd) {
		//커넥션 객체 생성
		Connection conn = /*JDBCTemplate.*/getConnection();
		//Dao호출
		Member m = new MemberDao().loginMember(conn,userId, userPwd);
		
		/*JDBCTemplate.*/close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn = /*JDBCTemplate.*/getConnection();
		
		int result = new MemberDao().insertMember(conn,m);
		
		//트랜젝션 처리
		if(result > 0) {//성공
			commit(conn);
		}else {//실패
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
