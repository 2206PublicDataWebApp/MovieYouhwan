// 카카오 주소 찾기 
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("sample4_roadAddress").value = roadAddr;
        }
    }).open();
}

// 파일 등록 디자인 (등록폼)
$(function() {
	$("#img-file").on('change', function() {
		var imgName = $("#img-file").val();
		$("#imgload-name").val(imgName);
	});
	
	$("#imgadd-file").on('change', function() {
		var imgName = $("#imgadd-file").val();
		$("#modifyadd-name").val(imgName);
	});
})

// 영화관 삭제 기능
function cinemaDataRemove() {
	event.preventDefault();
	if(confirm("영화관을 삭제하시겠습니까?")) {
		location.href="/admin/adminCinemaRemove.yh";
	}
}

$(function() {
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  
	// 지도 생성  
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	var mapTypeControl = new kakao.maps.MapTypeControl();
	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	var zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	// 주소-좌표 변환 객체 생성
	var geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표 검색
	var address = $("#cinemaAddress").val();
	geocoder.addressSearch(address, function(result, status) {
	if (status === kakao.maps.services.Status.OK) {
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;height:30px;text-align:center;padding:6px 0;">무비유환</div>'
        });
		infowindow.open(map, marker);
        map.setCenter(coords);
        }
	})
})

