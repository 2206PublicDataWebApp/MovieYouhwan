package kr.co.movieyouhwan.user.mate.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Survey {
	private Integer surveyNo;
	private String gender;
	private String age; // 선호하는 연령대
	private String cinemaName;
	private String memberId;
	private String memberBirth;
	private String memberAge; // 자신의 나이
	private String memberGender; // 자신의 성별
	private String matchingActive;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
	private int matchingGrade;

	public Integer getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(Integer surveyNo) {
		this.surveyNo = surveyNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int memberBirthYear = Integer.parseInt(memberBirth) / 10000;
		int realAge = year - memberBirthYear;
		if (realAge >= 50) {
			this.memberAge = "50대 이상";
		} else {
			this.memberAge = String.valueOf(realAge).substring(0, 1) + "0대";
		}
		this.memberBirth = memberBirth;
	}

	public String getMatchingActive() {
		return matchingActive;
	}

	public void setMatchingActive(String matchingActive) {
		this.matchingActive = matchingActive;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public int getMatchingGrade() {
		return matchingGrade;
	}

	public void setMatchingGrade(int matchingGrade) {
		this.matchingGrade = matchingGrade;
	}

	@Override
	public String toString() {
		return "Survey [surveyNo=" + surveyNo + ", gender=" + gender + ", age=" + age + ", cinemaName=" + cinemaName
				+ ", memberId=" + memberId + ", memberBirth=" + memberBirth + ", memberAge=" + memberAge
				+ ", memberGender=" + memberGender + ", matchingActive=" + matchingActive + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", deleteDate=" + deleteDate + ", matchingGrade=" + matchingGrade
				+ "]";
	}

}
