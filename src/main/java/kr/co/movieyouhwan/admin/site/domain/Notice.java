package kr.co.movieyouhwan.admin.site.domain;

import java.sql.Date;

public class Notice {
	
	private int noticeNo;
	private String adminId;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeCreate;
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeCreate() {
		return noticeCreate;
	}
	public void setNoticeCreate(Date noticeCreate) {
		this.noticeCreate = noticeCreate;
	}
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", adminId=" + adminId + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeCreate=" + noticeCreate + "]";
	}
	
	

}
