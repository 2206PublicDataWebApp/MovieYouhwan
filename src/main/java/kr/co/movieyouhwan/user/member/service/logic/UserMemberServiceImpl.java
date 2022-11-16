package kr.co.movieyouhwan.user.member.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.member.service.UserMemberService;
import kr.co.movieyouhwan.user.member.store.UserMemberStore;
@Service
public class UserMemberServiceImpl implements UserMemberService {
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private UserMemberStore uMemberStore;
	
	/**
	 * 회원가입
	 */
	@Override
	public int registerMember(Member member) {
		int result = uMemberStore.insertUserMember(session, member);
		return result;
		
	}
	/**
	 * 로그인
	 */
	@Override
	public Member loginMember(Member member) {
		Member mOne = uMemberStore.selectLoginMember(session, member);
		return mOne;
	}
	
	
	/**
	 * 아이디 중복 체크
	 */
	@Override
	public int checkDupId(String memberId) {
		int result = uMemberStore.checkDupId(session, memberId);
		return result;
	}
	
	/**
	 * 회원정보 수정
	 */
	@Override
	public int modifyMember(Member member) {
		int result = uMemberStore.updateMember(session, member);
		return result;
	}
	/**
	 * 아이디 찾기
	 */
	@Override
	public List<Member> findId(String memberName, String memberBirth, String memberPhone) {
		List<Member> uMemberList = uMemberStore.findId(session, memberName, memberBirth, memberPhone);
		return uMemberList;
	}
	

	
	// 패스워드 변경, 회원정보 조회
	@Override
	public List<Member> modifyPassword(String memberId, String memberEmail) {
		List<Member> uMemberList = uMemberStore.modifyPassword(session, memberId, memberEmail);
		return uMemberList;
	}
	
	/**
	 * 패스워드 재설정
	 */
	@Override
	public int pwUpdate(Member member) {
		int result = uMemberStore.updatePw(session, member);
		return result;
	}

	

	
}
