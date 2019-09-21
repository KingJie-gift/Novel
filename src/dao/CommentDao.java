package dao;

import java.util.List;

import entity.Comment;
import entity.Page;

public interface CommentDao {
	int add(Comment cm);
	int getCount(int bookid);
	List plfen(Page p,int bookid);
	
}
