package kr.co.movieyouhwan.user.member.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface UserMemberStore {
	// 회원가입
	public int insertUserMember(SqlSessionTemplate session, Member member);

	// 로그인
	public Member selectLoginMember(SqlSessionTemplate session, Member member);
	
	// 아이디 중복 체크
	public int checkDupId(SqlSessionTemplate session, String memberId);

	// 회원정보 수정
	public int updateMember(SqlSessionTemplate session, Member member);

	// 아이디 찾기
	public List<Member> findId(SqlSessionTemplate session, String memberName, String memberBirth, String memberPhone);

	
}
