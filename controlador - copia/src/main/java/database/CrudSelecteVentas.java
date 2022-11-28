package database;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Locale;

import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CrudSelecteVentas {
    private Connection connection;
    
    
    private String name;
    private float cantidad;
    public CrudSelecteVentas(String name, float cantidad, float precioV, String fechaventa, float precioC, int lot,
			String codigo) {
		super();
		this.name = name;
		this.cantidad = cantidad;
		this.precioV = precioV;
		Fechaventa = fechaventa;
		this.precioC = precioC;
		this.lot = lot;
		this.codigo = codigo;
	}



	private float precioV;
    private String Fechaventa;
    private float precioC;
    private int lot;
    private String codigo;
    
    

    public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
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

	public String getFechaventa() {
		return Fechaventa;
	}

	public void setFechaventa(String fechaventa) {
		Fechaventa = fechaventa;
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

	public CrudSelecteVentas(Connection connection) {
        this.connection = connection;
    }
    
    
    
   
    
    public CrudSelecteVentas(String name,String codigo,float cantidad, float precioC, float precioV,String fechaventa, int lot) {
		super();
		this.name = name;
		this.cantidad = cantidad;
		this.precioV = precioV;
		this.Fechaventa = fechaventa;
		this.precioC = precioC;
		this.lot = lot;
		this.codigo = codigo;
	}
    

	public ObservableList<CrudSelecteVentas> allVentas(){
    	ObservableList<CrudSelecteVentas> obs = FXCollections.observableArrayList();
        String sql = "select * from ventas;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
            	
            	String name = resultSet.getString(1);
            	
                String codigo1 = resultSet.getString(2);
                float cantidad = resultSet.getFloat(3);
                float precioCompra = resultSet.getFloat(4);
                float precioVenta = resultSet.getFloat(5);
                String fechaVenta = String.valueOf(resultSet.getDate(6));
                int lote = resultSet.getInt(7);
                
                
               CrudSelecteVentas all = new CrudSelecteVentas(name,codigo1, cantidad, precioCompra , precioVenta, fechaVenta,lote);
               obs.add(all);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        
        for (CrudSelecteVentas crudSelecteVentas : obs) {
			System.out.println(crudSelecteVentas.getFechaventa());
		}
        return obs;

    }
    
    

    public ObservableList<CrudSelecteVentas> searchVentas(String nombre, String codigo,LocalDate inicial,LocalDate fin){
    	ObservableList<CrudSelecteVentas> obs = FXCollections.observableArrayList();
        String sql = "SELECT * FROM ventas where (name=? or codigo=? ) and (\"fechaVenta\"<=? and \"fechaVenta\">=?);";
        try {
        	PreparedStatement statement = connection.prepareStatement(sql);
        	statement.setString(1, nombre);
        	statement.setString(2, codigo);
        	statement.setDate(3, Date.valueOf(fin));
        	statement.setDate(4, Date.valueOf(inicial));
        	
        	
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
            	
            	String name = resultSet.getString(1);
                String codigo1 = resultSet.getString(2);
                float cantidad = resultSet.getFloat(3);
                float precioCompra = resultSet.getFloat(4);
                float precioVenta = resultSet.getFloat(5);
                String fechaVenta = String.valueOf(resultSet.getDate(6)) ;
                int lote = resultSet.getInt(7); 
                
                
               CrudSelecteVentas all = new CrudSelecteVentas(name,codigo1, cantidad, precioCompra , precioVenta, fechaVenta,lote);
               obs.add(all);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return obs;
    }

    
	

}
