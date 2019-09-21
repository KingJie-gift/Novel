package dao;

import java.util.List;

import entity.Consumptionrecord;

public interface ConsumptionrecordDao {
	List<Consumptionrecord> getAll(int authorid);
	int addConsumptionre(int authorid,int chapterid,int price);
}
