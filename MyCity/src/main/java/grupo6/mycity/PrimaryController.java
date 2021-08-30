package grupo6.mycity;

import Modelos.Ciudad;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Emanuel Guerrero
 * @author Diego Vega
 * @author Darien L
 */
public class GameController implements Initializable {
 
    @FXML
    private GridPane grdPane;
    Ciudad city;
    @FXML
    private Label lbUser;
    @FXML
    private Label lbDias;
    @FXML
    private Label lbMoney;
    @FXML
    private Label lbNombreCity;
    @FXML
    private Button btVecindario;
    @FXML
    private Button btServicio;
    @FXML
    private Button btDemolicion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        
    }
        
    public void begin(){
        for(int i = 0;i<30;i++){
            for(int j=0;j<18;j++){
                ImageView img = new ImageView(new Image("Imagenes//grassTile.png",50,50,false,false));                
                grdPane.add(img, i, j);
            }       
        Thread t1 = new Thread(()->aumentarDias());
        t1.start();
        }
    }
    
    public void aumentarDias(){
          while(true){
              try {
                  city.increaseDays();
                  Platform.runLater(()->lbDias.setText("dias: "+city.getDias()));                  
                  Thread.sleep(3000);
              } catch (InterruptedException ex) {
                  ex.printStackTrace();
                }
            }
        }
    public void cobrarImpuestos(){            
        }
    public void crearServicio(){
        
        }
    }
        
