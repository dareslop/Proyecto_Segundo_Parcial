package grupo6.mycity;

import Modelos.IniciarSesion;
import Modelos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Emanuel Guerrero
 */
public class SesionController implements Initializable {
    public static Usuario user = null;

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnAcceder;
    @FXML
    private Button btnRegisro;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){       
    }
    
    @FXML
    public void iniciarSesion(){            
        user = IniciarSesion.login(txtUser.getText(),txtPass.getText());
        if(user==null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("USUARIO NO REGISTRADO: ");
            a.setContentText("POR FAVOR REGISTRESE");
            a.showAndWait();
            txtUser.clear();
            txtPass.clear();            
            try {
                switchToRegister();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else{            
            GameController.DeserializarCiudad();
            try {
                switchToGame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }                  
    }
    
    @FXML
    private void switchToRegister() throws IOException{
        App.setRoot("Registro");
    }
    private void switchToGame() throws IOException{
        App.setRoot("Game");
    }
}
