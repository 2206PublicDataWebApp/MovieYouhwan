package kr.co.movieyouhwan.user.mate.domain;

public class CinemaOption {
	Integer cinemaNo;
	String cinemaName;
	public Integer getCinemaNo() {
		return cinemaNo;
	}
	public void setCinemaNo(Integer cinemaNo) {
		this.cinemaNo = cinemaNo;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	@Override
	public String toString() {
		return "CinemaOption [cinemaNo=" + cinemaNo + ", cinemaName=" + cinemaName + "]";
	}
	
	

}
