// ++++++++++++++++++++회원가입++++++++++++++++++++
//모든 공백 체크 정규식
var empJ = /\s/g;
//아이디 정규식
var idJ = /^[a-z]+[a-z0-9]{5,19}$/;
// 비밀번호 정규식
var pwJ = /^(?!((?:[a-z]+)|(?:[!@#$]+)|(?:[0-9]+))$)[a-z\d!@#$]{8,20}$/;
// 이름 정규식
var nameJ = /^[가-힣]{2,6}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
// 이메일 검사 정규식
var mailJ = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;

// 휴대폰 번호 정규식
var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
var birthJ = false;
var profileJ = /([^\s]+(?=\.(jpg|png))\.\2)/
var emailAuthuJ = false;

let ImgIcon = $('#profile-icon');

$("#memberId").keyup(function () {
   if ($('#memberId').val() == '') {
      $('#id_check').text('아이디를 입력하세요.');
      $('#id_check').css('color', 'red');
   } else if (idJ.test($('#memberId').val()) != true) {
      $('#id_check').text('6~12자의 영소문자, 숫자만 사용 가능합니다.');
      $('#id_check').css('color', 'red');

   } else if ($('#memberId').val() != '') {

      var memberId = $("#memberId").val();
      console.log("memberId : " + memberId);
      $.ajax({
         url: "/member/idSearch.yh",
         data: { "memberId": memberId },
         type: "get",
         success: function (result) {
            console.log("keydown result:" + result);
            if (result != 0) {
               $('#id_check').text('이미 사용 중인 아이디 입니다.');
               $('#id_check').css('color', 'red');
               $("#usercheck").attr("disabled", true);
            } else {
               if (result == 0) {
                  $('#id_check').text('사용 가능한 아이디입니다.');
                  $('#id_check').css('color', '#6DAF00');
                  $("#usercheck").attr("disabled", false);
               } else if (memberId == '') {
                  $('#id_check').text('아이디를 입력해주세요.');
                  $('#id_check').css('color', 'red');
                  $("#usercheck").attr("disabled", true);
               }
               else {
                  $('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다.");
                  $('#id_check').css('color', 'red');
                  $("#usercheck").attr("disabled", true);
               }
            }
         },
         error: function () {
            alert("ajax 통신 실패")
         }
      });//ajax
   }
});




$('form').on('submit', function () {
   var inval_Arr = new Array(8).fill(false);
   if (idJ.test($('#memberId').val())) {
      inval_Arr[0] = true;
   } else {
      inval_Arr[0] = false;
      alert('아이디를 확인하세요');
      return false;
   }
   // 비밀번호가 같은 경우 && 비밀번호 정규식
   if (($('#memberPwd').val() == ($('#memberPwd-chk').val()))
      && pwJ.test($('#memberPwd').val())) {
      inval_Arr[1] = true;
   } else {
      inval_Arr[1] = false;
      alert('비밀번호를 확인하세요.');
      return false;
   }
   //인증번호 체크
   if (($('#emailAuthNo').val() === code)){
      inval_Arr[6] = true;
      console.log('true');
   }else{
      inval_Arr[1] = false;
      alert('인증번호가 불일치합니다. 확인해주세요');   
      console.log('false');
      return false;
      }

   // 이름 정규식
   if (nameJ.test($('#memberName').val())) {
      inval_Arr[2] = true;
   } else {
      inval_Arr[2] = false;
      alert('이름을 확인하세요.');
      return false;
   }
   // 생년월일 정규식
   if (birthJ) {
      console.log("memberBirth: " + birthJ);
      inval_Arr[3] = true;
   } else {
      inval_Arr[3] = false;
      alert('생년월일을 확인하세요.');
      return false;
   }
   // 이메일 정규식
   if (mailJ.test($('#memberEmail').val())) {
      console.log("mail : " + phoneJ.test($('#memberEmail').val()));
      inval_Arr[4] = true;
   } else {
      inval_Arr[4] = false;
      alert('이메일을 확인하세요.');
      return false;
   }
   // 휴대폰번호 정규식
   if (phoneJ.test($('#memberPhone').val())) {
      console.log("phone : " + phoneJ.test($('#memberPhone').val()));
      inval_Arr[5] = true;
   } else {
      inval_Arr[5] = false;
      alert('휴대폰번호를 확인하세요.');
      return false;
   }

   //전체 유효성 검사
   var validAll = true;
   for (var i = 0; i < inval_Arr.length; i++) {
      if (inval_Arr[i] == false) {
         validAll = false;
      }
   }
//    if (validAll == true) { // 유효성 모두 통과
//       alert('무비유환 가족이 되어주셔서 감사합니다.');
//    } else {
//       alert('정보를 다시 확인하세요.')
//    }
});

$('#memberPwd').keyup(function () {
   if (pwJ.test($('#memberPwd').val())) {
      console.log('true');
      $('#pw-check').text('');
   } else {
      console.log('false');
      $('#pw-check').text('영문, 숫자, 특수문자 조합 8~20자리');
      $('#pw-check').css('color', 'red');
   }
});

//1~2 패스워드 일치 확인
$('#memberPwd-chk').keyup(function () {
   if ($('#memberPwd').val() != $(this).val()) {
      $('#pw2_check').text('비밀번호가 일치하지 않습니다.');
      $('#pw2_check').css('color', 'red');
   } else {
      $('#pw2_check').text('');
   }
});

//이름에 특수문자 들어가지 않도록 설정
$("#memberName").keyup(function () {
   if (nameJ.test($(this).val())) {
      console.log(nameJ.test($(this).val()));
      $("#name_check").text('');
   } else {
      $('#name_check').text('한글 2~6자 이내로 입력하세요.');
      $('#name_check').css('color', 'red');
   }
});
$("#memberEmail").keyup(function () {
   if (mailJ.test($(this).val())) {
      $("#email_check").text('');
   } else {
      $('#email_check').text('이메일 양식을 확인해주세요.');
      $('#email_check').css('color', 'red');
   }
});


// 생일 유효성 검사
var birthJ = false;

// 생년월일   birthJ 유효성 검사
$('#memberBirth').keyup(function () {
   var dateStr = $(this).val();
   var year = Number(dateStr.substr(0, 4)); // 입력한 값의 0~4자리까지 (연)
   var month = Number(dateStr.substr(4, 2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
   var day = Number(dateStr.substr(6, 2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
   var today = new Date(); // 날짜 변수 선언
   var yearNow = today.getFullYear(); // 올해 연도 가져옴

   if (dateStr.length <= 8) {
      // 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
      if (year > yearNow || year < 1900) {

         $('#birth_check').text('생년월일을 확인해주세요');
         $('#birth_check').css('color', 'red');
      }
      else if (month < 1 || month > 12) {

         $('#birth_check').text('생년월일을 확인해주세요 ');
         $('#birth_check').css('color', 'red');

      } else if (day < 1 || day > 31) {

         $('#birth_check').text('생년월일을 확인해주세요 ');
         $('#birth_check').css('color', 'red');

      } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
         $('#birth_check').text('생년월일을 확인해주세요 ');
         $('#birth_check').css('color', 'red');
      } else if (month == 2) {
         var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

         if (day > 29 || (day == 29 && !isleap)) {

            $('#birth_check').text('생년월일을 확인해주세요 ');
            $('#birth_check').css('color', 'red');

         } else {
            $('#birth_check').text('');
            birthJ = true;
         }
      } else {
         $('#birth_check').text('');
         birthJ = true;
      }//end of if
   } else {
      //1.입력된 생년월일이 8자 초과할때 :  auth:false
      $('#birth_check').text('생년월일을 확인해주세요 ');
      $('#birth_check').css('color', 'red');
   }
}); //End of method /*

// 휴대전화
$('#memberPhone').keydown(function () {
   if (phoneJ.test($(this).val())) {
      console.log(nameJ.test($(this).val()));
      $("#phone_check").text('');
   } else {
      $('#phone_check').text('휴대폰번호를 확인해주세요 ');
      $('#phone_check').css('color', 'red');
   }
});

$('#email-confirm-btn').click(function() {
   const email = $('#memberEmail').val(); // 이메일 주소값 얻어오기
   console.log('입력받은 이메일 : ' + email); // 이메일 오는지 확인
   const checkInput = $('.mail-check-input') // 인증번호 입력하는곳 
   alert('인증번호가 전송되었습니다.');
   $.ajax({
      type : 'get',
      url : '/member/emailAuth.yh',
      data : { "email" : email },
      success : function (data) {
         console.log("data : " +  data);
         checkInput.attr('disabled',false);
         code = data;
      },
      error : function(data){
         alert('메일 발송을 실패했습니다.')
      }
   }); // end ajax
}); // end send eamil


// 인증번호 비교 
// blur -> focus가 벗어나는 경우 발생
$('.mail-check-input').keydown(function () {
   const inputCode = $(this).val();
   const $resultMsg = $('#email_check2');
   
   if(inputCode === code){
      $resultMsg.html('인증번호가 일치합니다.');
      $resultMsg.css('color','green');
      $('#email-confirm-btn').attr('disabled',true);
      $('#memberEmail').attr('readonly',true);
   }else{
      $resultMsg.html('인증번호 불일치. 다시 확인해주세요!');
      $resultMsg.css('color','red');
   }
});


$('#profile-img').change(function () {
   profilePreview($(this));
 });
//이미지 미리보기
function profilePreview(img){
   if(img[0].files && img[0].files[0]){
      let reader = new FileReader();
      reader.onload = function(e){
         img.parent().find('.profile-img-preview').attr('src', e.target.result);
      };
      reader.readAsDataURL(img[0].files[0]);
      ImgIcon.addClass('hidden');
   }
}


//  약관 전체 선택
$('#Allcheck').change(function () {
   if ($(this).is(':checked')) {
     $('.check').prop('checked', true);
   } else {
     $('.check').prop('checked', false);
   }
 });
// ++++++++++++++++++++회원가입++++++++++++++++++++

// 관리자 회원 목록
$('.admin-member-tab').addClass('admin-tab-selected');