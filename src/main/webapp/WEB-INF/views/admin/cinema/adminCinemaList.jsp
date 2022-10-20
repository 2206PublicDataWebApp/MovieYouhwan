<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 리스트(관리자)</title>
<link href="../../../resources/css/common.css" rel="stylesheet">
<link href="../resources/css/cinema.css" rel="stylesheet">
</head>
<body>
	<div id="admin-wrapper">
		<br><br><br><h3>영화관 관리</h3><br><br>
		<table border="1">
			<thead>
				<tr>
					<th>지역</th>
					<th>지점명</th>
					<th>주소</th>
					<th>전화번호</th>
					<th colspan="3">상영관</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty cList}">
					<c:forEach items="${cList}" var="cinema" varStatus="i">
						<tr>
							<td>${cinema.cinemaArea }</td>
							<td>${cinema.cinemaName }</td>
							<td>${cinema.cinemaAddress }</td>
							<td>${cinema.cinemaTel }</td>
							<!-- 상영관 만들어서 넣어야함 -->
							<td>1</td>
							<td>1</td>
							<td>1</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>