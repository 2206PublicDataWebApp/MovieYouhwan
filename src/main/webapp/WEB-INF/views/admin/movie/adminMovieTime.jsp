<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 상영영화관리(관리자)</title>
<link href="/resources/css/common.css" rel="stylesheet">
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/movie.css" rel="stylesheet">
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/movie.js" defer></script>
</head>
<body>
	<!-- 날짜 set -->
	<jsp:useBean id="today" class="java.util.Date" />
	<fmt:formatDate var="oneDayYear" value="${today}" pattern="yyyy"/>
	<fmt:formatDate var="oneDayMonth" value="${today}" pattern="MM"/>
	<fmt:formatDate var="oneDayDate" value="${today}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="today" value="${today}" pattern="yyyyMMdd"/>
	
	<c:set var="oneDate" value="<%=new Date(new Date( ).getTime() + 60*60*24*1000*1)%>"/>
	<fmt:formatDate var="oneDay" value="${oneDate}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="todayOne" value="${oneDate}" pattern="yyyyMMdd"/>
	
	<c:set var="twoDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*2)%>"/>
	<fmt:formatDate var="twoDay" value="${twoDate}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="todayTwo" value="${twoDate}" pattern="yyyyMMdd"/>
	
	<c:set var="threeDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*3)%>"/>
	<fmt:formatDate var="threeDay" value="${threeDate}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="todayThree" value="${threeDate}" pattern="yyyyMMdd"/>
	
	<c:set var="fourDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*4)%>"/>
	<fmt:formatDate var="fourDay" value="${fourDate}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="todayFour" value="${fourDate}" pattern="yyyyMMdd"/>
	
	<c:set var="fiveDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*5)%>"/>
	<fmt:formatDate var="fiveDay" value="${fiveDate}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="todayFive" value="${fiveDate}" pattern="yyyyMMdd"/>

	<c:set var="sixDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*6)%>"/>
	<fmt:formatDate var="sixDay" value="${sixDate}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="todaySix" value="${sixDate}" pattern="yyyyMMdd"/>
	
	<c:set var="sevenDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*7)%>"/>
	<fmt:formatDate var="sevenDay" value="${sevenDate}" pattern="dd일 (E요일)"/>
	<fmt:formatDate var="todaySeven" value="${sevenDate}" pattern="yyyyMMdd"/>
	
	<!-- 페이지 시작 -->
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="widemovie-wrapper">
		<h3>상영 영화 관리</h3><br><br>
		<div id="movietime-wrap">
			<input type="hidden" value="${cinema.cinemaNo }" name="cinemaNo">
			<input type="hidden" value="${theater.theaterNo }" name="theaterNo">
			<span class="cinema-theater">${cinema.cinemaName }</span>
			<span class="cinema-theater">${theater.theaterName }</span>
		</div>
		<div>
			<button class="date-empty"><c:out value="${oneDayYear}" />년 <c:out value="${oneDayMonth}" />월</button>
		   	<button class="date-today"><c:out value="${oneDayDate}" /></button>
		   	<button class="date-button"><c:out value="${oneDay}" /></button>
		   	<button class="date-button"><c:out value="${twoDay}" /></button>
		   	<button class="date-button"><c:out value="${threeDay}" /></button>
		   	<button class="date-button"><c:out value="${fourDay}" /></button>
		   	<button class="date-button"><c:out value="${fiveDay}" /></button>
		   	<button class="date-button"><c:out value="${sixDay}" /></button>
		   	<button class="date-button"><c:out value="${sevenDay}" /></button>
		</div>
		<hr>
		<div id="date-time-wrap">
			<p class="date-time">11:00</p>
			<p class="date-time">11:30</p>
			<p class="date-time">12:00</p>
			<p class="date-time">12:30</p>
			<p class="date-time">13:00</p>
			<p class="date-time">13:30</p>
			<p class="date-time">14:00</p>
			<p class="date-time">14:30</p>
			<p class="date-time">15:00</p>
			<p class="date-time">15:30</p>
			<p class="date-time">16:00</p>
			<p class="date-time">16:30</p>
			<p class="date-time">17:00</p>
			<p class="date-time">17:30</p>
			<p class="date-time">18:00</p>
			<p class="date-time">18:30</p>
			<p class="date-time">19:00</p>
			<p class="date-time">19:30</p>
			<p class="date-time">20:00</p>
			<p class="date-time">20:30</p>
			<p class="date-time">21:00</p>
			<p class="date-time">21:30</p>
			<p class="date-time">22:00</p>
		</div>
		<div>
			<!-- 날짜 div -->
			<c:forEach items=${weeks } var="day"></c:forEach>
			<div id="${day }" class="date-input-wrap1">
				<!-- 시간 div -->
				<div id="${today }1100" class="date-input">
				
				</div>
				<c:forEach begin="1" end="10">
					<c:forEach items="moviList" var="movie">
						<c:if test="movie.시간  eq ">
						<div class="date-input filled-color">${movi }</div>
						</c:if>						
						<c:if test="movie.시간  NE ">
						<div class="date-input"></div>
						</c:if>
						
					</c:forEach>
				</c:forEach>
			</div>
			<div class="date-input-wrap2">
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
			</div>
			<div class="date-input-wrap3">
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
			</div>
			<div class="date-input-wrap4">
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
			</div>
			<div class="date-input-wrap5">
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
			</div>
			<div class="date-input-wrap6">
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
			</div>
			<div class="date-input-wrap7">
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
			</div>
			<div class="date-input-wrap8">
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
				<div class="date-input"></div>
			</div>
		</div>
	</div>
	<div id="add-movie-time">
		<jsp:include page="/WEB-INF/views/admin/movie/addMovieTime.jsp" />
	</div>
</body>
</html>