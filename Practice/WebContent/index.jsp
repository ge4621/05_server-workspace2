<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>회원 정보 조회(아이디외 회원 번호)</h1>
	
    <form action="/practice/search.do">
        아이디 : <input type="text" name="userId" placeholder="아이디를 입력하세요"> <br>
        비밀번호 : <input type="text" name="userPwd" placeholder="비밀번호를 입력하세요"> <br>
        <input type="submit" value="조회">

    </form>



</body>
</html>