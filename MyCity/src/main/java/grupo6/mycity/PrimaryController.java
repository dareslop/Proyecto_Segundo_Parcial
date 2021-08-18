/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6.mycity;

import Modelos.Ciudad;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Emanuel Guerrero
 */
public class PrimaryController implements Initializable {
 
    @FXML
    private GridPane grdPane;
    Ciudad city;
    @FXML
    private Label lbUser;
    @FXML
    private Label lbDias;
    @FXML
    private ColumnConstraints grPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        city = new Ciudad("facil","Imagenes//grassTile.png");
        for(int i=0;i< city.getColumns();i++){
            for(int j=0;j<city.getRows();j++){
                //InputStream input = App.class.getResourceAsStream(city.getFloor());
                ImageView img = new ImageView(new Image(city.getFloor()));
                grdPane.add(img, j, i);                
            }
        }      
        
        
    }  
    public class Dias implements Runnable {
        @Override
        public void run() {
            
            try {
                city.increaseDays();
                Thread.sleep(3000);
                lbDias.setText(String.valueOf(city.getDias()));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }
        
}
