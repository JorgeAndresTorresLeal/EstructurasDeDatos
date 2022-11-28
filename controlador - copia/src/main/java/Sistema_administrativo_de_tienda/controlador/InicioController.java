package Sistema_administrativo_de_tienda.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionDb;
import database.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioController implements Initializable{

    @FXML
    private PasswordField Contraseña;

    @FXML
    private Button Ingresar;

    @FXML
    private TextField NombreDeUsuario;
    
    public static boolean globalcomprobante;
    
    



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
    

    @FXML
    void Verificar(ActionEvent event) {
    	
    	String nombre = this.NombreDeUsuario.getText();
    	String contraseña = this.Contraseña.getText();
    	boolean [] persona = new Login(new ConnectionDb().conectar()).loguear(nombre, contraseña);
    	if(persona[1] && persona[0]) {
    		
    		InicioController.globalcomprobante=false;
    		
    		
	    	try {	
	    		
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu jefe.fxml"));
	    		
	    		Parent root;
				
				root = loader.load();
				
	
	            
	            MenujefeController controlador = loader.getController();
	
	            
	            Scene scene = new Scene(root);
	            Stage stage = new Stage();
	
	           
	            stage.setScene(scene);
	            stage.setResizable(false);
	            stage.show();
	
	            
	            stage.setOnCloseRequest(e -> controlador.switchToInicio());
	
	            
	            Stage myStage = (Stage) this.Ingresar.getScene().getWindow();
	            myStage.close();
	    	}catch(IOException ex) {
	    		Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
	    	}
    	}else if(persona[1] && !persona[0]) {
    		
    		InicioController.globalcomprobante=true;		
    		
    	
    		try {	
    			
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu empleado.fxml"));
	    		
	    		Parent root;
				
				root = loader.load();
			 
	            MenuEmpleadoController controlador = loader.getController();
	
	            Scene scene = new Scene(root);
	            Stage stage = new Stage();
	
	           
	            stage.setScene(scene);
	            stage.setResizable(false);
	            stage.show();
	
	            
	            stage.setOnCloseRequest(e -> controlador.switchToInicio());
	
	            
	            Stage myStage = (Stage) this.Ingresar.getScene().getWindow();
	            myStage.close();
	    	}catch(IOException ex) {
	    		Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
	    	}
    	}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos");
            alert.showAndWait();
    	}
    }

}
