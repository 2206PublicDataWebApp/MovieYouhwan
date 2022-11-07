package kr.co.movieyouhwan.user.myPage.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.myPage.store.UserMyStore;
@Repository
public class UserMyStoreLogic implements UserMyStore{
	

	/**
	 * 마이페이지
	 */
	@Override
	public Member selectOneById(SqlSessionTemplate session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}
	
	/**
	 * 회원정보 수정
	 */
	@Override
	public int updateMember(SqlSessionTemplate session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}
	
	/**
	 * 회원정보 수정 / 조회
	 */
	@Override
	public Member selectOneByDetailId(SqlSessionTemplate session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneByDetailId", memberId);
		return null;
	}
}
