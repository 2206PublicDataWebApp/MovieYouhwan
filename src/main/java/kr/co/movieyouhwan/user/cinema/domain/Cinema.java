package kr.co.movieyouhwan.user.cinema.domain;

public class Cinema {
	private int cinemaNo; // 영화관 순번
	private String cinemaName; // 영화관 이름
	private String cinemaArea; // 영화관 지역
	private String cinemaAddress; // 영화관 주소
	private String cinemaTel; // 영화관 전화번호
	private String cinemaContent; // 영화관 한줄소개
	private String cinemaPark; // 영화관 주차정보
	private String cinemaPublic; // 영화관 대중교통정보
	private String cinemaImgName; // 영화관 변경전 사진이름
	private String cinemaImgRename; // 영화관 변경후 사진이름
	private String cinemaImgPath; // 영화관 사진 경로
	private String cinemaStatus; // 영화관 상태 (기본값 Y)
	
	public Cinema() {}

	public Cinema(int cinemaNo, String cinemaName, String cinemaArea, String cinemaAddress, String cinemaTel,
			String cinemaContent, String cinemaPark, String cinemaPublic, String cinemaImgName, String cinemaImgRename,
			String cinemaImgPath, String cinemaStatus) {
		super();
		this.cinemaNo = cinemaNo;
		this.cinemaName = cinemaName;
		this.cinemaArea = cinemaArea;
		this.cinemaAddress = cinemaAddress;
		this.cinemaTel = cinemaTel;
		this.cinemaContent = cinemaContent;
		this.cinemaPark = cinemaPark;
		this.cinemaPublic = cinemaPublic;
		this.cinemaImgName = cinemaImgName;
		this.cinemaImgRename = cinemaImgRename;
		this.cinemaImgPath = cinemaImgPath;
		this.cinemaStatus = cinemaStatus;
	}

	public int getCinemaNo() {
		return cinemaNo;
	}

	public void setCinemaNo(int cinemaNo) {
		this.cinemaNo = cinemaNo;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCinemaArea() {
		return cinemaArea;
	}

	public void setCinemaArea(String cinemaArea) {
		this.cinemaArea = cinemaArea;
	}

	public String getCinemaAddress() {
		return cinemaAddress;
	}

	public void setCinemaAddress(String cinemaAddress) {
		this.cinemaAddress = cinemaAddress;
	}

	public String getCinemaTel() {
		return cinemaTel;
	}

	public void setCinemaTel(String cinemaTel) {
		this.cinemaTel = cinemaTel;
	}

	public String getCinemaContent() {
		return cinemaContent;
	}

	public void setCinemaContent(String cinemaContent) {
		this.cinemaContent = cinemaContent;
	}

	public String getCinemaPark() {
		return cinemaPark;
	}

	public void setCinemaPark(String cinemaPark) {
		this.cinemaPark = cinemaPark;
	}

	public String getCinemaPublic() {
		return cinemaPublic;
	}

	public void setCinemaPublic(String cinemaPublic) {
		this.cinemaPublic = cinemaPublic;
	}

	public String getCinemaImgName() {
		return cinemaImgName;
	}

	public void setCinemaImgName(String cinemaImgName) {
		this.cinemaImgName = cinemaImgName;
	}

	public String getCinemaImgRename() {
		return cinemaImgRename;
	}

	public void setCinemaImgRename(String cinemaImgRename) {
		this.cinemaImgRename = cinemaImgRename;
	}

	public String getCinemaImgPath() {
		return cinemaImgPath;
	}

	public void setCinemaImgPath(String cinemaImgPath) {
		this.cinemaImgPath = cinemaImgPath;
	}

	public String getCinemaStatus() {
		return cinemaStatus;
	}

	public void setCinemaStatus(String cinemaStatus) {
		this.cinemaStatus = cinemaStatus;
	}

	@Override
	public String toString() {
		return "Cinema [cinemaNo=" + cinemaNo + ", cinemaName=" + cinemaName + ", cinemaArea=" + cinemaArea
				+ ", cinemaAddress=" + cinemaAddress + ", cinemaTel=" + cinemaTel + ", cinemaContent=" + cinemaContent
				+ ", cinemaPark=" + cinemaPark + ", cinemaPublic=" + cinemaPublic + ", cinemaImgName=" + cinemaImgName
				+ ", cinemaImgRename=" + cinemaImgRename + ", cinemaImgPath=" + cinemaImgPath + ", cinemaStatus="
				+ cinemaStatus + "]";
	}
}
