<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>Case List</title>
		<script>
			function ex_main(){
				$(document).ready(function(){
					var rows_length = document.getElementById("tbl").rows.length;
					var table = document.getElementById('tbl');
					const rex = /무죄.*공직선거법|공직선거법.*무죄/;
					var test = [];
					for (var i = 1; i < rows_length; i++) {
						try{
							const b = table.rows[i].cells[5].innerText;
							let string = b.match(rex)[0];
							var substring = "...";
							var res = string.includes(substring);
							var target = table.rows[i];
							if (!res) {
								target.style.color = "red";
								// console.log("청탁");
							}else {
								// console.log("청탁아님");
							}
							const cc = table.rows[i].cells[4].innerText;
							if(cc.includes("공직선거법위반의 점은 무죄") || cc.includes("공직선거법위반의 점은 각 무죄")) {
								target.style.color = "red";
								test.append(table.rows[i]);
							}
						} catch(e) {
							console.log(e);
						}
					}
					localStorage.setItem('key', test);

				});
			}
		</script>
	</head>
	<body onload="ex_main()">
		<h1>List</h1>
		<a href="case_list.do">전체보기</a>&nbsp;
		<a href="case_list_2021.do">2021년도</a>&nbsp;
		<a href="case_list_2020.do">2020년도</a>&nbsp;
		<a href="case_list_2019.do">2019년도</a>&nbsp;
		<br>
		<table border=1 id="tbl">
			<tr>
				<th>순번</th>
				<th>선고일자</th>    
				<th>법원명[사건번호]</th>
				<th>사건명</th>
				<th>주문</th>
				<th>이유</th>
			</tr>
			<c:forEach var="case_n" items="${case_cmd}">
				<tr id="tr">
					<td><a href="case_list.do?seq=${case_n.seq}">${case_n.seq}</a></td>
					<td id="t1">${case_n.case_day}</td>
					<td id="t2">${case_n.case_court}</td>
					<td id="t3">${case_n.case_name}</td>
					<td id="t4">${case_n.case_order}</td>
					<td id="t5">${case_n.case_main}</td>
				</tr>
			</c:forEach>
		</table>
	</body>

</html>