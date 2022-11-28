package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CrudDelete  {
	
	private Connection con;
	public CrudDelete(Connection con) {
		// TODO Auto-generated constructor stub
		this.con=con;
	}
	
	
	public void delUser(String str) {
		String sql = "delete from usuarios where usuario=?";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, str);
			System.out.println(statement.execute()?"exito!!":"Fail!!");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	
}