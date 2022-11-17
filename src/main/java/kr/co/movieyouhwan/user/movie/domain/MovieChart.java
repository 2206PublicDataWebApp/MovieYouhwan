package kr.co.movieyouhwan.user.movie.domain;

public class MovieChart {

	private int movieNo; // 영화 번호
	private String movieTitle; // 영화 제목
	private String startDay; // 개봉일
	private String endDay; // 상영종료일
	private String movieImgRename; // 영화 사진 저장명
	private String count; // 예매 수

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

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getMovieImgRename() {
		return movieImgRename;
	}

	public void setMovieImgRename(String movieImgRename) {
		this.movieImgRename = movieImgRename;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "MovieChart [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", startDay=" + startDay + ", endDay="
				+ endDay + ", movieImgRename=" + movieImgRename + ", count=" + count + "]";
	}

}
