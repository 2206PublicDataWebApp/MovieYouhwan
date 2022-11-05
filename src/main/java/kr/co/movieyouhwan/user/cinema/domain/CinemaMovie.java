package kr.co.movieyouhwan.user.cinema.domain;

public class CinemaMovie {
	private int movieNo;
	private String movieTitle;
	private String movieAge;
	private String theaterName;
	private String movieDay;
	private String movieStart;
	private String movieEnd;
	private String movieTicket;
	private String movieSeat;
	
	public CinemaMovie() {}

	public CinemaMovie(int movieNo, String movieTitle, String movieAge, String theaterName, String movieDay,
			String movieStart, String movieEnd, String movieTicket, String movieSeat) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieAge = movieAge;
		this.theaterName = theaterName;
		this.movieDay = movieDay;
		this.movieStart = movieStart;
		this.movieEnd = movieEnd;
		this.movieTicket = movieTicket;
		this.movieSeat = movieSeat;
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

	public String getMovieAge() {
		return movieAge;
	}

	public void setMovieAge(String movieAge) {
		this.movieAge = movieAge;
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

	public String getMovieTicket() {
		return movieTicket;
	}

	public void setMovieTicket(String movieTicket) {
		this.movieTicket = movieTicket;
	}

	public String getMovieSeat() {
		return movieSeat;
	}

	public void setMovieSeat(String movieSeat) {
		this.movieSeat = movieSeat;
	}

	@Override
	public String toString() {
		return "CinemaMovie [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", movieAge=" + movieAge
				+ ", theaterName=" + theaterName + ", movieDay=" + movieDay + ", movieStart=" + movieStart
				+ ", movieEnd=" + movieEnd + ", movieTicket=" + movieTicket + ", movieSeat=" + movieSeat + "]";
	}
}
