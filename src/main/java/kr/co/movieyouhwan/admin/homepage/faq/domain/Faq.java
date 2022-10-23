package kr.co.movieyouhwan.admin.homepage.faq.domain;

import java.sql.Date;

public class Faq {
	private int faqMo;
	private String admimId;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeCreate;
	
	public int getFaqMo() {
		return faqMo;
	}
	public void setFaqMo(int faqMo) {
		this.faqMo = faqMo;
	}
	public String getAdmimId() {
		return admimId;
	}
	public void setAdmimId(String admimId) {
		this.admimId = admimId;
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
	
	

}
