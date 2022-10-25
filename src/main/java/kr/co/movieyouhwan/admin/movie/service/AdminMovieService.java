package kr.co.movieyouhwan.admin.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;

public interface AdminMovieService {
	// 영화 등록
	public int registerMovie(Movie movie);
	// 영화 사진 등록
	public int registerMovieImg(MovieImg movieImg);
	// 영화 영상 등록
	public int registerMovieVideo(MovieVideo movieVideo);
	// 영화 목록
	public List<Movie> printAllMovie();
	// 영화 검색
	public List<Movie> printSearchMovie(String searchName);
}
