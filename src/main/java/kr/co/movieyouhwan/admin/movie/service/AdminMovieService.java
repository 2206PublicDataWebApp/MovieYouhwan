package kr.co.movieyouhwan.admin.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
import kr.co.movieyouhwan.common.page.PageInfo;

public interface AdminMovieService {
	// 영화 등록
	public int registerMovie(Movie movie);
	// 영화 사진 등록
	public int registerMovieImg(MovieImg movieImg);
	// 영화 영상 등록
	public int registerMovieVideo(MovieVideo movieVideo);
	// 영화 목록
	public List<Movie> printAllMovie(PageInfo pageInfo);
	// 영화 검색
	public List<Movie> printSearchMovie(String searchName);
	// 영화 상세
	public Movie printOneMovie(Integer movieNo);
	// 영화 상세 (사진)
	public List<MovieImg> printAllMovieImg(Integer movieNo);
	// 상영 영화 이미지 전부 출력
	public List<MovieImg> printAllMovieImg();
	// 영화 상세 (영상)
	public List<MovieVideo> printAllMovieVideo(Integer movieNo);
	// 영화 삭제
	public int removeOneMovie(int movieNo);
	// 영화 삭제 (사진)
	public int removeOneMovieImg(int movieNo);
	// 영화 삭제 (영상)
	public int removeOneMovieVideo(int movieNo);
	// 영화 수정
	public int modifyMovieData(Movie movie);
	// 영화 수정 (사진수정)
	public int modifyMoiveImg(MovieImg movieImg);
	// 영화 수정 (사진삭제)
	public int removeMovieImg(Integer movieImgNo);
	// 현재 상영 영화 출력
	public List<Movie> printNowMovie();
	public List<Movie> printNowMovie(Integer cinemaNo);
	// 상영 영화 등록
	public int registerMovieTime(MovieTime movieTime);
	// 상영 영화 목록 출력
	public List<MovieTime> printAllMovieTime(Integer theaterNo);
	// 영화 리스트 페이징 처리
	public int printMovieListCount();
}
