package kr.co.movieyouhwan.admin.movie.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
import kr.co.movieyouhwan.common.page.PageInfo;

public interface AdminMovieStore {
	// 영화 등록
	public int insertMovie(SqlSessionTemplate session, Movie movie);
	// 영화 사진 등록
	public int insertMovieImg(SqlSessionTemplate session, MovieImg movieImg);
	// 영화 영상 등록
	public int insertMovieVideo(SqlSessionTemplate session, MovieVideo movieVideo);
	// 영화 목록
	public List<Movie> selectAllMovie(SqlSessionTemplate session, PageInfo pageInfo);
	// 영화 검색 
	public List<Movie> selectSearchMovie(SqlSessionTemplate session, String searchName);
	// 영화 상세
	public Movie selectOneMovie(SqlSessionTemplate session, Integer movieNo);
	// 영화 상세 (사진)
	public List<MovieImg> selectOneMovieImg(SqlSessionTemplate session, Integer movieNo);
	// 영화 상세 (영상)
	public List<MovieVideo> selectOneMovieVideo(SqlSessionTemplate session, Integer movieNo);
	// 영화 삭제
	public int deleteOneMovie(SqlSessionTemplate session, int movieNo);
	// 영화 삭제 (사진)
	public int deleteOneMovieImg(SqlSessionTemplate session, int movieNo);
	// 영화 삭제 (영상)
	public int deleteOneMovieVideo(SqlSessionTemplate session, int movieNo);
	// 영화 수정
	public int updateMovieData(SqlSessionTemplate session, Movie movie);
	// 영화 수정 (사진수정)
	public int updateMovieImgData(SqlSessionTemplate session, MovieImg movieImg);
	// 영화 수정 (사진삭제)
	public int deleteMovieImg(SqlSessionTemplate session, Integer movieImgNo);
	// 현재 상영 영화
	public List<Movie> selectNowMovie(SqlSessionTemplate session);
	public List<Movie> selectNowMovie(SqlSessionTemplate session, Integer cinemaNo);
	// 현재 상영 영화 등록
	public int insertMovieTime(SqlSessionTemplate session, MovieTime movieTime);
	// 현재 상영 영화 출력
	public List<MovieTime> selectAllMovieTime(SqlSessionTemplate session, Integer theaterNo);
	public List<MovieImg> selectAllMovieImg(SqlSessionTemplate session);
	// 영화 리스트 페이징 처리
	public int selectMovieListCount(SqlSessionTemplate session, String searchValue);
}
