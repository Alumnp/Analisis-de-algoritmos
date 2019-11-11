package Mochila;

/**
 *
 * @author DKghost
 */
public class Main 
{
    
    public static void main(String arg[])
    {
        Mochila Moc = new Mochila(8);
        Moc.llenarArticulosRand(6, 100);
        Moc.imprimirArticulos();
        Moc.imprimirArticulosToken();
    }
}
