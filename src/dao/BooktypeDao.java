package dao;

import java.util.List;

import entity.Booktype;

public interface BooktypeDao {
List getbooktype(); //��ȡ����С˵����
Booktype gettype(int id);//����id��ȡС˵����
}
