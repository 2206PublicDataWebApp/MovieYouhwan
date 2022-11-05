package kr.co.movieyouhwan.user.myPage.store;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMyStore {
	
	
	// 마이페이지
	public Member selectOneById(SqlSessionTemplate session, String memberId);
	

}
