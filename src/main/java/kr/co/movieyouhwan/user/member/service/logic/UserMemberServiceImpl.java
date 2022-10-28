package kr.co.movieyouhwan.user.member.service.logic;

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
	
}
