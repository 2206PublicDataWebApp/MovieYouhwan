package kr.co.movieyouhwan.user.movie.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.member.domain.Member;
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

	// 영화관별 상영 영화 출력
	@Override
	public List<Movie> printAllMovieCinema(Integer cinemaNo) {
		List<Movie> mList = uMovieStore.selectAllMovieCinema(session, cinemaNo);
		return mList;
	}
	
	// 예매 현재 상영 영화 출력
	@Override
	public List<Movie> printTicketMovieOne(Integer cinemaNo, Integer movieNo, String movieDay) {
		List<Movie> mList = uMovieStore.selectTicketMovieOne(session, cinemaNo, movieNo, movieDay);
		return mList;
	}

	// 예매 현재 상영 영화 정보 출력
	@Override
	public List<CinemaMovie> printTicketMovieByDay(Integer cinemaNo, Integer movieNo, String movieDay) {
		List<CinemaMovie> cmList = uMovieStore.selectTicketMovieByDay(session, cinemaNo, movieNo, movieDay);
		return cmList;
	}

	// 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	@Override
	public Member printBuyerInfo(String memberId) {
		Member buyerInfo = uMovieStore.selectBuyerInfo(session, memberId);
		return buyerInfo;
	}
}
