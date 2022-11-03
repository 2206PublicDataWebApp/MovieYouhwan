package kr.co.movieyouhwan.user.movie.store.logic;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.movie.store.UserMovieStore;

@Repository
public class UserMovieStoreLogic implements UserMovieStore{

	@Override
	public List<MovieTime> selectAllCinemaMovie(SqlSessionTemplate session, Integer cinemaNo) {
		List<MovieTime> mtList = session.selectList("MovieMapper.selectAllCinemaMovie", cinemaNo);
		return mtList;
	}

	@Override
	public List<MovieTime> selectCinemaMovieByDate(SqlSessionTemplate session, Integer cinemaNo, String movieDay) {
		HashMap<String, String> paramMap=new HashMap<>();
		paramMap.put("cinemaNo", cinemaNo.toString());
		paramMap.put("movieDay", movieDay);
		List<MovieTime> mtList=session.selectList("MovieMapper.selectCinemaMovieByDate", paramMap);
		return mtList;
	}


}
