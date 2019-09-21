package dao.impl;

import java.sql.SQLException;

import dao.Basedao;
import dao.BuychapterDao;

public class BuychapterDaoImpl extends Basedao implements BuychapterDao {

	@Override
	public int add(int bookid,int chapterid, int authorid) {
		String sql="insert into buychapter (bookid,chapterid,authorid) value(?,?,?)";
		return super.excuteUpdate(sql,bookid,chapterid,authorid );
	}

	@Override
	public int getbuy(int chapterid, int authorid) {
	String sql="select count(*) from buychapter where authorid=? and chapterid=?";
	super.excuteQuery(sql, authorid,chapterid);
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
	public int getauthoridprice(int chapterid, int authorid) {
	String sql="UPDATE  author SET  authorprice=?  WHERE authorid=?";
	
		return super.excuteUpdate(sql, chapterid,authorid);
	}

	
}
