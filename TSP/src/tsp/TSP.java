/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 *
 * @author Alumno
 */
import java.util.List;

public class TSP {

    private final List<String> list_nam_n;
    private final double[] distancias;
    private String ruta_c = "";
    private long minim = Long.valueOf("9223372036854775807");
    String Ref = "0123456789abcdefghijklmnopqrstuwxyz";

    //Contructor
    public TSP(List<String> lista_nombre_nodos, double[] v_distancias) 
    {
        this.list_nam_n = lista_nombre_nodos;
        this.distancias = v_distancias;
    }

    //Método para obtener ruta corta
    public String getRuta() {
        //Control parametros correctos
        if (list_nam_n.size() == Math.sqrt(distancias.length)) 
        {
            double[][] tabla_distancias = conversorVT(distancias);
            int nNodos = list_nam_n.size();
            int vMiniRuta[] = new int[nNodos];
            String nodos = Ref.substring(0, nNodos);
            String ruta = "";
            long index = 0;
            while (ruta.length() <= nNodos) 
            {
                int vRuta[] = new int[distancias.length];
                double suma = 0;
                ruta = Long.toString(index, nNodos);
                // control del 0
                if (ruta.length() == nNodos - 1) 
                {
                    ruta = "0" + ruta;
                }
                if (ruta.length() == nNodos) {                    
                    if (validar(ruta, nodos)) { // eliminar repetidos
                        for (int i = 0; i < ruta.length(); i++) 
                        {
                            vRuta[i] = Integer.parseInt("" + ruta.charAt(i), 36);
                        }
                        // calculo distancias
                        suma += tabla_distancias[vRuta[nNodos - 1]][vRuta[0]];
                        for (int i = 0; i < (nNodos - 1); i++) 
                        {
                            suma += tabla_distancias[vRuta[i]][vRuta[i + 1]];
                            if (suma > minim) { // podador
                                break;
                            }
                        }
                        if (minim > suma) 
                        {
                            minim = (long) suma;
                            vMiniRuta = vRuta;
                        }                        
                    }
                }
                index++;
            }            
            for (int i = 0; i < nNodos; i++) 
            {
                ruta_c += list_nam_n.get(vMiniRuta[i]) + " - ";
            }
            return ruta_c;
        } 
        else 
        {
            return null;
        }
    }

    public long getDistanciaRecorrida() 
    {
        return minim;
    }

    public double[][] conversorVT(double[] v_distancias) 
    {
        int nNodos = (int) Math.sqrt(v_distancias.length);
        double[][] tabla_distancias = new double[nNodos][nNodos];
        int cont = 0;
        for (int i = 0; i < nNodos; i++) 
        {
            for (int j = 0; j < nNodos; j++) 
            {
                tabla_distancias[j][i] = v_distancias[cont] * 100000;
                cont++;
            }
        }
        return tabla_distancias;
    }

    private static boolean validar(String ruta, String nodos) 
    {
        for (int i = 0; i < nodos.length(); i++) 
        {
            if (!ruta.contains("" + nodos.charAt(i))) 
            {
                return false;
            }
        }
        return true;
    }

}