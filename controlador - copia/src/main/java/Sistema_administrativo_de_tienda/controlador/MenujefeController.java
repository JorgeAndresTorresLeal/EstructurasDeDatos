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

public class MenujefeController implements Initializable{

	@FXML
    private Button Cerrar;

	@FXML
    private Button consultar;

    @FXML
    private Button entradaProducto;

    @FXML
    private Button modificarEmpleado;

    @FXML
    private Button registrarSalida;

    @FXML
    private Button reporte;

    @FXML
    private Button modificarProducto;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
    @FXML void switchToInicio() {
    	
            Navegador nav = new Navegador("Inicio",Cerrar);
            nav.cambioVentanaAnterior();    
    }
	
    @FXML 
    private void switchToModificarEmpleado(ActionEvent event){
    	try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Crear-modificar empleado.fxml"));

            
            Parent root = loader.load();

            
            CrearEmpleadoController controlador = loader.getController();

            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

           
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            
            stage.setOnCloseRequest(e -> controlador.switchToMenu());

            
            Stage myStage = (Stage) this.modificarEmpleado.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        }     	
    }
    
    @FXML
    private void switchToCrearProducto(ActionEvent event)  {
try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Creacion de producto.fxml"));

            
            Parent root = loader.load();

            
            CreacionDeProductoController controlador = loader.getController();

            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

           
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            
            stage.setOnCloseRequest(e -> controlador.switchToMenu());

            
            Stage myStage = (Stage) this.modificarProducto.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @FXML
    private void switchToRegistrarSalida(ActionEvent event){
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

            
            Stage myStage = (Stage) this.registrarSalida.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    

    @FXML
    private void switchToConsultar(ActionEvent event){
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

            
            Stage myStage = (Stage) this.consultar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void switchToEntradaProducto(ActionEvent event) {
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
    private void switchToReporte(ActionEvent event) {
    	try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reporte.fxml"));

            
            Parent root = loader.load();

            
            ReporteController controlador = loader.getController();

            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

           
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            
            stage.setOnCloseRequest(e -> controlador.switchToMenu());

            
            Stage myStage = (Stage) this.reporte.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenujefeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
