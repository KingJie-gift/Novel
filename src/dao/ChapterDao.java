package dao;

import java.util.List;

import entity.Chapter;

public interface ChapterDao {
List getchapter(int bookid);//��ȡ�½ڼ��ϸ���С˵id
int add(Chapter c);//�����½�
Chapter getchapterlist(int id);  //��ȡ�����½ڸ���С˵id
int  countchapternumber(int id); //����С˵id��ȡ��Ӧ�����½ڵ�����
 Chapter getchapters(int id);  //�����½ڻ�ȡ����
 int update(Chapter c);//�����½�
 Chapter  maxupdatetime(int bookid);//�����޸ĵ��½ڸ���С˵id
 int   getminchapter(int bookid);//����С˵id��ȡ��һ��С˵�½�id
 int getischarge(int bookid);//��ȡ����С˵id��ȡ�����½�
 
 
}
