package dao.impl;

import java.sql.SQLException;

import dao.AuthorDao;
import dao.Basedao;
import entity.Author;

public class AuthorDaoImpl extends Basedao implements AuthorDao {

	@Override
	public int Insert(Author a) {
		String sql="INSERT INTO author (authorname,authorpwd,authorprice,collectionbook,releasebook,email,phone) VALUES(?,?,?,?,?,?,?)";
		int result=super.excuteUpdate(sql, a.getAuthorname(),a.getPwd(),a.getAuthorprice(),a.getCollectionbook(),a.getReleasebook(),a.getEmail(),a.getPhone());
		return result;
	}

	@Override
	public Author getauthor(int id) {
		String sql="select *from author where authorid=?";
		super.excuteQuery(sql, id);
		Author a=null;
		try {
			while(rs.next())
			{
				a=new Author();
				a.setAuthorid(rs.getInt("authorid"));
				a.setAuthorname(rs.getString("authorname"));
				a.setPwd(rs.getString("authorpwd"));
				a.setAuthorprice(rs.getDouble("authorprice"));
				a.setCollectionbook(rs.getInt("collectionbook"));
				a.setReleasebook(rs.getInt("releasebook"));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return a;
	}

	@Override
	public int addauthoridprice(double price, int authorid) {
		String sql="update author set authorprice=? where authorid=?";
		
		return super.excuteUpdate(sql, price,authorid);
	}

	@Override
	public int updateadmin(double price) {
       String sql="update author set authorprice=? where authorid=3";
		
		return super.excuteUpdate(sql, price);
	}

	@Override
	public int updatezuozhe(double price, int zuozheid) {
		 String sql="update author set authorprice=? where authorid=?";
			
			return super.excuteUpdate(sql, price,zuozheid);
	}
	public int Update(Author a) {
		String sql="update author set authorname=?,authorpwd=?,authorprice=?,email=? where authorid=?";
		int result=super.excuteUpdate(sql, a.getAuthorname(),a.getPwd(),0,a.getEmail(),a.getAuthorid());
		return result;
	}

	@Override
	public int checkauthorname(String name) {
		Author a=null;
		String sql="SELECT count(*) FROM author WHERE authorname=?";
		super.excuteQuery(sql,name);
		int count=0;
		try {
			while(rs.next()){
				a=new Author();
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CloseAll();
		}
		return count;
		
	}

	@Override
	public Author login(Author a) {
		String sql="select * from  author where authorname=? and authorpwd=? ";
		Author au=null;
		super.excuteQuery(sql, a.getAuthorname(),a.getPwd());
		try {
			if(rs.next()){
				au=new Author();
				au.setAuthorid(rs.getInt("authorid"));
				au.setAuthorname(rs.getString("authorname"));
				au.setPwd(rs.getString("authorpwd"));
				au.setAuthorprice(rs.getDouble("authorprice"));
			     au.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return au;
	}
}
