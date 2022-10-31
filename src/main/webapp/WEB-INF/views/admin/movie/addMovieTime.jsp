<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %> 
<!-- 날짜 set -->
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate var="oneDayDate" value="${today}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="today" value="${today}" pattern="yyyyMMdd"/>

<c:set var="oneDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
<fmt:formatDate var="oneDay" value="${oneDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayOne" value="${oneDate}" pattern="yyyyMMdd"/>

<c:set var="twoDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*2)%>"/>
<fmt:formatDate var="twoDay" value="${twoDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayTwo" value="${twoDate}" pattern="yyyyMMdd"/>

<c:set var="threeDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*3)%>"/>
<fmt:formatDate var="threeDay" value="${threeDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayThree" value="${threeDate}" pattern="yyyyMMdd"/>

<c:set var="fourDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*4)%>"/>
<fmt:formatDate var="fourDay" value="${fourDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayFour" value="${fourDate}" pattern="yyyyMMdd"/>

<c:set var="fiveDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*5)%>"/>
<fmt:formatDate var="fiveDay" value="${fiveDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayFive" value="${fiveDate}" pattern="yyyyMMdd"/>

<c:set var="sixDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*6)%>"/>
<fmt:formatDate var="sixDay" value="${sixDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todaySix" value="${sixDate}" pattern="yyyyMMdd"/>

<c:set var="sevenDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*7)%>"/>
<fmt:formatDate var="sevenDay" value="${sevenDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todaySeven" value="${sevenDate}" pattern="yyyyMMdd"/>

<form action="/admin/insertMovieTheater.yh" method="post">
	<input type="hidden" name="cinemaNo" value="${cinema.cinemaNo }">
	<input type="hidden" name="theaterNo" value="${theater.theaterNo }">
	<div class="modal-wrapper">
		<div class="modal-movie">
			<h3>영화 등록</h3>
			<p id="modal-movie-text">영화 선택</p>
			<select id="choice-addmovie" name="movieNo">
				<c:forEach items="${mList }" var="movie" varStatus="i">
					<option value="${movie.movieNo }">${movie.movieTitle} - 상영 종료일 : ${movie.movieEndday }</option>
				</c:forEach>
			</select>
			<p>상영 날짜</p>
			<select id="choicetime-movie-date" name="movieDay">
				<option value="${today }">${oneDayDate }</option>
				<option value="${todayOne }">${oneDay }</option>
				<option value="${todayTwo }">${twoDay }</option>
				<option value="${todayThree }">${threeDay }</option>
				<option value="${todayFour }">${fourDay }</option>
				<option value="${todayFive }">${fiveDay }</option>
				<option value="${todaySix }">${sixDay }</option>
				<option value="${todaySeven }">${sevenDay }</option>
			</select>
			<div id="movie-start-time">
				<p id="choice-movie-start">상영 시작 시간</p>
				<select id="movie-start-choice" name="movieStart">
					<option value="1100">11:00</option>
					<option value="1130">11:30</option>
					<option value="1200">12:00</option>
					<option value="1230">12:30</option>
					<option value="1300">13:00</option>
					<option value="1330">13:30</option>
					<option value="1400">14:00</option>
					<option value="1430">14:30</option>
					<option value="1500">15:00</option>
					<option value="1530">15:30</option>
					<option value="1600">16:00</option>
					<option value="1630">16:30</option>
					<option value="1700">17:00</option>
					<option value="1730">17:30</option>
					<option value="1800">18:00</option>
					<option value="1830">18:30</option>
					<option value="1900">19:00</option>
					<option value="1930">19:30</option>
					<option value="2000">20:00</option>
					<option value="2030">20:30</option>
					<option value="2100">21:00</option>
				</select>
			</div>
			<div id="movie-end-time">
				<p id="choice-movie-end">상영 종료 시간</p>
				<select id="movie-end-choice" name="movieEnd">
					<option value="1200">12:00</option>
					<option value="1230">12:30</option>
					<option value="1300">13:00</option>
					<option value="1330">13:30</option>
					<option value="1400">14:00</option>
					<option value="1430">14:30</option>
					<option value="1500">15:00</option>
					<option value="1530">15:30</option>
					<option value="1600">16:00</option>
					<option value="1630">16:30</option>
					<option value="1700">17:00</option>
					<option value="1730">17:30</option>
					<option value="1800">18:00</option>
					<option value="1830">18:30</option>
					<option value="1900">19:00</option>
					<option value="1930">19:30</option>
					<option value="2000">20:00</option>
					<option value="2030">20:30</option>
					<option value="2100">21:00</option>
					<option value="2130">21:30</option>
					<option value="2200">22:00</option>
				</select>
			</div>
			<div id="add-movie-button">
				<button type="button" id="add-movie-off">취소</button>
				<button type="submit" id="add-movie-on">적용</button>
			</div>
		</div>
	</div>
</form>
