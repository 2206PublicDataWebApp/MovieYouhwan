package kr.co.movieyouhwan.admin.movie.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;

public interface AdminMovieStore {
	// 영화 등록
	public int insertMovie(SqlSessionTemplate session, Movie movie);
	// 영화 사진 등록
	public int insertMovieImg(SqlSessionTemplate session, MovieImg movieImg);
	// 영화 영상 등록
	public int insertMovieVideo(SqlSessionTemplate session, MovieVideo movieVideo);
	// 영화 목록
	public List<Movie> selectAllMovie(SqlSessionTemplate session);
	// 영화 검색 
	public List<Movie> selectSearchMovie(SqlSessionTemplate session, String searchName);

}
