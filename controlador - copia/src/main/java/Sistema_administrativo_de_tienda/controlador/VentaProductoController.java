package Sistema_administrativo_de_tienda.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionDb;
import database.CrudUpadate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VentaProductoController implements Initializable{
	
	private Float cantidadE;
	private String razonE;
	private int lot;
	private String code; 
	
	private Connection con = new ConnectionDb().conectar();

    @FXML
    private Button Agregar;

    @FXML
    private TextField DineroADevolver;

    @FXML
    private TextField DineroRecibido;

    @FXML
    private TableColumn<CrudUpadate, LocalDate> FechaVenta;
    
    @FXML
    private TextField EntradaCantidad;

    @FXML
    private TextField EntradaRazon;
    
    @FXML
    private TableColumn<CrudUpadate, String> Razon;

    @FXML
    private TextField Lote;
    

    @FXML
    private TableColumn<CrudUpadate, Float> Cantidad;

    @FXML
    private TableColumn<CrudUpadate, String> Codigo;

    @FXML
    private TableColumn<CrudUpadate, String> Nombre;

    @FXML
    private TableColumn<CrudUpadate, Float> Precio;

    @FXML
    private TextField Preciototal;

    @FXML
    private TextField entradaCodigo;

    @FXML
    private TableView<CrudUpadate> TablaVenta;

    @FXML
    private Button Terminar;

    @FXML
    private Button regresar;
    
    private ObservableList<CrudUpadate> obse;
    
    private int cont=0;
    
    Navegador o;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
    	
	}

    @FXML
    void switchToMenu() {
    	boolean comprobante = InicioController.globalcomprobante;
    	
    	
    	if(comprobante) {
    		
    		o = new Navegador("Menu empleado",regresar);
    		o.cambioVentanaAnterior();
	    	
    	}else {
    		o = new Navegador("Menu jefe",regresar);
    		o.cambioVentanaAnterior();
    	}
    }

    @FXML
    void Agregar(ActionEvent event) {
    	Float cantidadE = Float.parseFloat(EntradaCantidad.getText());
    	String razonE = EntradaRazon.getText();
    	int lot = Integer.parseInt(Lote.getText());
    	String code = entradaCodigo.getText();
    	
    	this.Nombre.setCellValueFactory(new PropertyValueFactory("name"));
		this.Razon.setCellValueFactory(new PropertyValueFactory("razon"));
		this.Codigo.setCellValueFactory(new PropertyValueFactory("codigo"));
		this.Precio.setCellValueFactory(new PropertyValueFactory("precio"));
		this.FechaVenta.setCellValueFactory(new PropertyValueFactory("fecha"));
		this.Cantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
    	
		CrudUpadate upp = new CrudUpadate(con);
		if(cont ==0) {
		ObservableList<CrudUpadate> obs = upp.hacerVenta(code, lot, cantidadE, razonE);
		obse=obs;
		cont++;
		System.out.println(obse.size());
		}else {
			
			obse.add(upp.hacerVenta(code, lot, cantidadE, razonE).get(0));
			System.out.println(obse.size()); 
			System.out.println(obse.get(obse.size()-1));
		}
		
		this.TablaVenta.setItems(obse);
    	float suma=0;
		for (CrudUpadate crudUpadate : obse) {
			suma += crudUpadate.getPrecio();
		}
		
		Preciototal.setText(Float.valueOf(suma).toString());
		
    	
    }
    

    @FXML
    void TerminarVenta(ActionEvent event) {
    	
    	
    	float a = Float.parseFloat(Preciototal.getText()) ;
    	float b = Float.parseFloat(DineroRecibido.getText()) ;
    	float c= b-a;
    	DineroADevolver.setText(Float.valueOf(c).toString());
    	
    	System.out.println(obse.size());
    	
    	CrudUpadate crudUpadate = new CrudUpadate(con);
    	crudUpadate.confimarVenta(obse);
    	
    	
    	System.out.println(obse.size());
    		
    	
    	
    	
    	
    }


}
