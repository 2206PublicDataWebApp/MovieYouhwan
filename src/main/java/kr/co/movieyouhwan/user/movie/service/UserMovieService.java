package kr.co.movieyouhwan.user.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.movie.domain.MovieList;

public interface UserMovieService {
	// 현재 상영 영화 리스트 (영화)
	public List<MovieList> printAllMovieNow();
}
