package service.impl;

import dao.impl.BuychapterDaoImpl;
import service.BuychapterService;

public class BuychapterServiceImpl implements BuychapterService{

	
	BuychapterDaoImpl  bl=new BuychapterDaoImpl();
	@Override
	public int add(int bookid, int chapterid, int authorid) {
		return bl.add(bookid, chapterid, authorid);
	}

	@Override
	public int getbuy(int chapterid, int authorid) {
		return bl.getbuy(chapterid, authorid);
	}

	@Override
	public int getauthoridprice(int chapterprice, int authorid) {
		return bl.getauthoridprice(chapterprice, authorid);
	}

}
