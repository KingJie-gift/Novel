package entity;

public class Rechargerecord {

private int	authorid;
	private int price;
	private String rechargetime;
	private String rechargemode;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRechargetime() {
		return rechargetime;
	}
	public void setRechargetime(String rechargetime) {
		this.rechargetime = rechargetime;
	}
	public String getRechargemode() {
		return rechargemode;
	}
	public void setRechargemode(String rechargemode) {
		this.rechargemode = rechargemode;
	}

}
