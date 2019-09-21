package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.Basedao;
import dao.CommentDao;
import entity.Comment;
import entity.Page;

public class CommentDaoImpl extends Basedao implements CommentDao{

	@Override
	public int add(Comment cm) {
		String sql="insert into comment(authorid,bookid,commenttime,content)  values(?,?,?,?)";
		Date date=new Date();
		return super.excuteUpdate(sql, cm.getAuthorid(),cm.getBookid(),date,cm.getContent());
	}

	@Override
	public List plfen(Page p, int bookid) {
		List li=new ArrayList();
		Comment com=null;
		String sql="SELECT * FROM COMMENT  WHERE bookid=?   ORDER BY commenttime DESC LIMIT ?,?";
		super.excuteQuery(sql, bookid,(p.getIndexpage()-1)*p.getSizepage(),p.getSizepage());
		try {
			while(rs.next()){
				com=new Comment();
				com.setCommentid(rs.getInt("commentid"));
				com.setAuthorid(rs.getInt("authorid"));
				com.setBookid(rs.getInt("bookid"));
				com.setCommenttime(rs.getString("commenttime"));
				com.setContent(rs.getString("content"));
				
				AuthorDaoImpl adi=new AuthorDaoImpl();
				com.setAuthor(adi.getauthor(rs.getInt("authorid")));
				
				li.add(com);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return li;
		
	
	}

	@Override
	public int getCount(int bookid) {
		String sql="select count(*) from comment where bookid=? ";
		int count=0;
		super.excuteQuery(sql, bookid);
		try {
			while(rs.next()){
			count=rs.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return count;
	}

}
