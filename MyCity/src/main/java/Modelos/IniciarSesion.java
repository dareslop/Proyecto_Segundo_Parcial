
package Modelos;

import Modelos.Usuario;
import grupo6.mycity.GameController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class IniciarSesion {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public static Usuario RegistrarUsuario(String user,String pass,String cityName,String Dificultad){  
        Usuario usuario=null;
        for(Usuario u:usuarios){
            if(u.equals(new Usuario(user,pass))){            
            return usuario=u;
            } 
        }      
        try {
        BufferedWriter escribir = new BufferedWriter(new FileWriter("Usuarios.txt"));
        usuarios.add(new Usuario(user,pass,new Ciudad(Dificultad,cityName)));
        usuarios.forEach( u -> {
            try {
                escribir.write(u.toString()+"\n");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });            
        escribir.close();}
        catch (IOException ex) {
            ex.printStackTrace();
            }                        
    return usuario;    
    }
    public static void cargarUsuarios() {
        try{
           BufferedReader leer = new BufferedReader(new FileReader("Usuarios.txt"));
           String line;
           while((line = leer.readLine())!=null){
               String[] sep = line.split(",");//user,pass,cityname,dificultad,file.bin
               if(sep.length<5){
                   usuarios.add(new Usuario(sep[0],sep[1]));               
               }
               else if(sep.length==5){
                   usuarios.add(new Usuario(sep[0],sep[1],new Ciudad(sep[3],sep[2])));               
               }
           }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }        
        catch (IOException ex) {
            ex.printStackTrace();
        } 
    }      
       
    public static Usuario login(String user,String pass){         
        for(Usuario u:usuarios){
            if(u.equals(new Usuario(user,pass))){            
            return u;
            }        
        else{
            return null;
            } 
        }   
        return null;
    }
}
