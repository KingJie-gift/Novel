package dao;

import java.util.List;

import entity.Author;
import entity.Novel;
import entity.Page;

public interface NovelDao {
	List<Novel> getAll(String name);//����С˵����ģ����ѯ
	int add(Novel n);//����С˵
	int update(Novel n);//����С˵
	List<Novel> getnovle(int id);//С˵��Ϣ��������id
	int getall(int id);  //���һ�ȡ��Ϣ����
	List getpage(Page p); //��ҳ�����ļ���
	Novel getnovel(int id);  //����С˵id��ȡС˵����
	Novel  getauthorid(int authorid,String bookname);//�����û�id�ҵ�С˵����
    List<Novel>getAllnovel(String bookname,int typeid,Page p);//��ȡ����С˵
     int getallnovel(String name,int typeid); //��ȡ����С˵����
    List<Novel>getnovellist(int bookid);   //����С˵id��ȡ����
    
     int updatenovelclicks(int clicks,int bookid);//��С˵����
    
     List<Novel>getallnovel();//��ȡ����С˵
     
        List  getauthornovel(Page p,int authorid); //��ȡ����д��ÿ��С˵
        int updateischarge(String ischarge,int bookid);//�����Ƿ��շ�
        
        List<Novel>numberlist();//����������ѯС˵
        
        List<Novel>newlist();//���·���С˵
}
