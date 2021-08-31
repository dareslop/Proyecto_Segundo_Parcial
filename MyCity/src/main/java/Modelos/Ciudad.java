
package Modelos;


import Modelos.Vecindario;
import java.io.Serializable;
import java.util.ArrayList;


public class Ciudad implements Serializable{ 
    private ArrayList<Vecindario> vecindarios = new ArrayList<>();
    private int dias;
    private int mes;
    private int presupuesto;
    private String dificultad;
    private String nombreCiudad;
     

    public Ciudad(String dificultad,String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
        this.dias = 0;
        this.dificultad = dificultad;        
        this.mes = 0;        
        switch(dificultad){
            case "facil":
                this.presupuesto = 20000;
            case "medio":
                this.presupuesto = 10000;
            case "dificil":
                this.presupuesto = 5000;        
        }
    }  
    

    public String getNombreCiudad() {
        return nombreCiudad;
    }
    
    public int getDias() {
        return dias;
    }
    public int getMes() {
        return mes;
    }
    public int getPresupuesto() {
        return presupuesto;
    }   
    public String getDificultad() {
        return dificultad;
    }     
    public void increaseDays(){
        dias++;
    }   

    public ArrayList<Vecindario> getVecindarios() {
        return vecindarios;
    }
    
}
