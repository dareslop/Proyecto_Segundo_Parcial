
package Modelos.Servicios;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Emanuel Guerrero
 */
public class Servicios {
    protected ArrayList<File> files = new ArrayList<>();        
    protected int precioConstruccion;
    protected  int costoMensual;
    
    
    public Servicios(int precioConstruccion, int costoMensual) {                
        this.precioConstruccion = precioConstruccion;
        this.costoMensual = costoMensual;
    }
    public void listf(String directoryName, ArrayList<File> files) {
    File directory = new File(directoryName);    
    File[] fList = directory.listFiles();
    if(fList != null)
        for (File file : fList) {      
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
}
    
}
