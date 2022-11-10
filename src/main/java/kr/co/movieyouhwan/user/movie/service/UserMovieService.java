package kr.co.movieyouhwan.user.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.movie.domain.MovieList;

public interface UserMovieService {
	// 현재 상영 영화 리스트
	public List<MovieList> printAllMovieNow();
	// 현재 상영 영화 리스트 페이징 처리
	public int printNowMovieCount();
	// 상영 예정 영화 리스트
	public List<MovieList> printAllMovieAfter();
	// 상영 예정 영화 리스트 페이징 처리
	public int printAfterMovieCount();
	// 상영 종료 영화 리스트
	public List<MovieList> printAllMovieBefore();
	// 상영 종료 영화 리스트 페이징 처리
	public int printBeforeMovieCount();
	// 영화 검색 리스트
	public List<MovieList> printAllMovie();
	// 영화 검색 기능
	public List<MovieList> printSearchMovie(String searchName);
	// 영화관별 상영 영화 출력
	public List<Movie> printAllMovieCinema(Integer cinemaNo);
}
