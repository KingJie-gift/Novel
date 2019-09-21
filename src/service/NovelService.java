package service;

import java.util.List;

import entity.Author;
import entity.Novel;
import entity.Page;

public interface NovelService {
	List<Novel> getAll(String name);
	int add(Novel n);
	List<Novel> getnovle(int id);
	int getall(int id);  //��ȡ��Ϣ����
	List getpage(Page p);
	Novel getnovel(int id); 
	Novel  getauthorid(int authorid,String bookname );
	int update(Novel n);//����С˵
	List<Novel>getAllnovel(String bookname,int typeid,Page p);//��ȡ����С˵
      int getallnovel(String name,int typeid); //��ȡ����С˵����
      List<Novel>numberlist();//����������ѯС˵
   
      
      List<Novel>getnovellist(int bookid);   //����С˵id��ȡ����
      int updatenovelclicks(int clicks,int bookid);//��С˵����
      List<Novel>getallnovel();//��ȡ����С˵
      List  getauthornovel(Page p,int authorid); //��ȡ����д��ÿ��С˵
      int updateischarge(String ischarge,int bookid);//�����Ƿ��շ�
      
      List<Novel>newlist();//���·���С˵
}
