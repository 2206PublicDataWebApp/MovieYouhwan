package kr.co.movieyouhwan.user.mate.domain;

public class SurveyGenre {
	private Integer surveyGenreNo;
	private String genre;
	private Integer surveyNo;
	public Integer getSurveyGenreNo() {
		return surveyGenreNo;
	}
	public void setSurveyGenreNo(Integer surveyGenreNo) {
		this.surveyGenreNo = surveyGenreNo;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Integer getSurveyNo() {
		return surveyNo;
	}
	public void setSurveyNo(Integer surveyNo) {
		this.surveyNo = surveyNo;
	}
	@Override
	public String toString() {
		return "SurveyGenre [surveyGenreNo=" + surveyGenreNo + ", genre=" + genre + ", surveyNo=" + surveyNo + "]";
	}
	
	
	
	
	
	
}
