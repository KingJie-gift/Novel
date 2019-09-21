package service.impl;

import java.util.List;

import dao.impl.CommentDaoImpl;
import entity.Comment;
import entity.Page;
import service.CommentService;

public class CommentServiceImpl implements CommentService {
	CommentDaoImpl cdi=new CommentDaoImpl();
	@Override
	public int add(Comment cm) {
		// TODO Auto-generated method stub
		return cdi.add(cm);
	}
	@Override
	public List plfen(Page p, int bookid) {
		// TODO Auto-generated method stub
		return cdi.plfen(p, bookid);
	}
	@Override
	public int getCount(int bookid) {
		// TODO Auto-generated method stub
		return cdi.getCount(bookid);
	}

}
