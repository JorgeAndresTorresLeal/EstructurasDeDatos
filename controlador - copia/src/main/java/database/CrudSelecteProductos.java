package database;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CrudSelecteProductos {
    private Connection connection;
    private int id;
    private String name;
    private float cantidad;
    private float precioV;
    private String vencimiento;
    private float precioC;
    private int lot;
    private String codigo;
    
    

    public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioV() {
		return precioV;
	}

	public void setPrecioV(float precioV) {
		this.precioV = precioV;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public float getPrecioC() {
		return precioC;
	}

	public void setPrecioC(float precioC) {
		this.precioC = precioC;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	

	public CrudSelecteProductos(Connection connection) {
        this.connection = connection;
    }
    
    
    
   
    
    public CrudSelecteProductos(String code, String name, float cantidad, float precioV, String vencimiento, float precioC,
			int lot) {
		this.codigo=code;
		this.name = name;
		this.cantidad = cantidad; 	 	
		this.precioV = precioV;
		this.vencimiento = vencimiento;
		this.precioC = precioC;
		this.lot = lot;
	}
    

	public ObservableList<CrudSelecteProductos> allProducts(){
		
    	ObservableList<CrudSelecteProductos> obs = FXCollections.observableArrayList();
        String sql = "select * from productos;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
            	
                String code = resultSet.getString(2);
                String name = resultSet.getString(1);
                float cantidad = resultSet.getFloat(4);
                float precioV = resultSet.getFloat(6);
                String vencimiento = String.valueOf(resultSet.getDate(5));
                float precioC = resultSet.getFloat(3);
                int lot = resultSet.getInt(7);
                
                
               CrudSelecteProductos all = new CrudSelecteProductos(code, name, cantidad, precioV, vencimiento, precioC, lot);
               obs.add(all);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return obs;

    }
    
    

    public ObservableList<CrudSelecteProductos> search(String nombre, String codigo){
    	ObservableList<CrudSelecteProductos> obs = FXCollections.observableArrayList();
        String sql = "select * from productos where name=? or codigo=?;";
        try {
        	PreparedStatement statement = connection.prepareStatement(sql);
        	statement.setString(1, nombre);
        	statement.setString(2, codigo);
        	
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
            	
                String code = resultSet.getString(2);
                String name = resultSet.getString(1);
                float cantidad = resultSet.getFloat(4);
                float precioV = resultSet.getFloat(6);
                String vencimiento = String.valueOf(resultSet.getDate(5));
                float precioC = resultSet.getFloat(3);
                int lot = resultSet.getInt(7);
                
                
               CrudSelecteProductos all = new CrudSelecteProductos(code, name, cantidad, precioV, vencimiento, precioC, lot);
               obs.add(all);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return obs;
    }

    
	

}
