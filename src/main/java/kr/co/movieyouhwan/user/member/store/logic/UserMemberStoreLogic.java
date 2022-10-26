package kr.co.movieyouhwan.user.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.member.store.UserMemberStore;

@Repository
public class UserMemberStoreLogic implements UserMemberStore {
	private SqlSessionTemplate session;
	
	public UserMemberStoreLogic() {
		
	}
	
	public void setSqlSession(SqlSessionTemplate session) {
		this.session = session;
	}
	/**
	 * 회원가입
	 */
	@Override
	public int insertUserMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}
}

	
