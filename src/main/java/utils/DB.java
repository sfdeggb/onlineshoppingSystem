package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DB {
	private String driver_name = "com.mysql.jdbc.Driver";//qudong
	private String username = "root";//�û���
	private String password = "123456";//mima
	private String db_name = "ishopping";//database name
	private String url = "jdbc:mysql://localhost:3306/"+db_name;
	public Connection conn = null;
	public PreparedStatement ps = null;
	
	public void connect_db(){
		try{
			Class.forName(driver_name);
			conn = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close_db(){
		try{
			if(ps != null){
				ps.close();
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
