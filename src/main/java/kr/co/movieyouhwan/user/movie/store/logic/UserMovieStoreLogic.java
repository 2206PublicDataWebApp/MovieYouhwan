package kr.co.movieyouhwan.user.movie.store.logic;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieChart;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.domain.MovieReview;
import kr.co.movieyouhwan.user.movie.domain.MovieTicket;
import kr.co.movieyouhwan.user.movie.store.UserMovieStore;

@Repository
public class UserMovieStoreLogic implements UserMovieStore {
	// 현재 상영 영화 리스트
	@Override
	public List<MovieList> selectAllMovieNow(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieNow");
		return mlList;
	}

	// 현재 상영 영화 리스트 페이징 처리
	@Override
	public int selectNowMovieCount(SqlSessionTemplate session) {
		int count = session.selectOne("MovieMapper.selectNowMovieCount");
		return count;
	}

	// 상영 예정 영화 리스트
	@Override
	public List<MovieList> selectAllMovieAfter(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieAfter");
		return mlList;
	}

	// 상영 예정 영화 리스트 페이징 처리
	@Override
	public int selectAfterMovieCount(SqlSessionTemplate session) {
		int count = session.selectOne("MovieMapper.selectAfterMovieCount");
		return count;
	}

	// 상영 종료 영화 리스트
	@Override
	public List<MovieList> selectAllMovieBefore(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieBefore");
		return mlList;
	}

	// 상영 종료 영화 리스트 페이징 처리
	@Override
	public int selectBeforeMovieCount(SqlSessionTemplate session) {
		int count = session.selectOne("MovieMapper.selectBeforeMovieCount");
		return count;
	}

	// 영화 검색 완료 리스트
	@Override
	public List<MovieList> selectAllMovie(SqlSessionTemplate session) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectAllMovieList");
		return mlList;
	}

	// 영화 검색 기능
	@Override
	public List<MovieList> selectSearchMovie(SqlSessionTemplate session, String searchName) {
		List<MovieList> mlList = session.selectList("MovieMapper.selectSearchMovieList", searchName);
		return mlList;
	}

	// 영화관별 상영 영화 출력
	@Override
	public List<Movie> selectAllMovieCinema(SqlSessionTemplate session, Integer cinemaNo) {
		List<Movie> mList = session.selectList("MovieMapper.selectAllMovieCinema", cinemaNo);
		return mList;
	}

	// 예매 현재 상영 영화 출력
	@Override
	public List<Movie> selectTicketMovieOne(SqlSessionTemplate session, Integer cinemaNo, Integer movieNo,
			String movieDay) {
		HashMap<String, String> ticketMovieMap = new HashMap<>();
		ticketMovieMap.put("cinemaNo", cinemaNo.toString());
		ticketMovieMap.put("movieNo", movieNo.toString());
		ticketMovieMap.put("movieDay", movieDay);
		List<Movie> mList = session.selectList("MovieMapper.selectTicketMovieOne", ticketMovieMap);
		return mList;
	}

	// 예매 현재 상영 영화 정보 출력
	@Override
	public List<CinemaMovie> selectTicketMovieByDay(SqlSessionTemplate session, Integer cinemaNo, Integer movieNo,
			String movieDay) {
		HashMap<String, String> ticketMovieMap = new HashMap<>();
		ticketMovieMap.put("cinemaNo", cinemaNo.toString());
		ticketMovieMap.put("movieNo", movieNo.toString());
		ticketMovieMap.put("movieDay", movieDay);
		List<CinemaMovie> cmList = session.selectList("MovieMapper.selectTicketMovieByDay", ticketMovieMap);
		return cmList;
	}

	// 결제를 위한 회원 이름, 휴대폰 번호, 이메일 불러오기
	@Override
	public Member selectBuyerInfo(SqlSessionTemplate session, String memberId) {
		Member buyerInfo = session.selectOne("MemberMapper.selectBuyerInfo", memberId);
		return buyerInfo;
	}

	// 나의 찜 여부
	@Override
	public List<Integer> selectMyZzimMovieList(SqlSessionTemplate session, String memberId) {
		List<Integer> myZzimMovieList = session.selectList("MemberMapper.myZzimList", memberId);
		return myZzimMovieList;
	}

	// 예매 내역 등록
	@Override
	public int insertMovieTicket(SqlSessionTemplate session, MovieTicket movieTicket) {
		int result = session.insert("MovieMapper.insertMovieTicket", movieTicket);
		return result;
	}

	@Override
	public List<MovieReview> selectMovieReview(SqlSessionTemplate session, Integer movieNo) {
		List<MovieReview> movieReviewList = session.selectList("MovieMapper.selectMovieReview", movieNo);
		return movieReviewList;
	}

	@Override
	public int insertMovieReview(SqlSessionTemplate session, MovieReview review) {
		int result = session.insert("MovieMapper.insertMovieReview", review);
		return result;
	}

	@Override
	public int selectMovieReviewCount(SqlSessionTemplate session, String memberId, Integer movieNo) {
		HashMap<String, String> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("movieNo", movieNo.toString());
		int result = session.selectOne("MovieMapper.selectMovieReviewCount", param);
		return result;
	}

	// 회원 테이블 포인트 업데이트
	@Override
	public int updateMemberPoint(SqlSessionTemplate session, String memberId, Integer userPoint) {
		HashMap<String, String> memberPointMap = new HashMap<>();
		memberPointMap.put("memberId", memberId);
		memberPointMap.put("userPoint", userPoint.toString());
		int result = session.update("MovieMapper.updateMemberPoint", memberPointMap);
		return result;
	}

	// 배너 동영상 번호 리스트 불러오기
	@Override
	public List<Integer> selectBannerVideoNoList(SqlSessionTemplate session) {
		List<Integer> videoNoList = session.selectList("MovieMapper.selectBannerVideoNoList");
		return videoNoList;
	}

	// 타겟 배너 동영상 저장명 불러오기
	@Override
	public String selectBannerVideoRenameByVideoNo(SqlSessionTemplate session, int videoNo) {
		String videoRename = session.selectOne("MovieMapper.selectBannerVideoRenameByVideoNo", videoNo);
		return videoRename;
	}

	// 영화 차트 리스트 불러오기
	@Override
	public List<MovieChart> selectMovieChartList(SqlSessionTemplate session, int top) {
		List<MovieChart> movieList = session.selectList("MovieMapper.selectMovieChartList", top);
		return movieList;
	}
	
	@Override
	public MovieReview selectMovieReview(SqlSessionTemplate session, String memberId, Integer movieNo) {
		HashMap<String, String> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("movieNo", movieNo.toString());
		MovieReview myMovieReview=session.selectOne("MovieMapper.selectOneMovieReview",param);
		return myMovieReview;
	}

	@Override
	public int deleteMovieReview(SqlSessionTemplate session, String memberId, Integer movieNo) {
		HashMap<String,String> param=new HashMap<>();
		param.put("memberId", memberId);
		param.put("movieNo", movieNo.toString());
		int result=session.delete("MovieMapper.deleteMovieReview", param);
		return result;
	}

	@Override
	public int updateMovieReview(SqlSessionTemplate session, MovieReview movieReview) {
		int result=session.update("MovieMapper.updateMovieReview", movieReview);
		return result;
	}
	// 날짜별 영화 출력
	@Override
	public List<MovieList> selectTicketTimeChoice(SqlSessionTemplate session, Integer cinemaNo, Integer movieNo, String movieDay) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("cinemaNo", cinemaNo);
		paramMap.put("movieNo", movieNo);
		paramMap.put("movieDay", movieDay);
		List<MovieList> mlList = session.selectList("MovieMapper.selectTicketTimeChocie", paramMap);
		return mlList;
	}
}
