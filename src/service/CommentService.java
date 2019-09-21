package service;

import java.util.List;

import entity.Comment;
import entity.Page;

public interface CommentService {
	int add(Comment cm);
	List plfen(Page p,int bookid);
	int getCount(int bookid);
}
