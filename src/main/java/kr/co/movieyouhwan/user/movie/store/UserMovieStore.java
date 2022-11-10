package kr.co.movieyouhwan.user.movie.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.movie.domain.MovieList;

public interface UserMovieStore {
	// 현재 상영 영화 리스트
	public List<MovieList> selectAllMovieNow(SqlSessionTemplate session);
	// 현재 상영 영화 리스트 페이징 처리
	public int selectNowMovieCount(SqlSessionTemplate session);
	// 상영 예정 영화 리스트
	public List<MovieList> selectAllMovieAfter(SqlSessionTemplate session);
	// 상영 예정 영화 리스트 페이징 처리
	public int selectAfterMovieCount(SqlSessionTemplate session);
	// 상영 종료 영화 리스트
	public List<MovieList> selectAllMovieBefore(SqlSessionTemplate session);
	// 상영 종료 영화 리스트 페이징 처리
	public int selectBeforeMovieCount(SqlSessionTemplate session);
	// 영화 검색 리스트
	public List<MovieList> selectAllMovie(SqlSessionTemplate session);
	// 영화 검색 기능
	public List<MovieList> selectSearchMovie(SqlSessionTemplate session, String searchName);
}
