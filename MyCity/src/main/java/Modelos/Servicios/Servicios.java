
package Modelos.Servicios;

/**
 *
 * @author Emanuel Guerrero
 */
public class Servicios {
    protected String nombre;
    protected  String ruta;
    protected int precioConstruccion;
    protected  int costoMensual;
    protected String imageRuta;
    
    public Servicios(String nombre, String ruta, int precioConstruccion, int costoMensual) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.precioConstruccion = precioConstruccion;
        this.costoMensual = costoMensual;
    }

   
    
    
}
