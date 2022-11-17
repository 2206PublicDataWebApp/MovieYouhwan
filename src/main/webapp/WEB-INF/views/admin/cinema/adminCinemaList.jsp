<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비유환 : 영화관 리스트(관리자)</title>
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link href="/resources/css/common.css" rel="stylesheet"/>
<link href="/resources/css/header.css" rel="stylesheet"/>
<link href="/resources/css/cinema.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/adminHeader.jsp"></jsp:include>
	<div class="widecinema-wrapper">
		<div id="cinemalist-top">
			<h3 id="cinemalist-text">영화관 관리</h3>
			<button class="cinemalist-button" onclick="location.href='/admin/adminCinemaRegister.yh'">영화관 등록</button>
			<button class="cinemalist-button" onclick="location.href='/admin/adminTheaterRegister.yh'">상영관 등록</button>		
		</div>
		<div class="cinemalist-title">
			<div class="list-area">지역</div>
			<div class="list-name">지점명</div>
			<div class="list-address">주소</div>
			<div class="list-tel">전화번호</div>
			<div class="list-theater">상영관</div>
		</div>
		<hr>
		<c:if test="${!empty cList}">
			<c:forEach items="${cList}" var="cinema" varStatus="i">
				<div class="cinemalist-title">
					<div class="list-area" onclick="location.href='/admin/adminCinemaDetail.yh?cinemaNo=${cinema.cinemaNo}'">${cinema.cinemaArea }</div>
					<div class="list-name" onclick="location.href='/admin/adminCinemaDetail.yh?cinemaNo=${cinema.cinemaNo}'">${cinema.cinemaName }</div>
					<div class="list-address" onclick="location.href='/admin/adminCinemaDetail.yh?cinemaNo=${cinema.cinemaNo}'">${cinema.cinemaAddress1 }, ${cinema.cinemaAddress2 }</div>
					<div class="list-tel" onclick="location.href='/admin/adminCinemaDetail.yh?cinemaNo=${cinema.cinemaNo}'">${cinema.cinemaTel }</div>
					<c:if test="${!empty tList }">
						<c:forEach items="${tList }" var="theater" varStatus="i">
							<c:if test="${cinema.cinemaNo eq theater.tCinemaNo}">
								<button class="ctheater-button" onclick="location.href='/admin/adminTheaterDetail.yh?theaterNo=${theater.theaterNo}&cinemaName=${cinema.cinemaName }'">${theater.theaterName }</button>
							</c:if>
						</c:forEach>
					</c:if>
				</div>
				<hr>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>