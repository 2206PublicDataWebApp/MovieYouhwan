package kr.co.movieyouhwan.user.mate.domain;

import java.sql.Date;
import java.util.List;

public class Survey {
	private Integer surveyNo;
	private String gender;
	private String age;
	private String CinemaName;
	private List<String> genre;
	private String memberId;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
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
		return CinemaName;
	}
	public void setCinemaName(String cinemaName) {
		CinemaName = cinemaName;
	}
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	@Override
	public String toString() {
		return "Survey [surveyNo=" + surveyNo + ", gender=" + gender + ", age=" + age + ", CinemaName=" + CinemaName
				+ ", genre=" + genre + ", memberId=" + memberId + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", deleteDate=" + deleteDate + "]";
	}
	
	
	
	
	
}
