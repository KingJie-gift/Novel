package service;

import entity.Author;

public interface AuthorService {
	int Insert(Author a);
	Author getauthor(int id);
	int addauthoridprice(double price,int authorid);//充值
	int updateadmin(double price);//网站的收益
	int updatezuozhe(double price,int zuozheid) ;//获取作者给作者更新金额
	int Update(Author a);
	  int checkauthorname(String name);//查重
	  Author login(Author a);//登录
}
