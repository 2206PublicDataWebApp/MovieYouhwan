package kr.co.movieyouhwan.user.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMemberStore {
	
	public int insertUserMember(SqlSession session, Member member);
	
	
}
