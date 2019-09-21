package dao;

import java.util.List;

import entity.Chapter;
import entity.History;
import entity.Novel;

public interface HistoryDao {
int updatehistory(int bookid ,int chapterid,int authorid);//更新历史记录
int addhistory(int bookid ,int chapterid,int authorid);  //添加历史记录
List<History> gethistorylist(int authorid);//获取阅读记录  根据用户id
}
