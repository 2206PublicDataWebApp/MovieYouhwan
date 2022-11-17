package kr.co.movieyouhwan.user.movie.service;

import java.util.List;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieChart;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.domain.MovieReview;
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
	// 마이찜여부
	public List<Integer> printMyZzimMovieList(String memberId);
	// 예매 내역 등록
	public int registerMovieTicket(MovieTicket movieTicket);
	public List<MovieReview> printMovieReview(Integer movieNo);
	public int registerMovieReview(MovieReview review);
	public int checkReviewExist(String memberId, Integer movieNo);
	// 회원 테이블 포인트 업데이트
	public int modifyMemberPoint(String memberId, Integer userPoint);
	
	/**
	 * 배너 동영상 번호 리스트 불러오기
	 * @return
	 */
	public List<Integer> printBannerVideoNoList();
	/**
	 * 타겟 배너 동영상 저장명 불러오기
	 * @param targetVideoNo
	 * @return
	 */
	public String printBannerVideoRenameByVideoNo(int videoNo);
	/**
	 * 영화 차트 리스트 불러오기
	 * @param movieChartCount
	 * @return
	 */
	public List<MovieChart> printMovieChartList(int top);
}
