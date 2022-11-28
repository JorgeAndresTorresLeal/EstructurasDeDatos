package database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;



public class ConnectionDb{
    public Connection conectar(){
    	String url = "jdbc:mysql://localhost:3306/";
    	String bd = "estructurasdedatos?serverTimezone=UTC";
    	Connection con=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url + bd,"root","957846Oso");
            Statement stmt=con.createStatement();  
            
            System.out.println("Connected");  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }  
}