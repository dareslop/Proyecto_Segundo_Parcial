
package Modelos.Servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author Emanuel Guerrero
 */
public class Servicios {
    protected ArrayList<String> files = new ArrayList<>();        
    protected int precioConstruccion;
    protected  int costoMensual;
    
    
    public Servicios(int precioConstruccion, int costoMensual) {                
        this.precioConstruccion = precioConstruccion;
        this.costoMensual = costoMensual;
    }
    public void listf(String directoryName){
        try{
            InputStreamReader lector = new InputStreamReader(Servicios.class.getResourceAsStream(this.toString()+"/"+directoryName+".txt"));
            BufferedReader reader = new BufferedReader(lector);      
            String line = reader.readLine();            
            while((line = reader.readLine()) != null){                
                files.add(line);                
            }
         } 
         catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
               
    }

    public ArrayList<String> getFiles() {
        return files;
    }
    

    @Override
    public String toString() {
        String sub = this.getClass().getName();
        return sub.substring(18, sub.length());
    }    
    
}
