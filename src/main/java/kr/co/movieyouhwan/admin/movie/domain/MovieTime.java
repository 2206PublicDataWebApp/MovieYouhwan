package kr.co.movieyouhwan.admin.movie.domain;

import java.util.Date;

public class MovieTime {
	private int movieTimeNo;
	private int cinemaNo;
	private int theaterNo;
	private int movieNo;
	private String movieDay;
	private String movieStart;
	private String movieEnd;
	
	public MovieTime() {}

	public MovieTime(int movieTimeNo, int cinemaNo, int theaterNo, int movieNo, String movieDay, String movieStart,
			String movieEnd) {
		super();
		this.movieTimeNo = movieTimeNo;
		this.cinemaNo = cinemaNo;
		this.theaterNo = theaterNo;
		this.movieNo = movieNo;
		this.movieDay = movieDay;
		this.movieStart = movieStart;
		this.movieEnd = movieEnd;
	}

	public int getMovieTimeNo() {
		return movieTimeNo;
	}

	public void setMovieTimeNo(int movieTimeNo) {
		this.movieTimeNo = movieTimeNo;
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

	@Override
	public String toString() {
		return "MovieTime [movieTimeNo=" + movieTimeNo + ", cinemaNo=" + cinemaNo + ", theaterNo=" + theaterNo
				+ ", movieNo=" + movieNo + ", movieDay=" + movieDay + ", movieStart=" + movieStart + ", movieEnd="
				+ movieEnd + "]";
	}
}