package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.ChapterDao;
import entity.Author;
import entity.Chapter;
import entity.Novel;

public class ChapterDaoImpl  extends Basedao implements ChapterDao{

	@Override
	public List getchapter(int bookid) {
		String sql="select *from chapter where bookid=?";
		super.excuteQuery(sql, bookid);
		List list=new ArrayList();
		try {
			while(rs.next())
			{
				Chapter c=new Chapter();
				c.setBookid(rs.getInt("bookid"));
				c.setChaptercontent(rs.getString("chaptercontent"));
				c.setChapterid(rs.getInt("chapterid"));
				c.setChapternumber(rs.getInt("chapternumber"));
				c.setChapterprice(rs.getInt("chapterprice"));
				c.setChaptertitle(rs.getString("chaptertitle"));
				c.setEstablishtime(rs.getString("establishtime"));
				c.setModifytime(rs.getString("modifytime"));
				
			     NovelDaoImpl nl=new NovelDaoImpl();
				    Novel n=nl.getnovel(bookid);
				    c.setNovel(n);
				    
				    
				    
				    
				   
				    
				 list.add(c);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	@Override
	public int add(Chapter c) {
		String sql="insert into chapter (chapterid, chaptertitle,chapternumber,chapterprice,establishtime,chaptercontent,bookid)values(?,?,?,?,now(),?,?)";
		return super.excuteUpdate(sql, c.getChapterid(),c.getChaptertitle(),c.getChapternumber(),c.getChapterprice(),c.getChaptercontent(),c.getBookid());
	}

	@Override
	public Chapter getchapterlist(int id) {
	String sql="SELECT  *from chapter where bookid=?";
	super.excuteQuery(sql, id);
	Chapter c=null;
	try {
		while(rs.next())
		{
			c=new Chapter();
			c.setBookid(rs.getInt("bookid"));
			c.setChaptercontent(rs.getString("chaptercontent"));
			c.setChapterid(rs.getInt("chapterid"));
			c.setChapternumber(rs.getInt("chapternumber"));
			c.setChapterprice(rs.getInt("chapterprice"));
			c.setChaptertitle(rs.getString("chaptertitle"));
			c.setEstablishtime(rs.getString("establishtime"));
			c.setModifytime(rs.getString("modifytime"));
			
			NovelDaoImpl nl=new NovelDaoImpl();
		    Novel n=nl.getnovel(rs.getInt("bookid"));
		    c.setNovel(n);
		 
		 
		 
		 AuthorDaoImpl al=new AuthorDaoImpl();
		 int authorid=n.getAuthorid();
		Author a=al.getauthor(authorid);
		 c.setAuthor(a);
		 
		 
		 
		 
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		super.CloseAll();
	}
	return c;
	}

	@Override
	public int countchapternumber(int id) {
		String sql="SELECT SUM(chapternumber) FROM chapter WHERE bookid=?";
		super.excuteQuery(sql, id);
		int count=0;
		try {
			while(rs.next())
			{
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return count;
	}

	@Override
	public Chapter getchapters(int id) {
		String sql="select *From chapter where chapterid=?";
		super.excuteQuery(sql, id);
		Chapter c=null;
		try {
			while(rs.next())
			{
				c=new Chapter();
				c.setBookid(rs.getInt("bookid"));
				c.setChaptercontent(rs.getString("chaptercontent"));
				c.setChapterid(rs.getInt("chapterid"));
				c.setChapternumber(rs.getInt("chapternumber"));
				c.setChapterprice(rs.getInt("chapterprice"));
				c.setChaptertitle(rs.getString("chaptertitle"));
				c.setEstablishtime(rs.getString("establishtime"));
				c.setModifytime(rs.getString("modifytime"));
				
				
				NovelDaoImpl nl=new NovelDaoImpl();
			 Novel n=nl.getnovel(rs.getInt("bookid"));
			 c.setNovel(n);
			 
			 
			 AuthorDaoImpl al=new AuthorDaoImpl();
			 int authorid=n.getAuthorid();
			Author a=al.getauthor(authorid);
			 c.setAuthor(a);
			 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return c;
	}

	@Override
	public int update(Chapter c) {
		String sql="update chapter set chaptertitle=?,chapternumber=?,chapterprice=?,modifytime=now(),chaptercontent=? where chapterid=?";
		return super.excuteUpdate(sql, c.getChaptertitle(),c.getChapternumber(),c.getChapterprice(),c.getChaptercontent(),c.getChapterid());
	}

	@Override
	public Chapter maxupdatetime(int bookid) {
		String  sql="SELECT  chaptertitle,MAX(modifytime) FROM chapter WHERE bookid=?  GROUP BY bookid  ";
		super.excuteQuery(sql, bookid);
		Chapter c=null;
		try {
			while(rs.next())
			{
				c=new Chapter();
				c.setBookid(rs.getInt("bookid"));
				c.setChaptercontent(rs.getString("chaptercontent"));
				c.setChapterid(rs.getInt("chapterid"));
				c.setChapternumber(rs.getInt("chapternumber"));
				c.setChapterprice(rs.getInt("chapterprice"));
				c.setChaptertitle(rs.getString("chaptertitle"));
				c.setEstablishtime(rs.getString("establishtime"));
				c.setModifytime(rs.getString("modifytime"));
				
				
				NovelDaoImpl nl=new NovelDaoImpl();
			    Novel n=nl.getnovel(rs.getInt("bookid"));
			    c.setNovel(n);
			 
			 
			 AuthorDaoImpl al=new AuthorDaoImpl();
			 int authorid=n.getAuthorid();
			Author a=al.getauthor(authorid);
			 c.setAuthor(a);
			 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return c;
	}

	@Override
	public int getminchapter(int bookid) {
	String sql="SELECT MIN(chapterid) FROM chapter WHERE bookid=?";
	super.excuteQuery(sql, bookid);
	int count=0;
	try {
		while(rs.next())
		{
			count=rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		super.CloseAll();
	}
	return count;
	}

	@Override
	public int getischarge(int bookid) {
		String sql="SELECT MIN(chapterprice) FROM chapter WHERE bookid=?";
		super.excuteQuery(sql, bookid);
		int count=0;
		try {
			while(rs.next())
			{
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return count;
	}

}
