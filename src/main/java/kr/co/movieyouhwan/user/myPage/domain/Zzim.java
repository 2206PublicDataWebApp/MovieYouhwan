package kr.co.movieyouhwan.user.myPage.domain;

import java.util.Date;

public class Zzim {
	private int zzimNo;	
	private String memberId;	
	private int movieNo;	
	private Date zzimDate;
	private String movieImgName;
	private String movieImgReName;
	private String movieTitle;
	private String movieAge;
	private Date movieStartDay;
	private String movieDirector;
	private String movieActor;
	private int movieSee;
	private int movieZzim;
	
	
	
	
	
//	들어갈 데이터 모두 적어주기 mapper도 동일
	public Zzim() {}



	public int getZzimNo() {
		return zzimNo;
	}



	public void setZzimNo(int zzimNo) {
		this.zzimNo = zzimNo;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public int getMovieNo() {
		return movieNo;
	}



	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}



	public Date getZzimDate() {
		return zzimDate;
	}



	public void setZzimDate(Date zzimDate) {
		this.zzimDate = zzimDate;
	}



	public String getMovieImgName() {
		return movieImgName;
	}



	public void setMovieImgName(String movieImgName) {
		this.movieImgName = movieImgName;
	}



	public String getMovieImgReName() {
		return movieImgReName;
	}



	public void setMovieImgReName(String movieImgReName) {
		this.movieImgReName = movieImgReName;
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



	public Date getMovieStartDay() {
		return movieStartDay;
	}



	public void setMovieStartDay(Date movieStartDay) {
		this.movieStartDay = movieStartDay;
	}



	public String getMovieDirector() {
		return movieDirector;
	}



	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}



	public String getMovieActor() {
		return movieActor;
	}



	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}



	public int getMovieSee() {
		return movieSee;
	}



	public void setMovieSee(int movieSee) {
		this.movieSee = movieSee;
	}



	@Override
	public String toString() {
		return "Zzim [zzimNo=" + zzimNo + ", memberId=" + memberId + ", movieNo=" + movieNo + ", zzimDate=" + zzimDate
				+ ", movieImgName=" + movieImgName + ", movieImgReName=" + movieImgReName + ", movieTitle=" + movieTitle
				+ ", movieAge=" + movieAge + ", movieStartDay=" + movieStartDay + ", movieDirector=" + movieDirector
				+ ", movieActor=" + movieActor + ", movieSee=" + movieSee + "]";
	}



	public Zzim(int zzimNo, String memberId, int movieNo, Date zzimDate, String movieImgName, String movieImgReName,
			String movieTitle, String movieAge, Date movieStartDay, String movieDirector, String movieActor,
			int movieSee) {
		super();
		this.zzimNo = zzimNo;
		this.memberId = memberId;
		this.movieNo = movieNo;
		this.zzimDate = zzimDate;
		this.movieImgName = movieImgName;
		this.movieImgReName = movieImgReName;
		this.movieTitle = movieTitle;
		this.movieAge = movieAge;
		this.movieStartDay = movieStartDay;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieSee = movieSee;
	}
	
	
}
