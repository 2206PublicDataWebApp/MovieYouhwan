<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/user/my/memberModify.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/header.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<script src="/resources/js/jquery-3.6.1.min.js" defer></script>
<script src="/resources/js/header.js" defer></script>
<script src="/resources/js/footer.js" defer></script>
<script src="/resources/js/user/memberModify.js" defer></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>


<title>무비유환 - 회원정보수정</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<div class="member-modify-wrap">
    <h1 id="modify-title">회원정보 수정</h1>
    <form action="/my/modify.yh" method="post">
    <div id="modify-contents">
        <div id="profile-img-wrap">
            <div id="profile-left">
                <div id="profile-title">프로필 사진</div>
                <div id="profile-info">
                    회원님을 알릴 수 있는 사진을 등록해 주세요<br>
                    등록된 사진은 회원님의 게시물이나 댓글들에 사용됩니다.
                </div>
            </div>
            <div id="profile-right">
                    <img id="profile-img" src="http://yirb.yonsei.ac.kr/xe/files/attach/images/394/846/008/fead9329649315739047729e5619b975.jpg">
                    <!-- <c:if test="${not empty loginUser.memberImgRename}"><img class="profileImg" src="/resources/images/userProfileImg/${loginUser.memberImgRename}"></c:if> -->
                    <label for="img-modify" id="img-modify-btn">사진등록</label>
                    <input type="file" name="uploadFile" id="img-modify" value="사진등록">
            </div>
        </div>
    </div>
    <div class="content-wrap">
        <div class="modi-content">
            <div class="content-title">
                아이디
            </div>
            <div class="content-stored">
                khuser01
            </div>
        </div>
    </div>
    <div class="content-wrap">
        <div class="modi-content" id="password-area">
            <div class="content-title">
                비밀번호
            </div>
            <div class="content-stored">
                *********
            </div>
        </div>
        <div class="btn-wrap">
            <input type="button" class="modify-btn" id="change-password-btn" value="비밀번호 변경">
        </div>
    </div>
    <!-- 비밀번호 변경 -->
    <div class="pass-wrap" style="display: none;">
        <div>
            <div class="pass-modi-content change-password-form" id="change-password-area" style="display: none;">
                <div class="line"></div>
                <div class="input ">
                    <div class="pass-content-title">
                        비밀번호<span id="pass-info">
                            영문 대 소문자, 숫자, 특수기호(!,@,#,$)중 2가지 이상 조합하여 사용
                        </span>
                    </div>
                    
                </div>
                <div class="input input-new">
                    <label class="pass-content-title" for="password">현재 비밀번호</label>
                    <div class="input-wrap">
                    <div class="input-password__wrap">
                        <input type="password" class="n-input content-input" id="password">
                    </div>
                    <span id="password-invalid" class="validate danger" style="display: none;"></span>
                </div>
                    
                </div>
                <div class="input input-new">
                    <label class="pass-content-title" for="newPassword">신규 비밀번호</label>
                    <div class="input-password__wrap">
                        <input type="password" class="n-input content-input" id="newPassword" maxlength="20">
                    </div>
                    <span id="new-password-invalid" class="validate danger" style="display: none;">8자리 이상 입력해 주십시오.</span>
                    <span id="valid-newPassword" class="validate" style="display: none">사용 가능한 비밀번호입니다.</span>
                </div>
                <div class="input input-new">
                    <label class="pass-content-title" for="confirmPassword" >신규 비밀번호 재입력</label>
                    <div class="input-password__wrap">
                        <input type="password" class="n-input content-input" id="confirmPassword" maxlength="20">
                    </div>
                    <span id="confirm-password-invalid" class="validate danger"></span>
                    <span id="valid-confirmPassword" class="validate" style="display: none">사용 가능한 비밀번호입니다.</span>
                </div>
                <div class="btn-group">
                    <button type="button" class="n-btn btn-sm btn-lighter pass-btn cancleBtn" id="change-password-cancel-btn" style="display: none;">취소</button>
                    <button type="button" class="n-btn btn-sm btn-accent pass-btn modiBtn disabled" id="change-password-finish-btn" style="display: none;" disabled>수정</button>
                </div>
                <div class="line"></div>
            </div>
            
            
        </div>
    </div>
    <!-- 비밀번호 수정 -->
    <div class="content-wrap">
        <div class="modi-content">
            <div class="content-title">
                이름
            </div>
            <div class="content-stored">
                김무비
            </div>
        </div>
    </div>
    <div class="content-wrap">
        <div class="modi-content">
            <div class="content-title">
                생년월일
            </div>
            <div class="content-stored">
                2022-11-06
            </div>
        </div>
    </div>
    <div class="content-wrap">
        <div class="modi-content">
            <div class="content-title">
                성별
            </div>
            <div class="content-stored">
                여성
            </div>
        </div>
    </div>
    <div class="content-wrap">
        <div class="modi-content nick-on" id="nickname-area">
            <div class="content-title">
                닉네임
            </div>
            <div class="content-stored">
                무비무비무비
            </div>
        </div>
        <div class="btn-wrap">
            <input type="button" class="modify-btn" id="change-nickname-btn" value="닉네임 변경">
        </div>
    </div>
    <div class="content-wrap">
        <div class="change-nick-form modi-content" id="change-nickname-area" style="display: none;">
            <div class="content-title">
                닉네임
            </div>
            <div id="nick-modi-input">
                <input type="text" class="nick-input" id="nickName" maxlength="8" placeholder="최대 8자리">
            </div>
            <div id="nick-modi-btn">
                <input type="button" class="modify-btn2" id="change-nick-finish-btn" value="수정">
            </div>
            <span id="nickname-invalid" class="validate danger" style="display: none;">최대 8자리 </span>
        </div>
    </div>
    <div class="content-wrap">
        <div class="modi-content phone-on" id="phone-area">
            <div class="content-title">
                휴대폰
            </div>
            <div class="content-stored">
                01012341234
            </div>
        </div>
        <div class="btn-wrap">
            <input type="button" class="modify-btn" id="change-phone-btn" value="휴대폰 번호 변경">
        </div>
    </div>
    <div class="content-wrap">
        <div class="change-phone-form modi-content" id="change-phone-area" style="display: none;">
            <div class="content-title">
                휴대폰
            </div>
            <div id="phone-modi-input">
                <input type="text" class="phone-input" id="phone" maxlength="11" placeholder="-없이 입력 (01020221107)">
            </div>
            <div id="phone-modi-btn">
                <input type="button" class="modify-btn2" id="change-phone-finish-btn" value="수정">
            </div>
            <span id="phone-invalid" class="validate danger" style="display: none;"> </span>
        </div>
    </div>
    <div class="content-wrap">
        <div class="modi-content email-on" id="email-area">
            <div class="content-title">
                이메일
            </div>
            <div class="content-stored">
                movieyoohwan@movie.com
            </div>
        </div>
        <div class="btn-wrap">
            <input type="button" class="modify-btn" id="change-email-btn" value="이메일 변경">
        </div>
    </div>
    <div class="content-wrap">
        <div class="change-email-form modi-content" id="change-email-area" style="display: none;">
            <div class="content-title">
                이메일
            </div>
            <div id="email-modi-input">
                <input type="text" class="email-input" id="email" maxlength="11" placeholder="movieyoohwan@movie.com">
            </div>
            <div id="email-modi-btn">
                <input type="button" class="modify-btn2" id="change-email-finish-btn" value="수정">
            </div>
            <span id="email-invalid" class="validate danger" style="display: none;"> </span>
        </div>
    </div>
    <div class="btn-secession-modify">
        <input type="button" class="member-btn memeber-secession-btn" value="회원 탈퇴">
        <input type="button" class="member-btn member-modify-btn" value="회원정보 수정">
    </div>
    </form>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>