package kr.co.movieyouhwan.user.myPage.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.myPage.service.UserMyService;
import kr.co.movieyouhwan.user.myPage.store.UserMyStore;
@Service
public class UserMyServiceImpl implements UserMyService{
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private UserMyStore uMyStore;
	
	/**
	 * 마이페이지 Top
	 */
	@Override
	public Member printOneById(String memberId) {
		Member member = uMyStore.selectOneById(session, memberId);
		return member;
	}
	
	/**
	 * 회원정보 수정
	 */
	@Override
	public int modifyMember(Member member) {
		int result = uMyStore.updateMember(session, member);
		return result;
	}
	/**
	 *  회원정보 조회 / 수정 페이지
	 */
	@Override
	public Member printOneByDetailId(String memberId) {
		Member member = uMyStore.selectOneByDetailId(session, memberId);
		return member;
	}

	

}
