package kr.co.movieyouhwan.user.member.service;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMemberService {
	// 로그인
	public Member loginMember(Member member);
	
	// 회원가입
	public int registerMember(Member member);
	
	// 아이디 중복 체크 checkIdDuplicate
	public int checkDupId(String memberId);

	// 회원정보 수정
	public int modifyMember(Member member);

	
}
