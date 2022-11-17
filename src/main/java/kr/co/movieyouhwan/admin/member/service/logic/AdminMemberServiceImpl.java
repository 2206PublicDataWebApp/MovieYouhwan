package kr.co.movieyouhwan.admin.member.service.logic;

import java.util.List;

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
	
	// 관리자 로그인
	@Override
	public Member loginManager(Member member) {
		Member aMemberOne = aMemberStore.selectAdminLoginMember(session, member);
		
		return aMemberOne;
	}

	// 페이징
	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = aMemberStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	// 회원 리스트
	@Override
	public List<Member> printAllMember(int currentPage, int listLimit) {
		List<Member> aMemberList = aMemberStore.selectAllMember(session, currentPage, listLimit);
		return aMemberList;
	}

	// 조건 검색
	@Override
	public List<Member> selectOneMember(String searchCondition, String searchValue, int currentPage, int listLimit) {
		List<Member> aMemberList = aMemberStore.selectOneByValue(session, searchCondition, searchValue, currentPage, listLimit);
		return aMemberList;
	}

}
