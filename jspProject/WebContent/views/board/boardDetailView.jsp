<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <td width="70">등산</td>
            <th width="70">제목</th>
            <td width="350">이곳이 제목 자리</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>admin</td>
            <th>작성일</th>
            <td>2023/08/18</td>
        </tr>
        <tr>
            <th>내용</th>
            <td colspan="3">
                <p style="height: 200px;">이곳이 내용자리</p>
            </td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td colspan="3">
            <!--case1. 첨부파일이 없을 겨우-->
            <!--첨부파일이 없습니다.-->

            <!--case2. 첨부파일이 있을 경우-->
            <a href="폴더경로/바뀐파일명">원본명.png</a>
            </td>
            
           
        </tr>

    </table>
    <br>
    <div align="center">
        <a href="#">목록가기</a>

        <!--로그인한 사람과 게시글의 작성자가 일치하는 경우-->
        <a href="#">수정하기</a>
        <a href="#">삭제하기</a>
    </div>



</div>





</body>
</html>