package kr.co.movieyouhwan.admin.movie.domain;

import java.sql.Date;

public class Movie {
	private int movieNo; // 영화 순번
	private String movieTitle; // 영화 제목
	private String movieGenre; // 영화 장르
	private int movieRuntime; // 상영시간
	private String movieDirector; // 영화 감독
	private String movieActor; // 영화 배우
	private String movieAge; // 관람가능연령
	private Date movieStartday; // 상영시작날짜
	private Date movieTicketingday; // 예매시작날짜
	private Date movieEndday; // 종영날짜
	private String movieContent; // 영화 줄거리
	private int movieSee; // 조회수
	private Date movieCreate; // 영화 생성일
	private int manCount; // 남자 예매자 수
	private int womanCount; // 여자 예매자 수
	private int oneAgeCount; // 10대 예매자 수
	private int twoAgeCount; // 20대 예매자 수
	private int threeAgeCount; // 30대 얘매자 수
	private int fourAgeCount; /// 40대 예매자 수
	private int fiveAgeCount; // 50대 예매자 수
	
	public Movie() {}

	public Movie(int movieNo, String movieTitle, String movieGenre, int movieRuntime, String movieDirector,
			String movieActor, String movieAge, Date movieStartday, Date movieTicketingday, Date movieEndday,
			String movieContent, int movieSee, Date movieCreate, int manCount, int womanCount, int oneAgeCount,
			int twoAgeCount, int threeAgeCount, int fourAgeCount, int fiveAgeCount) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieGenre = movieGenre;
		this.movieRuntime = movieRuntime;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieAge = movieAge;
		this.movieStartday = movieStartday;
		this.movieTicketingday = movieTicketingday;
		this.movieEndday = movieEndday;
		this.movieContent = movieContent;
		this.movieSee = movieSee;
		this.movieCreate = movieCreate;
		this.manCount = manCount;
		this.womanCount = womanCount;
		this.oneAgeCount = oneAgeCount;
		this.twoAgeCount = twoAgeCount;
		this.threeAgeCount = threeAgeCount;
		this.fourAgeCount = fourAgeCount;
		this.fiveAgeCount = fiveAgeCount;
	}

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

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public int getMovieRuntime() {
		return movieRuntime;
	}

	public void setMovieRuntime(int movieRuntime) {
		this.movieRuntime = movieRuntime;
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

	public Date getMovieTicketingday() {
		return movieTicketingday;
	}

	public void setMovieTicketingday(Date movieTicketingday) {
		this.movieTicketingday = movieTicketingday;
	}

	public Date getMovieEndday() {
		return movieEndday;
	}

	public void setMovieEndday(Date movieEndday) {
		this.movieEndday = movieEndday;
	}

	public String getMovieContent() {
		return movieContent;
	}

	public void setMovieContent(String movieContent) {
		this.movieContent = movieContent;
	}

	public int getMovieSee() {
		return movieSee;
	}

	public void setMovieSee(int movieSee) {
		this.movieSee = movieSee;
	}

	public Date getMovieCreate() {
		return movieCreate;
	}

	public void setMovieCreate(Date movieCreate) {
		this.movieCreate = movieCreate;
	}

	public int getManCount() {
		return manCount;
	}

	public void setManCount(int manCount) {
		this.manCount = manCount;
	}

	public int getWomanCount() {
		return womanCount;
	}

	public void setWomanCount(int womanCount) {
		this.womanCount = womanCount;
	}

	public int getOneAgeCount() {
		return oneAgeCount;
	}

	public void setOneAgeCount(int oneAgeCount) {
		this.oneAgeCount = oneAgeCount;
	}

	public int getTwoAgeCount() {
		return twoAgeCount;
	}

	public void setTwoAgeCount(int twoAgeCount) {
		this.twoAgeCount = twoAgeCount;
	}

	public int getThreeAgeCount() {
		return threeAgeCount;
	}

	public void setThreeAgeCount(int threeAgeCount) {
		this.threeAgeCount = threeAgeCount;
	}

	public int getFourAgeCount() {
		return fourAgeCount;
	}

	public void setFourAgeCount(int fourAgeCount) {
		this.fourAgeCount = fourAgeCount;
	}

	public int getFiveAgeCount() {
		return fiveAgeCount;
	}

	public void setFiveAgeCount(int fiveAgeCount) {
		this.fiveAgeCount = fiveAgeCount;
	}

	@Override
	public String toString() {
		return "Movie [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", movieGenre=" + movieGenre
				+ ", movieRuntime=" + movieRuntime + ", movieDirector=" + movieDirector + ", movieActor=" + movieActor
				+ ", movieAge=" + movieAge + ", movieStartday=" + movieStartday + ", movieTicketingday="
				+ movieTicketingday + ", movieEndday=" + movieEndday + ", movieContent=" + movieContent + ", movieSee="
				+ movieSee + ", movieCreate=" + movieCreate + ", manCount=" + manCount + ", womanCount=" + womanCount
				+ ", oneAgeCount=" + oneAgeCount + ", twoAgeCount=" + twoAgeCount + ", threeAgeCount=" + threeAgeCount
				+ ", fourAgeCount=" + fourAgeCount + ", fiveAgeCount=" + fiveAgeCount + "]";
	}
}
