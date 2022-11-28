package Sistema_administrativo_de_tienda.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionDb;
import database.CrudSelecteProductos;
import database.CrudSelecteVentas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReporteController  implements Initializable{
		private Connection con = new ConnectionDb().conectar();

	 	@FXML
	    private TextField Codigo;
	 
	 	@FXML
	    private TableView<CrudSelecteVentas> tablaVendidos;
	 
	 	@FXML
	    private TableColumn<CrudSelecteVentas, Integer> ColLote;

	    @FXML
	    private TableColumn<CrudSelecteVentas, Float> ColCantidad;

	    @FXML
	    private TableColumn<CrudSelecteVentas, String> ColCode;

	    @FXML
	    private TableColumn<CrudSelecteVentas, String> ColFechaVenta;

	    @FXML
	    private TableColumn<CrudSelecteVentas,String> ColNombre;

	    @FXML
	    private TableColumn<CrudSelecteVentas, Float> ColprecioC;

	    @FXML
	    private TableColumn<CrudSelecteVentas, Float> ColprecioV;

	    @FXML
	    private DatePicker FechaFinal;

	    @FXML
	    private DatePicker FechaInicial;

	    @FXML
	    private TextField Nombreproducto;

	    @FXML
	    private Button buscar;

	    @FXML
	    private Button regresar;
	    
	    

    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	this.ColLote.setCellValueFactory(new PropertyValueFactory("lot"));
    	this.ColCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
    	this.ColCode.setCellValueFactory(new PropertyValueFactory("codigo"));
    	this.ColFechaVenta.setCellValueFactory(new PropertyValueFactory("Fechaventa"));
    	this.ColprecioC.setCellValueFactory(new PropertyValueFactory("precioC"));
    	this.ColprecioV.setCellValueFactory(new PropertyValueFactory("precioV"));
    	this.ColNombre.setCellValueFactory(new PropertyValueFactory("name"));
    	
    	CrudSelecteVentas crudSelecteVentas = new CrudSelecteVentas(con);
    	ObservableList<CrudSelecteVentas> obs = crudSelecteVentas.allVentas();
    	
    	this.tablaVendidos.setItems(obs);
    
    	
		
	}

    @FXML
    void switchToMenu() {
    	
    	Navegador o = new Navegador("Menu jefe",regresar);
    	o.cambioVentanaAnterior();
    	
    }
    
    @FXML
    void BuscarReporte(ActionEvent event) {
    	
    	LocalDate inicial= FechaInicial.getValue();
    	LocalDate finale= FechaFinal.getValue();
    	String name = Nombreproducto.getText();
    	String code = Codigo.getText();
    	
    	
    	this.ColLote.setCellValueFactory(new PropertyValueFactory("lot"));
    	this.ColCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
    	this.ColCode.setCellValueFactory(new PropertyValueFactory("codigo"));
    	this.ColFechaVenta.setCellValueFactory(new PropertyValueFactory("Fechaventa"));
    	this.ColprecioC.setCellValueFactory(new PropertyValueFactory("precioC"));
    	this.ColprecioV.setCellValueFactory(new PropertyValueFactory("precioV"));
    	this.ColNombre.setCellValueFactory(new PropertyValueFactory("name"));
    	
    	CrudSelecteVentas crudSelecteVentas = new CrudSelecteVentas(con);
    	ObservableList<CrudSelecteVentas> obs = crudSelecteVentas.searchVentas(name, code, inicial, finale);
    	
    	this.tablaVendidos.setItems(obs);
    	
    }

}
