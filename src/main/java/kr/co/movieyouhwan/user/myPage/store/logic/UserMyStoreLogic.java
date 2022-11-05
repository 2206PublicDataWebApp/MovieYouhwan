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
}
