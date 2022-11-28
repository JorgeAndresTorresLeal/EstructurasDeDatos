package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Observable;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 
public class CrudUpadate {
	
	private String name;
	private String codigo;
	private float cantidad;
	private float precio;
	private String razon;
	private LocalDate fecha;
	private Connection con;
	private int lote;
	private float precioC;
	
	public int getLote() {
		return lote;
	}


	public void setLote(int lote) {
		this.lote = lote;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public float getCantidad() {
		return cantidad;
	}


	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


	public String getRazon() {
		return razon;
	}



	public void setRazon(String razon) {
		this.razon = razon;
	}


	public CrudUpadate(Connection con) {
		this.con =  con;
	}
	
	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

	public CrudUpadate(String name, String codigo, float cantidad, float precio, String razon, LocalDate fecha, int lote, float precioC) {
		this.name = name;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.razon = razon;
		this.fecha = fecha;
		this.lote =lote;
		this.precioC =precioC;
	}


	public void updatePass(String user, String pass) {
		String sql = "UPDATE usuarios\r\n"
				+ "	SET password=?\r\n"
				+ "	WHERE usuario=?;";
		try {
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, pass);
		statement.setString(2, user);
		statement.execute();
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public ObservableList<CrudUpadate> hacerVenta(String codigo, int lote, float cantidad, String razon) {
		LocalDate fecha1 = LocalDate.now();
		String nombre="";
		float precio=0;
		ObservableList<CrudUpadate> obs = FXCollections.observableArrayList();
		//if(!ob.isEmpty())
		//obs.add(ob.get(0));
		CrudUpadate upVenta = new CrudUpadate(nombre, codigo, cantidad, precio, razon, fecha1, 1,0);
		
		String sql = "SELECT  name, precio, lote\r\n"
				+ "	FROM productos where codigo =?;";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, codigo);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				upVenta.setName(result.getString(1));
				upVenta.setLote(result.getInt(3));
				precio = result.getFloat(2);
				precio=precio*cantidad;
				upVenta.setPrecio(precio);
				obs.add(upVenta);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return obs;
		
	}

	public void confimarVenta(ObservableList<CrudUpadate> crudUpadates) {
		float precioC;
		float cantidad=0;
		String preProducto = "select precioc from productos where codigo=? and lote=?;";
		
		String canProducto = "select cantidad from productos where codigo =? and lote =?;";
		
		String upProducto = "UPDATE productos\r\n"
				+ "	SET cantidad=?\r\n"
				+ "	WHERE codigo=? and lote=?;";
		
		String insVentas = "INSERT INTO ventas(\r\n"
				+ "	name, codigo, cantidad, precioCompra, precioVenta, fechaVenta, lote)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement statement1 = con.prepareStatement(preProducto);
			PreparedStatement statement2 = con.prepareStatement(canProducto);
			
			
			for (CrudUpadate crudUpadate : crudUpadates) {
				
				
				statement1.setString(1, crudUpadate.getCodigo());
				statement1.setInt(2, crudUpadate.getLote());
				ResultSet resultSet1 = statement1.executeQuery();
				
				if(resultSet1.next())
				crudUpadate.setPrecioC(resultSet1.getFloat(1)*crudUpadate.getCantidad());
				
				//
				statement2.setString(1, crudUpadate.getCodigo());
				statement2.setInt(2, crudUpadate.getLote());
				ResultSet resultSet2 = statement2.executeQuery();
				
				if(resultSet2.next()) {
					cantidad = resultSet2.getFloat(1) - crudUpadate.getCantidad();
					System.out.println(cantidad);
					}
				
					PreparedStatement statement3 = con.prepareStatement(upProducto);
					statement3.setFloat(1, cantidad);
					statement3.setString(2, crudUpadate.getCodigo());
					statement3.setInt(3, crudUpadate.getLote());
					statement3.execute();
				
				
				PreparedStatement statement4 = con.prepareStatement(insVentas);
				statement4.setString(1, crudUpadate.getName());
				statement4.setString(2, crudUpadate.getCodigo());
				statement4.setFloat(3, crudUpadate.getCantidad());
				statement4.setFloat(4, crudUpadate.getPrecioC());
				statement4.setFloat(5, crudUpadate.getPrecio());
				statement4.setDate(6, Date.valueOf(crudUpadate.getFecha()) );
				statement4.setInt(7, crudUpadate.getLote());
				statement4.executeUpdate();
				
				
				
				
				
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
		}
		
		
		
		
	}


	public float getPrecioC() {
		return precioC;
	}


	public void setPrecioC(float precioC) {
		this.precioC = precioC;
	}
	

}
