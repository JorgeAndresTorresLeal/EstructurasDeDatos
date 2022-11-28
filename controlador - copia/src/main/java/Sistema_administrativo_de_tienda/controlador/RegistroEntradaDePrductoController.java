package Sistema_administrativo_de_tienda.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionDb;
import database.CrudInsert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroEntradaDePrductoController implements Initializable{

    @FXML
    private Button regresar;
    
    @FXML
    private TextField Lote;
    
    @FXML
    private TextField Precioventa;
    
    @FXML
    private TextField Cantidad;

    @FXML
    private TextField Codigoproducto;

    @FXML
    private DatePicker Fechavencimiento;

    @FXML
    private Button Guardar;

    @FXML
    private TextField Nombreproducto;

    @FXML
    private TextField Preciocompraproducto;

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
    void Guardarentradadeproducto(ActionEvent event) {
    	
    	try {
	    	String nombreproducto = Nombreproducto.getText();
	    	String codigoproducto = Codigoproducto.getText();   		
	    	float precioCompra = Float.parseFloat(Preciocompraproducto.getText());
	    	float cantidad = Float.parseFloat(Cantidad.getText());
	    	LocalDate fechaDeVencimiento = Fechavencimiento.getValue();
	    	float precioVenta = Float.parseFloat(Precioventa.getText());
	    	int lote = Integer.parseInt(Lote.getText());
	    	
	    	HashTableQuadraticProbing <Integer, Float> hashtableFloats = new HashTableQuadraticProbing<>();
	    	HashTableQuadraticProbing <Integer, String> hashtableStrings = new HashTableQuadraticProbing<>();
	    	HashTableQuadraticProbing <Integer, Integer> hashtableInteger = new HashTableQuadraticProbing<>();
	    	HashTableQuadraticProbing <Integer, LocalDate> hashtableDate = new HashTableQuadraticProbing<>();
	    	
	    	hashtableStrings.insert(1, nombreproducto);
	    	hashtableStrings.insert(2, codigoproducto);
	    	hashtableFloats.insert(3, precioCompra);
	    	hashtableFloats.insert(4, precioCompra);
	    	hashtableDate.insert(5, fechaDeVencimiento);
	    	hashtableFloats.insert(6, precioCompra);
	    	hashtableInteger.insert(7, lote);
	    	
	    	Connection m = new ConnectionDb().conectar();
	    	CrudInsert l = new CrudInsert(m);
	    	l.insertarPr(hashtableStrings.get(1), hashtableStrings.get(2), hashtableFloats.get(3), hashtableFloats.get(4), hashtableDate.get(5), hashtableFloats.get(6), hashtableInteger.get(7) );
    	
    	} catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ingrese números");
            alert.showAndWait();
        }
    	
    }

}
