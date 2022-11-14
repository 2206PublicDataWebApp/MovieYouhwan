package kr.co.movieyouhwan.user.movie.domain;

import java.sql.Date;

public class MovieTicket {
	private String ticketNo; // 예매번호
	private String memberId; // 회원 아이디
	private String memberBirth; // 회원 생일
	private String memberGender; // 회원 성별
	private int cinemaNo; // 영화관 번호
	private int theaterNo; // 상영관 번호
	private int movieNo; // 영화 번호
	private String cinemaName; // 영화관 이름
	private String theaterName; // 상영관 이름
	private String movieName; // 영화 제목
	private String personType; // 성인 여부 - 성인 or 청소년
	private String personCount; // 관람 인원
	private String choiceSeat; // 좌석 번호
	private String impUid; // 아임포트
	private int moviePay; // 결제 금액
	private String payMethod; // 결제 수단
	private int addPoint; // 적립 포인트
	private Date payDate; // 결제 일자
	private String movieDay; // 영화 상영 일자
	private String movieStart; // 영화 시작 시간
	private String ticketStatus; // 예매 상태
	
	public MovieTicket() {}

	public MovieTicket(String ticketNo, String memberId, String memberBirth, String memberGender, int cinemaNo,
			int theaterNo, int movieNo, String cinemaName, String theaterName, String movieName, String personType,
			String personCount, String choiceSeat, String impUid, int moviePay, String payMethod, int addPoint,
			Date payDate, String movieDay, String movieStart, String ticketStatus) {
		super();
		this.ticketNo = ticketNo;
		this.memberId = memberId;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
		this.cinemaNo = cinemaNo;
		this.theaterNo = theaterNo;
		this.movieNo = movieNo;
		this.cinemaName = cinemaName;
		this.theaterName = theaterName;
		this.movieName = movieName;
		this.personType = personType;
		this.personCount = personCount;
		this.choiceSeat = choiceSeat;
		this.impUid = impUid;
		this.moviePay = moviePay;
		this.payMethod = payMethod;
		this.addPoint = addPoint;
		this.payDate = payDate;
		this.movieDay = movieDay;
		this.movieStart = movieStart;
		this.ticketStatus = ticketStatus;
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

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
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

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getPersonCount() {
		return personCount;
	}

	public void setPersonCount(String personCount) {
		this.personCount = personCount;
	}

	public String getChoiceSeat() {
		return choiceSeat;
	}

	public void setChoiceSeat(String choiceSeat) {
		this.choiceSeat = choiceSeat;
	}

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
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

	@Override
	public String toString() {
		return "MovieTicket [ticketNo=" + ticketNo + ", memberId=" + memberId + ", memberBirth=" + memberBirth
				+ ", memberGender=" + memberGender + ", cinemaNo=" + cinemaNo + ", theaterNo=" + theaterNo
				+ ", movieNo=" + movieNo + ", cinemaName=" + cinemaName + ", theaterName=" + theaterName
				+ ", movieName=" + movieName + ", personType=" + personType + ", personCount=" + personCount
				+ ", choiceSeat=" + choiceSeat + ", impUid=" + impUid + ", moviePay=" + moviePay + ", payMethod="
				+ payMethod + ", addPoint=" + addPoint + ", payDate=" + payDate + ", movieDay=" + movieDay
				+ ", movieStart=" + movieStart + ", ticketStatus=" + ticketStatus + "]";
	}
}
