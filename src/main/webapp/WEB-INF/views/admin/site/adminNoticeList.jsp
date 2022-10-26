<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post">
  <div id="search-area">
    <select>
      <option>제목</option>
      <option>내용</option>
      <option>전체</option>
    </select>
    <input class="search-input" type="text" placeholder="검색어를 입력하세요" />
    <button class="search-btn">검색</button>
    <button type="button" class="left-top-dark-btn" id="">등록</button>
    <button class="right-top-white-btn">삭제</button>
  </div>
</form>
<div id="board">
  <div class="board-row" id="board-header">
    <div class="num-col">번호</div>
    <div class="title-col">제목</div>
    <div class="date-col">등록일</div>
    <div class="check-col"><input id="notice-check-all" type="checkbox" name="delete-check" /></div>
  </div>
  <div class="board-row">
    <div class="num-col">1</div>
    <div class="title-col"><a href="#">영화관람권 가격 변경 안내</a></div>
    <div class="date-col">2022-10-07</div>
    <div class="check-col"><input class="notice-check support-check" type="checkbox" name="delete-check" /></div>
  </div>
  <div class="board-row">
    <div class="num-col">2</div>
    <div class="title-col"><a href="#">무비유환 개인정보처리방침 개정 안내</a></div>
    <div class="date-col">2022-09-25</div>
    <div class="check-col"><input class="notice-check support-check" type="checkbox" name="delete-check" /></div>
  </div>
</div>
<!-- <script>
      $('#check-all').change(function () {
        console.log($('.check-col').children('input:checkbox'));
        if ($(this).is(':checked')) {
          console.log('true');
          $('.check-col').children('input:checkbox').prop('checked', true);
        } else {
          $('.check-col').children('input:checkbox').prop('checked', false);
        }
      });

      $('.homepage-tab-item').mouseover(function () {
        console.log('mouseover');
        $('#homepage-notice').css('border', 'none');
      });

      $('.homepage-tab-item').mouseout(function () {
        $('#homepage-notice').css('border-bottom', '3px solid #0f1a3b');
      });
    </script>
  </body>
</html> -->
