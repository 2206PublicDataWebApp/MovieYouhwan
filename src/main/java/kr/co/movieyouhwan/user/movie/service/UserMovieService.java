package kr.co.movieyouhwan.user.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.domain.MovieTicket;

public interface UserMovieService {
	// 현재 상영 영화 리스트
	public List<MovieList> printAllMovieNow();
	// 현재 상영 영화 리스트 페이징 처리
	public int printNowMovieCount();
	// 상영 예정 영화 리스트
	public List<MovieList> printAllMovieAfter();
	// 상영 예정 영화 리스트 페이징 처리
	public int printAfterMovieCount();
	// 상영 종료 영화 리스트
	public List<MovieList> printAllMovieBefore();
	// 상영 종료 영화 리스트 페이징 처리
	public int printBeforeMovieCount();
	// 영화 검색 리스트
	public List<MovieList> printAllMovie();
	// 영화 검색 기능
	public List<MovieList> printSearchMovie(String searchName);
	// 영화관별 상영 영화 출력
	public List<Movie> printAllMovieCinema(Integer cinemaNo);
	// 예매 현재 상영 영화 출력
	public List<Movie> printTicketMovieOne(Integer cinemaNo, Integer movieNo, String movieDay);
	// 예매 현재 상영 영화 정보 출력
	public List<CinemaMovie> printTicketMovieByDay(Integer cinemaNo, Integer movieNo, String movieDay);
	// 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	public Member printBuyerInfo(String memberId);
	// 예매 내역 등록
	public int registerMovieTicket(MovieTicket movieTicket);
}
