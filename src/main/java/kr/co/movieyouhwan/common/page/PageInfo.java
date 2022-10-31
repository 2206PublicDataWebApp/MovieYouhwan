package kr.co.movieyouhwan.common.page;

public class PageInfo {
  private int currentPage; // 현재 페이징 넘버
  private int dataCount; // 총 데이터 개수
  private int dataLimit; // 페이지당 데이터 개수
  private int pageLimit; // 한번에 보이는 페이징 넘버 개수
  private int pageCount; // 총 페이징 넘버 개수
  private int startPage;
  private int endPage;
  
  public PageInfo() {
	super();
}
  public PageInfo(int currentPage, int dataCount, int dataLimit, int pageLimit) {
	  this.currentPage=currentPage;
	  this.dataCount=dataCount;
	  this.dataLimit=dataLimit;
	  this.pageLimit=pageLimit;
	  this.pageCount=(int) ((double) dataCount / dataLimit + 0.9);
	  this.startPage=((int) ((double) currentPage / pageLimit + 0.9) - 1) * pageLimit + 1;
	  this.endPage=this.startPage + this.pageLimit - 1;
	  if(this.pageCount<this.endPage) {
		  this.endPage=this.pageCount;
	  }
  }

public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getDataCount() {
    return dataCount;
  }

  public void setDataCount(int dataCount) {
    this.dataCount = dataCount;
  }

  public int getDataLimit() {
    return dataLimit;
  }

  public void setDataLimit(int dataLimit) {
    this.dataLimit = dataLimit;
  }

  public int getPageLimit() {
    return pageLimit;
  }

  public void setPageLimit(int pageLimit) {
    this.pageLimit = pageLimit;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public int getStartPage() {
    return startPage;
  }

  public void setStartPage(int startPage) {
    this.startPage = startPage;
  }

  public int getEndPage() {
    return endPage;
  }

  public void setEndPage(int endPage) {
    this.endPage = endPage;
  }

  @Override
  public String toString() {
    return "PageInfo [currentPage=" + currentPage + ", dataCount=" + dataCount + ", dataLimit=" + dataLimit
        + ", pageLimit=" + pageLimit + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
        + "]";
  }

}
