package entity;
//���߱����ߣ�
public class Author {
	private int authorid;//���
	private String authorname;//�ǳ�
	private String pwd;//����
	private double authorprice;//���
	private int collectionbook;//�ղ�С˵
	private int releasebook;//������С˵
	private String email;//��������
	private String phone;//�绰
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
