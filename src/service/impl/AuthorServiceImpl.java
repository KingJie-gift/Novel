package service.impl;

import dao.impl.AuthorDaoImpl;
import entity.Author;
import service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
	AuthorDaoImpl ad=new AuthorDaoImpl();
	@Override
	public int Insert(Author a) {
		return ad.Insert(a);
	}
	@Override
	public Author getauthor(int id) {
		return ad.getauthor(id);
	}
	@Override
	public int addauthoridprice(double price, int authorid) {
		return ad.addauthoridprice(price, authorid);
	}
	@Override
	public int updateadmin(double price) {
		return ad.updateadmin(price);
	}
	@Override
	public int updatezuozhe(double price, int zuozheid) {
		return ad.updatezuozhe(price, zuozheid);
	}
	@Override
	public int Update(Author a) {
		return ad.Update(a);
	}
	@Override
	public int checkauthorname(String name) {
		return ad.checkauthorname(name);
	}
	@Override
	public Author login(Author a) {
		return ad.login(a);
	}

}
