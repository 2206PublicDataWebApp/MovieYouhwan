package kr.co.movieyouhwan.user.myPage.store;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMyStore {

	// 마이페이지
	public Member selectOneById(SqlSessionTemplate session, String memberId);
	
	// 회원정보 수정
	public int updateMember(SqlSessionTemplate session, Member member);

	// 회원정보 조회 / 수정 페이지
	public Member selectOneByDetailId(SqlSessionTemplate session, String memberId);
	

}
