<%@page import="edu.kh.test.user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	User user = (User)request.getAttribute("user1"); // User 라는 자료형에 user라는 이름의 변수 생성 (user1) 은  SelectServlet2에서 if else에서 else에 있는 "user1"
 	
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
            <th><%= user.getUserNo() %></th>
            <th><%= user.getUserId() %></th>
            <th><%= user.getUserName() %></th>
            <th><%=user.getUserAge() %></th>
        </tr>



    </table>

    <a href="/Test1/">메인페이지로 돌아기기</a>


</body>
</html>