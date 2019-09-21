package service.impl;

import java.util.List;

import dao.impl.RechargerecordDaoImpl;
import entity.Rechargerecord;
import service.RechargerecordService;

public class RechargerecordServiceImpl  implements RechargerecordService{

	
	RechargerecordDaoImpl   rl=new RechargerecordDaoImpl();
	@Override
	public int addRechargerecord(Rechargerecord re) {
		return rl.addRechargerecord(re);
	}
	@Override
	public List<Rechargerecord> getRechargerecord(int authorid) {
		return rl.getRechargerecord(authorid);
	}

}
