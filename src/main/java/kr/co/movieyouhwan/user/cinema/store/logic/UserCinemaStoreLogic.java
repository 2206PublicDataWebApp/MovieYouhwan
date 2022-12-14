package kr.co.movieyouhwan.user.cinema.store.logic;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.cinema.store.UserCinemaStore;

@Repository
public class UserCinemaStoreLogic implements UserCinemaStore{
	
	// 영화관 별 오늘 날짜 현재 상영 영화 중복 없이 출력
	@Override
	public List<Movie> selectMovieNowOne(SqlSessionTemplate session, Integer cinemaNo, String movieDay) {
		HashMap<String, String> movieMap = new HashMap<>();
		movieMap.put("cinemaNo", cinemaNo.toString());
		movieMap.put("movieDay", movieDay);
		List<Movie> mList = session.selectList("CinemaMapper.selectMovieNowOne", movieMap);
		return mList;
	}

	// 영화관 상영 영화 조회
	@Override
	public List<CinemaMovie> selectAllCinemaMovie(SqlSessionTemplate session, Integer cinemaNo, String movieDay) {
		HashMap<String, String> cinemaMovieMap = new HashMap<>();
		cinemaMovieMap.put("cinemaNo", cinemaNo.toString());
		cinemaMovieMap.put("movieDay", movieDay);
		List<CinemaMovie> cmList = session.selectList("CinemaMapper.selectAllCinemaMovie", cinemaMovieMap);
		return cmList;
	}
}