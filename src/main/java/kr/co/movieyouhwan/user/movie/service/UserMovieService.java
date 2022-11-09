package kr.co.movieyouhwan.user.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.movie.domain.MovieList;

public interface UserMovieService {
	// 전체 영화 출력
	public List<MovieList> printAllMovie();
	// 현재 상영 영화 리스트
	public List<MovieList> printAllMovieNow();
	// 상영 예정 영화 리스트
	public List<MovieList> printAllMovieAfter();
	// 상영 종료 영화 리스트
	public List<MovieList> printAllMovieBefore();
}
