package Sistema_administrativo_de_tienda.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuEmpleadoController implements Initializable{

    @FXML
    private Button Consultarproducto;

    @FXML
    private Button Regristrarsalidadeproducto;

    @FXML
    private Button entradaProducto;
    
    @FXML
    private Button Cerrar;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    void switchToConsultar(ActionEvent event) {
    	
    	
    	try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Consultar producto.fxml"));

            
            Parent root = loader.load();

            
            ConsultarProductoController controlador = loader.getController();

            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

           
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            
            stage.setOnCloseRequest(e -> controlador.switchToMenu());

            
            Stage myStage = (Stage) this.Consultarproducto.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    void switchToEntradaProducto(ActionEvent event) {
    	try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Registro entrada de producto.fxml"));

            
            Parent root = loader.load();

            
            RegistroEntradaDePrductoController controlador = loader.getController();

            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

           
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            
            stage.setOnCloseRequest(e -> controlador.switchToMenu());

            
            Stage myStage = (Stage) this.entradaProducto.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    void switchToRegistrarSalida(ActionEvent event) {
    	try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Salida-Venta de Producto.fxml"));

            
            Parent root = loader.load();

            
            VentaProductoController controlador = loader.getController();

            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

           
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            
            stage.setOnCloseRequest(e -> controlador.switchToMenu());

            
            Stage myStage = (Stage) this.Regristrarsalidadeproducto.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	
	@FXML void switchToInicio() {
    	Navegador n = new Navegador("Inicio",Cerrar);
    	n.cambioVentanaAnterior();
    }

}
