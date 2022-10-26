package kr.co.movieyouhwan.admin.site.domain;

import java.sql.Date;

public class Faq {
	
	private int faqNo;
	private String adminId;
	private String faqTitle;
	private String faqType;
	private String faqContent;
	private Date faqCreate;
	
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
		return faqCreate;
	}
	public void setNoticeCreate(Date noticeCreate) {
		this.faqCreate = noticeCreate;
	}
	
	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", adminId=" + adminId + ", faqTitle=" + faqTitle + ", faqType=" + faqType
				+ ", faqContent=" + faqContent + ", faqCreate=" + faqCreate + "]";
	}
	

}
