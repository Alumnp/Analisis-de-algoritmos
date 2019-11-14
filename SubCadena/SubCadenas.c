
#include <stdio.h>
#include <string.h>
//es una varibale global definida en 258, este 258 pude usarse de con el codigo aski
#define dter 258
//Creamos un metodo llamdo buscar
void Buscar(char pat[], char txt[], int q)
{//El strlem devuelve la longitud de una cadena de texto

    //Las demas variables las usamos para las operaciones
    int M = strlen(pat);
    int N = strlen(txt);
    int i, j;
    int a = 0;
    int b = 0;
    int c = 1;
        //Este siclo es para poder encontar la sub cadena
    for (i = 0; i < M - 1; i++)
    {
        //El %q nos permite tener los datso como cadena de texto
         c = (c * dter) % q;
    }

//Este metodo convierte el texto en un una cadena de numeros el cual se puede comparar
    for (i = 0; i < M; i++)
    {
        a = (dter * a + pat[i]) % q;
        b = (dter * b + txt[i]) % q;
    }
//Aqui imprimimos la ubicacion de la sub cadena mediante un cnteo d eletras
    for (i = 0; i <= N - M; i++)
    {

        //nos permite compara cuando se empatan la cadena y la sub cadeana
        if (a == b)
        {

//Aqui es vcuando imprime la sub cadena
            for (j = 0; j < M; j++)
            {
                if (txt[i + j] != pat[j])
                    break;
            }


            if (j == M)
            {
                printf("Patron encontrado en la Letra numero %d \n", i+1);
            }

        }
//Aqui nos determina cuando la subcadena termino de mostarse en la cadena primaria

        if (i < N - M)
        {
            b = (dter * (b - txt[i] * c) + txt[i + M]) % q;


            if (b < 0)
            {
                 b = (b + q);
            }

        }
    }
}

int main()
{

    char Cadena[] = "aaaabbsdaaabbbsdaaaabbbbsd";
    char SubCad[] = "ab";
    int q = 101;
    printf("\nCadena: %s",Cadena);
    printf("\nSubCadena: %s\n",SubCad);

    /*printf("Introduce la cadena\n");
    scanf("%s",&Cadena);
     printf("Introduce la sub cadena\n");

    scanf("%s",&SubCad);
*/


    Buscar(SubCad, Cadena, q);
    return 0;
}
