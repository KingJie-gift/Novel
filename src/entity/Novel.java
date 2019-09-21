package entity;
//小说表
public class Novel {
	private int bookid;//小说id
	private String bookname;//小说名称
	private int booktype;//小说类型
	private String booktitle;//小说标题
	private String bookoutline;//小说概要
	private int authorid;//小说作者对应作者id
	private String bookstate;//小说状态
	private String ischarge;//是否收费
	private String platform;//发布平台
	private int booknumber;//小说字数
	private int clicks;//点击率
	private int chapter;//小说章节id
    private Author author;	//作者对象
    private Chapter chapters;//章节对象
    private Booktype type;//小说类型对象
    private String images;  //小说图片
    private String sendword;  //作者寄语
    private String shouzimu;//首字母
	public String getShouzimu() {
		return shouzimu;
	}
	public void setShouzimu(String shouzimu) {
		this.shouzimu = shouzimu;
	}
	public String getSendword() {
		return sendword;
	}
	public void setSendword(String sendword) {
		this.sendword = sendword;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Booktype getType() {
		return type;
	}
	public void setType(Booktype type) {
		this.type = type;
	}
	public Chapter getChapters() {
		return chapters;
	}
	public void setChapters(Chapter chapters) {
		this.chapters = chapters;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBooktype() {
		return booktype;
	}
	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getBookoutline() {
		return bookoutline;
	}
	public void setBookoutline(String bookoutline) {
		this.bookoutline = bookoutline;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getBookstate() {
		return bookstate;
	}
	public void setBookstate(String bookstate) {
		this.bookstate = bookstate;
	}
	public String getIscharge() {
		return ischarge;
	}
	public void setIscharge(String ischarge) {
		this.ischarge = ischarge;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public int getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public int getChapter() {
		return chapter;
	}
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	
}
