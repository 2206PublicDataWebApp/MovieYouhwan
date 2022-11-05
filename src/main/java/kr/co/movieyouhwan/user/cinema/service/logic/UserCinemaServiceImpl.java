package kr.co.movieyouhwan.user.cinema.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.cinema.service.UserCinemaService;
import kr.co.movieyouhwan.user.cinema.store.UserCinemaStore;

@Service
public class UserCinemaServiceImpl implements UserCinemaService{
	@Autowired
	private UserCinemaStore uCinemaStore;
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<CinemaMovie> printCinemaMovieByDay(Integer cinemaNo, String movieDay) {
		List<CinemaMovie> cmList = uCinemaStore.selectAllCinemaMovie(session, cinemaNo, movieDay);
		return cmList;
	}

	@Override
	public List<Movie> printMovieNowOne(String movieDay) {
		List<Movie> mList = uCinemaStore.selectMovieNowOne(session, movieDay);
		return mList;
	}

}
