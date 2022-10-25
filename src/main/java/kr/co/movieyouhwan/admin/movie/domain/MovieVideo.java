package kr.co.movieyouhwan.admin.movie.domain;

public class MovieVideo {
	private int movieVideoNo; // 영화 영상 순번
	private int movieNo; // 영화 순번 
	private String movieVideoName; // 영화 변경전 영상 이름
	private String movieVideoRename; // 영화 변경후 영상 이름
	private String movieVideoPath; // 영화 영상 경로
	
	public MovieVideo() {}

	public MovieVideo(int movieVideoNo, int movieNo, String movieVideoName, String movieVideoRename,
			String movieVideoPath) {
		super();
		this.movieVideoNo = movieVideoNo;
		this.movieNo = movieNo;
		this.movieVideoName = movieVideoName;
		this.movieVideoRename = movieVideoRename;
		this.movieVideoPath = movieVideoPath;
	}

	public int getMovieVideoNo() {
		return movieVideoNo;
	}

	public void setMovieVideoNo(int movieVideoNo) {
		this.movieVideoNo = movieVideoNo;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getMovieVideoName() {
		return movieVideoName;
	}

	public void setMovieVideoName(String movieVideoName) {
		this.movieVideoName = movieVideoName;
	}

	public String getMovieVideoRename() {
		return movieVideoRename;
	}

	public void setMovieVideoRename(String movieVideoRename) {
		this.movieVideoRename = movieVideoRename;
	}

	public String getMovieVideoPath() {
		return movieVideoPath;
	}

	public void setMovieVideoPath(String movieVideoPath) {
		this.movieVideoPath = movieVideoPath;
	}

	@Override
	public String toString() {
		return "MovieVideo [movieVideoNo=" + movieVideoNo + ", movieNo=" + movieNo + ", movieVideoName="
				+ movieVideoName + ", movieVideoRename=" + movieVideoRename + ", movieVideoPath=" + movieVideoPath
				+ "]";
	}
}
