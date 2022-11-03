<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*" %> 
<!-- 날짜 set -->
<jsp:useBean id="today" class="java.util.Date" />
<fmt:formatDate var="oneDayDate" value="${today}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="today" value="${today}" pattern="yyyy-MM-dd"/>

<c:set var="oneDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*1)%>"/>
<fmt:formatDate var="oneDay" value="${oneDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayOne" value="${oneDate}" pattern="yyyy-MM-dd"/>

<c:set var="twoDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*2)%>"/>
<fmt:formatDate var="twoDay" value="${twoDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayTwo" value="${twoDate}" pattern="yyyy-MM-dd"/>

<c:set var="threeDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*3)%>"/>
<fmt:formatDate var="threeDay" value="${threeDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayThree" value="${threeDate}" pattern="yyyy-MM-dd"/>

<c:set var="fourDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*4)%>"/>
<fmt:formatDate var="fourDay" value="${fourDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayFour" value="${fourDate}" pattern="yyyy-MM-dd"/>

<c:set var="fiveDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*5)%>"/>
<fmt:formatDate var="fiveDay" value="${fiveDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todayFive" value="${fiveDate}" pattern="yyyy-MM-dd"/>

<c:set var="sixDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*6)%>"/>
<fmt:formatDate var="sixDay" value="${sixDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todaySix" value="${sixDate}" pattern="yyyy-MM-dd"/>

<c:set var="sevenDate" value="<%=new Date(new Date().getTime() + 60*60*24*1000*7)%>"/>
<fmt:formatDate var="sevenDay" value="${sevenDate}" pattern="yyyy년 MM월 dd일 (E요일)"/>
<fmt:formatDate var="todaySeven" value="${sevenDate}" pattern="yyyy-MM-dd"/>

<form action="/admin/insertMovieTheater.yh" method="post">
	<input type="hidden" name="cinemaNo" value="${cinema.cinemaNo }">
	<input type="hidden" name="theaterNo" value="${theater.theaterNo }">
	<input type="hidden" value="${(theater.theaterSeatoneRow * theater.theaterSeatoneColumn) + (theater.theaterSeattwoRow * theater.theaterSeattwoColumn) + (theater.theaterSeatthreeRow * theater.theaterSeatthreeColumn) }" name="movieTicket">
	<input type="hidden" value="${(theater.theaterSeatoneRow * theater.theaterSeatoneColumn) + (theater.theaterSeattwoRow * theater.theaterSeattwoColumn) + (theater.theaterSeatthreeRow * theater.theaterSeatthreeColumn) }" name="movieSeat">
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
					<option value="11:00">11:00</option>
					<option value="11:30">11:30</option>
					<option value="12:00">12:00</option>
					<option value="12:30">12:30</option>
					<option value="13:00">13:00</option>
					<option value="13:30">13:30</option>
					<option value="14:00">14:00</option>
					<option value="14:30">14:30</option>
					<option value="15:00">15:00</option>
					<option value="15:30">15:30</option>
					<option value="16:00">16:00</option>
					<option value="16:30">16:30</option>
					<option value="17:00">17:00</option>
					<option value="17:30">17:30</option>
					<option value="18:00">18:00</option>
					<option value="18:30">18:30</option>
					<option value="19:00">19:00</option>
					<option value="19:30">19:30</option>
					<option value="20:00">20:00</option>
					<option value="20:30">20:30</option>
					<option value="21:00">21:00</option>
				</select>
			</div>
			<div id="movie-end-time">
				<p id="choice-movie-end">상영 종료 시간</p>
				<select id="movie-end-choice" name="movieEnd">
					<option value="12:00">12:00</option>
					<option value="12:30">12:30</option>
					<option value="13:00">13:00</option>
					<option value="13:30">13:30</option>
					<option value="14:00">14:00</option>
					<option value="14:30">14:30</option>
					<option value="15:00">15:00</option>
					<option value="15:30">15:30</option>
					<option value="16:00">16:00</option>
					<option value="16:30">16:30</option>
					<option value="17:00">17:00</option>
					<option value="17:30">17:30</option>
					<option value="18:00">18:00</option>
					<option value="18:30">18:30</option>
					<option value="19:00">19:00</option>
					<option value="19:30">19:30</option>
					<option value="20:00">20:00</option>
					<option value="20:30">20:30</option>
					<option value="21:00">21:00</option>
					<option value="21:30">21:30</option>
					<option value="22:00">22:00</option>
				</select>
			</div>
			<div id="movie-insert-button">
				<button type="button" id="add-movie-off">취소</button>
				<button type="submit" id="add-movie-on">적용</button>
			</div>
		</div>
	</div>
</form>
