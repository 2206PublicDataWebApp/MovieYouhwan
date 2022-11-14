package kr.co.movieyouhwan.user.movie.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieList;

public interface UserMovieStore {
	// 현재 상영 영화 리스트
	public List<MovieList> selectAllMovieNow(SqlSessionTemplate session);
	// 현재 상영 영화 리스트 페이징 처리
	public int selectNowMovieCount(SqlSessionTemplate session);
	// 상영 예정 영화 리스트
	public List<MovieList> selectAllMovieAfter(SqlSessionTemplate session);
	// 상영 예정 영화 리스트 페이징 처리
	public int selectAfterMovieCount(SqlSessionTemplate session);
	// 상영 종료 영화 리스트
	public List<MovieList> selectAllMovieBefore(SqlSessionTemplate session);
	// 상영 종료 영화 리스트 페이징 처리
	public int selectBeforeMovieCount(SqlSessionTemplate session);
	// 영화 검색 리스트
	public List<MovieList> selectAllMovie(SqlSessionTemplate session);
	// 영화 검색 기능
	public List<MovieList> selectSearchMovie(SqlSessionTemplate session, String searchName);
	// 영화관별 상영 영화 출력
	public List<Movie> selectAllMovieCinema(SqlSessionTemplate session, Integer cinemaNo);
	// 예매 현재 상영 영화 출력	
	public List<Movie> selectTicketMovieOne(SqlSessionTemplate session, Integer cinemaNo, Integer movieNo, String movieDay);
	// 예매 현재 상영 영화 정보 출력
	public List<CinemaMovie> selectTicketMovieByDay(SqlSessionTemplate session, Integer cinemaNo, Integer movieNo, String movieDay);
	// 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	public Member selectBuyerInfo(SqlSessionTemplate session, String memberId);
}
