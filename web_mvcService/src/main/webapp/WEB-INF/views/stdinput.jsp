<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>회원정보 등록화면</title>
	</head>
	<body>
		<h1>회원정보 등록화면</h1>
		<form:form method="POST" action="/w13/stdinput.do" commandName="msg">
			<table>
				<tr><td>아이디</td><td><input type="text" value="" name="id" id="id" /></td></tr>
				<tr><td>이름</td><td><form:input path="name" /></td></tr>
				<tr><td>나이</td><td><form:input path="age" /></td></tr>
				<tr><td></td><td><input type="submit" value="전송" /></td></tr>
			</table>
		</form:form>
	</body>
</html>