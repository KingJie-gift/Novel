package entity;
//读者表（作者）
public class Author {
	private int authorid;//编号
	private String authorname;//昵称
	private String pwd;//密码
	private double authorprice;//金额
	private int collectionbook;//收藏小说
	private int releasebook;//发布的小说
	private String email;//电子邮箱
	private String phone;//电话
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public double getAuthorprice() {
		return authorprice;
	}
	public void setAuthorprice(double authorprice) {
		this.authorprice = authorprice;
	}
	public int getCollectionbook() {
		return collectionbook;
	}
	public void setCollectionbook(int collectionbook) {
		this.collectionbook = collectionbook;
	}
	public int getReleasebook() {
		return releasebook;
	}
	public void setReleasebook(int releasebook) {
		this.releasebook = releasebook;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
