
package Modelos;

import Modelos.Ciudad;
import java.util.Objects;

public class Usuario {
    private String username;
    private String password;        
    private Ciudad city;
    private String city_url;
    
    

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;    }  
    

    public Usuario(String username, String password,Ciudad city) {
        this.username = username;
        this.password = password;        
        this.city= city;
        }

    public void setCity_url(String city_url) {
        this.city_url = city_url;
    }  

    public String getUsername() {
        return username;
    }

    public String getCity_url() {
        return city_url;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    public Ciudad getCity() {
        return city;
    }    

    public void setCity(Ciudad city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return username + ","+password+","+city.getNombreCiudad()+","+city.getDificultad()+","+city_url;
    }
      
    
}
