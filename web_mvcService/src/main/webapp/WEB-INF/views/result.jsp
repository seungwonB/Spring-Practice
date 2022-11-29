<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:if test="${not empty msg.seq}">
	<c:set var="call" value="/w13/update/case_list.do?seq=${seq}" />
</c:if>

<c:if test="${msg.seq eq 0}">
	<c:set var="call" value="/w13/case_list.do?seq=${seq}" />
</c:if> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Case List</title>
	</head>
	<body>
		<h1>List</h1>
		<form:form method="POST" action = "${call}" commandName="msg">
			<form:hidden path="seq" />
			<table>
				<tr><td>선고일자 : </td><td path="case_day">${msg.case_day}</td></tr>
				<tr><td>법원명[사건번호] : </td><td path="case_court">${msg.case_court}</td></tr>
				<tr><td>사건명 : </td><td path="case_name">${msg.case_name}</td></tr>
				<tr><td>주문 : </td><td path="case_order">${msg.case_order}</td></tr>
				<tr><td>이유 : </td><td path="case_main">${msg.case_main}</td></tr>
			</table>
			<c:if test="${not empty msg.seq}">
				<a href="case_delete.do?seq=${msg.seq}">${msg.case_court}삭제</a><br>
			</c:if>
		</form:form>
		<a href="case_list.do">전체목록</a>
	</body>
</html>