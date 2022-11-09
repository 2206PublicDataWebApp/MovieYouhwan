<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/user/member/find.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
	<script src="/resources/js/userMember.js" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<title>무비유환 - 비밀번호 변경</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
 <div id="findIdForm">
    <form action="/member/findPassword.yh" method="post">
        <div id="container">
            <h1 id="findPassTitle">비밀번호 변경</h1>
            
            <div class="findId-input">
                <div id="pass-find-info">
                    가입한 아이디를 입력해주세요<br>
                    휴대폰 인증을 통해 비밀번호를 변경합니다.
                </div>
                <div class="input-wrap">${member.memberId}
                    <input type="text" class="input-box" id="id-input" name="memberId" maxlength="12" placeholder="아이디" required>
                </div>
                
                <div class="input-wrap">
                    <input type="number" class="input-box" id="phone-input" name="memberPhone" maxlength="11" placeholder="휴대폰 번호 (- 제외)" required>
                    <input type="button" class="phone-confirm-btn" value="인증하기" maxlength="6" >
                </div>
                <div class="input-wrap">
                    <input type="number" class="input-box" id="sendSMS" name="sendSMS" placeholder="6자리의 인증번호를 입력하세요" maxlength="6" required>
                </div>
                <input type="hidden" id="phoneDoubleChk"/>
                <button type="submit" id="find-btn" name="findSubmit">인증완료</button>
            </div>
        </div>
    </form>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>