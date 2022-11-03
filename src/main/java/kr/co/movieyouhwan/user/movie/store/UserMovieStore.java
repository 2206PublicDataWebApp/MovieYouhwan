package kr.co.movieyouhwan.user.movie.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;

public interface UserMovieStore {

	public List<MovieTime> selectAllCinemaMovie(SqlSessionTemplate session, Integer cinemaNo);

	public List<MovieTime> selectCinemaMovieByDate(SqlSessionTemplate session, Integer cinemaNo, String movieDay);

}
