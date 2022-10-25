package kr.co.movieyouhwan.admin.movie.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
import kr.co.movieyouhwan.admin.movie.store.AdminMovieStore;

@Repository
public class AdminMovieStoreLogic implements AdminMovieStore {
	
	// 영화 등록
	@Override
	public int insertMovie(SqlSessionTemplate session, Movie movie) {
		int result = session.insert("MovieMapper.insertMovie", movie);
		return result;
	}
	
	// 영화 사진 등록
	@Override
	public int insertMovieImg(SqlSessionTemplate session, MovieImg movieImg) {
		int result = session.insert("MovieMapper.insertMovieImg", movieImg);
		return result;
	}

	// 영화 영상 등록
	@Override
	public int insertMovieVideo(SqlSessionTemplate session, MovieVideo movieVideo) {
		int result = session.insert("MovieMapper.insertMovieVideo", movieVideo);
		return result;
	}

	// 영화 목록
	@Override
	public List<Movie> selectAllMovie(SqlSessionTemplate session) {
		List<Movie> mList = session.selectList("MovieMapper.selectAllMovie");
		return mList;
	}

	// 영화 검색
	@Override
	public List<Movie> selectSearchMovie(SqlSessionTemplate session, String searchName) {
		List<Movie> mList = session.selectList("MovieMapper.selectSearchMovie", searchName);
		return mList;
	}

}
