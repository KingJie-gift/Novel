package dao;

import java.util.List;

import entity.Author;
import entity.Novel;
import entity.Page;

public interface NovelDao {
	List<Novel> getAll(String name);//根据小说名称模糊查询
	int add(Novel n);//新增小说
	int update(Novel n);//更新小说
	List<Novel> getnovle(int id);//小说信息根据作者id
	int getall(int id);  //作家获取信息数量
	List getpage(Page p); //分页数量的集合
	Novel getnovel(int id);  //根据小说id获取小说对象
	Novel  getauthorid(int authorid,String bookname);//根据用户id找到小说对象
    List<Novel>getAllnovel(String bookname,int typeid,Page p);//获取所有小说
     int getallnovel(String name,int typeid); //获取所有小说数量
    List<Novel>getnovellist(int bookid);   //根据小说id获取集合
    
     int updatenovelclicks(int clicks,int bookid);//给小说点赞
    
     List<Novel>getallnovel();//获取所有小说
     
        List  getauthornovel(Page p,int authorid); //获取作者写的每部小说
        int updateischarge(String ischarge,int bookid);//更新是否收费
        
        List<Novel>numberlist();//根据字数查询小说
        
        List<Novel>newlist();//最新发布小说
}
