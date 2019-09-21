package service;

import java.util.List;

import entity.Collection;

public interface CollectionService {
	int  collection(int authorid,int bookid);
	int  addcollection(int authorid,int bookid);
	List<Collection> getcollection(int authorid);
	 int delte(int authorid,int bookid); 
	 int deleteall(int authorid);
}
