package kr.co.movieyouhwan.user.cinema.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;

public interface UserCinemaStore {
	// 영화관 별 오늘 날짜 현재 상영 영화 중복 없이 출력
	public List<Movie> selectMovieNowOne(SqlSessionTemplate session, Integer cinemaNo, String movieDay);
	// 영화관에서 상영중인 영화, 상영관 정보, 상영 영화 정보 출력
	public List<CinemaMovie> selectAllCinemaMovie(SqlSessionTemplate session, Integer cinemaNo, String movieDay);
}
