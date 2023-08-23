<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>AJAX의 개요</h1>
	
	<p>
		Asynchronous JavaScript And XML의 약자로  <br>
		서버로부터 데이터를 가져와 전체 페이지를 새로고치지 않고 일부만 로드할 수 있게 하는 기법 <br>
		우리가 기존에 a태그로 요청 및 form submit 요청 방식은 "동기식 요청" => 응답페이지가 돌아와야만 볼 수 있음(페이지가 깜빡 거림) <br><br>
		
		* 동기식 / 비동기식 <br>
		> 동기식 (a, form submit)

		<ul>
			<li>요청 처리 후 그에 해당하하는 응답페이지가 돌아와야지만 그 다음 작업 가능</li>
			<li>서버에 요청한 결과까지의 시간이 지연되면 무작정 계속 기다려야 됨(흰페이지로 보여질꺼임)</li>
			<li>전체페이지를 응답해주기 때문에 기본적으로 페이지가 깜빡거림</li>
		</ul>

		>비동기식(ajax)
		<ul>
			<li>현재페이지를 그대로 유지하면서 중간중간마다 추가적으로 필요한 요청을 보내줄 수 있음</li>
			<li>요청을 보냈다고 해서 다른 페이지로 넘어가지 않음(현재페이지를 그대로 유지)</li>
			<li>요청 보내놓고 그에 해당 하는 응답(데이터)이 돌아올떄가지 현재페이지에서 다른 작업을 할 수 있다.</li>
			<li>페이지 깜빡거리지 않음</li>
		</ul>

	</p>
	
	
	
</body>
</html>