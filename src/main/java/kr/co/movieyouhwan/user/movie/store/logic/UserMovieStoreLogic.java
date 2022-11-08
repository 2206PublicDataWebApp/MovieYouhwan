package kr.co.movieyouhwan.user.movie.store.logic;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.store.UserMovieStore;

@Repository
public class UserMovieStoreLogic implements UserMovieStore{
	// 전체 상영 영화 리스트
	@Override
	public List<MovieList> selectAllMovie(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieList");
		return mlList;
	}
	
	// 현재 상영 영화 리스트
	@Override
	public List<MovieList> selectAllMovieNow(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieNow");
		return mlList;
	}

	// 상영 예정 영화 리스트
	@Override
	public List<MovieList> selectAllMovieAfter(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieAfter");
		return mlList;
	}

	// 상영 종료 영화 리스트
	@Override
	public List<MovieList> selectAllMovieBefore(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieBefore");
		return mlList;
	}
}
