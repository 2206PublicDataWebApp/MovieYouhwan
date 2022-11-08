package kr.co.movieyouhwan.user.movie.store.logic;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.store.UserMovieStore;

@Repository
public class UserMovieStoreLogic implements UserMovieStore{
	// 현재 상영 영화 리스트 (영화)
	@Override
	public List<MovieList> selectAllMovieNow(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieNow");
		return mlList;
	}

}
