	
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

        //아이디 중복확인
      $("#memberId").blur(function() {
          if($('#memberId').val()==''){
          	
             $('#id_check').text('아이디를 입력하세요.');
             $('#id_check').css('color', 'red');                     
      
             } else if(idJ.test($('#memberId').val())!=true){
                $('#id_check').text('6~12자의 영소문자, 숫자만 사용 가능합니다.');
                $('#id_check').css('color', 'red');
             } else if($('#memberId').val()!=''){
                
               var memberId=$('#memberId').val();
                 $.ajax({
                     async : true,
                        type : 'POST',
                        data : memberId,
			url : '/member/idSearch.yh',
                        dateType: 'json',
                        contentType: "application/json; charset=UTF-8",
                        success : function(result) {

             if(result.cnt > 0){
             console.log("중복")
                $('#id_check').text('중복된 아이디 입니다.');
                      $('#id_check').css('color', 'red');
                      $("#usercheck").attr("disabled", true);
             }else{
                if(idJ.test(memberId)){
                   $('#id_check').text('사용가능한 아이디 입니다.');
                   $('#id_check').css('color', 'blue');
                   $("#usercheck").attr("disabled", false);
                }
                else if(memberId==''){
                $('#id_check').text('아이디를 입력해주세요.');
                      $('#id_check').css('color', 'red');
                      $("#usercheck").attr("disabled", true);
                }
                else{
                   $('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다.");
                   $('#id_check').css('color', 'red');
                   $("#usercheck").attr("disabled", true);
                }
             }

           }

                });//ajax/// 
             }//else if
           
    });//blur
    
    
    
    