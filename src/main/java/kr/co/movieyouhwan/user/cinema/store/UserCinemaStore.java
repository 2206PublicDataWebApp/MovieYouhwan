package kr.co.movieyouhwan.user.cinema.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;

public interface UserCinemaStore {

	public List<CinemaMovie> selectAllCinemaMovie(SqlSessionTemplate session, Integer cinemaNo, String movieDay);

	public List<Movie> selectMovieNowOne(SqlSessionTemplate session, String movieDay);

}
