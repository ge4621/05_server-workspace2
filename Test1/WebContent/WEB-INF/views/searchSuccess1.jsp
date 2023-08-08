<%@page import="edu.kh.test.user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	User king = (User)request.getAttribute("king");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원 정보</h1>

    <table border="1">
        <tr>
            <th>회원 번호</th>
            <th>회원 아이디</th>
            <th>회원 이름</th>
            <th>회원 나이</th>
        </tr>
        <tr>
            <th><%= king.getUserNo() %></th>
            <th><%= king.getUserId() %></th>
            <th><%= king.getUserName() %></th>
            <th><%= king.getUserAge() %></th>
        </tr>



    </table>

    <a href="/Test1/">메인페이지로 돌아기기</a>


</body>
</html>