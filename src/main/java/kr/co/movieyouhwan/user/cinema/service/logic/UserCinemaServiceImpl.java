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

	// 영화관 별 오늘 날짜 현재 상영 영화 중복 없이 출력
	@Override
	public List<Movie> printMovieNowOne(Integer cinemaNo, String movieDay) {
		List<Movie> mList = uCinemaStore.selectMovieNowOne(session, cinemaNo, movieDay);
		return mList;
	}
	
	// 영화관에서 상영중인 영화, 상영관 정보, 상영 영화 정보 출력
	@Override
	public List<CinemaMovie> printCinemaMovieByDay(Integer cinemaNo, String movieDay) {
		List<CinemaMovie> cmList = uCinemaStore.selectAllCinemaMovie(session, cinemaNo, movieDay);
		return cmList;
	}
	

}
