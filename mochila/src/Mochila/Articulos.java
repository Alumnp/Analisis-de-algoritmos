package Mochila;
/**
 *
 * @author DKghost
 */
public class Articulos {

    private int costo;
    private int beneficio;
            
    public Articulos(int c, int b) {
        costo = c;
        beneficio = b;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }
    
    
}
