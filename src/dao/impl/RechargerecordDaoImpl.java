package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.RechargerecordDao;
import entity.Chapter;
import entity.Novel;
import entity.Rechargerecord;

public class RechargerecordDaoImpl  extends Basedao implements RechargerecordDao{

	@Override
	public int addRechargerecord(Rechargerecord re) {
	String sql="insert into rechargerecord (authorid ,price, rechargetime, rechargemode) value(?,?,now(),?)";
		return super.excuteUpdate(sql, re.getAuthorid(),re.getPrice(),re.getRechargemode());
	}

	@Override
	public List<Rechargerecord> getRechargerecord(int authorid) {
		String sql="select *From Rechargerecord where authorid=?";
		super.excuteQuery(sql, authorid);
		List<Rechargerecord> list=new ArrayList<Rechargerecord>();
		try {
			while(rs.next())
			{
				    
				    
				    Rechargerecord  r=new Rechargerecord();
				    r.setAuthorid(rs.getInt("authorid"));
				    r.setPrice(rs.getInt("price"));
				    r.setRechargemode(rs.getString("rechargemode"));
				    r.setRechargetime(rs.getString("rechargetime"));
				list.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.CloseAll();
		}
		return list;

	}

}
