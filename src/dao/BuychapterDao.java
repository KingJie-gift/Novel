package dao;

public interface BuychapterDao {
int add(int bookid,int chapterid,int authorid);//��ӹ����¼
int getbuy(int chapterid,int authorid);//�鿴��û�м�¼
int getauthoridprice(int chapterprice,int authorid);//�����û������
}
