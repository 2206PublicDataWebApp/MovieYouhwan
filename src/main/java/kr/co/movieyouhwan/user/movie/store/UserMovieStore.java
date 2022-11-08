package kr.co.movieyouhwan.user.movie.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.movie.domain.MovieList;

public interface UserMovieStore {
	// 현재 상영 영화 리스트 (영화)
	public List<MovieList> selectAllMovieNow(SqlSessionTemplate session);

}
