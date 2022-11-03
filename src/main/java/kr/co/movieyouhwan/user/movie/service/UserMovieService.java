package kr.co.movieyouhwan.user.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;

public interface UserMovieService {

	// 영화 예약 화면 (영화관)
	public List<MovieTime> printAllCinemaMovie(Integer cinemaNo);

	public List<MovieTime> printCinemaMovieByDate(Integer cinemaNo, String movieDay);
}
