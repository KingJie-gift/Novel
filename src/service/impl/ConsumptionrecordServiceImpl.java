package service.impl;

import java.util.List;

import dao.impl.ConsumptionrecordDaoImpl;
import entity.Consumptionrecord;
import service.ConsumptionrecordService;

public class ConsumptionrecordServiceImpl implements ConsumptionrecordService {
	ConsumptionrecordDaoImpl cd=new ConsumptionrecordDaoImpl();
	
	@Override
	public List<Consumptionrecord> getAll(int authorid) {
		return cd.getAll(authorid);
	}

	@Override
	public int addConsumptionre(int authorid,int chapterid,int price ) {
		return cd.addConsumptionre(authorid, chapterid, price);
	}


}
