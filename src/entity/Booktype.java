package entity;
//小说类型表 
public class Booktype {
	private int bookid;//主键id
	private String booktype;//类型名称
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	
}
