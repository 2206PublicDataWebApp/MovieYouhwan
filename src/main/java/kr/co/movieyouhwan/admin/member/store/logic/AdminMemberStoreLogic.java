package kr.co.movieyouhwan.admin.member.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.member.store.AdminMemberStore;
import kr.co.movieyouhwan.user.member.domain.Member;

@Repository
public class AdminMemberStoreLogic implements AdminMemberStore {
	private SqlSessionTemplate session;
	
	/**
	 * 로그인
	 */
	@Override
	public Member selectAdminLoginMember(SqlSessionTemplate session, Member member) {
		Member aMemberOne = session.selectOne("MemberMapper.selectAdminLogin", member);
		return aMemberOne;
	}

	/**
	 * 전체 회원 수 
	 *
	 */
	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String>paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("MemberMapper.selectMemberTotalCount", paramMap);
		return totalCount;
	}
	/**
	 * 회원리스트
	 * 
	 */
	@Override
	public List<Member> selectAllMember(SqlSessionTemplate session, int currentPage, int listLimit) {
		int offset = (currentPage-1)*listLimit;
		RowBounds rowBounds = new RowBounds(offset, listLimit);
		List<Member> aMemberList = session.selectList("MemberMapper.selectAllMember", null, rowBounds);
		return aMemberList;
	}
	
	/**
	 * 조건검색
	 */
	@Override
	public List<Member> selectOneByValue(SqlSessionTemplate session, String searchCondition, String searchValue,int currentPage, int listLimit) {
		int offset = (currentPage-1) * listLimit;
		RowBounds rowBounds = new RowBounds(offset, listLimit);
		HashMap<String, String>paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		List<Member> aMemberList = session.selectList("MemberMapper.selectOneByValue", paramMap, rowBounds);
		return aMemberList;
	}

	
}
