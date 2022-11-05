package kr.co.movieyouhwan.user.myPage.service;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMyService {

	// 마이페이지
	public Member printOneById(String memberId);
}
