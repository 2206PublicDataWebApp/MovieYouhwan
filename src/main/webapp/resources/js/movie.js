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
	event.preventDefault();
	if(confirm("선택한 영화를 삭제하시겠습니까?")) {
		location.href="/admin/adminMovieRemove.yh";
	}
}

function removeOriginImg() {
	var divTag = $("#imglist-wrap");
	$(divTag).children('p:last').remove();
	$(divTag).children('i:last').remove();
}