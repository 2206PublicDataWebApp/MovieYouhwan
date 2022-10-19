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

function addfile() {
	var number = 2;
	var divTag = $("#videofile-wrap");
	$(divTag).append("<div class='file-wrap'><input id='videoload-name' value='첨부파일' placeholder='첨부파일'><label for='video-file'>파일찾기</label> <input type='file' id='video-file' class='upload-file'><input type='button' id='video-remove' value='삭제' onclick='removefile();'></div><br>");
	number = number + 1;
}