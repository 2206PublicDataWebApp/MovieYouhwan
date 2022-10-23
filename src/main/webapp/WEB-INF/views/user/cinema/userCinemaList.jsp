<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 리스트</title>
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="../resources/css/cinema.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<img src="../resources/images/cinema/user_movieList.png" id="userCinema-img">
	<div class="usercinema-wrapper">
		<h3>서울</h3> <br><br>
		<div class="ucinemalist-outside">
		
		</div>
		<c:if test="${!empty cList }">
			<c:forEach items="${cList }" var="cinema" varStatus="i">
				<h3>${cinema.cinemaArea }</h3>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>