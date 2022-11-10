package kr.co.movieyouhwan.user.movie.store.logic;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.store.UserMovieStore;

@Repository
public class UserMovieStoreLogic implements UserMovieStore{
	// 현재 상영 영화 리스트
	@Override
	public List<MovieList> selectAllMovieNow(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieNow");
		return mlList;
	}
	
	// 현재 상영 영화 리스트 페이징 처리
	@Override
	public int selectNowMovieCount(SqlSessionTemplate session) {
		int count = session.selectOne("MovieMapper.selectNowMovieCount");
		return count;
	}

	// 상영 예정 영화 리스트
	@Override
	public List<MovieList> selectAllMovieAfter(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieAfter");
		return mlList;
	}
	
	// 상영 예정 영화 리스트 페이징 처리
	@Override
	public int selectAfterMovieCount(SqlSessionTemplate session) {
		int count = session.selectOne("MovieMapper.selectAfterMovieCount");
		return count;
	}

	// 상영 종료 영화 리스트
	@Override
	public List<MovieList> selectAllMovieBefore(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieBefore");
		return mlList;
	}
	
	// 상영 종료 영화 리스트 페이징 처리
	@Override
	public int selectBeforeMovieCount(SqlSessionTemplate session) {
		int count = session.selectOne("MovieMapper.selectBeforeMovieCount");
		return count;
	}
	
	// 영화 검색 완료 리스트
	@Override
	public List<MovieList> selectAllMovie(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieList");
		return mlList;
	}

	// 영화 검색 기능
	@Override
	public List<MovieList> selectSearchMovie(SqlSessionTemplate session, String searchName) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectSearchMovieList", searchName);
		return mlList;
	}
}
