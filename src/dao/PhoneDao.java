package dao;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

public interface PhoneDao {
	
	public int addCode(String phone,int code);
	public int delCode(String phone,int code);
	public String sendCode(String phone, int code) throws HttpException, IOException;
}
