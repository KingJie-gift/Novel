package dao;

import entity.Author;

public interface AuthorDao {
	int Insert(Author a);//�����û�
	Author getauthor(int id);//��������id��ȡ���߶���
   int addauthoridprice(double price,int authorid);//��ֵ
   int updateadmin(double price);//��վ������
     int updatezuozhe(double price,int zuozheid) ;//��ȡ����
     int Update(Author a);//�޸�
     int checkauthorname(String name);//����
     Author login(Author a);//��¼
}
