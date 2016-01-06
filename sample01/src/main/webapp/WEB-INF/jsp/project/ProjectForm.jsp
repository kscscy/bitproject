<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset='UTF-8'>
	<title>프로젝트-새 프로젝트</title>
</head>
<body>
<h1>새 프로젝트</h1>
<form action='add.do' method='post'>
<table border='1'>
<tr>
	<th>제목</th>
	<td><input type='text' name='title' placeholder="제목을 넣으세요"></td>
</tr>
<tr>
	<th>시작일</th>
	<td><input type='text' name='startDate' placeholder="시작일을 넣으세요"></td>
</tr>
<tr>
	<th>종료일</th>
	<td><input type='text' name='endDate' placeholder="종료일을 넣으세요"></td>
</tr>
<tr>
	<th>멤버</th>
	<td><input type='text' name='member' placeholder="멤버를 넣으세요"></td>
</tr>
</table>
<p>

<button type='submit'>등록</button>

</form>

<jsp:include page="/Copyright.jsp"/>

</body>
</html>
