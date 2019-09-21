package dao;

import java.util.List;

import entity.Collection;

public interface CollectionDao {
int  collection(int authorid,int bookid);//查询小说是否有被收藏
int  addcollection(int authorid,int bookid);//添加收藏小说
List<Collection> getcollection(int authorid); //获取收藏的小说通过用户id
 int delte(int authorid,int bookid); //移除收藏
 int deleteall(int authorid);//移除全部收藏
}
