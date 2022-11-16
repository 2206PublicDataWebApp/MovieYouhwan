<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/user/my/myPage.css" />
<link rel="stylesheet" href="/resources/css/user/my/movieHistory.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>


<title>무비유환 - 예매내역</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/user/mypage/myPage.jsp"></jsp:include>

<div id="inner-wrap">
<c:if test="${!empty uMovieTicketList}">
    <div id="conut-wrap">
        <span id="movie-History">예매 내역 <span id="movie-count">6</span>건</span>
    </div>
    <c:forEach items="${uMovieTicketList}" var="movieTicket" varStatus="i">
        <div class="movie-detail-info">
            <div class="content">
                <div class="content-img">
                    <c:if test="${movieTicket.movieImgName eq '대표이미지.jpg'}">
                        <img class="movie-poster" src="/resources/images/movieLodeImg/${movieTicket.movieImgRename}">
                    </c:if>
                </div>
            </div>
                <div class="info-wrap-1">
                    <div class="movie-name">
                        
                    </div>
                    <div class="mv-info-1">
                        <div class="detail-wrap">
                            <div class="info-title">예매번호</div>
                            <div class="info-details">${movieTicket.ticketNo}</div>
                        </div>
                        <div class="detail-wrap">
                            <div class="info-title">영화명</div>
                            <div class="info-details">${movieTicket.movieName}</div>
                        </div>
                        <div class="detail-wrap">
                            <div class="info-title">극장 / 상영관</div>
                            <div class="info-details">${movieTicket.cinemaName} / ${movieTicket.theaterName}</div>
                        </div>
                        <div class="detail-wrap">
                            <div class="info-title">관람일시</div>
                            <div class="info-details">${movieTicket.movieDay} ${movieTicket.movieStart}</div>
                        </div>
                        <div class="detail-wrap">
                            <div class="info-title">결제일시</div>
                            <div class="info-details">${movieTicket.payDate}</div>
                        </div>
                        <!-- <div class="detail-wrap">
                            <div class="info-title">추가 결제 내역</div>
                            <div class="info-details">무비콤보 | 수량 : 1 | + 8,000원</div>
                        </div> -->
                    </div>
                </div>
                <div class="info-wrap-2">
                    <div class="mv-info-2">
                        <div class="detail-wrap-2">
                            <div class="info-title-2">관람인원</div>
                            <div class="info-details-2">성인 : ${movieTicket.adultCount} / 청소년 : ${movieTicket.teenagerCount}</div>
                        </div>
                        <div class="detail-wrap-2">
                            <div class="info-title-2">관람좌석</div>
                            <div class="info-details-2">${movieTicket.choiceSeat}</div>
                        </div>
                        <div class="btn">
                            <button class="delete-btn">예매취소</button>
                            <button class="review-btn">리뷰작성</button>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>
    </c:forEach>

    <div id="paging">
        <ul id="paging-wrap">
            <li><a href="#">＜</a></li>
            <li><a href="#">1</a></li>
            <!-- <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li> -->
            <li><a href="#">＞</a></li>
        </ul>
    </div>
</c:if>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>