package kr.co.movieyouhwan.user.myPage.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieTicket;
import kr.co.movieyouhwan.user.myPage.domain.Zzim;
import kr.co.movieyouhwan.user.myPage.service.UserMyService;
import kr.co.movieyouhwan.user.myPage.store.UserMyStore;
@Service
public class UserMyServiceImpl implements UserMyService{
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private UserMyStore uMyStore;
	
	/**
	 * 마이페이지 Top
	 */
	@Override
	public Member printOneById(String memberId) {
		Member member = uMyStore.selectOneById(session, memberId);
		return member;
	}
	
	/**
	 * 회원정보 수정
	 */
	@Override
	public int modifyMember(Member member) {
		int result = uMyStore.updateMember(session, member);
		return result;
	}
	/**
	 *  회원정보 조회 / 수정 페이지
	 */
	@Override
	public Member printOneByDetailId(String memberId) {
		Member member = uMyStore.selectOneByDetailId(session, memberId);
		return member;
	}
	
	/**
	 * 영화 찜 페이징 
	 */
	@Override
	public int printZzimCount() {
		int count = uMyStore.selectPrintZzimCount(session);
		return count;
	}
	/**
	 * 영화 찜 목록
	 */
	@Override
	public List<Zzim> printAllZzimMovie(String memberId) {
		List<Zzim> uZzimList = uMyStore.selectAllZzimMovie(session, memberId);
		return uZzimList;
	}

	/**
	 * 예매내역
	 */
	@Override
	public List<MovieTicket> printAllTicketHistoryMovie(String memberId) {
		List<MovieTicket> uMovieTicketList = uMyStore.selectAllTiketHistory(session, memberId);
		return uMovieTicketList;
	}

	/**
	 * 나의 찜 카운트
	 * 
	 */
	@Override
	public Zzim selectMovieZzimCount(Zzim zzimCount) {
		Zzim myZzimCount = uMyStore.selectMovieZzimCount(zzimCount);
		return myZzimCount;
	}


	

}
