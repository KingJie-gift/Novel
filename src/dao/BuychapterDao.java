package dao;

public interface BuychapterDao {
int add(int bookid,int chapterid,int authorid);//添加购买记录
int getbuy(int chapterid,int authorid);//查看有没有记录
int getauthoridprice(int chapterprice,int authorid);//更新用户的书卷
}
