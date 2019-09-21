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
Chapter  maxupdatetime(int bookid);//最新修改的章节根据小说id
int   getminchapter(int bookid);//根据小说id获取第一章小说章节id
int getischarge(int bookid);//获取根据小说id获取所有章节
}
