package dao;

import java.util.List;

import entity.Chapter;
import entity.History;
import entity.Novel;

public interface HistoryDao {
int updatehistory(int bookid ,int chapterid,int authorid);//������ʷ��¼
int addhistory(int bookid ,int chapterid,int authorid);  //�����ʷ��¼
List<History> gethistorylist(int authorid);//��ȡ�Ķ���¼  �����û�id
}
