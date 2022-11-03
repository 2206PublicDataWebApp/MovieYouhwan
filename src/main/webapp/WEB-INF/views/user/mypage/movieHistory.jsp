<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/movieHistory.css" />
<link rel="stylesheet" href="/resources/css/myPage.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>


<title>무비유환 - 관람영화</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/user/mypage/myPage.jsp"></jsp:include>
<div class="history-btn-wrap">
    <button id="history-btn-1">예매내역</button>
    <button id="history-btn-2">관람영화</button>
    <button id="history-btn-3">취소내역</button>
</div>
<div id="inner-wrap">
    <div id="conut-wrap">
        <span id="movie-History">내가 본 영화 <span id="movie-count">6</span>건</span>
    </div>
    <div class="movie-detail-info">
        <div class="content">
            <div class="content-img">
                <img class="movie-poster" src="https://img.megabox.co.kr/SharedImg/2022/10/13/TnglPxaL6kXOO8KI7PNDTDgua4HXGHwV_420.jpg">
            </div>
            <div class="info-wrap-1">
                <div class="movie-name">정직한 후보 2</div>
                <div class="mv-info-1">
                    <div class="detail-wrap">
                        <div class="info-title">예매번호</div>
                        <div class="info-details">0000-8282-8282</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">영화명</div>
                        <div class="info-details">정직한 후보 2</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">극장 / 상영관</div>
                        <div class="info-details">신촌 메가박스</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">관람일시</div>
                        <div class="info-details">2022-10-04 (금) 23 : 45</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">결제일시</div>
                        <div class="info-details">2022-10-04</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">추가 결제 내역</div>
                        <div class="info-details">무비콤보 | 수량 : 1 | + 8,000원</div>
                    </div>
                </div>
            </div>
            <div class="info-wrap-2">
                <div class="mv-info-2">
                    <div class="detail-wrap-2">
                        <div class="info-title-2">관람인원</div>
                        <div class="info-details-2">성인 1명</div>
                    </div>
                    <div class="detail-wrap-2">
                        <div class="info-title-2">관람좌석</div>
                        <div class="info-details-2">H열 12</div>
                    </div>
                    <div class="btn">
                        <button class="delete-btn">삭제</button>
                        <button class="review-btn">리뷰작성</button>
                    </div>
                </div>
                
            </div>
        </div>
        
    </div>

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
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>