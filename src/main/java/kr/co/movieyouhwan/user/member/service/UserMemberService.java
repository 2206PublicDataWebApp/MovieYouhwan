package kr.co.movieyouhwan.user.member.service;

import java.util.List;

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

	// 아이디 찾기
	public List<Member> findId(String memberName, String memberBirth, String memberPhone);

	// 패스워드 찾기
	public List<Member> findPassword(String memberId, String memberPhone);

	// 휴대폰 인증
	public void certifiedPhoneNumber(String memberPhone, int randomNumber);
		
	
}
