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

	

}
