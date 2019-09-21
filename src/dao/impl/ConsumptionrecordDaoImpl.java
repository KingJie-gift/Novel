package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.ConsumptionrecordDao;
import entity.Chapter;
import entity.Consumptionrecord;

public class ConsumptionrecordDaoImpl extends Basedao implements
		ConsumptionrecordDao {

	@Override
	public List<Consumptionrecord> getAll(int authorid) {
		List<Consumptionrecord> list=new ArrayList<Consumptionrecord>();
		String sql="select * from Consumptionrecord where authorid=?";
		super.excuteQuery(sql, authorid);
		try {
			while(rs.next()){
				Consumptionrecord c=new Consumptionrecord();
				c.setId(rs.getInt("id"));
				c.setChapterid(rs.getInt("chapterid"));
				c.setAuthorid(rs.getInt("authorid"));
				c.setConsumptiontime(rs.getString("consumptiontime"));
				c.setConsumptionamount(rs.getInt("consumptionamount"));
				
				
				ChapterDaoImpl  cl=new ChapterDaoImpl();
				 Chapter  chapter=cl.getchapters(rs.getInt("chapterid"));
				c.setChapter(chapter);
				list.add(c);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CloseAll();
		}
		return list;
	}

	@Override
	public int addConsumptionre(int authorid,int chapterid,int price) {
		String sql="insert into consumptionrecord(authorid,chapterid,consumptiontime,consumptionamount) values(?,?,NOW(),?)";
		int result=super.excuteUpdate(sql,authorid,chapterid,price);
		return result;
	}

}
