package kr.co.movieyouhwan.user.myPage.service;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMyService {

	// 마이페이지
	public Member printOneById(String memberId);
	
	// 회원 정보 수정
	public int modifyMember(Member member);
	
	// 회원정보 조회 / 수정 페이지
	public Member printOneByDetailId(String memberId);
	
}
