package Mochila;

import java.util.ArrayList;
/**
 *
 * @author DKghost
 */
public class Mochila 
{

    private int tamaño;
    private ArrayList<Articulos> articulos;
    
    public Mochila(int n) 
    {
        tamaño = n;
        articulos = new ArrayList<Articulos>();
    }
    
    public void llenarArticulosRand(int n, int rango)//lllenamos los articulos con la clase Articulos Ramndodm
    {
        ArticulosRandom gen = new ArticulosRandom();
        articulos = gen.ArticulosR(n+1, rango);
    }
    
    public void imprimirArticulos()
    {
        for(int i =1;i< articulos.size();i++)//Se crea un ciclo que nos permiete imprimir los diferentes articulos
        {
            System.out.println("Articulo "+ i +
                                "  Costo: "+ articulos.get(i).getCosto()+
                                ", Beneficio: "+articulos.get(i).getBeneficio());
        }
    }
    
    public void imprimirArticulosToken()
    {
        for(int i =0;i< articulos.size();i++)
        {
            System.out.println(articulos.get(i).getCosto()+","+articulos.get(i).getBeneficio());
        }
    }
    
}
