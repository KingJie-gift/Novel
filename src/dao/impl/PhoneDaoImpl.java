package dao.impl;







import java.io.IOException;

import javax.mail.Header;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import dao.Basedao;
import dao.PhoneDao;

public class PhoneDaoImpl extends Basedao implements PhoneDao{

	

	@Override
	public int addCode(String phone, int code) {
		String sql="insert into phone(phone,code) values(?,?)";
	
		
		return super.excuteUpdate(sql, phone,code);
	}

	@Override
	public int delCode(String phone, int code) {
		String sql="delete from phone where phone=? and code=?";
		return super.excuteUpdate(sql, phone,code);
	}

	@Override
	public String sendCode(String phone , int code) throws HttpException, IOException {
		 HttpClient client = new HttpClient();
		 PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
		 post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		 NameValuePair[] data ={ new NameValuePair("Uid", "任浩任浩"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob",phone),new NameValuePair("smsText","验证码："+code)};
		 post.setRequestBody(data);

		 client.executeMethod(post);
		 String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		 post.releaseConnection();
		 System.out.println(result);
		return result;
	}

}
