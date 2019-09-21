package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basedao {
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void GetConnection(){
		try {
			if(conn==null||conn.isClosed()){
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/novel","root","ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void CloseAll(){
		try {
			if(rs!=null){
			rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int excuteUpdate(String sql,Object...obj){
		int result=0;
		GetConnection();
		try {
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject((i+1), obj[i]);
			}
			result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CloseAll();
		}
		return result;
	}
	public void excuteQuery(String sql,Object...obj){
		GetConnection();
		try {
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject((i+1), obj[i]);
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
