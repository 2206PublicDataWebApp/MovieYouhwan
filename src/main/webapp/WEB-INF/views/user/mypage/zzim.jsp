<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/user/my/zzim.css" />
<link rel="stylesheet" href="/resources/css/user/my/myPage.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
<title>무비유환 - 내가 찜한 영화</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/user/mypage/myPage.jsp"></jsp:include>
<div id="inner-wrap">
    ${zzimCount}
    <c:if test="${!empty uZzimList}">
        <div id="conut-wrap">
            <span id="movie-History">내가 찜한 영화 <span id="movie-count">${zzimCount}</span>건</span>
        </div>
        <c:forEach items="${uZzimList}" var="zzim" varStatus="i">
        <div class="movie-detail-info">
            
            <div class="content">
                
                <div class="content-img">
                    <c:if test="${zzim.movieImgName eq '대표이미지.jpg'}">
                        <img class="movie-poster" src="/resources/images/movieLodeImg/${zzim.movieImgReName}">
                    </c:if>
                </div>
                <div class="info-wrap-1">
                    <div class="movie-name">
                        ${zzim.movieTitle}
                        <c:if test="${zzim.movieAge eq '전체' }">
								<img class="film-rating" src="/resources/images/movie/전체.jpg"/>
							</c:if>
							<c:if test="${zzim.movieAge eq '만12세' }">
								<img class="film-rating" src="/resources/images/movie/12.jpg"/>
							</c:if>
							<c:if test="${zzim.movieAge eq '만15세' }">
								<img class="film-rating" src="/resources/images/movie/15.jpg"/>
							</c:if>
							<c:if test="${zzim.movieAge eq '청불' }">
								<img class="film-rating" src="/resources/images/movie/청불.jpg"/>
							</c:if>
                    </div>
                        <div class="mv-info-1">
                            <div class="detail-wrap">
                                <div class="info-title">개봉일</div>
                                <div class="info-details">
                                    <fmt:formatDate value="${zzim.movieStartDay}" pattern="yyyy-MM-dd"/>
                                </div>
                            </div>
                            <div class="detail-wrap">
                                <div class="info-title">감독</div>
                                <div class="info-details">${zzim.movieDirector}</div>
                            </div>
                            <div class="detail-wrap">
                                <div class="info-title">출연</div>
                                <div class="info-details">${zzim.movieActor}</div>
                            </div>
                            <div class="detail-wrap">
                                <div class="info-title">관람객</div>
                                <div class="info-details">${zzim.movieSee}명</div>
                            </div>
                        </div>
                    </div>
                
                <div class="info-wrap-2">
                    
                    <a href="/movieTicketTime.yh"class="ticketing-btn" >예매하기</a>
                    <a href="#"><i class="fa-solid fa-heart" class="heart-btn"></i></a>
                </div>
            </div>
        </div>
        </c:forEach>
        <div class="padding"></div>
        <div id="paging">
            <ul id="paging-wrap">
                <c:if test="${pageInfo.startPage ne 1 }"><li><a href="/my/zzim.yh?currentPage=${pageInfo.startPage-1 }"></a></li></c:if>
                <c:forEach var="page" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
	   				<c:if test="${pageInfo.currentPage eq page}">
	   					<li><a class="currentP" href="#">${page }</a></li>
	   				</c:if>
	   				<c:if test="${pageInfo.currentPage ne page }">
	   					<li><a href="/my/zzim.yh?currentPage=${page }">${page }</a></li>
	   				</c:if>
	   				<c:if test="${pageInfo.endPage ne pageInfo.pageCount }">
	   					<li><a href="/my/zzim.yh?currentPage=${pageInfo.endPage+1 }">&raquo;</a></li>
	   				</c:if>
	   			</c:forEach>
                <!-- <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">＞</a></li> -->
            </ul>
        </div>
    </c:if>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>