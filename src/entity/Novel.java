package entity;
//С˵��
public class Novel {
	private int bookid;//С˵id
	private String bookname;//С˵����
	private int booktype;//С˵����
	private String booktitle;//С˵����
	private String bookoutline;//С˵��Ҫ
	private int authorid;//С˵���߶�Ӧ����id
	private String bookstate;//С˵״̬
	private String ischarge;//�Ƿ��շ�
	private String platform;//����ƽ̨
	private int booknumber;//С˵����
	private int clicks;//�����
	private int chapter;//С˵�½�id
    private Author author;	//���߶���
    private Chapter chapters;//�½ڶ���
    private Booktype type;//С˵���Ͷ���
    private String images;  //С˵ͼƬ
    private String sendword;  //���߼���
    private String shouzimu;//����ĸ
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
