package Sistema_administrativo_de_tienda.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionDb;
import database.CrudDelete;
import database.CrudInsert;
import database.CrudUpadate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CrearEmpleadoController implements Initializable{

    @FXML
    private Button regresar;
    
    @FXML
    private Button Activar;

    @FXML
    private Button Actualizarempleado;

    @FXML
    private TextField Contraseña;
    

    @FXML
    private Button Desactivarempleado;

    @FXML
    private TextField Nombreusuario;
    
    Connection conec = new ConnectionDb().conectar();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    void switchToMenu() {

    	Navegador o = new Navegador("Menu jefe",regresar);
    	o.cambioVentanaAnterior();
    	
    }
    
    @FXML
    void Activarempleado(ActionEvent event) {
    	String nombreUsuario = Nombreusuario.getText();
    	String contraseña = Contraseña.getText();
    	HashTableQuadraticProbing <Integer, String> hashtableStrings3 = new HashTableQuadraticProbing<>();
    	hashtableStrings3.insert(1, nombreUsuario);
    	hashtableStrings3.insert(2, contraseña);
    	
    	CrudInsert empleado = new CrudInsert(conec);
    	empleado.insertarUs(hashtableStrings3.get(1), hashtableStrings3.get(2), false);
    }

    @FXML
    void Actualizarempleado(ActionEvent event) {
    	String nombreUsuario = Nombreusuario.getText();
    	String contraseña = Contraseña.getText();
    	
    	HashTableQuadraticProbing <Integer, String> hashtableStrings = new HashTableQuadraticProbing<>();
    	hashtableStrings.insert(1, nombreUsuario);
    	hashtableStrings.insert(2, contraseña);
    	CrudUpadate up = new CrudUpadate(conec);
    	up.updatePass(hashtableStrings.get(1), hashtableStrings.get(2));
    	
    	
    }
    
    @FXML
    void DesactivarEmpleado(ActionEvent event) {
    	String nombreUsuario = Nombreusuario.getText();
    	CrudDelete delU = new CrudDelete(conec);
    	delU.delUser(nombreUsuario);
    	
    }


}
