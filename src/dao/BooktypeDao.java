package dao;

import java.util.List;

import entity.Booktype;

public interface BooktypeDao {
List getbooktype(); //获取所有小说类型
Booktype gettype(int id);//根据id获取小说类型
}
