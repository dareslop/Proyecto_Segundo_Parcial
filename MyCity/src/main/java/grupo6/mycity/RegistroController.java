
package grupo6.mycity;

import Modelos.IniciarSesion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class RegistroController implements Initializable{

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnRegistar;
    @FXML
    private ComboBox<String> cbDificultad;
    @FXML
    private TextField txtCity;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cbDificultad.getItems().addAll("BABY LEVEL","HARDCORE","INFERNO");
       
    }
    @FXML
    public void registrar(){
        IniciarSesion.RegistrarUsuario(txtUser.getText(),txtPass.getText(),txtCity.getText(),cbDificultad.getValue());   
        try {
            switchToSesion();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("SE HA REGISTRADO CORRECTAMENTE\nINICIE SESION PARA CONTRINUAR");
        a.setTitle("REGISTRO EXITOSO");
        a.showAndWait();
    }
    
    private void switchToSesion() throws IOException{
        App.setRoot("Sesion");
    }


    
}
