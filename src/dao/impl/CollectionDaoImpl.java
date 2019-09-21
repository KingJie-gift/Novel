package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.CollectionDao;
import entity.Collection;

public class CollectionDaoImpl extends Basedao implements CollectionDao {

	@Override
	public int collection(int authorid,int bookid) {
	String sql="SELECT  COUNT(*) FROM collection WHERE authorid=? AND bookid=?";
	super.excuteQuery(sql, authorid,bookid);
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
	public int addcollection(int authorid, int bookid) {
		String sql="insert into collection (authorid,bookid) values(?,?)";
		return super.excuteUpdate(sql,authorid, bookid);
	}

	@Override
	public List<Collection> getcollection(int authorid) {
		String sql="SELECT bookid FROM  collection WHERE authorid=?";
		super.excuteQuery(sql, authorid);
		List list=new ArrayList();
		try {
			while(rs.next())
			{
				Collection c=new Collection();
				c.setBookid(rs.getInt("bookid"));
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
	public int delte(int authorid, int bookid) {
	String sql="delete from collection where authorid=? and bookid=?";
		return super.excuteUpdate(sql, authorid,bookid);
	}

	@Override
	public int deleteall(int authorid) {
	String sql="delete from collection where authorid=?";
		return super.excuteUpdate(sql, authorid);
	}

}
