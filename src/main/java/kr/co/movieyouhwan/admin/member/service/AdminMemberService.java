package kr.co.movieyouhwan.admin.member.service;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface AdminMemberService {

	// 관리자 로그인
	public Member loginManager(Member member);

}
