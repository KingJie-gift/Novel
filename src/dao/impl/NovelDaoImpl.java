package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.NovelDao;
import entity.Author;
import entity.Booktype;
import entity.Novel;
import entity.Page;

public class NovelDaoImpl extends Basedao implements NovelDao {

	@Override
	public List<Novel> getAll(String name) {
		List<Novel> list=new ArrayList<Novel>();
		String sql="SELECT * FROM novels WHERE bookname LIKE '%"+name+"%'";
		super.excuteQuery(sql);
		try {
			while(rs.next()){
				Novel n=new Novel();
				n.setBookid(rs.getInt("bookid"));
				n.setBookname(rs.getString("bookname"));
				n.setBooktype(rs.getInt("booktype"));
				n.setBooktitle(rs.getString("booktitle"));
				n.setBookoutline(rs.getString("bookoutline"));
				n.setAuthorid(rs.getInt("authorid"));
				n.setBookstate(rs.getString("bookstate"));
				n.setIscharge(rs.getString("ischarge"));
				n.setPlatform(rs.getString("platform"));
				n.setBooknumber(rs.getInt("booknumber"));
				n.setClicks(rs.getInt("clicks"));
				n.setImages(rs.getString("image"));
				n.setSendword(rs.getString("sendword"));
				n.setShouzimu(rs.getString("bookshouzimu"));
	
				
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CloseAll();
		}
		return list;
	}

	@Override
	public int add(Novel n) {
		String sql="insert into novels (bookname,booktype,booktitle,bookoutline,authorid,bookstate,ischarge,platform,booknumber,clicks,image,sendword,bookshouzimu) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return super.excuteUpdate(sql, n.getBookname(),n.getBooktype(),n.getBooktitle(),n.getBookoutline(),n.getAuthorid(),"连载","免费",n.getPlatform(),0,0,n.getImages(),n.getSendword(),n.getShouzimu());
	}

	@Override
	public int update(Novel n) {
		String sql="update novels  set bookname=?, booktype=?,booktitle=?,bookoutline=?,bookstate=?,platform=?,booknumber=?,clicks=?,image=?,sendword=?,bookshouzimu=? where bookid=?";
		return super.excuteUpdate(sql, n.getBookname(),n.getBooktype(),n.getBooktitle(),n.getBookoutline(),n.getBookstate(),n.getPlatform(),n.getBooknumber(),n.getClicks(),n.getImages(),n.getSendword(),n.getShouzimu(),n.getBookid());
	}

	@Override
	public List<Novel> getnovle(int id) {
		String sql="SELECT *FROM novels WHERE authorid=?";
		super.excuteQuery(sql, id);
	   List<Novel>list=new ArrayList<Novel>();
		try {
			while(rs.next()){
			    Novel	n=new Novel();
				n.setBookid(rs.getInt("bookid"));
				n.setBookname(rs.getString("bookname"));
				n.setBooktype(rs.getInt("booktype"));
				n.setBooktitle(rs.getString("booktitle"));
				n.setBookoutline(rs.getString("bookoutline"));
				n.setAuthorid(rs.getInt("authorid"));
				n.setBookstate(rs.getString("bookstate"));
				n.setIscharge(rs.getString("ischarge"));
				n.setPlatform(rs.getString("platform"));
				n.setBooknumber(rs.getInt("booknumber"));
				n.setClicks(rs.getInt("clicks"));
				n.setImages(rs.getString("image"));
				n.setSendword(rs.getString("sendword"));
				n.setShouzimu(rs.getString("bookshouzimu"));
				
				AuthorDaoImpl al=new AuthorDaoImpl();
				Author a=al.getauthor(rs.getInt("authorid"));
				n.setAuthor(a);
				
				
				BooktypeDaoImpl bt=new BooktypeDaoImpl();
			     Booktype b= bt.gettype(rs.getInt("booktype"));
			     n.setType(b);
				
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	@Override
	public int getall(int id) {
		String sql="SELECT  COUNT(*)FROM novels WHERE authorid=?";
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
	public List getpage(Page p) {
		String sql="select *from  novels   limit ?,?";
		super.excuteQuery(sql, (p.getIndexpage()-1)*p.getSizepage(),p.getSizepage());
		List list=new ArrayList();
		try {
			while(rs.next())
			{
				  Novel	n=new Novel();
					n.setBookid(rs.getInt("bookid"));
					n.setBookname(rs.getString("bookname"));
					n.setBooktype(rs.getInt("booktype"));
					n.setBooktitle(rs.getString("booktitle"));
					n.setBookoutline(rs.getString("bookoutline"));
					n.setAuthorid(rs.getInt("authorid"));
					n.setBookstate(rs.getString("bookstate"));
					n.setIscharge(rs.getString("ischarge"));
					n.setPlatform(rs.getString("platform"));
					n.setBooknumber(rs.getInt("booknumber"));
					n.setClicks(rs.getInt("clicks"));
					n.setImages(rs.getString("image"));
					n.setSendword(rs.getString("sendword"));
					n.setShouzimu(rs.getString("bookshouzimu"));
					list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	@Override
	public Novel getnovel(int id) {
		String sql="select *From novels where bookid=?";
		super.excuteQuery(sql, id);
		Novel n=null;
		try {
			while(rs.next())
			{
				  	n=new Novel();
					n.setBookid(rs.getInt("bookid"));
					n.setBookname(rs.getString("bookname"));
					n.setBooktype(rs.getInt("booktype"));
					n.setBooktitle(rs.getString("booktitle"));
					n.setBookoutline(rs.getString("bookoutline"));
					n.setAuthorid(rs.getInt("authorid"));
					n.setBookstate(rs.getString("bookstate"));
					n.setIscharge(rs.getString("ischarge"));
					n.setPlatform(rs.getString("platform"));
					n.setBooknumber(rs.getInt("booknumber"));
					n.setClicks(rs.getInt("clicks"));
					n.setImages(rs.getString("image"));
					n.setSendword(rs.getString("sendword"));
					
					n.setShouzimu(rs.getString("bookshouzimu"));
					
					
					BooktypeDaoImpl bt=new BooktypeDaoImpl();
				     Booktype b= bt.gettype(rs.getInt("booktype"));
				     n.setType(b);
				     
				     
				     AuthorDaoImpl al=new AuthorDaoImpl();
				     Author a=al.getauthor(rs.getInt("authorid"));
				     n.setAuthor(a);
				     
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return n;
	}

	@Override
	public Novel getauthorid(int authorid,String bookname) {
		String sql="SELECT *FROM novels WHERE authorid=? AND bookname=? ";
		super.excuteQuery(sql, authorid,bookname);
		Novel n=null;
		try {
			while(rs.next())
			{
				  	n=new Novel();
					n.setBookid(rs.getInt("bookid"));
					n.setBookname(rs.getString("bookname"));
					n.setBooktype(rs.getInt("booktype"));
					n.setBooktitle(rs.getString("booktitle"));
					n.setBookoutline(rs.getString("bookoutline"));
					n.setAuthorid(rs.getInt("authorid"));
					n.setBookstate(rs.getString("bookstate"));
					n.setIscharge(rs.getString("ischarge"));
					n.setPlatform(rs.getString("platform"));
					n.setBooknumber(rs.getInt("booknumber"));
					n.setClicks(rs.getInt("clicks"));
					n.setImages(rs.getString("image"));
					n.setSendword(rs.getString("sendword"));
					n.setShouzimu(rs.getString("bookshouzimu"));
					
					 AuthorDaoImpl al=new AuthorDaoImpl();
				     Author a=al.getauthor(rs.getInt("authorid"));
				     n.setAuthor(a);
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return n;
	}

	@Override
	public List<Novel> getAllnovel(String bookname,int typeid,Page p) {
		
		String sql="SELECT *FROM novels WHERE bookname LIKE'%"+bookname+"%' LIMIT ?,?";
		if(typeid!=-1)
		{
		 sql="SELECT *FROM novels WHERE bookname LIKE'%"+bookname+"%' and booktype="+typeid+" LIMIT ?,?";
		}
		super.excuteQuery(sql, (p.getIndexpage()-1)*p.getSizepage(),p.getSizepage());
        List<Novel>list=new ArrayList<Novel>();
		try {
			while(rs.next())
			{
				    Novel n=new Novel();
					n.setBookid(rs.getInt("bookid"));
					n.setBookname(rs.getString("bookname"));
					n.setBooktype(rs.getInt("booktype"));
					n.setBooktitle(rs.getString("booktitle"));
					n.setBookoutline(rs.getString("bookoutline"));
					n.setAuthorid(rs.getInt("authorid"));
					n.setBookstate(rs.getString("bookstate"));
					n.setIscharge(rs.getString("ischarge"));
					n.setPlatform(rs.getString("platform"));
					n.setBooknumber(rs.getInt("booknumber"));
					n.setClicks(rs.getInt("clicks"));
					n.setImages(rs.getString("image"));
					n.setSendword(rs.getString("sendword"));
					n.setShouzimu(rs.getString("bookshouzimu"));
					
					AuthorDaoImpl al=new AuthorDaoImpl();
					Author a=al.getauthor(rs.getInt("authorid"));
					n.setAuthor(a);
					
					
					BooktypeDaoImpl bt=new BooktypeDaoImpl();
				     Booktype b= bt.gettype(rs.getInt("booktype"));
				     n.setType(b);
				   list.add(n);
				   
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	@Override
	public int getallnovel(String name,int typeid) {
		String sql="SELECT COUNT(*)FROM novels WHERE bookname LIKE'%"+name+"%'";
		if(typeid!=-1)
		{
			sql="SELECT COUNT(*)FROM novels WHERE bookname LIKE '%"+name+"%' AND booktype="+typeid;
		}
		super.excuteQuery(sql);
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
	public List<Novel> getnovellist(int bookid) {
		String sql="SELECT *FROM novels WHERE bookid=?";
		super.excuteQuery(sql, bookid);
	   List<Novel>list=new ArrayList<Novel>();
		try {
			while(rs.next()){
			    Novel	n=new Novel();
				n.setBookid(rs.getInt("bookid"));
				n.setBookname(rs.getString("bookname"));
				n.setBooktype(rs.getInt("booktype"));
				n.setBooktitle(rs.getString("booktitle"));
				n.setBookoutline(rs.getString("bookoutline"));
				n.setAuthorid(rs.getInt("authorid"));
				n.setBookstate(rs.getString("bookstate"));
				n.setIscharge(rs.getString("ischarge"));
				n.setPlatform(rs.getString("platform"));
				n.setBooknumber(rs.getInt("booknumber"));
				n.setClicks(rs.getInt("clicks"));
				n.setImages(rs.getString("image"));
				n.setSendword(rs.getString("sendword"));
				n.setShouzimu(rs.getString("bookshouzimu"));
				AuthorDaoImpl al=new AuthorDaoImpl();
				Author a=al.getauthor(rs.getInt("authorid"));
				n.setAuthor(a);
				
				
				BooktypeDaoImpl bt=new BooktypeDaoImpl();
			     Booktype b= bt.gettype(rs.getInt("booktype"));
			     n.setType(b);
				
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
	}
		return list;
	}

	@Override
	public int updatenovelclicks(int clicks,int bookid) {
	 String sql="UPDATE novels SET clicks=?  WHERE bookid=?";
	 
		return super.excuteUpdate(sql, clicks,bookid);
	}

	@Override
	public List<Novel> getallnovel() {
		String sql="SELECT *FROM novels where bookstate='完本'";
		super.excuteQuery(sql);
	   List<Novel>list=new ArrayList<Novel>();
		try {
			while(rs.next()){
			    Novel	n=new Novel();
				n.setBookid(rs.getInt("bookid"));
				n.setBookname(rs.getString("bookname"));
				n.setBooktype(rs.getInt("booktype"));
				n.setBooktitle(rs.getString("booktitle"));
				n.setBookoutline(rs.getString("bookoutline"));
				n.setAuthorid(rs.getInt("authorid"));
				n.setBookstate(rs.getString("bookstate"));
				n.setIscharge(rs.getString("ischarge"));
				n.setPlatform(rs.getString("platform"));
				n.setBooknumber(rs.getInt("booknumber"));
				n.setClicks(rs.getInt("clicks"));
				n.setImages(rs.getString("image"));
				n.setSendword(rs.getString("sendword"));
				n.setShouzimu(rs.getString("bookshouzimu"));
				AuthorDaoImpl al=new AuthorDaoImpl();
				Author a=al.getauthor(rs.getInt("authorid"));
				n.setAuthor(a);
				
				
				BooktypeDaoImpl bt=new BooktypeDaoImpl();
			     Booktype b= bt.gettype(rs.getInt("booktype"));
			     n.setType(b);
				
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
	}
		return list;
	}

	@Override
	public List getauthornovel(Page p, int authorid) {
		String sql="select *from  novels where authorid=?  limit ?,?";
		super.excuteQuery(sql,authorid, (p.getIndexpage()-1)*p.getSizepage(),p.getSizepage());
		List list=new ArrayList();
		try {
			while(rs.next())
			{
				  Novel	n=new Novel();
					n.setBookid(rs.getInt("bookid"));
					n.setBookname(rs.getString("bookname"));
					n.setBooktype(rs.getInt("booktype"));
					n.setBooktitle(rs.getString("booktitle"));
					n.setBookoutline(rs.getString("bookoutline"));
					n.setAuthorid(rs.getInt("authorid"));
					n.setBookstate(rs.getString("bookstate"));
					n.setIscharge(rs.getString("ischarge"));
					n.setPlatform(rs.getString("platform"));
					n.setBooknumber(rs.getInt("booknumber"));
					n.setClicks(rs.getInt("clicks"));
					n.setImages(rs.getString("image"));
					n.setSendword(rs.getString("sendword"));
					n.setShouzimu(rs.getString("bookshouzimu"));
					list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	@Override
	public int updateischarge(String ischarge,int bookid) {
		String  sql="UPDATE  novels SET ischarge=?  WHERE bookid=?";
		return super.excuteUpdate(sql, ischarge,bookid);
	}

	@Override
	public List<Novel> numberlist() {
		String sql="SELECT     *FROM  novels ORDER BY booknumber DESC LIMIT 5";
		super.excuteQuery(sql);
		List<Novel> list=new ArrayList<Novel>();
		try {
			while(rs.next())
			{
				  Novel	n=new Novel();
					n.setBookid(rs.getInt("bookid"));
					n.setBookname(rs.getString("bookname"));
					n.setBooktype(rs.getInt("booktype"));
					n.setBooktitle(rs.getString("booktitle"));
					n.setBookoutline(rs.getString("bookoutline"));
					n.setAuthorid(rs.getInt("authorid"));
					n.setBookstate(rs.getString("bookstate"));
					n.setIscharge(rs.getString("ischarge"));
					n.setPlatform(rs.getString("platform"));
					n.setBooknumber(rs.getInt("booknumber"));
					n.setClicks(rs.getInt("clicks"));
					n.setImages(rs.getString("image"));
					n.setSendword(rs.getString("sendword"));
					n.setShouzimu(rs.getString("bookshouzimu"));
					
					AuthorDaoImpl al=new AuthorDaoImpl();
					Author a=al.getauthor(rs.getInt("authorid"));
					n.setAuthor(a);
					
					
					BooktypeDaoImpl bt=new BooktypeDaoImpl();
				     Booktype b= bt.gettype(rs.getInt("booktype"));
				     n.setType(b);
					
					
					
					list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	@Override
	public List<Novel> newlist() {
		String sql=" SELECT   DISTINCT novels.bookid,novels.bookname,novels.authorid,novels.booktype,novels.image FROM  novels  INNER JOIN chapter  ON novels.bookid=chapter.bookid ORDER BY chapter.modifytime DESC  LIMIT 5";
		super.excuteQuery(sql);
		List<Novel> list=new ArrayList<Novel>();
		try {
			while(rs.next())
			{
				  Novel	n=new Novel();
					n.setBookid(rs.getInt("bookid"));
					n.setBookname(rs.getString("bookname"));
					n.setBooktype(rs.getInt("booktype"));
				
					n.setImages(rs.getString("image"));
					
					AuthorDaoImpl al=new AuthorDaoImpl();
					Author a=al.getauthor(rs.getInt("authorid"));
					n.setAuthor(a);
					
					
					BooktypeDaoImpl bt=new BooktypeDaoImpl();
				     Booktype b= bt.gettype(rs.getInt("booktype"));
				     n.setType(b);
					
					
					
					list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	
	
}
