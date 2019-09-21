package entity;

public class Consumptionrecord {
	private int id;
	private int chapterid;
	private int authorid;
	private String consumptiontime;
	private int consumptionamount;
	private Chapter chapter;
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChapterid() {
		return chapterid;
	}
	public void setChapterid(int chapterid) {
		this.chapterid = chapterid;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getConsumptiontime() {
		return consumptiontime;
	}
	public void setConsumptiontime(String consumptiontime) {
		this.consumptiontime = consumptiontime;
	}
	public int getConsumptionamount() {
		return consumptionamount;
	}
	public void setConsumptionamount(int consumptionamount) {
		this.consumptionamount = consumptionamount;
	}
	
}
