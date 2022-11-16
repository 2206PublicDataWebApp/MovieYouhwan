package kr.co.movieyouhwan.user.member.domain;

import java.util.Date;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberNick;
	private String memberBirth;
	private String memberGender;
	private String memberPhone;
	private String memberEmail;
	private String memberImgName;
	private String memberImgRename;
	private String memberImgPath;
	private Date memberSignUpDate;
	private String memberLevel;	// 회원 등급
	private int memberPoint;
	private int socialCode;
	private String socialType;
	private String memberYn;	// 회원존재 여부
	private String mateStatus;		// 메이브 서비스 사용 여부
	private int mateReportCount;	// 신고받은 횟수
	private Date mateRestartDate;	// 메이트 신고 해제일
	private String memberType;		// 회원 구분
	
	public Member(){}

	public Member(String memberId, String memberPwd, String memberName, String memberNick, String memberBirth,
			String memberGender, String memberPhone, String memberEmail, String memberImgName, String memberImgRename,
			String memberImgPath, Date memberSignUpDate, String memberLevel, int memberPoint, int socialCode,
			String socialType, String memberYn, String mateStatus, int mateReportCount, Date mateRestartDate,
			String memberType) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberNick = memberNick;
		this.memberBirth = memberBirth;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberImgName = memberImgName;
		this.memberImgRename = memberImgRename;
		this.memberImgPath = memberImgPath;
		this.memberSignUpDate = memberSignUpDate;
		this.memberLevel = memberLevel;
		this.memberPoint = memberPoint;
		this.socialCode = socialCode;
		this.socialType = socialType;
		this.memberYn = memberYn;
		this.mateStatus = mateStatus;
		this.mateReportCount = mateReportCount;
		this.mateRestartDate = mateRestartDate;
		this.memberType = memberType;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberImgName() {
		return memberImgName;
	}

	public void setMemberImgName(String memberImgName) {
		this.memberImgName = memberImgName;
	}

	public String getMemberImgRename() {
		return memberImgRename;
	}

	public void setMemberImgRename(String memberImgRename) {
		this.memberImgRename = memberImgRename;
	}

	public String getMemberImgPath() {
		return memberImgPath;
	}

	public void setMemberImgPath(String memberImgPath) {
		this.memberImgPath = memberImgPath;
	}

	public Date getMemberSignUpDate() {
		return memberSignUpDate;
	}

	public void setMemberSignUpDate(Date memberSignUpDate) {
		this.memberSignUpDate = memberSignUpDate;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public int getSocialCode() {
		return socialCode;
	}

	public void setSocialCode(int socialCode) {
		this.socialCode = socialCode;
	}

	public String getSocialType() {
		return socialType;
	}

	public void setSocialType(String socialType) {
		this.socialType = socialType;
	}

	public String getMemberYn() {
		return memberYn;
	}

	public void setMemberYn(String memberYn) {
		this.memberYn = memberYn;
	}

	public String getMateStatus() {
		return mateStatus;
	}

	public void setMateStatus(String mateStatus) {
		this.mateStatus = mateStatus;
	}

	public int getMateReportCount() {
		return mateReportCount;
	}

	public void setMateReportCount(int mateReportCount) {
		this.mateReportCount = mateReportCount;
	}

	public Date getMateRestartDate() {
		return mateRestartDate;
	}

	public void setMateRestartDate(Date mateRestartDate) {
		this.mateRestartDate = mateRestartDate;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", memberNick=" + memberNick + ", memberBirth=" + memberBirth + ", memberGender=" + memberGender
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberImgName=" + memberImgName
				+ ", memberImgRename=" + memberImgRename + ", memberImgPath=" + memberImgPath + ", memberSignUpDate="
				+ memberSignUpDate + ", memberLevel=" + memberLevel + ", memberPoint=" + memberPoint + ", socialCode="
				+ socialCode + ", socialType=" + socialType + ", memberYn=" + memberYn + ", mateStatus=" + mateStatus
				+ ", mateReportCount=" + mateReportCount + ", mateRestartDate=" + mateRestartDate + ", memberType="
				+ memberType + "]";
	}
}
