/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caballito;

/**
 *
 * @author Alumno
 */
public class Caballito {

     public static boolean tablero[][]=new boolean[8][8];
    public static int [][] recorrido=new int[8][8];
    public static int con=64;
    public static int cam=1;
    public static void DFS(int n,int h,int v)
    {
        if(n==64)
        {
            System.out.println("Camino "+cam+" con un total de "+con+
                    " pasos"
            );
            for(int i=0;i<recorrido.length;i++)
            {
                for(int j=0;j<recorrido.length;j++)
                    System.out.print(recorrido[i][j]+" ");
                System.out.println("");
                //imprime la matriz de 
            }
                cam++;//contador que nos muestra cuantos caminos diferentes salen
        }
        
        int mov[][]={{2,1},{1,2},{-2,1},{-1,2},{2,-1},{1,-2},{-2,-1},{-1,-2}};
        for(int [] m:mov)//este metodo nos permite repetir varias veces la matriz hasta que lo detengamos
        {
            //se asignan al sh y sv las posiciones de m que se asigno de mov, esto mediante que valores le asignemos a h o v
            int sh=h+m[0];
            int sv=v+m[1];
            if(sh>=0 && sv>=0)
                if(sh<8 && sv<8)
                    if(!tablero[sh][sv])
                    {
                        recorrido[sh][sv]=n+1;
                        tablero[sh][sv]=true;
                        DFS(n+1,sh,sv);
                        tablero[sh][sv]=false;
                        recorrido[sh][sv]=0;
                     }
        }         
    }
    public static void main(String [] args)
    {
        tablero[0][1]=true;//decimos que tablero en la posicion 0 1 es verdadera para validar la funcion
        recorrido[0][1]=1;//asignamos los numero 0 1 en uno para obviar el 0
        DFS(1,0,1);
        //el primer uno nos da inicion en la pocion siguiente el 0 no nos mueve de su direccion y el tercer 1 nos muebe por diferentes lados
        
       
    }
}