// 상영관 삭제 기능
function theaterDataRemove() {
	event.preventDefault();
	if(confirm("상영관을 삭제하시겠습니까?")) {
		location.href="/admin/adminTheaterRemove.yh";
	}
}