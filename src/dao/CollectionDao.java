package dao;

import java.util.List;

import entity.Collection;

public interface CollectionDao {
int  collection(int authorid,int bookid);//��ѯС˵�Ƿ��б��ղ�
int  addcollection(int authorid,int bookid);//����ղ�С˵
List<Collection> getcollection(int authorid); //��ȡ�ղص�С˵ͨ���û�id
 int delte(int authorid,int bookid); //�Ƴ��ղ�
 int deleteall(int authorid);//�Ƴ�ȫ���ղ�
}
