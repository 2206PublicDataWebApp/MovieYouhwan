package kr.co.movieyouhwan.admin.member.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface AdminMemberStore {

	// 어드민 로긴
	public Member selectAdminLoginMember(SqlSessionTemplate session, Member member);

	// 전체게시물 수  페이징
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue);
	
	// 회원 리스트
	public List<Member> selectAllMember(SqlSessionTemplate session, int currentPage, int listLimit);

	// 게시글 조건 검색
	public List<Member> selectOneByValue(SqlSessionTemplate session, String searchCondition, String searchValue,
			int currentPage, int listLimit);


}
