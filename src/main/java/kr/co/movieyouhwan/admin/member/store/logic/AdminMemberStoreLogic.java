package kr.co.movieyouhwan.admin.member.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.member.store.AdminMemberStore;
import kr.co.movieyouhwan.user.member.domain.Member;

@Repository
public class AdminMemberStoreLogic implements AdminMemberStore {
	private SqlSessionTemplate session;
	
	/**
	 * 로그인
	 */
	@Override
	public Member selectAdminLoginMember(SqlSessionTemplate session, Member member) {
		Member aMemberOne = session.selectOne("MemberMapper.selectAdminLogin", member);
		return aMemberOne;
	}

}
