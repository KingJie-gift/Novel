package service.impl;

import java.util.List;

import dao.impl.BooktypeDaoImpl;
import entity.Booktype;
import service.BooktypeService;

public class BooktypeServiceImpl implements BooktypeService {
 
	
	BooktypeDaoImpl bl=new BooktypeDaoImpl();
	@Override
	public List getbooktype() {
		return bl.getbooktype();
	}
	@Override
	public Booktype gettype(int id) {
		return bl.gettype(id);
	}

}
