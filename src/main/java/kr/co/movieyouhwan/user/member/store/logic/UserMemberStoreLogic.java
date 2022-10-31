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
	/**
	 * 로그인 
	 */
	@Override
	public Member selectLoginMember(SqlSessionTemplate session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectLoginOne", member);
		return mOne;
	}
	
	/**
	 * 아이디 중복 체크
	 */
	@Override
	public int checkDupId(SqlSessionTemplate session, String memberId) {
		int result = session.selectOne("MemberMapper.checkIdDuplicate", memberId);
		return result;
	}
	
	// 회원정보 수정
	@Override
	public int updateMember(SqlSessionTemplate session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}
}

	
