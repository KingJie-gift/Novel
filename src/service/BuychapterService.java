package service;

public interface BuychapterService {
	int add(int bookid,int chapterid,int authorid);
	int getbuy(int chapterid,int authorid);
	int getauthoridprice(int chapterprice,int authorid);//更新用户的书卷
}
