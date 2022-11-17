package kr.co.movieyouhwan.user.myPage.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieTicket;
import kr.co.movieyouhwan.user.myPage.domain.Zzim;

public interface UserMyStore {

	// 마이페이지
	public Member selectOneById(SqlSessionTemplate session, String memberId);
	
	
	// 회원정보 조회 / 수정 페이지
	public Member selectOneByDetailId(SqlSessionTemplate session, String memberId);

	
	// 회원정보 수정
	public int updateMember(SqlSessionTemplate session, Member member);

	// 영화 찜 페이징
	public int selectPrintZzimCount(SqlSessionTemplate session);

	// 영화 찜 목록
	public List<Zzim> selectAllZzimMovie(SqlSessionTemplate session, String memberId);

	// 예매내역
	public List<MovieTicket> selectAllTiketHistory(SqlSessionTemplate session, String memberId);


	/**
	 * 영화찜 카운트
	 */
	public int selectMovieZzimCount(String memberId);


	
	




	

}
