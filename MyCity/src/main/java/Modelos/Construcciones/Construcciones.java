
package Modelos.Construcciones;



public class Construcciones {
    protected double alumbradoPublico;
    protected double valorAgua;
    protected double impuestoSueloMesual;
    protected int row;
    protected int column;   
    protected String imageRuta;

    public Construcciones(double alumbradoPublico, double valorAgua, double impuestoSueloMesual, int row, int column) {
        this.alumbradoPublico = alumbradoPublico;
        this.valorAgua = valorAgua;
        this.impuestoSueloMesual = impuestoSueloMesual;
        this.row = row;
        this.column = column;
    }    
    
}
