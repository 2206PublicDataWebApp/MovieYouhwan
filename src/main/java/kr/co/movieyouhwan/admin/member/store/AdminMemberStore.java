package kr.co.movieyouhwan.admin.member.store;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.user.member.domain.Member;

public interface AdminMemberStore {

	public Member selectAdminLoginMember(SqlSessionTemplate session, Member member);

}
