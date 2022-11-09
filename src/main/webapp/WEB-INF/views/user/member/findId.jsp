<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/user/member/joinSuccess.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
    <script src="/resources/js/header.js" defer></script>
    <script src="/resources/js/footer.js" defer></script>
<title>무비유환 - 아이디 찾기 실패</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <!-- <c:if test="{check == 1}"> -->
    <div id="joinSucceseForm">
        <div id="succeseMessage">
            <h2>MovieYouHwan</h2>
		        잘못된 입력이거나.<br>
                존재하지 않는 회원정보입니다.
                다시 시도해주세요
        </div>
        <div id="j-btn-group">
            <a class="main-btn-main" href="/home.yh">
                메인페이지로 이동
            </a>
            <a class="main-btn-login" href="/member/findIdForm.yh">
                아이디 찾기
            </a>
        </div>
    </div>
    <!-- </c:if> -->
    
    <div id="joinSucceseForm">
        <div id="succeseMessage">
            <h2>아이디 찾기 결과</h2>
		        입력하신 정보와 일치하는 아이디 정보입니다.
                ${uMemberList}
                <c:forEach items="${uMemberList}" var="uMemberList">
                    ${uMemberList.memberId}
                    ${uMemberList}
                    가입일 : ${uMemberList.memberSignUpDate}
                </c:forEach>
        </div>
        <div id="j-btn-group">
            <a class="main-btn-main" href="/home.yh">
                메인페이지로 이동
            </a>
            <a class="main-btn-login" href="/member/findIdForm.yh">
                아이디 찾기
            </a>
        </div>
    </div>
    
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>