package service.impl;

import java.util.List;

import dao.impl.NovelDaoImpl;
import entity.Author;
import entity.Novel;
import entity.Page;
import service.NovelService;

public class NovelServiceImpl implements NovelService {
	NovelDaoImpl nd=new NovelDaoImpl();
	@Override
	public List<Novel> getAll(String name) {
		return nd.getAll(name);
	}
	@Override
	public int add(Novel n) {
		return nd.add(n);
	}
	@Override
	public List<Novel> getnovle(int  id) {
		return nd.getnovle(id);
	}
	@Override
	public int getall(int id) {
		return nd.getall(id);
	}
	@Override
	public List getpage(Page p) {
		return nd.getpage(p);
	}
	@Override
	public Novel getnovel(int id) {
		return nd.getnovel(id);
	}
	@Override
	public int update(Novel n) {
		return nd.update(n);
	}
	@Override
	public Novel getauthorid(int authorid,String bookname) {
		return nd.getauthorid(authorid,bookname);
	}
	@Override
	public List<Novel> getAllnovel(String bookname,int typeid, Page p) {
		return nd.getAllnovel(bookname,typeid, p);
	}
	@Override
	public int getallnovel(String name,int typeid) {
		return nd.getallnovel(name,typeid);
	}
	@Override
	public List<Novel> getnovellist(int bookid) {
		return nd.getnovellist(bookid);
	}
	@Override
	public int updatenovelclicks(int clicks, int bookid) {
		return nd.updatenovelclicks(clicks, bookid);
	}
	@Override
	public List<Novel> getallnovel() {
		return nd.getallnovel();
	}
	@Override
	public List getauthornovel(Page p, int authorid) {
		return nd.getauthornovel(p, authorid);
	}
	@Override
	public int updateischarge(String ischarge, int bookid) {
		return nd.updateischarge(ischarge, bookid);
	}
	@Override
	public List<Novel> numberlist() {
		return nd.numberlist();
	}
	@Override
	public List<Novel> newlist() {
		return nd.newlist();
	}

	
}
