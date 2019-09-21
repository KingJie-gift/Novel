package service.impl;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.httpclient.HttpException;

import dao.impl.PhoneDaoImpl;
import service.PhoneService;

public class PhoneServiceImpl implements PhoneService {
	PhoneDaoImpl pdi=new PhoneDaoImpl();
	@Override
	public int addCode(String phone, int code) {
		int result=pdi.addCode(phone, code);
		del(phone, code);
		return result;
	}
	
	//¶¨Ê±É¾³ý
	 public  void del(final String phone, final int code){
	        Timer nTimer = new Timer();
	        nTimer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	               pdi.delCode(phone, code);
	            }
	        },60000);
	    }

	
	@Override
	public int delCode(String phone, int code) {
		return pdi.delCode(phone, code);
	}

	@Override
	public String sendCode(String phone, int code) throws HttpException, IOException {
		return pdi.sendCode(phone,code);
	}

}
