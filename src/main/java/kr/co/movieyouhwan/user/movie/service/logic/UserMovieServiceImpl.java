package kr.co.movieyouhwan.user.movie.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieChart;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.domain.MovieReview;
import kr.co.movieyouhwan.user.movie.domain.MovieTicket;
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

	// 회원 테이블 포인트 업데이트 (김미소)
	@Override
	public int modifyMemberPoint(String memberId, Integer userPoint) {
		int result = uMovieStore.updateMemberPoint(session, memberId, userPoint);
		return result;
	}

	// 나의 찜 여부
	@Override
	public List<Integer> printMyZzimMovieList(String memberId) {
		List<Integer> myZzimMovieList = uMovieStore.selectMyZzimMovieList(session, memberId);
		return myZzimMovieList;
	}

	// 예매 내역 등록
	@Override
	public int registerMovieTicket(MovieTicket movieTicket) {
		int result = uMovieStore.insertMovieTicket(session, movieTicket);
		return result;
	}

	@Override
	public List<MovieReview> printMovieReview(Integer movieNo) {
		List<MovieReview> movieReviewList=uMovieStore.selectMovieReview(session, movieNo);
		return movieReviewList;
	}

	@Override
	public int registerMovieReview(MovieReview review) {
		int result=uMovieStore.insertMovieReview(session, review);
		return result;
	}

	@Override
	public int checkReviewExist(String memberId, Integer movieNo) {
		int result=uMovieStore.selectMovieReviewCount(session, memberId, movieNo);
		return result;
	}

	// 배너 동영상 번호 리스트 불러오기
	@Override
	public List<Integer> printBannerVideoNoList() {
		List<Integer> videoNoList = uMovieStore.selectBannerVideoNoList(session);
		return videoNoList;
	}

	// 타겟 배너 동영상 저장명 불러오기
	@Override
	public String printBannerVideoRenameByVideoNo(int videoNo) {
		String videoRename = uMovieStore.selectBannerVideoRenameByVideoNo(session, videoNo);
		return videoRename;
	}

	// 영화 차트 리스트 불러오기
	@Override
	public List<MovieChart> printMovieChartList(int top) {
		List<MovieChart> movieList = uMovieStore.selectMovieChartList(session, top);
		return movieList;
	}
	
	@Override
	public MovieReview printOneMovieReview(String memberId, Integer movieNo) {
		MovieReview myMovieReview=uMovieStore.selectMovieReview(session, memberId, movieNo);
		return myMovieReview;
	}

	@Override
	public int deleteReview(Integer movieNo, String memberId) {
		int result=uMovieStore.deleteMovieReview(session, memberId, movieNo);
		return result;
	}

	@Override
	public int modifyReview(MovieReview movieReview) {
		int result=uMovieStore.updateMovieReview(session, movieReview);
		return result;
	}
	// 날짜별 영화 출력
	@Override
	public List<MovieList> printTicketTimeChoice(Integer cinemaNo, Integer movieNo, String movieDay) {
		List<MovieList> mlList = uMovieStore.selectTicketTimeChoice(session, cinemaNo, movieNo, movieDay);
		return mlList;
	}

}
