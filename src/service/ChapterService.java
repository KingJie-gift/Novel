package service;

import java.util.List;

import entity.Chapter;

public interface ChapterService {
List getchapter(int bookid);
int add(Chapter c);
Chapter getchapterlist(int id); 
int  countchapternumber(int id);
Chapter getchapters(int id);
int update(Chapter c);
Chapter  maxupdatetime(int bookid);//�����޸ĵ��½ڸ���С˵id
int   getminchapter(int bookid);//����С˵id��ȡ��һ��С˵�½�id
int getischarge(int bookid);//��ȡ����С˵id��ȡ�����½�
}
