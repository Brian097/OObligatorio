package org.example;

import java.util.Scanner;

/**
 *
 * ESCUELA TÉCNICA DE ROCHA
 * BT - TECNOLOGÍAS DE LA INFORMACIÓN
 * @author BALDIVIESO - 57237477
 * @author MAGNONE - 54785814
 * OBLIGATORIO - Gestión de un equipo de Pokémon.
 *
 **/

public class Main {
    public static void main(String[] args) {

        //Variables
        int opcion; //Bandera

        //Variable colores:
        String amarillo = "\u001B[33m";  // Color amarillo
        String azul = "\u001B[34m";      // Color azul
        String blanco = "\u001B[37m";   // Color blanco
        String rojo = "\u001B[31m";     // Color rojo
        String reset = "\u001B[0m";      // Restablecer color

        /*
        Variable emojis:
        String emojiAgua = "\uD83D\uDCA7";
        */

        //Scanner
        Scanner entradaDeTexto = new Scanner(System.in);
        Scanner entradaDeNumeros = new Scanner(System.in);

        System.out.println(amarillo +
                "                               .::.                           \n"+
                "                              .;:**'                          \n"+
                "                              `                               \n"+
                "  .:XHHHHk.              db.   .;;.     dH  MX                \n"+
                "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN     \n"+
                "QMMMMMb  'MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM\n"+
                "  `MMMM.  )M> :X!Hk. MMMM   XMM.o'  .  MMMMMMM X?XMMM MMM>!MMP\n"+
                "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `' MX MMXXMM \n"+
                "    ~MMMMM~ XMM. .XM XM`'MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP \n"+
                "     ?MMM>  YMMMMMM! MM   `?MMRb.    `MM   !L'MMMMM XM IMMM   \n"+
                "      MMMX   'MMMM'  MM       ~%:           !Mh.''' dMI IMMP  \n"+
                "      'MMM.                                             IMX   \n"+
                "       ~M!M                                             IM    \n"+
                reset
        );

        //Menu
        do {

            // Imprimir arte ASCII con bordes alternados
            System.out.println(blanco +                          "+++++++++++++++++++++++++++++++++++++++++" + reset);
            System.out.println(rojo   + "+" + reset + blanco + "                                       " + reset + rojo   + "+" + reset  );
            System.out.println(blanco + "+" + reset + blanco + "   -- Menú de Gestión de Pokémon--     " + reset + blanco + "+" + reset );
            System.out.println(rojo   + "+" + reset + blanco + "   1. Agregar un Pokémon               " + reset + rojo   + "+" + reset );
            System.out.println(blanco + "+" + reset + blanco + "   2. Mostrar Pokémon                  " + reset + blanco + "+" + reset );
            System.out.println(rojo   + "+" + reset + blanco + "   3. Realizar Ataque Especial         " + reset + rojo   + "+" + reset );
            System.out.println(blanco + "+" + reset + blanco + "   4. Calcular Promedio de Nivel       " + reset + blanco + "+" + reset );
            System.out.println(rojo   + "+" + reset + blanco + "   0. Salir                            " + reset + rojo   + "+" + reset );
            System.out.println(blanco + "+" + reset + blanco + "                                       " + reset + blanco + "+" + reset );
            System.out.println(rojo   +                          "+++++++++++++++++++++++++++++++++++++++++" + reset                        );

            System.out.print("Seleccione una opción: ");
            opcion = entradaDeNumeros.nextInt();

            switch(opcion){
                case 1:
                    //LLamo al metodo agregar un pokemon
                    break;
                case 2:
                    //LLamo al metodo mostar pokemon
                    break;
                case 3:
                    //LLamo al metodo ralizar un ataque especial
                    break;
                case 4:
                    //LLamo al metodo calcular promedio
                    break;
                case 0:
                    //Salgo del programa
                    break;
                default:
                    System.out.println("Debe ser un numero del uno al 5");
            }
        } while (opcion != 0);

        System.out.print("...");
    }
}