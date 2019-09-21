package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.BooktypeDao;
import entity.Booktype;

public class BooktypeDaoImpl extends Basedao implements BooktypeDao  {

	@Override
	public List getbooktype() {
		String sql="select *from booktype";
		super.excuteQuery(sql);
		List list=new ArrayList();
		try {
			while(rs.next())
			{
				Booktype bt=new Booktype();
				bt.setBookid(rs.getInt("bookid"));
				bt.setBooktype(rs.getString("booktype"));
				list.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
	}

	@Override
	public Booktype gettype(int id) {
		String sql="select *From booktype where bookid=?";
		super.excuteQuery(sql, id);
		Booktype bt=null;
		try {
			while(rs.next())
			{
				bt=new Booktype();
				bt.setBookid(rs.getInt("bookid"));
				bt.setBooktype(rs.getString("booktype"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return bt;
	}

}
