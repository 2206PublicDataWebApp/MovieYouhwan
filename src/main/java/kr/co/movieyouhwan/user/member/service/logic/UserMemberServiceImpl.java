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
	
	@Override
	public Member selectMember(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int modifyPassword(String memberId, String memberEmail) {
		int result = uMemberStore.modifyPassword(session, memberId, memberEmail);
		return result;
	}
	

//	}
//	@Override
//	public void certifiedPhoneNumber(String memberPhone, int randomNumber) {
//		String apiKey = "NCSRIFPKA6RUHB6S";
//		String apiSecret = "ZLR0RL0FFNHCKVPOHWN8NSFK866BWOKF";
//		Message coolsms = new Message(apiKey, apiSecret);
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("toTellNumber", memberPhone);    // 수신전화번호
//	    params.put("fromTellNumer", "01062204048");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
//	    params.put("type", "SMS");
//	    params.put("text", "[TEST] 인증번호는" + "["+randomNumber+"]" + "입니다."); // 문자 내용 입력
//	    params.put("app_version", "test app 1.2"); // application name and version
//	}
//	
}
