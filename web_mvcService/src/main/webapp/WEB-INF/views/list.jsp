<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>Insert title here</title>
		<script>
			function search() {
				var sel = document.getElementById("sel");
				var idx = sel.selectedIndex;
				var val = sel.options[idx].value;
				
				var sel2 = document.getElementById("sel2");
				var idx2 = sel2.selectedIndex;
				var val2 = sel2.options[idx2].value;
				
				$.ajax({
					type: 'post',
					url: 'std_list.do',
					data : val,

				})
			}
		</script>
		<script>
			function ex_main(){
				$(document).ready(function(){
					var rows_length = document.getElementById("tbl").rows.length;
					var table = document.getElementById('tbl');
					const rex = /무죄.*공직선거법|공직선거법.*무죄/;
					// var text = $("#tbl tr #cmain").text();
					// try{
					// 	const b2 = table.rows[2].cells[5].innerText;
					// 	let string = b2.match(rex)[0];
					// 	// console.log(twc);
					// 	var substring = "...";
					// 	var res = string.includes(substring);
					// 	if (!res) {
					// 		console.log("청탁");
					// 	}else {
					// 		console.log("청탁아님");
					// 	}
					// } catch(e){
					// 	console.log(e);
					// }
					
					// console.log(b2.match(rex)[0]);
					
					const b3 = table.rows[2].cells[5].innerText;
					// console.log(b3);
					// console.log(b3.match(rex)[0]);

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
								// console.log(cc);
							}
						} catch(e) {
							console.log(e);
						}
					}
				});
			}
		</script>
	</head>
	<body onload="ex_main()">
		<h1>리스트 화면</h1>
		<select id="sel">
			<option value="2021">2021</option>
			<option value="2020">2020</option>
			<option value="2019">2019</option>
		</select>
		<select id="sel2">
			<option value="1">1</option>
			<option value="2">2</option>
		</select>
		<button id="btn" onclick="search()">검색</button>
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
			<c:forEach var="std_n" items="${std_cmd}">
				<tr id="tr">
					<td><a href="std_list.do?seq=${std_n.seq}">${std_n.seq}</a></td>
					<td>${std_n.case_day}</td>
					<td>${std_n.case_court}</td>
					<td>${std_n.case_name}</td>
					<td>${std_n.case_order}</td>
					<td id="cmain">${std_n.case_main}</td>
				</tr>
			</c:forEach>
		</table>
	</body>

</html>
