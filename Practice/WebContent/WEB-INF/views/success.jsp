<%@page import="com.ji.practice.user.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% Member sky = (Member)request.getAttribute("sky"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h2>회원 정보 조회 결과</h2>
    
    <table border="1">
        <tr>
            <th>회원 번호</th>
            <th>회원 이름</th>
            <th>회원 아이디</th>
            <th>회원 비밀번호</th>
        </tr>
        <tr>
            <td><%=sky.getUserNo() %></td>
           <th><%= sky.getUserId() %></th>
            <th><%= sky.getUserName() %></th>
            <th><%=sky.getUserAge() %></th>
        </tr>
    </table>


</body>
</html>