package kr.co.movieyouhwan.admin.homepage.faq.domain;

import java.sql.Date;

public class Faq {
	private int faqMo;
	private String admimId;
	private String faqTitle;
	private String faqType;
	private String faqContent;
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
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqType() {
		return faqType;
	}
	public void setFaqType(String faqType) {
		this.faqType = faqType;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public Date getNoticeCreate() {
		return noticeCreate;
	}
	public void setNoticeCreate(Date noticeCreate) {
		this.noticeCreate = noticeCreate;
	}
	
	

}
