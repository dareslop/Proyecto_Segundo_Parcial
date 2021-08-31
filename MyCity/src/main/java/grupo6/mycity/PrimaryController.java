package grupo6.mycity;

import Modelos.Ciudad;
import Modelos.Usuario;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Emanuel Guerrero
 * @author Diego Vega
 * @author Dariel L.
 */
public class GameController implements Initializable {
    public static Usuario u = SesionController.user;
    public static ArrayList<Celda> nodos = new ArrayList<>();
    public static Ciudad city = u.getCity();
    @FXML
    private GridPane grdPane;    
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
        begin();
        Thread t1 = new Thread(()->aumentarDias());
        t1.start();        
    }
        
    public void begin(){
        for(int i = 0;i<30;i++){
            for(int j=0;j<18;j++){
                ImageView img = new ImageView(new Image("Imagenes//grassTile.png",50,50,false,false));  
                StackPane sckPane = new StackPane();
                sckPane.getChildren().addAll(img);                
                grdPane.add(sckPane, i, j);
                nodos.add(new Celda(sckPane,j,i));
            }               
        }
    }
    
    public void aumentarDias(){
          while(true){
              try {
                  city.increaseDays();
                  Platform.runLater(()->lbDias.setText("Dias: "+city.getDias()));                  
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
    
    @FXML
    private void mouseEntered(MouseEvent e) {
        StackPane source = (StackPane)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue()); 
    } 
}
class Celda{
    StackPane skPane;
    int row;
    int column;
    public Celda(StackPane skPane, int row, int column) {
        this.skPane = skPane;
        this.row = row;
        this.column = column;
    }   
}
        
        
