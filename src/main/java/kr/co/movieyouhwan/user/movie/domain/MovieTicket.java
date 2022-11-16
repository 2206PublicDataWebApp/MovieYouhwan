package kr.co.movieyouhwan.user.movie.domain;

import java.sql.Date;

public class MovieTicket {
	private String ticketNo; // 예매번호
	private String memberId; // 회원 아이디
	private int memberAge; // 회원 생일
	private String memberGender; // 회원 성별
	private int cinemaNo; // 영화관 번호
	private int theaterNo; // 상영관 번호
	private int movieNo; // 영화 번호
	private String cinemaName; // 영화관 이름
	private String theaterName; // 상영관 이름
	private String movieName; // 영화 제목
	private int adultCount; // 성인 카운트
	private int teenagerCount; // 청소년 카운트
	private String choiceSeat; // 좌석 번호
	private int moviePay; // 결제 금액
	private String payMethod; // 결제 수단
	private int addPoint; // 적립 포인트
	private Date payDate; // 결제 일자
	private String movieDay; // 영화 상영 일자
	private String movieStart; // 영화 시작 시간
	private String ticketStatus; // 예매 상태
	private String movieImgName;	// 은선 - 예매 내역에서 사용
	private String movieImgRename;	// 은선 - 예매 내역에서 사용
	
	public MovieTicket() {}

	public MovieTicket(String ticketNo, String memberId, int memberAge, String memberGender, int cinemaNo,
			int theaterNo, int movieNo, String cinemaName, String theaterName, String movieName, int adultCount,
			int teenagerCount, String choiceSeat, int moviePay, String payMethod, int addPoint, Date payDate,
			String movieDay, String movieStart, String ticketStatus, String movieImgName, String movieImgRename) {
		super();
		this.ticketNo = ticketNo;
		this.memberId = memberId;
		this.memberAge = memberAge;
		this.memberGender = memberGender;
		this.cinemaNo = cinemaNo;
		this.theaterNo = theaterNo;
		this.movieNo = movieNo;
		this.cinemaName = cinemaName;
		this.theaterName = theaterName;
		this.movieName = movieName;
		this.adultCount = adultCount;
		this.teenagerCount = teenagerCount;
		this.choiceSeat = choiceSeat;
		this.moviePay = moviePay;
		this.payMethod = payMethod;
		this.addPoint = addPoint;
		this.payDate = payDate;
		this.movieDay = movieDay;
		this.movieStart = movieStart;
		this.ticketStatus = ticketStatus;
		this.movieImgName = movieImgName;
		this.movieImgRename = movieImgRename;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public int getCinemaNo() {
		return cinemaNo;
	}

	public void setCinemaNo(int cinemaNo) {
		this.cinemaNo = cinemaNo;
	}

	public int getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getTeenagerCount() {
		return teenagerCount;
	}

	public void setTeenagerCount(int teenagerCount) {
		this.teenagerCount = teenagerCount;
	}

	public String getChoiceSeat() {
		return choiceSeat;
	}

	public void setChoiceSeat(String choiceSeat) {
		this.choiceSeat = choiceSeat;
	}

	public int getMoviePay() {
		return moviePay;
	}

	public void setMoviePay(int moviePay) {
		this.moviePay = moviePay;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public int getAddPoint() {
		return addPoint;
	}

	public void setAddPoint(int addPoint) {
		this.addPoint = addPoint;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getMovieDay() {
		return movieDay;
	}

	public void setMovieDay(String movieDay) {
		this.movieDay = movieDay;
	}

	public String getMovieStart() {
		return movieStart;
	}

	public void setMovieStart(String movieStart) {
		this.movieStart = movieStart;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getMovieImgName() {
		return movieImgName;
	}

	public void setMovieImgName(String movieImgName) {
		this.movieImgName = movieImgName;
	}

	public String getMovieImgRename() {
		return movieImgRename;
	}

	public void setMovieImgRename(String movieImgRename) {
		this.movieImgRename = movieImgRename;
	}

	@Override
	public String toString() {
		return "MovieTicket [ticketNo=" + ticketNo + ", memberId=" + memberId + ", memberAge=" + memberAge
				+ ", memberGender=" + memberGender + ", cinemaNo=" + cinemaNo + ", theaterNo=" + theaterNo
				+ ", movieNo=" + movieNo + ", cinemaName=" + cinemaName + ", theaterName=" + theaterName
				+ ", movieName=" + movieName + ", adultCount=" + adultCount + ", teenagerCount=" + teenagerCount
				+ ", choiceSeat=" + choiceSeat + ", moviePay=" + moviePay + ", payMethod=" + payMethod + ", addPoint="
				+ addPoint + ", payDate=" + payDate + ", movieDay=" + movieDay + ", movieStart=" + movieStart
				+ ", ticketStatus=" + ticketStatus + ", movieImgName=" + movieImgName + ", movieImgRename="
				+ movieImgRename + "]";
	}

	

}
