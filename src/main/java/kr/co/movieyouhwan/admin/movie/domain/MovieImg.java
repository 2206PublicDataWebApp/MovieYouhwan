package kr.co.movieyouhwan.admin.movie.domain;

public class MovieImg {
	private int movieImgNo; // 영화 이미지 순번
	private int movieNo; // 영화 순번
	private String movieImgName; // 영화 변경전 사진 이름
	private String movieImgRename; // 영화 변경후 사진 이름
	private String movieImgPath; // 영화 사진 경로
	
	public MovieImg() {}

	public MovieImg(int movieImgNo, int movieNo, String movieImgName, String movieImgRename, String movieImgPath) {
		super();
		this.movieImgNo = movieImgNo;
		this.movieNo = movieNo;
		this.movieImgName = movieImgName;
		this.movieImgRename = movieImgRename;
		this.movieImgPath = movieImgPath;
	}

	public int getMovieImgNo() {
		return movieImgNo;
	}

	public void setMovieImgNo(int movieImgNo) {
		this.movieImgNo = movieImgNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
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

	@Override
	public String toString() {
		return "MovieImg [movieImgNo=" + movieImgNo + ", movieNo=" + movieNo + ", movieImgName=" + movieImgName
				+ ", movieImgRename=" + movieImgRename + ", movieImgPath=" + movieImgPath + "]";
	}
}
