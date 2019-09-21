package service.impl;

import java.util.List;

import dao.impl.HistoryDaoImpl;
import entity.History;
import entity.Novel;
import service.HistoryService;

public class HistoryServiceImpl implements HistoryService {

	
	
	HistoryDaoImpl  hl=new HistoryDaoImpl();
	@Override
	public int updatehistory(int bookid ,int chapterid,int authorid) {
		return hl.updatehistory(bookid, chapterid, authorid);
	}
	@Override
	public int addhistory(int bookid, int chapterid, int authorid) {
		return hl.addhistory(bookid, chapterid, authorid);
	}
	@Override
	public List<History> gethistorylist(int authorid) {
		return hl.gethistorylist(authorid);
	}

}
