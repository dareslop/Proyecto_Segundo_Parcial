
package Modelos;


public class Ciudad{ 
    private int dias;
    private int mes;
    private int presupuesto;
    private int rows;
    private int columns;
    private String dificultad;
    private String floor; 

    public Ciudad(String dificultad, String floor){
        this.rows = 18;
        this.columns = 30;
        this.dias = 0;
        this.dificultad = dificultad;  
        this.floor = floor;
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
    public int getDias() {
        return dias;
    }
    public int getMes() {
        return mes;
    }
    public int getPresupuesto() {
        return presupuesto;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public String getDificultad() {
        return dificultad;
    }
    public String getFloor() {
        return floor;
    }    
    
    public void increaseDays(){
        dias+=1;
    }
    
    
}
