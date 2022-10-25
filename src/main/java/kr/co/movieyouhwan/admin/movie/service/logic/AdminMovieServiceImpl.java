package kr.co.movieyouhwan.admin.movie.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.admin.movie.store.AdminMovieStore;

@Service
public class AdminMovieServiceImpl implements AdminMovieService{
	@Autowired
	private AdminMovieStore aMovieStore;
	@Autowired
	private SqlSessionTemplate session;
	
	// 영화 등록
	@Override
	public int registerMovie(Movie movie) {
		int result = aMovieStore.insertMovie(session, movie);
		return result;
	}
	
	// 영화 사진 등록
	@Override
	public int registerMovieImg(MovieImg movieImg) {
		int result = aMovieStore.insertMovieImg(session, movieImg);
		return result;
	}

	// 영화 영상 등록
	@Override
	public int registerMovieVideo(MovieVideo movieVideo) {
		int result = aMovieStore.insertMovieVideo(session, movieVideo);
		return result;
	}
	
	// 영화 목록
	@Override
	public List<Movie> printAllMovie() {
		List<Movie> mList = aMovieStore.selectAllMovie(session);
		return mList;
	}

	// 영화 검색
	@Override
	public List<Movie> printSearchMovie(String searchName) {
		List<Movie> mList = aMovieStore.selectSearchMovie(session, searchName);
		return mList;
	}

}
