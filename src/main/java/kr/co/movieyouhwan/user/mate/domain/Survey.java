package kr.co.movieyouhwan.user.mate.domain;

import java.sql.Date;
import java.util.List;

public class Survey {
	private Integer surveyNo;
	private Integer genderNo;
	private Integer ageNo;
	private Integer cinemaNo;
	private List<Integer> genreNo;
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
	public Integer getGenderNo() {
		return genderNo;
	}
	public void setGenderNo(Integer genderNo) {
		this.genderNo = genderNo;
	}
	public Integer getAgeNo() {
		return ageNo;
	}
	public void setAgeNo(Integer ageNo) {
		this.ageNo = ageNo;
	}
	public Integer getCinemaNo() {
		return cinemaNo;
	}
	public void setCinemaNo(Integer cinemaNo) {
		this.cinemaNo = cinemaNo;
	}
	public List<Integer> getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(List<Integer> genreNo) {
		this.genreNo = genreNo;
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
		return "Survey [surveyNo=" + surveyNo + ", genderNo=" + genderNo + ", ageNo=" + ageNo + ", cinemaNo=" + cinemaNo
				+ ", genreNo=" + genreNo + ", memberId=" + memberId + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", deleteDate=" + deleteDate + "]";
	}
	
	
}
