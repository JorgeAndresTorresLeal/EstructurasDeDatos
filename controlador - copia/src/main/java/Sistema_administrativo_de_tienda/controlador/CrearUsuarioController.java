package Sistema_administrativo_de_tienda.controlador;

import java.sql.Connection;

import database.ConnectionDb;
import database.CrudInsert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CrearUsuarioController {

    @FXML
    private PasswordField ContraseñaNueva;

    @FXML
    private Button CrearUsuario;

    @FXML
    private TextField NombreUsuario;

    @FXML
    void CrearUsuario(ActionEvent event) {
    	
    	String nombreUsuario = NombreUsuario.getText();
    	String contraseña = ContraseñaNueva.getText();
    	
    	Connection conc = new ConnectionDb().conectar();
    	
    	CrudInsert jefe = new CrudInsert(conc);
    	jefe.insertarUs(nombreUsuario, contraseña, true);
    	
    }

}
