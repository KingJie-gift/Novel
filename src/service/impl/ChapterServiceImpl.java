package service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.ChapterService;
import dao.Basedao;
import dao.ChapterDao;
import dao.impl.ChapterDaoImpl;
import entity.Chapter;

public class ChapterServiceImpl  extends Basedao implements ChapterService{

	
	ChapterDaoImpl cl=new ChapterDaoImpl();
	@Override
	public List getchapter(int bookid) {
		return cl.getchapter(bookid);
	}
	@Override
	public int add(Chapter c) {
		return cl.add(c);
	}
	@Override
	public Chapter getchapterlist(int id) {
		return cl.getchapterlist(id);
	}
	@Override
	public int countchapternumber(int id) {
		return cl.countchapternumber(id);
	}
	@Override
	public Chapter getchapters(int id) {
		return cl.getchapters(id);
	}
	@Override
	public int update(Chapter c) {
		return cl.update(c);
	}
	@Override
	public Chapter maxupdatetime(int bookid) {
		return cl.maxupdatetime(bookid);
	}
	@Override
	public int getminchapter(int bookid) {
		return cl.getminchapter(bookid);
	}
	@Override
	public int getischarge(int bookid) {
		return cl.getischarge(bookid);
	}

}
