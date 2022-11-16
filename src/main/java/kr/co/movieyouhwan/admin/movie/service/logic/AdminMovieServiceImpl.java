package kr.co.movieyouhwan.admin.movie.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.admin.movie.store.AdminMovieStore;
import kr.co.movieyouhwan.common.page.PageInfo;

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
	public List<Movie> printAllMovie(PageInfo pageInfo) {
		List<Movie> mList = aMovieStore.selectAllMovie(session, pageInfo);
		return mList;
	}

	// 현재 상영 영화
	@Override
	public List<Movie> printNowMovie() {
		List<Movie> mList = aMovieStore.selectNowMovie(session);
		return mList;
	}
	
	// 현재 상영 영화
	@Override
	public List<Movie> printNowMovie(Integer cinemaNo) {
		List<Movie> mList = aMovieStore.selectNowMovie(session);
		return mList;
	}
	
	// 영화 검색
	@Override
	public List<Movie> printSearchMovie(String searchName) {
		List<Movie> mList = aMovieStore.selectSearchMovie(session, searchName);
		return mList;
	}
	
	// 영화 상세
	@Override
	public Movie printOneMovie(Integer movieNo) {
		Movie movie = aMovieStore.selectOneMovie(session, movieNo);
		return movie;
	}
	
	// 영화 상세 (사진)
	@Override
	public List<MovieImg> printAllMovieImg(Integer movieNo) {
		List<MovieImg> miList = aMovieStore.selectOneMovieImg(session, movieNo);
		return miList;
	}

	// 영화 상세 (영상)
	@Override
	public List<MovieVideo> printAllMovieVideo(Integer movieNo) {
		List<MovieVideo> mvList = aMovieStore.selectOneMovieVideo(session, movieNo);
		return mvList;
	}
	
	// 현재 상영 영화 출력
	@Override
	public List<MovieTime> printAllMovieTime(Integer theaterNo) {
		List<MovieTime> mtList = aMovieStore.selectAllMovieTime(session, theaterNo); 
		return mtList;
	}

	// 영화 삭제
	@Override
	public int removeOneMovie(int movieNo) {
		int result = aMovieStore.deleteOneMovie(session, movieNo);
		return result;
	}
	
	// 영화 삭제 (사진)
	@Override
	public int removeOneMovieImg(int movieNo) {
		int result = aMovieStore.deleteOneMovieImg(session, movieNo);
		return result;
	}

	// 영화 삭제 (영상)
	@Override
	public int removeOneMovieVideo(int movieNo) {
		int result = aMovieStore.deleteOneMovieVideo(session, movieNo);
		return result;
	}

	// 영화 수정
	@Override
	public int modifyMovieData(Movie movie) {
		int result = aMovieStore.updateMovieData(session, movie);
		return result;
	}
	
	// 영화 수정 (사진수정)
	@Override
	public int modifyMoiveImg(MovieImg movieImg) {
		int result = aMovieStore.updateMovieImgData(session, movieImg);
		return result;
	}

	// 영화 수정 (사진삭제)
	@Override
	public int removeMovieImg(Integer movieImgNo) {
		int result = aMovieStore.deleteMovieImg(session, movieImgNo);
		return result;
	}

	// 현재 상영 영화 관리 등록
	@Override
	public int registerMovieTime(MovieTime movieTime) {
		int result = aMovieStore.insertMovieTime(session, movieTime);
		return result;
	}

	@Override
	public List<MovieImg> printAllMovieImg() {
		List<MovieImg> miList = aMovieStore.selectAllMovieImg(session);
		return miList;
	}

	// 영화 리스트 페이징 처리
	@Override
	public int printMovieListCount() {
		int count = aMovieStore.selectMovieListCount(session);
		return count;
	}
}
