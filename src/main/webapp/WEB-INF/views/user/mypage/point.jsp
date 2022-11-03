<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/point.css" />
<link rel="stylesheet" href="/resources/css/myPage.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
<title>무비유환 - 나의 포인트</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/user/mypage/myPage.jsp"></jsp:include>
<div class="wrap">
    <div class="title-item">포인트 조회</div>
    <div class="point-wrap">
        <span id="nick">짱아님의 포인트는<span id="point">1000P</span>입니다</span>
    </div>
    <div id="point-history-lookup-wrap">
        <div id="point-history-lookup">이용내역 조회</div>
        <div id="point-info">- 적립 예정 포인트는 사용 가능포인트에 포함되지 않으며, 환불 또는 거래 취소가 될 경우 내역에서 삭제됩니다.</div>
    </div>
    <div class="lookup-period">
        <div class="period-lookup">조회기간</div>
        <div class="period" id="1week">1주일</div>
        <div class="period" id="1month">1개월</div>
        <div class="period" id="1month">1개월</div>
        <div class="period" id="3month">3개월</div>
        <div class="period" id="6month">6개월</div>
    </div>
    <h3>전체 2건</h3>
    <table class="pointHistoryBoard">
        <thead>
            <tr class="underLine">
                <th class="td-date">일자</th>
                <th class="td-division">구분</th>
                <th class="td-movie">영화</th>
                <th class="td-branch">지점</th>
                <th class="td-point">포인트</th>
            </tr>
        </thead>
        
        <tbody id="historyList">
            <tr>
                <td class="td-date"><div class="date">2022-01-01</div></td>
                <td class="td-division"><div class="division">일반영화</div></td>
                <td class="td-movie"><div class="movie">이터널선샤인</div></td>
                <td class="td-branch"><div class="branch">롯데시네마 연남</div></td>
                <td class="td-point"><div class="point">200P</div></td>
            </tr>
        </tbody>
    </table>
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
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>