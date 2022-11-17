package kr.co.movieyouhwan.admin.member.service;

import java.util.List;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface AdminMemberService {

	// 관리자 로그인
	public Member loginManager(Member member);

	// 전체 게시글 수 페이징
	public int getTotalCount(String searchCondition, String searchValue);

	// 회원 리스트
	public List<Member> printAllMember(int currentPage, int listLimit);

	// 검색
	public List<Member> selectOneMember(String searchCondition, String searchValue, int currentPage, int listLimit);

}
