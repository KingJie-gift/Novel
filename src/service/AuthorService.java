package service;

import entity.Author;

public interface AuthorService {
	int Insert(Author a);
	Author getauthor(int id);
	int addauthoridprice(double price,int authorid);//��ֵ
	int updateadmin(double price);//��վ������
	int updatezuozhe(double price,int zuozheid) ;//��ȡ���߸����߸��½��
	int Update(Author a);
	  int checkauthorname(String name);//����
	  Author login(Author a);//��¼
}
