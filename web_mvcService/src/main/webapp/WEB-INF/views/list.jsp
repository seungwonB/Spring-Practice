<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>리스트 화면</h1>
		<table border=1>
			<tr>
				<th>순서</th>    <th>아이디</th>
				<th>성명</th>
				<th>나이</th>
			</tr>
			<c:forEach var="std_n" items="${std_cmd}">
				<tr>
					<td><a href="std_list.do?seq=${std_n.seq}">${std_n.seq}</a></td>
					<td>${std_n.id}</td>
					<td>${std_n.name}</td>
					<td>${std_n.age}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>