package grupo6.mycity;

import Modelos.Ciudad;
import Modelos.IniciarSesion;
import Modelos.Servicios.Agua;
import Modelos.Servicios.Calle;
import Modelos.Servicios.Electricidad;
import Modelos.Servicios.Escuela;
import Modelos.Servicios.Hospital;
import Modelos.Servicios.Parque;
import Modelos.Servicios.Policia;
import Modelos.Servicios.Servicios;
import Modelos.Usuario;
import Modelos.Vecindario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

/**
 * FXML Controller class
 *
 * @author Emanuel Guerrero
 */
public class GameController implements Initializable {
    public static Usuario u = SesionController.user;
    public static ArrayList<Celda> nodos = new ArrayList<>();
    public static Ciudad city = u.getCity();
    private Celda celda_select;
    
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
    @FXML
    private Button btSave;
    @FXML
    private HBox hboxBottom;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        begin();
        Thread t1 = new Thread(()->aumentarDias());
        t1.start();        
    }        
    public void begin(){
        lbUser.setText(u.getUsername());
        lbNombreCity.setText(city.getNombreCiudad());
        lbMoney.setText(String.valueOf(city.getPresupuesto()));
        for(int i = 0;i<30;i++){
            for(int j=0;j<18;j++){
                ImageView img = new ImageView(new Image("Imagenes//grassTile.png",50,50,false,false));                                 
                grdPane.add(img, i, j);
                nodos.add(new Celda(img,new Pair<Integer,Integer>(j,i)));
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
    @FXML
    public void crearServicio(){         
        ArrayList<Servicios> servicios = new ArrayList<>();
        servicios.add(new Agua(500,150));
        servicios.add(new Calle(50,10));
        servicios.add(new Electricidad(500,2000));
        servicios.add(new Escuela(1500,150));
        servicios.add(new Parque(1500,150));
        servicios.add(new Policia(700,700));
        servicios.add(new Hospital(1400,800));        
        for(Servicios s:servicios){
            Button b = new Button(s.toString());
            b.setOnAction(e ->añadirServicioImg(s));
            hboxBottom.getChildren().add(b);
            }
        }
    private void añadirServicioImg(Servicios s){ 
        hboxBottom.getChildren().clear();        
        s.listf(s.toString());
        ArrayList<String> files = s.getFiles();
        for(String f:files){
            ImageView img = new ImageView(new Image(s.toString()+"//"+f,50,50,false,false));  
            hboxBottom.getChildren().add(img);
        }
        
    }
    
    @FXML
    private void mouseClicked(MouseEvent e) {
        Node clickedNode = e.getPickResult().getIntersectedNode();
        if (clickedNode != grdPane) {        
        Integer colIndex = grdPane.getColumnIndex(clickedNode);
        Integer rowIndex = grdPane.getRowIndex(clickedNode);
        ImageView img = (ImageView)this.getNodeFrom(grdPane,colIndex,rowIndex);
        celda_select = new Celda(img,new Pair<Integer,Integer>(rowIndex,colIndex));
        System.out.println("Mouse clicked cell: column:" + colIndex + " And row: " + rowIndex);
        }
    }  
    private Node getNodeFrom(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
            return node;
        }
    }
    return null;
}
    @FXML
    public void serializarCiudad(ActionEvent e){
        String nomFile = "city"+"_"+city.getNombreCiudad()+".bin";
        u.setCity_url(nomFile);
        try{
        BufferedWriter escribir = new BufferedWriter(new FileWriter("Usuarios.txt"));
        IniciarSesion.usuarios.forEach(user ->{
        if(!user.equals(u)){
            try {
                escribir.write(user.toString()+"\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else{
            try {
                escribir.write(u.toString()+"\n");
                } 
            catch (IOException ex) {
                    ex.printStackTrace();
                }
            }        
        });
        escribir.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
        try(ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(nomFile))){            
            s.writeObject(city);
            s.close();
        } 
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }       
    }
    public static void DeserializarCiudad(){
        try(ObjectInputStream s = new ObjectInputStream(new FileInputStream("city"+"_"+city.getNombreCiudad()+".bin"))){
            city = (Ciudad)s.readObject();
            u.setCity(city);            
        } 
        catch(FileNotFoundException ex){
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    public void crearVecinadrio(){
        Vecindario v = new Vecindario(celda_select.coordenada.getKey(),celda_select.coordenada.getValue());
        v.makeCoodenadas();
        System.out.println(v.getPuntos());
        for(Vecindario v2:city.getVecindarios()){
            if(!v.compareCoordenadas(v2)){
                city.getVecindarios().add(v);
            }
            else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("VECINDARIO NO CREADO");
                a.setContentText("EL VECINDARIO ESTA EN LA PROXIMIDADES DE OTRO VECINDARIO O CONTRUCCION");
                a.showAndWait();
            }        
        }
        
    }
    
}
class Celda{
    ImageView img;    
    Pair<Integer,Integer> coordenada;

    public Celda(ImageView img, Pair<Integer, Integer> coordenada) {
        this.img = img;        
        this.coordenada = coordenada;
    }
    
      
}
        
    
        

