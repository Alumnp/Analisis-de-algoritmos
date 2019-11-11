/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alumno
 */
//todo este metodo salio del programa de burbuja

public class ArticulosRandom 
{
    public ArticulosRandom() 
    {
        
    }
    
    public ArrayList<Articulos> ArticulosR(int n,int rango)
    {
        
        Random r = new Random();
        ArrayList<Articulos> articulosR;
        articulosR = new ArrayList<Articulos>();
        
        for(int i = 0; i<n;i++)
        {
            Articulos aux = new Articulos(r.nextInt(rango),r.nextInt(rango));
            articulosR.add(aux);
        }
        return articulosR;
    }
}
