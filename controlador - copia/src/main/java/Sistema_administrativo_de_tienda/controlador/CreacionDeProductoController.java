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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreacionDeProductoController implements Initializable {

    @FXML
    private Button regresar;
    
    @FXML
    private Button Activar;

    @FXML
    private Button Actualizar;

    @FXML
    private TextField Codigoproduco;

    @FXML
    private Button Desactivar;

    @FXML
    private TextField Nombreproducto;

    @FXML
    private TextField PorcentajeIVA;

    @FXML
    private TextField Precioventa;

    @FXML
    private TextField TipoIVA;

    
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
    void Activarproducto(ActionEvent event) {

    }

    @FXML
    void Actualizarproducto(ActionEvent event) {

    }

    @FXML
    void Desactivarproducto(ActionEvent event) {

    }


}
