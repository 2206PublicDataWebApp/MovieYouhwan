package kr.co.movieyouhwan.user.movie.domain;

import java.sql.Date;

public class MovieList {
	private int movieNo;
	private int theaterNo;
	private String movieTitle;
	private String movieAge;
	private Date movieStartday;
	private Date movieEndday;
	private String movieImgName;
	private String movieImgRename;
	private String movieImgPath;
	private String theaterName;
	private String movieDay;
	private String movieStart;
	private String movieEnd;
	private int movieTicket;
	private int movieSeat;
	private String memberId;
	private int movieZzim;
	private int zzimNo;
	private String zzimYn;	// 사용자 찜 여부
	
	public MovieList() {}

	@Override
	public String toString() {
		return "MovieList [movieNo=" + movieNo + ", theaterNo=" + theaterNo + ", movieTitle=" + movieTitle
				+ ", movieAge=" + movieAge + ", movieStartday=" + movieStartday + ", movieEndday=" + movieEndday
				+ ", movieImgName=" + movieImgName + ", movieImgRename=" + movieImgRename + ", movieImgPath="
				+ movieImgPath + ", theaterName=" + theaterName + ", movieDay=" + movieDay + ", movieStart="
				+ movieStart + ", movieEnd=" + movieEnd + ", movieTicket=" + movieTicket + ", movieSeat=" + movieSeat
				+ ", memberId=" + memberId + ", movieZzim=" + movieZzim + ", zzimNo=" + zzimNo + ", zzimYn=" + zzimYn
				+ "]";
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public int getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieAge() {
		return movieAge;
	}

	public void setMovieAge(String movieAge) {
		this.movieAge = movieAge;
	}

	public Date getMovieStartday() {
		return movieStartday;
	}

	public void setMovieStartday(Date movieStartday) {
		this.movieStartday = movieStartday;
	}

	public Date getMovieEndday() {
		return movieEndday;
	}

	public void setMovieEndday(Date movieEndday) {
		this.movieEndday = movieEndday;
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

	public String getMovieImgPath() {
		return movieImgPath;
	}

	public void setMovieImgPath(String movieImgPath) {
		this.movieImgPath = movieImgPath;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
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

	public String getMovieEnd() {
		return movieEnd;
	}

	public void setMovieEnd(String movieEnd) {
		this.movieEnd = movieEnd;
	}

	public int getMovieTicket() {
		return movieTicket;
	}

	public void setMovieTicket(int movieTicket) {
		this.movieTicket = movieTicket;
	}

	public int getMovieSeat() {
		return movieSeat;
	}

	public void setMovieSeat(int movieSeat) {
		this.movieSeat = movieSeat;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMovieZzim() {
		return movieZzim;
	}

	public void setMovieZzim(int movieZzim) {
		this.movieZzim = movieZzim;
	}

	public int getZzimNo() {
		return zzimNo;
	}

	public void setZzimNo(int zzimNo) {
		this.zzimNo = zzimNo;
	}

	public String getZzimYn() {
		return zzimYn;
	}

	public void setZzimYn(String zzimYn) {
		this.zzimYn = zzimYn;
	}

	public MovieList(int movieNo, int theaterNo, String movieTitle, String movieAge, Date movieStartday,
			Date movieEndday, String movieImgName, String movieImgRename, String movieImgPath, String theaterName,
			String movieDay, String movieStart, String movieEnd, int movieTicket, int movieSeat, String memberId,
			int movieZzim, int zzimNo, String zzimYn) {
		super();
		this.movieNo = movieNo;
		this.theaterNo = theaterNo;
		this.movieTitle = movieTitle;
		this.movieAge = movieAge;
		this.movieStartday = movieStartday;
		this.movieEndday = movieEndday;
		this.movieImgName = movieImgName;
		this.movieImgRename = movieImgRename;
		this.movieImgPath = movieImgPath;
		this.theaterName = theaterName;
		this.movieDay = movieDay;
		this.movieStart = movieStart;
		this.movieEnd = movieEnd;
		this.movieTicket = movieTicket;
		this.movieSeat = movieSeat;
		this.memberId = memberId;
		this.movieZzim = movieZzim;
		this.zzimNo = zzimNo;
		this.zzimYn = zzimYn;
	}

	


	
}
