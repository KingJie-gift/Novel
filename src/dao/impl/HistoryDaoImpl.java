package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.HistoryDao;
import entity.Chapter;
import entity.Collection;
import entity.History;
import entity.Novel;

public class HistoryDaoImpl extends Basedao implements HistoryDao {

	@Override
	public int updatehistory(int bookid ,int chapterid,int authorid) {
	String sql="update history set chapterid=? , bookid=? where author=? and bookid=?";
			return super.excuteUpdate(sql,chapterid,bookid,authorid,bookid );
	}

	@Override
	public int addhistory(int bookid ,int chapterid,int authorid) {
		String sql="insert into history (bookid,chapterid,author) value(?,?,?)";
		return super.excuteUpdate(sql, bookid,chapterid,authorid);
	}

	@Override
	public List<History> gethistorylist(int authorid) {
	String sql="SELECT chapterid FROM  history WHERE author=?";
		super.excuteQuery(sql, authorid);
		List list=new ArrayList();
		try {
			while(rs.next())
			{
				History c=new History();
				c.setChaperid(rs.getInt("chapterid"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;
		
	}

}
