package Sistema_administrativo_de_tienda.controlador;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Navegador{
	
	String fxml;
	Button boton;
	
	
	public Navegador(String fxml,Button boton) {
		this.fxml = fxml;
		this.boton = boton;
	}
	

	void cambioVentanaAnterior() {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml + ".fxml"));

            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            
            

            Stage myStage = (Stage) this.boton.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
		
	}
	
	

	
}