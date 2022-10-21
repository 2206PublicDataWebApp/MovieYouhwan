package kr.co.movieyouhwan.admin.theater.domain;

public class Theater {
	private int theaterNo; // 상영관 번호
	private int tCinemaNo; // 영화관 번호
	private String theaterName; // 상영관 이름
	private int theaterSeatoneRow; // 첫번째 행
	private int theaterSeatoneColumn; // 첫번째 열
	private int theaterSeattwoRow; // 두번째 행
	private int theaterSeattwoColumn; // 두번째 열
	private int theaterSeatthreeRow; // 세번째 행
	private int theaterSeatthreeColumn; // 세번째 열
	private String theaterStatus; // 상영관 상태
	
	public Theater() {}

	public Theater(int theaterNo, int tCinemaNo, String theaterName, int theaterSeatoneRow, int theaterSeatoneColumn,
			int theaterSeattwoRow, int theaterSeattwoColumn, int theaterSeatthreeRow, int theaterSeatthreeColumn,
			String theaterStatus) {
		super();
		this.theaterNo = theaterNo;
		this.tCinemaNo = tCinemaNo;
		this.theaterName = theaterName;
		this.theaterSeatoneRow = theaterSeatoneRow;
		this.theaterSeatoneColumn = theaterSeatoneColumn;
		this.theaterSeattwoRow = theaterSeattwoRow;
		this.theaterSeattwoColumn = theaterSeattwoColumn;
		this.theaterSeatthreeRow = theaterSeatthreeRow;
		this.theaterSeatthreeColumn = theaterSeatthreeColumn;
		this.theaterStatus = theaterStatus;
	}

	public int getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}

	public int gettCinemaNo() {
		return tCinemaNo;
	}

	public void settCinemaNo(int tCinemaNo) {
		this.tCinemaNo = tCinemaNo;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public int getTheaterSeatoneRow() {
		return theaterSeatoneRow;
	}

	public void setTheaterSeatoneRow(int theaterSeatoneRow) {
		this.theaterSeatoneRow = theaterSeatoneRow;
	}

	public int getTheaterSeatoneColumn() {
		return theaterSeatoneColumn;
	}

	public void setTheaterSeatoneColumn(int theaterSeatoneColumn) {
		this.theaterSeatoneColumn = theaterSeatoneColumn;
	}

	public int getTheaterSeattwoRow() {
		return theaterSeattwoRow;
	}

	public void setTheaterSeattwoRow(int theaterSeattwoRow) {
		this.theaterSeattwoRow = theaterSeattwoRow;
	}

	public int getTheaterSeattwoColumn() {
		return theaterSeattwoColumn;
	}

	public void setTheaterSeattwoColumn(int theaterSeattwoColumn) {
		this.theaterSeattwoColumn = theaterSeattwoColumn;
	}

	public int getTheaterSeatthreeRow() {
		return theaterSeatthreeRow;
	}

	public void setTheaterSeatthreeRow(int theaterSeatthreeRow) {
		this.theaterSeatthreeRow = theaterSeatthreeRow;
	}

	public int getTheaterSeatthreeColumn() {
		return theaterSeatthreeColumn;
	}

	public void setTheaterSeatthreeColumn(int theaterSeatthreeColumn) {
		this.theaterSeatthreeColumn = theaterSeatthreeColumn;
	}

	public String getTheaterStatus() {
		return theaterStatus;
	}

	public void setTheaterStatus(String theaterStatus) {
		this.theaterStatus = theaterStatus;
	}

	@Override
	public String toString() {
		return "Theater [theaterNo=" + theaterNo + ", tCinemaNo=" + tCinemaNo + ", theaterName=" + theaterName
				+ ", theaterSeatoneRow=" + theaterSeatoneRow + ", theaterSeatoneColumn=" + theaterSeatoneColumn
				+ ", theaterSeattwoRow=" + theaterSeattwoRow + ", theaterSeattwoColumn=" + theaterSeattwoColumn
				+ ", theaterSeatthreeRow=" + theaterSeatthreeRow + ", theaterSeatthreeColumn=" + theaterSeatthreeColumn
				+ ", theaterStatus=" + theaterStatus + "]";
	}
}
