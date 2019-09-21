package service.impl;

import java.util.List;

import dao.impl.CollectionDaoImpl;
import entity.Collection;
import service.CollectionService;

public class CollectionServiceImpl  implements CollectionService{

	CollectionDaoImpl cl=new CollectionDaoImpl();
	@Override
	public int collection(int authorid, int bookid) {
		return cl.collection(authorid, bookid);
	}
	@Override
	public int addcollection(int authorid, int bookid) {
		return cl.addcollection(authorid, bookid);
	}
	@Override
	public List<Collection> getcollection(int authorid) {
		return cl.getcollection(authorid);
	}
	@Override
	public int delte(int authorid, int bookid) {
		return cl.delte(authorid, bookid);
	}
	@Override
	public int deleteall(int authorid) {
		
		return cl.deleteall(authorid);
	}

}
