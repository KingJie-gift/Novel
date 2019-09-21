package service;

import java.util.List;

import entity.Rechargerecord;

public interface RechargerecordService {
int addRechargerecord(Rechargerecord re);
List<Rechargerecord>getRechargerecord(int authorid);
}
