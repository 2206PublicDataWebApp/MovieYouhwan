package kr.co.movieyouhwan.user.myPage.service;

import java.util.List;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieTicket;
import kr.co.movieyouhwan.user.myPage.domain.Zzim;

public interface UserMyService {

	// 마이페이지
	public Member printOneById(String memberId);
	
	// 회원 정보 수정
	public int modifyMember(Member member);
	
	// 회원정보 조회 / 수정 페이지
	public Member printOneByDetailId(String memberId);
	
	// 영화 찜 목록 페이징
	public int printZzimCount();

	// 영화 찜 목록
	public List<Zzim> printAllZzimMovie(String memberId);

	// 예매목록
	public List<MovieTicket> printAllTicketHistoryMovie(String memberId);

	// 나의 찜 카운트
	public Zzim selectMovieZzimCount(Zzim zzimCount);



	
	

}
