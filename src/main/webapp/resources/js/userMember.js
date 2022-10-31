	
	//모든 공백 체크 정규식
	var empJ = /\s/g;
	//아이디 정규식
	var idJ = /^[a-z]+[a-z0-9]{5,19}$/;
	// 비밀번호 정규식
	var pwJ = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*[!@#$])).{8,20}$/
	// 이름 정규식
	var nameJ = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
	// 이메일 검사 정규식
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 휴대폰 번호 정규식
	var phoneJ = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	var birthJ = false;
	var profileJ = /([^\s]+(?=\.(jpg|png))\.\2)/


    
    
    
    $("#memberId").blur(function() {
    if($('#memberId').val()==''){
       $('#id_check').text('아이디를 입력하세요.');
       $('#id_check').css('color', 'red');     
       } else if(idJ.test($('#memberId').val())!=true){
          $('#id_check').text('6~12자의 영소문자, 숫자만 사용 가능합니다.');
          $('#id_check').css('color', 'red');
       } else if($('#memberId').val()!=''){
               }else if(memberId==''){
                $('#id_check').text('아이디를 입력해주세요.');
                      $('#id_check').css('color', 'red');
                      $("#usercheck").attr("disabled", true);
                }
                else{
                   $('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다.");
                   $('#id_check').css('color', 'red');
                   $("#usercheck").attr("disabled", true);
                
             }//else if
     
});//blur
$("#memberId").on("blur", function() {
    var memberId = $("#memberId").val();
    console.log("memberId : "+memberId);
    if(memberId == ""){
    console.log("공백")
        $(".id-ok").hide();
        $(".id-error").show();
    }else{
        $.ajax({
            url : "/member/idSearch.yh",
            data : { "memberId" : memberId },
            type : "get",
            success : function(result){
                console.log("blur result:"+result);
                if(result != 0){
                    
                    $(".guide.id-ok").hide();
                    $(".guide.id-error").show();
                }else{
                    
                    $(".guide.id-error").hide();
                    $(".guide.id-ok").show();
                }
            },
            error : function(){
                alert("ajax 통신 실패")
            }
            
        });
    }
});

    
     $('form').on('submit',function(){
         var inval_Arr = new Array(8).fill(false);
         if (idJ.test($('#').val())) {
            inval_Arr[0] = true;   
         } else {
            inval_Arr[0] = false;
            alert('아이디를  확인하세요.');
            return false;
         }
         // 비밀번호가 같은 경우 && 비밀번호 정규식
         if (($('memberPwd').val() == ($('memberPwd-chk').val()))
               && pwJ.test($('#mem_pw').val())) {
            inval_Arr[1] = true;
         } else {
            inval_Arr[1] = false;
            alert('비밀번호를 확인하세요.');
            return false;
         }
         // 이름 정규식
         if (nameJ.test($('#mem_name').val())) {
            inval_Arr[2] = true;   
         } else {
            inval_Arr[2] = false;
            alert('이름을 확인하세요.');
            return false;
         }
         // 생년월일 정규식
          if (birthJ) {
            console.log("birth: "+birthJ);
            inval_Arr[3] = true; 
         } else {
            inval_Arr[3] = false;
            alert('생년월일을 확인하세요.');
            return false;
         } 
         // 이메일 정규식
         if (mailJ.test($('#mem_email').val())){
            console.log("phone : "+phoneJ.test($('#mem_email').val()));
            inval_Arr[4] = true;
         } else {
            inval_Arr[4] = false;
            alert('이메일을 확인하세요.');
            return false;
         }
         // 휴대폰번호 정규식
         if (phoneJ.test($('#mem_phone').val())) {
            console.log("phone : "+phoneJ.test($('#mem_phone').val()));
            inval_Arr[5] = true;
         } else {
            inval_Arr[5] = false;
            alert('휴대폰 번호를 확인하세요.');
            return false;
}
       });