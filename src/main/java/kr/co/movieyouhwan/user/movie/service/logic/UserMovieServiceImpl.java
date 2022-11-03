package kr.co.movieyouhwan.user.movie.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.movie.service.UserMovieService;
import kr.co.movieyouhwan.user.movie.store.UserMovieStore;

@Service
public class UserMovieServiceImpl implements UserMovieService{
	@Autowired
	private UserMovieStore uMovieStore;
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<MovieTime> printAllCinemaMovie(Integer cinemaNo) {
		List<MovieTime> mtList = uMovieStore.selectAllCinemaMovie(session, cinemaNo);
		return mtList;
	}

	@Override
	public List<MovieTime> printCinemaMovieByDate(Integer cinemaNo, String movieDay) {
		List<MovieTime> mtList=uMovieStore.selectCinemaMovieByDate(session, cinemaNo, movieDay);
		return mtList;
	}
}
