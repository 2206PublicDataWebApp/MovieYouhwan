package kr.co.movieyouhwan.user.movie.domain;

import java.sql.Date;

public class MovieList {
	private int movieNo;
	private String movieTitle;
	private String movieAge;
	private Date movieStartday;
	private Date movieEndday;
	private String movieImgName;
	private String movieImgRename;
	private String movieImgPath;
	private String memberId;
	private int movieZzim;	// 찜 카운트
	private int zzimNo;	// 사용자 찜 여부
	
	
	public MovieList() {}


	public int getMovieNo() {
		return movieNo;
	}


	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
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


	@Override
	public String toString() {
		return "MovieList [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", movieAge=" + movieAge
				+ ", movieStartday=" + movieStartday + ", movieEndday=" + movieEndday + ", movieImgName=" + movieImgName
				+ ", movieImgRename=" + movieImgRename + ", movieImgPath=" + movieImgPath + ", memberId=" + memberId
				+ ", movieZzim=" + movieZzim + ", zzimNo=" + zzimNo + "]";
	}


	public MovieList(int movieNo, String movieTitle, String movieAge, Date movieStartday, Date movieEndday,
			String movieImgName, String movieImgRename, String movieImgPath, String memberId, int movieZzim,
			int zzimNo) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieAge = movieAge;
		this.movieStartday = movieStartday;
		this.movieEndday = movieEndday;
		this.movieImgName = movieImgName;
		this.movieImgRename = movieImgRename;
		this.movieImgPath = movieImgPath;
		this.memberId = memberId;
		this.movieZzim = movieZzim;
		this.zzimNo = zzimNo;
	}

	

	
}
