<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/findPassword.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
	<script src="/resources/js/userMember.js" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<title>무비유환 - 비밀번호 찾기</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
 <div id="findIdForm">
        <div id="container">
            <h1 id="findIdTitle">비밀번호 찾기</h1>
            <div class="findId-input">
                <div id="pass-find-info">
                    가입한 아이디를 입력해주세요<br>
                    휴대폰 또는 이메일 인증을 통해 비밀번호를 변경합니다.
                </div>
                <div class="input-wrap">
                    <input type="text" class="input-box" name="memberName" maxlength="12" placeholder="아이디">
                </div>
                <!-- <div class="input-wrap">
                    <a class="phone-confirm-btn" href="#">휴대폰 인증하기</a>
                </div> -->
                <div class="input-wrap">
                    <input type="text" class="input-box" id="phone-input" name="memberPhone" maxlength="11" placeholder="휴대폰 번호 (- 제외)">
                    <input type="button" class="phone-confirm-btn" value="인증하기" maxlength="6">
                </div>
                <button type="submit" id="find-btn" name="find-btn">아이디찾기</button>
            </div>
            
        </div>
    </div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>