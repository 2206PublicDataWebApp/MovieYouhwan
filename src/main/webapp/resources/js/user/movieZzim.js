// 로그인 한 상태에서 하트를 클릭했을 때 (로그인한 상태인 하트의 <a></a> class명: heart-click)
$(".heart-click").click(function() {

    // 게시물 번호(no)를 idx로 전달받아 저장합니다.
    let movieNo = $(this).attr('idx');
    console.log("heart-click");

    // 빈하트를 눌렀을때
    if($(this).children('svg').attr('class') == "bi bi-suit-heart"){
        console.log("빈하트 클릭" + movieNo);

        $.ajax({
            type : 'post',
            url : '/saveZzim',
            data : { movieNo : movieNo, },
            success : function(movieList) {
                //페이지 새로고침
                //document.location.reload(true);

                let movieZzim = movieList.movieZzim;

                // 하트수 갱신
                $('#heart'+movieNo).text(movieZzim);

                console.log("하트추가 성공");
            },
            error : function() {
                alert('서버 에러');
            }
        });
        console.log("꽉찬하트");

        // 꽉찬하트로 바꾸기
        $('.heart_icon'+movieNo).html("<svg xmlns='http://www.w3.org/2000/svg' width='16' height='20' fill='currentColor' class='bi bi-suit-heart-fill' viewBox='0 0 16 16'><path d='M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z'/></svg>");


    // 꽉찬 하트를 눌렀을 때
    }else if($(this).children('svg').attr('class') == "bi bi-suit-heart-fill"){
        console.log("꽉찬하트 클릭" + movieNo);

        $.ajax({
            url : '/removeZzim',
            type : 'post',
            data : { movieNo : movieNo, },
            success : function(movieList) {
                //새로고침
                //document.location.reload(true);

                let movieZzim = movieList.movieZzim;
                //하트수 갱신

                $('#heart'+movieNo).text(movieZzim);

                console.log("하트삭제 성공");
            },
            error : function() {
                alert('서버 에러');
            }
        });
        console.log("빈하트");

        // 빈하트로 바꾸기
        $('.heart_icon'+movieNo).html('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="20" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16"><path d="M8 6.236l-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z" /></svg>');
    }



});


// 로그인 안한 상태에서 하트를 클릭하면 로그인해야한다는 알림창이 뜹니다.
// (로그인한 상태인 하트의 <a></a> class명: heart-notlogin)
$(".heart-notlogin").unbind('click');
$(".heart-notlogin").click(function() {
    alert('로그인 후 사용가능합니다.');
});