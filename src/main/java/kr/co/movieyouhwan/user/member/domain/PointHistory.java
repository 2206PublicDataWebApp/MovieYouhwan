package kr.co.movieyouhwan.user.member.domain;

import java.util.Date;

public class PointHistory {
	private int pointHistoryNo;		// 포인트 내역 번호
	private String memberId;
	private Date pointDate;			// 포인트 변동일
	private int pointAmount;		// 포인트 증감액
	private String pointType;		// 포인트 구분
	private String pointContent;	// 포인트 내용?
	private String pointLocation;	// 포인트 지점
	
	public PointHistory() {}

	public int getPointHistoryNo() {
		return pointHistoryNo;
	}

	public void setPointHistoryNo(int pointHistoryNo) {
		this.pointHistoryNo = pointHistoryNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getPointDate() {
		return pointDate;
	}

	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	public int getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(int pointAmount) {
		this.pointAmount = pointAmount;
	}

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}

	public String getPointContent() {
		return pointContent;
	}

	public void setPointContent(String pointContent) {
		this.pointContent = pointContent;
	}

	public String getPointLocation() {
		return pointLocation;
	}

	public void setPointLocation(String pointLocation) {
		this.pointLocation = pointLocation;
	}

	@Override
	public String toString() {
		return "PointHistory [pointHistoryNo=" + pointHistoryNo + ", memberId=" + memberId + ", pointDate=" + pointDate
				+ ", pointAmount=" + pointAmount + ", pointType=" + pointType + ", pointContent=" + pointContent
				+ ", pointLocation=" + pointLocation + "]";
	}

	public PointHistory(int pointHistoryNo, String memberId, Date pointDate, int pointAmount, String pointType,
			String pointContent, String pointLocation) {
		super();
		this.pointHistoryNo = pointHistoryNo;
		this.memberId = memberId;
		this.pointDate = pointDate;
		this.pointAmount = pointAmount;
		this.pointType = pointType;
		this.pointContent = pointContent;
		this.pointLocation = pointLocation;
	}
	
	
}
