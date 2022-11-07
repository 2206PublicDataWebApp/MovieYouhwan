
// 비밀번호 입력 폼
$("#change-password-btn").click(function (e) {
    e.preventDefault();
    $("#password-area").css("display", "none");
    $(".pass-wrap").css("display", "");
    $("#change-password-area").css("display", "");
    $("#change-password-cancel-btn").css("display", "");
    $("#change-password-finish-btn").css("display", "");
    $("#change-password-btn").css("display", "none");
});

$("#change-password-cancel-btn").click(function (e) {
    e.preventDefault();
    $("#password").val('');
    $("#newPassword").val('');
    $("#confirmPassword").val('');
    $("#password-area").css("display", "");
    $("#change-password-area").css("display", "none");
    $("#change-password-cancel-btn").css("display", "none");
    $("#change-password-finish-btn").css("display", "none");
    $("#new-password-invalid").css("display", "none");
    $("#valid-newPassword").css("display", "none");
    $("#password-invalid").css("display", "none");
    $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
    $("#change-password-finish-btn").prop('disabled', true);
    $("#newPassword").attr('class', 'n-input');
    $("#change-password-btn").css("display", "");
});
// 비밀번호 입력 폼
$("#password").keyup(function (e) {
    e.preventDefault();
    var password = $("#password");
    var newPassword = $("#newPassword");
    var confirmPassword = $("#confirmPassword");
    var displayValue = $("#new-password-invalid").css("display");
    var passwordInvalidDisplayValue = $('#password-invalid').css("display");

    if (password.val().length >= 4 &&
        newPassword.val().length >= 8 &&
        confirmPassword.val().length >= 8 &&
        displayValue == 'none' &&
        passwordInvalidDisplayValue == 'none'
    ) {
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent');
        $("#change-password-finish-btn").prop('disabled', false);
    } else {
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
        $("#change-password-finish-btn").prop('disabled', true);
    }

    value = $(this).val();
    var passwordInvalid = $('#password-invalid');
    var newPasswordInvalid = $("#new-password-invalid");

    if (!value) {
        passwordInvalid.css('display', '');
        passwordInvalid.text('');
        return false;
    }

    if (password.val().length < 4) {
        passwordInvalid.css('display', '');
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
        $("#change-password-finish-btn").prop('disabled', true);
        $("#password_div").attr("class", "input-password__wrap input-danger");
        passwordInvalid.text("4자리 이상 입력해 주십시오.");
        return false;
    }

    passwordInvalid.css('display', 'none');
    $("#password_div").attr("class", "input-password__wrap ");
    if (passwordInvalid.css("display") === 'none' && newPasswordInvalid.css("display") === 'none' && confirmPassword.val().length >= 8) {
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent');
        $("#change-password-finish-btn").prop('disabled', false);
    }
});

$("#newPassword").keyup(function (e) {
    e.preventDefault();
    var newPassword = $("#newPassword");

    if (newPassword.val() == '' || newPassword.val().length < 8) {
        newPassword.attr('class', 'n-input input-danger');
        $("#valid-newPassword").css("display", "none");
        $("#new-password-invalid").css("display", "");
        $("#new-password-invalid").text("8자리 이상 입력해 주십시오.");
        $("#newPassword_div").attr("class", "input-password__wrap input-danger");
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
        $("#change-password-finish-btn").prop('disabled', true);
        return false;
    } else if (checkFourConsecutiveChar(newPassword.val())) {
        newPassword.attr('class', 'n-input input-danger');
        $("#valid-newPassword").css("display", "none");
        $("#new-password-invalid").css("display", "");
        $("#new-password-invalid").text("4개 이상 연속으로 동일한 문자는 사용하실 수 없습니다.");
        $("#newPassword_div").attr("class", "input-password__wrap input-danger");
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
        $("#change-password-finish-btn").prop('disabled', true);
        return false;
    } else if (!isValidPassword(newPassword.val())) {
        newPassword.attr('class', 'n-input input-danger');
        $("#valid-newPassword").css("display", "none");
        $("#new-password-invalid").css("display", "");
        $("#new-password-invalid").text("숫자 ,영문 대소문자, 특수문자 중 두가지 이상으로 조합해 주십시오.");
        $("#newPassword_div").attr("class", "input-password__wrap input-danger");
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
        $("#change-password-finish-btn").prop('disabled', true);
        return false;
    } else {
        var points = getPassordRulePoint(newPassword.val());
        newPassword.attr('class', 'n-input');
        $("#new-password-invalid").css("display", "none");
        $("#valid-newPassword").css("display", "");
        $("#valid-newPassword").text("사용 가능한 비밀번호입니다.");
        $("#newPassword_div").attr("class", "input-password__wrap");
        var confirmPassword = $("#confirmPassword");
        var password = $("#password");
        if (password.val().length >= 4 && confirmPassword.val().length >= 8) {
            $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent');
            $("#change-password-finish-btn").prop('disabled', false);
        } else {
            $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
            $("#change-password-finish-btn").prop('disabled', true);
        }
    }
    return true;
});

$("#confirmPassword").keyup(function (e) {
    e.preventDefault();
    var password = $("#password");
    var newPassword = $("#newPassword");
    var confirmPassword = $("#confirmPassword");
    var displayValue = $("#new-password-invalid").css("display");
    var passwordInvalidDisplayValue = $('#password-invalid').css("display");

    if (password.val().length >= 4 &&
        newPassword.val().length >= 8 &&
        confirmPassword.val().length >= 8 &&
        displayValue == 'none' &&
        passwordInvalidDisplayValue == 'none'
    ) {
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent');
        $("#change-password-finish-btn").prop('disabled', false);
    } else {
        $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
        $("#change-password-finish-btn").prop('disabled', true);
    }
});


encryptInputForm = function () {
    if (typeof encryptAES !== 'undefined') {
        $('#encryptPassword').val(encryptAES($('#password').val().trim(), 'yOL3IKfg6GDjDgMzRpctgiLASBu5YCXZ'));
        $('#encryptNewPassword').val(encryptAES($('#newPassword').val().trim(), 'yOL3IKfg6GDjDgMzRpctgiLASBu5YCXZ'));
        $('#encryptConfirmPassword').val(encryptAES($('#confirmPassword').val().trim(), 'yOL3IKfg6GDjDgMzRpctgiLASBu5YCXZ'));

        $("#password").val('');
        $("#newPassword").val('');
        $("#confirmPassword").val('');
    }
}

// $("#change-password-finish-btn").click(function (e) {
//     e.preventDefault();

//     var password = $("#password").val();
//     var newPassword = $("#newPassword").val();
//     var confirmPassword = $("#confirmPassword").val();

//     if (password === '') {
//         alert('현재 비밀번호를 입력해주세요.');
//         return false;
//     }

//     if (password.length < 4) {
//         alert('비밀번호 4자 이상이여야합니다.');
//         return false;
//     }

//     if (newPassword !== confirmPassword) {
//         alert('신규 비밀번호와 재입력 비밀번호가 같지 않습니다.');
//         $("#confirmPassword").val('');
//         $("#newPassword").val('');
//         $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
//         $("#change-password-finish-btn").prop('disabled', true);
//         $("#new-password-invalid").text('');
//         $("#valid-newPassword").text('');
//         return false;
//     }

//     if (password === newPassword) {
//         alert('현재 비밀번호와 신규 비밀번호가 동일합니다.');
//         $("#newPassword").val('');
//         $("#confirmPassword").val('');
//         $("#change-password-finish-btn").attr('class', 'n-btn btn-sm btn-accent pass-btn modiBtn disabled');
//         $("#change-password-finish-btn").prop('disabled', true);
//         $("#new-password-invalid").text('');
//         $("#valid-newPassword").text('');
//         return false;
//     }

//     if (confirm('비밀번호를 변경하시겠습니까?')) {

//         encryptInputForm();

//         mss.my.ajax.call(
//             {
//                 method: "PUT",
//                 url: "https://my.musinsa.com/api/member/v1/change-password",
//                 xhrFields: {
//                     withCredentials: true
//                 },
//                 data: {
//                     "cipherKey": 'yOL3IKfg6GDjDgMzRpctgiLASBu5YCXZ',
//                     "cipherVersion": 'V1',
//                     "password": $("#password").val(),
//                     "newPassword": $("#newPassword").val(),
//                     "confirmPassword": $("#confirmPassword").val(),
//                     "encryptPassword": $("#encryptPassword").val(),
//                     "encryptNewPassword": $("#encryptNewPassword").val(),
//                     "encryptConfirmPassword": $("#encryptConfirmPassword").val(),
//                 },
//                 success: function (responseData) {
//                     alert(responseData.message);
//                     if (responseData.success) {
//                         $("#password-area").css("display", "");
//                         $("#change-password-area").css("display", "none");
//                     }

//                     if (responseData.code == 1500) {
//                         document.location.href = "/auth/login?referer=" + encodeURIComponent(location.pathname);
//                         return false;
//                     }

//                     $("#password").val('');
//                     $("#newPassword").val('');
//                     $("#confirmPassword").val('');
//                     $("#new-password-invalid").css("display", "none");
//                     $("#valid-newPassword").css("display", "none");
//                     $("#password-invalid").css("display", "none");
//                     $("#valid-password").css("display", "none");

//                 },
//                 fail: function (data) {
//                     var responseData = data.responseJSON;
//                     alert(responseData.message);
//                 }
//             },
//             true
//         )
//     }
// });

function checkFourConsecutiveChar(password) {
    for (var i = 0; i < password.length - 3; i++) {
        if (password.charAt(i) == password.charAt(i + 1) &&
            password.charAt(i + 1) == password.charAt(i + 2) &&
            password.charAt(i + 2) == password.charAt(i + 3)) {
            return true;
        }
    }
    return false;
}

function isValidPassword(password) {
    var violationCnt = 0;
    if (!letterRegExp.test(password)) {
        violationCnt++;
    }

    if (!capsLockRegExp.test(password)) {
        violationCnt++;
    }

    if (!numberRegExp.test(password)) {
        violationCnt++;
    }

    if (!symbolRegExp.test(password)) {
        violationCnt++;
    }

    if (violationCnt > 2) {
        return false;
    } else {
        return true;
    }
}

function getPassordRulePoint(password) {
    var point = 0;
    if (letterRegExp.test(password)) {
        point = point + 4;
    }

    if (capsLockRegExp.test(password)) {
        point = point + 4;
    }

    if (numberRegExp.test(password)) {
        point = point + 4;
    }

    if (symbolRegExp.test(password)) {
        point = point + 4;
    }

    return point;
}

// 닉네임
$("#change-nickname-btn").click(function (e) {
    e.preventDefault();
    $("#nickname-area").css("display", "none");
    $(".nick-wrap").css("display", "");
    $("#change-nickname-area").css("display", "");
    $("#change-nick-finish-btn").css("display", "");
    $("#change-nickname-btn").css("display", "none");
});

// 휴대폰
$("#change-phone-btn").click(function (e) {
    e.preventDefault();
    $("#phone-area").css("display", "none");
    $("#change-phone-area").css("display", "");
    $("#change-phone-finish-btn").css("display", "");
    $("#change-phone-btn").css("display", "none");
});

// 이메일
$("#change-email-btn").click(function (e) {
    e.preventDefault();
    $("#email-area").css("display", "none");
    $("#change-email-area").css("display", "");
    $("#change-email-finish-btn").css("display", "");
    $("#change-email-btn").css("display", "none");
});