package dao;

import entity.Author;

public interface AuthorDao {
	int Insert(Author a);//新增用户
	Author getauthor(int id);//根据作者id获取作者对象
   int addauthoridprice(double price,int authorid);//充值
   int updateadmin(double price);//网站的收益
     int updatezuozhe(double price,int zuozheid) ;//获取作者
     int Update(Author a);//修改
     int checkauthorname(String name);//查重
     Author login(Author a);//登录
}
