<%@page import="com.kh.board.model.vo.Attachment"%>
<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Board b = (Board)request.getAttribute("b");
	//글번호, 카테고리명, 글제목, 글내용, 작성자, 작성일

	Attachment at = (Attachment)request.getAttribute("at");
	//1. 첨부파일이 없다면 => null
	//2. 첨부파일이 있다면 => 파일번호,원본명,수정명, 저장경로
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    .outer{
        background-color: black;
        color: white;
        width: 1000px;
        height: 550px;
        margin: auto;
        margin-top: 50px;
    }
</style>


</head>
<body>

<%@ include file="../common/menubar.jsp" %>


<div class="outer">
    <br>
    <h2 align="center">일반게시판 상세보기</h2>
    <br>

    <table  id="detail-area" border="1" align="center">
        
        <tr>
            <th width="70">카테고리</th>
            <td width="70"><%=b.getCategory() %></td>
            <th width="70">제목</th>
            <td width="350"><%=b.getBoardTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=b.getBoardWriter() %></td>
            <th>작성일</th>
            <td><%=b.getCreateDate() %></td>
        </tr>
        <tr>
            <th>내용</th>
            <td colspan="3">
                <p style="height: 200px;"><%=b.getBoardContent() %></p>
            </td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td colspan="3">
            <%if(at==null){ %>
            <!--case1. 첨부파일이 없을 겨우-->
            	첨부파일이 없습니다.
            	
			<%}else{ %>
			
            <!--case2. 첨부파일이 있을 경우-->
            <!-- 예시 : /jsp/resource/board_upfiles/20230808111.png -->
            <a download="<%=at.getOriginName() %>" href="<%=contextPath %>/<%=at.getFilePath() %>/<%=at.getChangeName()%>"><%=at.getOriginName() %></a>
			<!-- download만 쓰면 변경된 사진명으로 저장 , 뒤에 at.getOriginName()를 쓰면 원본명으로 저장-->
            <%} %>
            </td>
            
           
        </tr>

    </table>
    <br>
    <div align="center">
    	
        <a href="<%=contextPath %>/list.bo?cpage=1" class="btn btn-sm btn-secondary">목록가기</a>

        <!--로그인한 사람과 게시글의 작성자가 일치하는 경우-->
        <%if(loginMember != null && loginMember.getUserId().equals(b.getBoardWriter())){ %>
        <a href="<%=contextPath %>/updateForm.bo?bno=<%=b.getBoardNo() %>" class="btn btn-sm btn-warning">수정하기</a>
        <a href="#" class="btn btn-sm btn-danger">삭제하기</a>
        <%} %>
    </div>



</div>





</body>
</html>