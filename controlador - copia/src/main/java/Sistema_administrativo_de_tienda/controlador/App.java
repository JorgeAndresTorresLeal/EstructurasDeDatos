package Sistema_administrativo_de_tienda.controlador;

import database.ConnectionDb;
import database.Login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

/**
 * JavaFX App
 */
public class App extends Application {
	
	

    @Override
    public void start(Stage stage) throws IOException {   	
    
    Connection coneccion1 = new ConnectionDb().conectar();	
    Login log = new Login(coneccion1);
    	
    if(log.existeUser()) {	
    	try {
    		System.out.println("entro");
            FXMLLoader loader = new FXMLLoader(App.class.getResource("Inicio.fxml"));        
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }else {
    	try {
    		System.out.println("entroooooo");
            FXMLLoader loader = new FXMLLoader(App.class.getResource("Crear usuario.fxml"));        
            Pane ventana = (Pane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(ventana);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    	
    }



    public static void main(String[] args) {
        launch();
    }

}