package kr.co.movieyouhwan.user.mate.domain;

public class MatchResult {
	private String memberId;
	private String memberImgRename;
	private String memberNick;
	private String memberGender;
	private String memberAge;
	private String cinemaName;
	private String genre;
	private int matchingGrade;
	private String createDate; // 매칭날짜
	private String deleteDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberImgRename() {
		return memberImgRename;
	}
	public void setMemberImgRename(String memberImgRename) {
		this.memberImgRename = memberImgRename;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
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
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getMatchingGrade() {
		return matchingGrade;
	}
	public void setMatchingGrade(int matchingGrade) {
		this.matchingGrade = matchingGrade;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	@Override
	public String toString() {
		return "MatchResult [memberId=" + memberId + ", memberImgRename=" + memberImgRename + ", memberNick="
				+ memberNick + ", memberGender=" + memberGender + ", memberAge=" + memberAge + ", cinemaName="
				+ cinemaName + ", genre=" + genre + ", matchingGrade=" + matchingGrade + ", createDate=" + createDate
				+ "]";
	}
	
	
	
	
}
