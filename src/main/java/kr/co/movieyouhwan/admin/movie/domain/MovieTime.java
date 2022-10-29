package kr.co.movieyouhwan.admin.movie.domain;

import java.sql.Date;
import java.sql.Time;

public class MovieTime {
	private int movieTimeNo;
	private int cinemaNo;
	private int theaterNo;
	private int movieNo;
	private Date movieDay;
	private Time movieStart;
	private Time movieEnd;
	
	public MovieTime() {}

	public MovieTime(int movieTimeNo, int cinemaNo, int theaterNo, int movieNo, Date movieDay, Time movieStart,
			Time movieEnd) {
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

	public Date getMovieDay() {
		return movieDay;
	}

	public void setMovieDay(Date movieDay) {
		this.movieDay = movieDay;
	}

	public Time getMovieStart() {
		return movieStart;
	}

	public void setMovieStart(Time movieStart) {
		this.movieStart = movieStart;
	}

	public Time getMovieEnd() {
		return movieEnd;
	}

	public void setMovieEnd(Time movieEnd) {
		this.movieEnd = movieEnd;
	}

	@Override
	public String toString() {
		return "MovieTime [movieTimeNo=" + movieTimeNo + ", cinemaNo=" + cinemaNo + ", theaterNo=" + theaterNo
				+ ", movieNo=" + movieNo + ", movieDay=" + movieDay + ", movieStart=" + movieStart + ", movieEnd="
				+ movieEnd + "]";
	}
}
