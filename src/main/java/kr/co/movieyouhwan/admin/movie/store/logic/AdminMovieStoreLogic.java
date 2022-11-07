package kr.co.movieyouhwan.admin.movie.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
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

	// 현재 상영 영화
	@Override
	public List<Movie> selectNowMovie(SqlSessionTemplate session) {
		List<Movie> mList = session.selectList("MovieMapper.selectNowMovie");
		return mList;
	}
	
	// 현재 상영 영화
	@Override
	public List<Movie> selectNowMovie(SqlSessionTemplate session, Integer cinemaNo) {
		List<Movie> mList = session.selectList("MovieMapper.selectNowMovieCinema", cinemaNo);
		return mList;
	}
	
	// 영화 검색
	@Override
	public List<Movie> selectSearchMovie(SqlSessionTemplate session, String searchName) {
		List<Movie> mList = session.selectList("MovieMapper.selectSearchMovie", searchName);
		return mList;
	}

	// 영화 상세
	@Override
	public Movie selectOneMovie(SqlSessionTemplate session, Integer movieNo) {
		Movie movie = session.selectOne("MovieMapper.selectOntMovie", movieNo);
		return movie;
	}

	// 영화 상세 (사진)
	@Override
	public List<MovieImg> selectOneMovieImg(SqlSessionTemplate session, Integer movieNo) {
		List<MovieImg> miList = session.selectList("MovieMapper.selectAllMovieImg", movieNo);
		return miList;
	}

	// 영화 상세 (영상)
	@Override
	public List<MovieVideo> selectOneMovieVideo(SqlSessionTemplate session, Integer movieNo) {
		List<MovieVideo> mvList = session.selectList("MovieMapper.selectAllMovieVideo", movieNo);
		return mvList;
	}
	
	// 현재 상영 영화 출력
	@Override
	public List<MovieTime> selectAllMovieTime(SqlSessionTemplate session, Integer theaterNo) {
		List<MovieTime> mtList = session.selectList("MovieMapper.selectAllMovieTime", theaterNo);
		return mtList;
	}

	// 영화 삭제
	@Override
	public int deleteOneMovie(SqlSessionTemplate session, int movieNo) {
		int result = session.delete("MovieMapper.deleteOneMovie", movieNo);
		return result;
	}

	// 영화 삭제 (사진)
	@Override
	public int deleteOneMovieImg(SqlSessionTemplate session, int movieNo) {
		int result = session.delete("MovieMapper.deleteOneMovieImg", movieNo);
		return result;
	}

	// 영화 삭제 (영상)
	@Override
	public int deleteOneMovieVideo(SqlSessionTemplate session, int movieNo) {
		int result = session.delete("MovieMapper.deleteOneMovieVideo", movieNo);
		return result;
	}

	// 영화 수정
	@Override
	public int updateMovieData(SqlSessionTemplate session, Movie movie) {
		int result = session.update("MovieMapper.updateOneMovie", movie);
		return result;
	}

	// 영화 수정 (사진수정)
	@Override
	public int updateMovieImgData(SqlSessionTemplate session, MovieImg movieImg) {
		int result = session.update("MovieMapper.updateOneMovieImg", movieImg);
		return result;
	}
	
	// 영화 수정 (사진삭제)
	@Override
	public int deleteMovieImg(SqlSessionTemplate session, Integer movieImgNo) {
		int result = session.delete("MovieMapper.deleteMovieImg", movieImgNo);
		return result;
	}
	
	// 현재 상영 영화 등록
	@Override
	public int insertMovieTime(SqlSessionTemplate session, MovieTime movieTime) {
		int result = session.insert("MovieMapper.insertMovieTime", movieTime);
		return result;
	}

	@Override
	public List<MovieImg> selectAllMovieImg(SqlSessionTemplate session) {
		List<MovieImg> miList = session.selectList("MovieMapper.selectAllMovieImg");
		return miList;
	}
}