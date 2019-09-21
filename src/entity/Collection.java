package entity;
//小说收藏表
public class Collection {
	private int bookid;//主键id
	private int authorid;//收藏小说的id
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
}
