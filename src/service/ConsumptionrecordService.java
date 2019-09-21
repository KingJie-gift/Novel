package service;

import java.util.List;

import entity.Consumptionrecord;

public interface ConsumptionrecordService {
	List<Consumptionrecord> getAll(int authorid);
	int addConsumptionre(int authorid,int chapterid,int price );
}
