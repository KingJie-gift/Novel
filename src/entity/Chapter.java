package entity;
//章节表
public class Chapter {
	private int chapterid;//主键id 
	private String chaptertitle;//章节标题
	private int bookid;//对应哪本小说
	private int chapternumber;//章节字数
	private int chapterprice;//章节金额
	private String establishtime;// 创建时间
	private String modifytime;//修改时间
	private String chaptercontent;//章节内容
private Novel	novel ;//小说对象
private Author author;//作者对象
	public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}
	public Novel getNovel() {
	return novel;
}
public void setNovel(Novel novel) {
	this.novel = novel;
}
	public String getChaptercontent() {
		return chaptercontent;
	}
	public void setChaptercontent(String chaptercontent) {
		this.chaptercontent = chaptercontent;
	}
	public int getChapterid() {
		return chapterid;
	}
	public void setChapterid(int chapterid) {
		this.chapterid = chapterid;
	}
	public String getChaptertitle() {
		return chaptertitle;
	}
	public void setChaptertitle(String chaptertitle) {
		this.chaptertitle = chaptertitle;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getChapternumber() {
		return chapternumber;
	}
	public void setChapternumber(int chapternumber) {
		this.chapternumber = chapternumber;
	}
	public int getChapterprice() {
		return chapterprice;
	}
	public void setChapterprice(int chapterprice) {
		this.chapterprice = chapterprice;
	}
	public String getEstablishtime() {
		return establishtime;
	}
	public void setEstablishtime(String establishtime) {
		this.establishtime = establishtime;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	
}
