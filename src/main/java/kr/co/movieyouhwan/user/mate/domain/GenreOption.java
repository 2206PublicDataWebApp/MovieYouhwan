package kr.co.movieyouhwan.user.mate.domain;

public class GenreOption {
	private Integer genreNo;
	private String genre;
	public Integer getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(Integer genreNo) {
		this.genreNo = genreNo;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "GenreOption [genreNo=" + genreNo + ", genre=" + genre + "]";
	} 
	
	

}
