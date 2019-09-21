package service;

import java.util.List;

import entity.History;
import entity.Novel;

public interface HistoryService {
	int updatehistory(int bookid ,int chapterid,int authorid);//历史记录
	int addhistory(int bookid ,int chapterid,int authorid);  //添加历史记录
	List <History>gethistorylist(int authorid);//获取阅读记录  根据用户id
}
