package service;

import java.util.List;

import entity.History;
import entity.Novel;

public interface HistoryService {
	int updatehistory(int bookid ,int chapterid,int authorid);//��ʷ��¼
	int addhistory(int bookid ,int chapterid,int authorid);  //�����ʷ��¼
	List <History>gethistorylist(int authorid);//��ȡ�Ķ���¼  �����û�id
}
