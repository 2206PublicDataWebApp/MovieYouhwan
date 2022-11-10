package kr.co.movieyouhwan.user.movie.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
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
	
	// 현재 상영 영화 리스트
	@Override
	public List<MovieList> printAllMovieNow() {
		List<MovieList> mlList = uMovieStore.selectAllMovieNow(session);
		return mlList;
	}
	
	// 현재 상영 영화 리스트 페이징 처리
	@Override
	public int printNowMovieCount() {
		int count = uMovieStore.selectNowMovieCount(session);
		return count;
	}

	// 상영 예정 영화 리스트
	@Override
	public List<MovieList> printAllMovieAfter() {
		List<MovieList> mlList = uMovieStore.selectAllMovieAfter(session);
		return mlList;
	}
	
	// 상영 예정 영화 페이징 처리
	@Override
	public int printAfterMovieCount() {
		int count = uMovieStore.selectAfterMovieCount(session);
		return count;
	}

	// 상영 종료 영화 리스트
	@Override
	public List<MovieList> printAllMovieBefore() {
		List<MovieList> mlList = uMovieStore.selectAllMovieBefore(session);
		return mlList;
	}
	
	// 상영 종료 영화 리스트 페이징 처리
	@Override
	public int printBeforeMovieCount() {
		int count = uMovieStore.selectBeforeMovieCount(session);
		return count;
	}
	
	// 영화 검색 리스트
	@Override
	public List<MovieList> printAllMovie() {
		List<MovieList> mlList = uMovieStore.selectAllMovie(session);
		return mlList;
	}
	
	// 영화 검색 기능
	@Override
	public List<MovieList> printSearchMovie(String searchName) {
		List<MovieList> mlList = uMovieStore.selectSearchMovie(session, searchName);
		return mlList;
	}
}
