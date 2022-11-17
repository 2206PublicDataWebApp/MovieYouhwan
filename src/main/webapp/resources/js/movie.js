$('.movie-tab').addClass('tab-selected');
$('.admin-movie7-tab').addClass('admin-tab-selected');

// 등록 jsp
const registerModal = $('#add-movie-time');
// 등록 버튼
const registerBtn = $('#add-movie-button');
// 취소 버튼
let cancelBtn = $('#add-movie-off');

// 등록 버튼 클릭 시 등록 jsp 화면에 띄우기
registerBtn.click(function () {
	registerModal.css('display', 'block');
});

// 취소 버튼 클릭 시 등록 jsp 지우기
cancelBtn.click(function () {
	if(registerModal.css('display') == 'block') {
		registerModal.css('display', 'none');
	}
});

// 영화 탭
$('.movie-tab').addClass('tab-selected');
$('.cinema-tab').addClass('tab-selected');

$(function() {
	$("#img-file").on('change', function() {
		var imgName = $("#img-file").val();
		$("#imgload-name").val(imgName);
	});
	
	$("#video-file").on('change', function() {
		var videoName = $("#video-file").val();
		$("#videoload-name").val(videoName);
	});
})

// 파일 추가
let num = 1;
function addimgfile() {
	var choice = 2;
	var fileTag = $("#imgfile-wrap");
	$(fileTag).append("<div class='imgadd-wrap'><input id='imgload-addname"+num+"' value='첨부파일' placeholder='첨부파일'><label for='img-addfile"+num+"'>파일찾기</label><input type='file' id='img-addfile"+num+"' class='upload-file' name='uploadImgFile'><input type='button' id='img-remove' value='삭제' onclick='removeimgfile();'></div><br>")
	choice = choice + 1;
	bindingChange(num++);
}
function bindingChange(num) {
	$(document).on("change", "#img-addfile"+num, function() {
		var imgName = $("#img-addfile"+num).val();
		$("#imgload-addname"+num).val(imgName);
	})
}
function removeimgfile() {
	var fileTag = $("#imgfile-wrap");
	if($(fileTag).children('div').length > 1) {
		$(fileTag).children('div:last').remove();
	}
}

let count = 1;
function addvideofile() {
	var number = 2;
	var divTag = $("#videofile-wrap");
	$(divTag).append("<div class='videoadd-wrap'><input id='videoload-addname"+ count +"' value='첨부파일' placeholder='첨부파일'><label for='video-addfile"+count+"'>파일찾기</label><input type='file' id='video-addfile"+count+"' class='upload-file' name='uploadVideoFile'><input type='button' id='video-remove' value='삭제' onclick='removevideofile();'></div><br>");
	number = number + 1;
	bindChange(count++);
}
function bindChange(count) {
	$(document).on("change", "#video-addfile"+count, function() {
		var videoName = $("#video-addfile"+count).val();
		$("#videoload-addname"+count).val(videoName);
	});
}
function removevideofile() {
	var divTag = $("#videofile-wrap");
	if($(divTag).children('div').length > 1) { 
		$(divTag).children('div:last').remove();
	}
}

function removeMovieData() {
	if(confirm("선택한 영화를 삭제하시겠습니까?")) {
		location.href="/admin/adminMovieRemove.yh";
	}
}

function removieOneImg() {
	var divTag = $("#imgmodify-filewrap");
	if($(divTag).children('div').length > 1) {
		$(divTag).children('div:last').remove();
	}
}

$(function() {
	let imgNo = 1;
	$("#imgadd-file"+num).on('change', function() {
		var videoName = $("#imgadd-file"+num).val();
		$("#imgmodify-loadname"+num).val(videoName);
		imgNo++;
	});
})

let imgAdd = 1;
function addOneImg() {
	var number = 2;
	var divTag = $("#imgmodify-filewrap");
	$(divTag).append("<div class='imgmodify-listwrap'><input id='imgmodify-addname"+ imgAdd +"' value='첨부파일' placeholder='첨부파일'><label for='imgmodify-addfile"+imgAdd+"'>파일찾기</label><input type='file' id='imgmodify-addfile"+imgAdd+"' class='upload-file' name='uploadVideoFile'></div>");
	number = number + 1;
	bindChange(imgAdd++);	
}
function bindChange(imgAdd) {
	$(document).on("change", "#imgmodify-addfile"+ imgAdd, function() {
		var imgName = $("#imgmodify-addfile"+imgAdd).val();
		$("#imgmodify-addname"+imgAdd).val(imgName);
	});
}

// 상영 영화 관리 페이지
// 영화 추가시 상영날짜, 종영날짜, 상영시간 추출 후 출력
function handleOnChange(e) {
	var movieNo = e.value;
	$.ajax({
		type : "post",
		url : "/admin/choiceMovieInformation.yh",
		data : {
			"movieNo" : movieNo
		},
		dataType : "json",
		success : function(result) {
			const movie = JSON.parse(result.movie);
			var movieStartday = movie.movieStartday;
			var movieEndday = movie.movieEndday;
			var movieRuntime = movie.movieRuntime;
			var addDiv = $('#movie-info').html('');
			addDiv.append('<p class="add-font"> 상영날짜 : '+ movieStartday +'</p>');
			addDiv.append('<p class="add-font"> 종영날짜 : '+ movieEndday +'</p>');
			addDiv.append('<p class="add-font"> 상영시간 : '+ movieRuntime +'분</p>');
		},
		error : function() {
			alert("관리자에게 문의해주세요. (02-655-9523)");
		}
	});
}

$('.ticket-button').click(function () {
    if (!$('#profile-user').length) {
      alert('로그인이 필요한 서비스입니다.');
      $(location).attr('href', '/member/loginView.yh');
    }else {
        $(location).attr('href', '/movieTicketTime.yh');
    }
  });