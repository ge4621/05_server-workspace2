<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- index.jsp파일 만들고 맨 처음에 실행 되는지 확인 -->

	<h1>회원 정보 검색(회원 번호 검색)</h1>
	<form action="/Test1/test.do" method="get">
	
		<input type="test" name="userNo" placeholder="회원 번호 입력"> <!-- name 값을 줘야 날라감 =>db로 넘어가야 하는 정보이다 (=>꼭 name 값 주기  -->
		<!-- db로 넘겨야할 값은 무조건 name을 줘야 한다. -->
		<input type="submit" value="조회">
		
	</form>
	
	<br>

	<form action="/Test1/login.do" method="get">

		아이디 : <input type="text" name="userId"> <br>
		나이 : <input type="number" name="userAge"> <br>
			<input type="submit">

	</form>

<br><br>
	<form action="/Test1/practice.do" method="get">
		이름 : <input type="text" name="userName"> <br>
		회원 번호 : <input type="text" name="userNo"> <br>

		<input type="submit">
	</form>

</body>
</html>