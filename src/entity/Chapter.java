package entity;
//�½ڱ�
public class Chapter {
	private int chapterid;//����id 
	private String chaptertitle;//�½ڱ���
	private int bookid;//��Ӧ�ı�С˵
	private int chapternumber;//�½�����
	private int chapterprice;//�½ڽ��
	private String establishtime;// ����ʱ��
	private String modifytime;//�޸�ʱ��
	private String chaptercontent;//�½�����
private Novel	novel ;//С˵����
private Author author;//���߶���
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
