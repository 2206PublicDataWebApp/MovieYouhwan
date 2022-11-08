package kr.co.movieyouhwan.user.movie.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.service.UserMovieService;
import kr.co.movieyouhwan.user.movie.store.UserMovieStore;

@Service
public class UserMovieServiceImpl implements UserMovieService{
	@Autowired
	private UserMovieStore uMovieStore;
	@Autowired
	private SqlSessionTemplate session;

	// 현재 상영 영화 리스트 (영화)
	@Override
	public List<MovieList> printAllMovieNow() {
		List<MovieList> mlList = uMovieStore.selectAllMovieNow(session);
		return mlList;
	}
}
