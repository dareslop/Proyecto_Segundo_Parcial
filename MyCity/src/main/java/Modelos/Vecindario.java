
package Modelos;

import Modelos.Construcciones.Construcciones;
import Modelos.Servicios.Servicios;
import java.util.ArrayList;
import javafx.util.Pair;

public class Vecindario {
    private int radio=2;
    private int centroX;
    private int centroY;
    private ArrayList<Pair<Integer,Integer>> puntos = new ArrayList<Pair<Integer,Integer>>();
    private ArrayList<Construcciones> construcciones;
    private ArrayList<Servicios> servicios;
    public static ArrayList<Vecindario> vecindarios;

    public Vecindario(int centroX, int centroY) {
        this.centroX = centroX;
        this.centroY = centroY;
        this.construcciones = new ArrayList();
        this.servicios = new ArrayList();
    }    
    
    public void makeCoodenadas(){
        int r = radio;
        while(r>0){
            for(int i=0;i<2*r;i++){
                Pair<Integer,Integer> pos = new Pair<>(centroX-r,(centroY-r)+i);
                puntos.add(pos);
                }
            for(int i =0;i<2*r;i++){
                Pair<Integer,Integer> pos = new Pair<>((centroX-r)+i,centroY+r);
                puntos.add(pos);
            }
            for(int i=0;i<2*r;i++){
                Pair<Integer,Integer> pos = new Pair<>(centroX+r,(centroY+r)-i);
                puntos.add(pos);
            }
            for(int i=0;i<2*r;i++){
                Pair<Integer,Integer> pos = new Pair<>((centroX+r)-i,centroY-r);
                puntos.add(pos);
            }
            r--;
        }
        Pair<Integer,Integer> pos = new Pair<>(centroX,centroY);
        puntos.add(pos);
        }   

    public ArrayList<Pair<Integer, Integer>> getPuntos() {
        return puntos;
    }
    
    public boolean compareCoordenadas(Vecindario v){
        for(Pair<Integer,Integer> p2:v.getPuntos()){
            for(Pair<Integer,Integer> p1:this.getPuntos()){
                if(p1.equals(p2)){
                    return false;
                }
            }
        } 
        return true;
    }
}
