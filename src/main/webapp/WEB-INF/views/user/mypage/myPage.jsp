<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="/resources/css/user/my/myPage.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>

<title>무비유환 - 마이페이지</title>
</head>
<body>
<div id="user-wrapper">
<div id="back-yellow"></div>
    <div id="mypage-form">
        <div id="mypage-top">
            <div id="now-level">Silver</div>
            <div id="editProfile">
                <i class="fa-solid fa-pencil" id="pen"></i>
               <a href="/my/editMemberInfo.yh">회원정보수정</a>
            </div>
        </div>
        
        <div id="profile-img-bangga">
            <c:if test="${empty loginUser.memberImgRename}"><i id="user-icon" class="fa-sharp fa-solid fa-user"></i></c:if>
            <c:if test="${not empty loginUser.memberImgRename}"><img class="myprofileImg" id="img-frame" src="/resources/images/userProfileImg/${loginUser.memberImgRename}"></c:if>
            <div id="bangabanga">${loginUser.memberNick} 님 반가워요!</div>
        </div>
        <div id="level-wrap">
            <div class="level-name">
                <div>Bronze</div>
                <div>Silver</div>
                <div>Gold</div>
                <div>VIP</div>
                <div>VVIP</div>
            </div>
            <div id="level-bar-wrap">
                <div class="level-bar">
                    <div class="level"></div>

                </div>
            </div>
            <div class="level-count">
                <div>0회</div>
                <div>2회</div>
                <div>4회</div>
                <div>6회</div>
                <div>8회</div>
            </div>
        </div>
        <div id="bottom-line"></div>
        <div class="point-mate">
            <div class="my-point-wrap">
                <div id="my-point">POINT</div>
                <a href="/my/point.yh">
                    <div id="mypoint">${member.memberPoint}P</div>
                </a>
            </div>
                <div id="bottom-line2"></div>
            <div class="mate-wrap">
                <div id="my-mate">MATE</div>
                <a href="#">
                    <div id="mymate">${member.memberPoint}명</div>
                </a>
            </div>
        </div>
    </div>
    <div id="menu-wrap">
        <button class="myMenu-start">예매내역</button>
        <button class="myMenu">구매내역</button>
        <button class="myMenu">메이트 매칭내역</button>
        <button class="myMenu">찜한 영화</button>
        <button class="myMenu-end">문의내역</button>
    </div>
</div>

</body>
</html>