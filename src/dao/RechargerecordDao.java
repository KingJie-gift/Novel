package dao;

import java.util.List;

import entity.Rechargerecord;

public interface RechargerecordDao {
int addRechargerecord(Rechargerecord re);
List<Rechargerecord>getRechargerecord(int authorid);
}
