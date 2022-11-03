<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/zzim.css" />
<link rel="stylesheet" href="/resources/css/myPage.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
<title>무비유환 - 내가 찜한 영화</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/user/mypage/myPage.jsp"></jsp:include>
<div id="inner-wrap">
    <div id="conut-wrap">
        <span id="movie-History">내가 찜한 영화 <span id="movie-count">3</span>건</span>
    </div>
    <div class="movie-detail-info">
        <div class="content">
            <div class="content-img">
                <img class="movie-poster" src="https://img.megabox.co.kr/SharedImg/2022/09/29/OZgzOHC1T6Jg2ZCJW0gzCrzOGUjJAbiP_420.jpg">
            </div>
            <div class="info-wrap-1">
                <div class="movie-name">정직한 후보 2<img class="film-rating" src="https://upload.wikimedia.org/wikipedia/commons/0/04/KMRB_B.png?20151112023543"></div>
                <div class="mv-info-1">
                    
                    <div class="detail-wrap">
                        <div class="info-title">개봉일</div>
                        <div class="info-details">2022-09-28</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">감독</div>
                        <div class="info-details">장유정</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">출연</div>
                        <div class="info-details">라미란, 김무열, 윤경호, 박진주, 윤두준</div>
                    </div>
                    <div class="detail-wrap">
                        <div class="info-title">관람객</div>
                        <div class="info-details">51,584명</div>
                    </div>
                </div>
            </div>
            <div class="info-wrap-2">
                <button class="ticketing-btn">예매하기</button>
                <a href="#"><i class="fa-solid fa-heart" class="heart-btn"></i></a>
            </div>
        </div>
        </div>
        <div class="padding"></div>
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