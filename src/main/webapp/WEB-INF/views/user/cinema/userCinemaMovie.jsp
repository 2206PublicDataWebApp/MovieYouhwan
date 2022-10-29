<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 전체 상영 영화</title>
<link href="/resources/css/common.css" rel="stylesheet" />
<link href="/resources/css/header.css" rel="stylesheet" />
<link href="/resources/css/cinema.css" rel="stylesheet" />
</head>
<body>
	<!-- 날짜 set -->
	<jsp:useBean id="today" class="java.util.Date" />
	<fmt:formatDate var="oneDayYear" value="${today}" pattern="yyyy"/>
	<fmt:formatDate var="oneDayMonth" value="${today}" pattern="MM"/>
	<fmt:formatDate var="oneDayDate" value="${today}" pattern="dd E"/>
	
	<c:set var="oneDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
	<fmt:formatDate var="oneDay" value="${oneDate}" pattern="dd E"/>
	
	<c:set var="twoDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*2)%>"/>
	<fmt:formatDate var="twoDay" value="${twoDate}" pattern="dd E"/>
	
	<c:set var="threeDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*3)%>"/>
	<fmt:formatDate var="threeDay" value="${threeDate}" pattern="dd E"/>
	
	<c:set var="fourDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*4)%>"/>
	<fmt:formatDate var="fourDay" value="${fourDate}" pattern="dd E"/>
	
	<c:set var="fiveDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*5)%>"/>
	<fmt:formatDate var="fiveDay" value="${fiveDate}" pattern="dd E"/>

	<c:set var="sixDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*6)%>"/>
	<fmt:formatDate var="sixDay" value="${sixDate}" pattern="dd E"/>
	
	<c:set var="sevenDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*7)%>"/>
	<fmt:formatDate var="sevenDay" value="${sevenDate}" pattern="dd E"/>
	
	<!-- 페이지 시작 -->
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <div class="cinemaImg-wrapper">
	    <img class="cinemaImg" src="/resources/images/cinemaLodeImg/${cinema.cinemaImgRename }"/>
    </div>
    <div class="usercinema-wrapper">
	    <!-- 영화관 이름 옆에 즐겨찾기 추가해주시면 됩니다 ! -->
    	<div class="usercinema-bottom">
	    	<h3>${cinema.cinemaName }</h3>
    	</div>
    	<div class="usercinema-bottom">
    		<p>${cinema.cinemaContent }</p>
    	</div>
    	<div class="usercinema-bottom">
    		<button id="usercinema-listbutton" onclick="location.href='/user/cinemaList.yh'">목록으로</button>
    	</div>
		<!-- 영화관 정보, 전체 상영 영화 메뉴 탭 -->
	   	<div id="movie-menu">
	   		<button class="cinema-off" onclick="location.href='/user/cinemaInformation.yh?cinemaNo=${cinema.cinemaNo}'">영화관 정보</button>
			<button class="cinema-on" onclick="location.href='/user/cinemaMovie.yh?cinemaNo=${cinema.cinemaNo}'">전체 상영 영화</button>
	   	</div>
	   	<!-- 날짜 -->
	   	<div>
	   		<div id="now-year">
		   		<c:out value="${oneDayYear}" />
	   		</div>
	   		<hr>
	   		<div>
	   			<button class="date-button"><c:out value="${oneDayDate}" /></button>
	   			<button class="date-button"><c:out value="${twoDay}" /></button>
	   			<button class="date-button"><c:out value="${threeDay}" /></button>
	   			<button class="date-button"><c:out value="${fourDay}" /></button>
	   			<button class="date-button"><c:out value="${fiveDay}" /></button>
	   			<button class="date-button"><c:out value="${sixDay}" /></button>
	   			<button class="date-button"><c:out value="${sevenDay}" /></button>
	   		</div>
	   		<c:out value="${oneDayMonth}" />
	   	</div>
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>