package entity;
//观看历史表
public class History {
	private int bookid;//小说 id
	private int chaperid;//章节id
	private int author;//用户id
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getChaperid() {
		return chaperid;
	}
	public void setChaperid(int chaperid) {
		this.chaperid = chaperid;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	
}
