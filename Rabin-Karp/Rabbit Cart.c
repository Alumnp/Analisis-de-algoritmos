
#include <stdio.h>
#include <string.h>

#define d 258
int RabinKarpSearch (char A[], char B[])
{
   // Se el asingno la m y n a las cdenas de A y B respectivamente como numers
    int m=strlen(A);
    int n= strlen(B);
    int h1=0;
    int h2=0;
    int i,j, cont=0;
    //Calculamos el hash definitivo de B y el primero de A (El cual de estara recalculando)
    for(i=0; i< n; i++)
    {
        h1=h1+A[i]*pow(3, i);
        h2=h2+B[i]*pow(3, i);
    }
    //hacemos que la cadena A y la cadena B se resten constante mente para finalizar de leer la cadena A
    for(i=0; i<m-n+1; i++)
    {
//Esta condicional imprime que s encontro la sub cadena cuansdo se igualan las ambas cadenas
        if(h1==h2)
        {
            printf("\nSe encontro la Sub Cadena \n");
//creamos un cliclo que determina cuanto veces se encontro la subcadena, pero no lo imprimimos
            for(j; j<n; j++)
            {
                if(A[i+j]==B[j])
                {
                    cont++;
                }
                else
                {
                    j=n;
                    cont=0;
                }
            }
            if(cont==n)
            {

                return 1;
            }

        }

//Despues retomamos al hast de A  pero cn numeros primos

        h1 = ((h1 - A[i])/3) + (A[i+n]*pow(3, n-1));
    }

    return 0;
}



int main()
{

    char a[100];
    char b[100];

    printf("Introduce la cadena\n");
    scanf("%s",&a);
    printf("Introduce la sub cadena\n");
    scanf("%s",&b);


  RabinKarpSearch(a, b);
    return 0;
}
