package kr.co.movieyouhwan.user.member.store;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMemberStore {
	// 회원가입
	public int insertUserMember(SqlSession session, Member member);

	// 로그인
	public Member selectLoginMember(SqlSessionTemplate session, Member member);
	
	// 아이디 중복 체크
	public int checkDupId(SqlSessionTemplate session, String memberId);
	
	
}
