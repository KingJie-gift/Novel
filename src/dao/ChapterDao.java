package dao;

import java.util.List;

import entity.Chapter;

public interface ChapterDao {
List getchapter(int bookid);//获取章节集合根据小说id
int add(Chapter c);//新增章节
Chapter getchapterlist(int id);  //获取最新章节根据小说id
int  countchapternumber(int id); //根据小说id获取对应所有章节的字数
 Chapter getchapters(int id);  //根据章节获取对象
 int update(Chapter c);//更新章节
 Chapter  maxupdatetime(int bookid);//最新修改的章节根据小说id
 int   getminchapter(int bookid);//根据小说id获取第一章小说章节id
 int getischarge(int bookid);//获取根据小说id获取所有章节
 
 
}
