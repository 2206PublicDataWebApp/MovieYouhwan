package kr.co.movieyouhwan.admin.member.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.member.service.AdminMemberService;
import kr.co.movieyouhwan.admin.member.store.AdminMemberStore;
import kr.co.movieyouhwan.user.member.domain.Member;

@Service
public class AdminMemberServiceImpl implements AdminMemberService{

	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private AdminMemberStore aMemberStore;
	
	@Override
	public Member loginManager(Member member) {
		Member aMemberOne = aMemberStore.selectAdminLoginMember(session, member);
		
		return aMemberOne;
	}

}
