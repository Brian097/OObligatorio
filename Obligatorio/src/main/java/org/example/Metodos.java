package org.example;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * ESCUELA TÉCNICA DE ROCHA
 * BT - TECNOLOGÍAS DE LA INFORMACIÓN
 * @author BALDIVIESO - 57237477
 * @author MAGNONE - 54785814
 * OBLIGATORIO - Gestión de un equipo de Pokémon.
 *
 **/

public class Metodos {
    // Creamos los objetos del tipo Scanner para entrada de Datos
    public static Scanner entradaDeTexto = new Scanner(System.in);
    public static Scanner entradaDeNumero = new Scanner(System.in);

    // Códigos de color ANSI
    public static final String reset = "\u001B[0m";
    public static final String rojo = "\u001B[31m";
    public static final String blanco = "\u001B[37m";
    public static final String amarillo = "\u001B[33m";
    public static final String azul = "\u001B[34m";
    public static final String verde = "\u001B[32m";

    // Creamos contador para saber cuántos Pokémon hay en el arreglo
    private static int contador = 0;

    // Creamos el arreglo que almacenará los Pokémon
    private static Pokemon[] equipoPokemon = new Pokemon[6];

    // Método usado para agregar un objeto Pokémon al arreglo.
    public static void agregarPokemon() {
        if (contador < equipoPokemon.length) { //Uso if para verifiicar que aun haya espacio en el vector
            int bandera = 0;
            //DO-WHILE QUE CONTIENE EL MENU PARA AGREGAR POKÉMON
            do {
                System.out.println(amarillo + "+-------------------------------+" + reset);
                System.out.println(blanco + "|       AGREGAR NUEVO POKÉMON    |" + reset);
                System.out.println(amarillo + "+-------------------------------+" + reset);

                // Solicitar nombre
                System.out.println(blanco + "| Ingrese el nombre del Pokémon: |" + reset);
                System.out.print("| > ");
                String nombre = "";
                nombre = entradaDeTexto.nextLine().toUpperCase();

                // Solicitar nivel (0-100)
                int nivel = 0;
                boolean entradaValida = false;
                do {
                    System.out.println(blanco + "| Ingrese el nivel:              |" + reset);
                    System.out.print("| > ");
                    try {
                        nivel = entradaDeNumero.nextInt();  // Intenta leer el número
                        entradaValida = true;  // Si la lectura es exitosa, marca la entrada como válida
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Solo se permiten números.");
                        entradaDeNumero.next();  // Limpia la entrada no válida
                    }
                } while (!entradaValida);

                // Solicitar puntos de vida (1-100)
                int puntosDeVida = 0;
                entradaValida = false; // Reseteo entradavalida para volver a usarla
                do {
                    try {
                        System.out.println(blanco + "| Ingrese los puntos de vida:    |" + reset);
                        System.out.print("| > ");
                        puntosDeVida = entradaDeNumero.nextInt();
                        entradaValida = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Solo se permiten números.");
                        entradaDeNumero.next();  // Limpia la entrada no válida
                    }
                } while (!entradaValida);

                // Solicitar tipo
                System.out.println(blanco + "| Ingrese el tipo (fuego, agua,  |" + reset);
                System.out.println(blanco + "| electrico o planta):           |" + reset);
                System.out.print("| > ");
                String tipo = entradaDeTexto.nextLine().toUpperCase();

                // Corroboro el tipo con switch
                switch (tipo) {
                    case "FUEGO":
                        //Pedir poder del pokemon
                        System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                        System.out.print("| > ");
                        int poderFuego = entradaDeNumero.nextInt();

                        //Pedir ataque del pokemon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");
                        String ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();

                        equipoPokemon[contador] = new PokemonFuego(nombre, nivel, puntosDeVida, "FUEGO", poderFuego, ataqueEspecial);

                        bandera = 1; //Establezco a uno la bandera para detener el while y finalizar
                        break;
                    case "PLANTA":
                        //Pedir poder del pokemon
                        System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                        System.out.print("| > ");
                        int poderPlanta = entradaDeNumero.nextInt();

                        //Pedir ataque del pokemon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");
                        ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();

                        equipoPokemon[contador] = new PokemonPlanta(nombre, nivel, puntosDeVida, "PLANTA", poderPlanta, ataqueEspecial);

                        bandera = 1; //Establezco a uno la bandera para detener el while y finalizar
                        break;
                    case "ELECTRICO":
                        //Pedir poder del pokemon
                        System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                        System.out.print("| > ");
                        int poderElectrico = entradaDeNumero.nextInt();

                        //Pedir ataque del pokemon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");
                        ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();

                        equipoPokemon[contador] = new PokemonElectrico(nombre, nivel, puntosDeVida, "ELECTRICO", poderElectrico, ataqueEspecial);

                        bandera = 1; //Establezco a uno la bandera para detener el while y finalizar
                        break;
                    case "AGUA":
                        //Pedir poder del pokemon
                        System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                        System.out.print("| > ");
                        int poderAgua = entradaDeNumero.nextInt();

                        //Pedir ataque del pokemon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");

                        ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();
                        equipoPokemon[contador] = new PokemonAgua(nombre, nivel, puntosDeVida, "AGUA", poderAgua, ataqueEspecial);

                        bandera = 1; //Establezco a uno la bandera para detener el while y finalizar
                        break;
                    default:
                        System.out.println(rojo + "Tipo de Pokémon inválido" + reset);
                        break;
                }

                //Si bandera vale uno, es decir el pokemon fue agregado, muestro mensaje
                if (bandera == 1) {
                    System.out.println(amarillo + "+-------------------------------+" + reset);
                    System.out.println(rojo + "Pokémon agregado exitosamente!" + reset);
                    contador++;
                }
            } while (bandera != 1);

        } else {
            System.out.println(rojo + "El equipo está lleno, no se puede agregar más Pokémon." + reset);
        }
    }

    /**
     * Método Mostrar Informacion
     */
    public static void mostrarInformacion() {
        if (contador == 0) {
            System.out.println("El equipo esta vacío.");
        } else {
            // Mostrar encabezado una sola vez con colores
            System.out.println(rojo + "+-------------------------------+" + reset);
            System.out.println(blanco + "|          INFO POKÉMON         |" + reset);
            System.out.println(amarillo + "+-------------------------------+" + reset);

            for (int i = 0; i < contador; i++) {
                System.out.print(equipoPokemon[i]);
            }
        }
    }
    /**
     * Metodo para elejir un pokemon y realizar un ataque especial
     */
    public static void ataqueEspecial() {
        // muestro una lista de los pokemon y el usuario elije uno
        for (int i = 0; i < contador; i++) {
            System.out.println(azul + (i+1) + ". " + reset +verde + equipoPokemon[i].getNombre() + reset);
        }
        if (contador == 0){  //verifico que haya pokemon en el equipo
            System.out.println("No hay Pokémon en el equipo.");
        } else {
            // pregunto cual pokemon va a realizar el ataque
            System.out.print("Elige un pokemon para realizar un ataque especial: ");
            int pokemonElejido = entradaDeTexto.nextInt() - 1;
            if (pokemonElejido >= contador || pokemonElejido < 0){ //verifico que se haya elejido un pokemon existente
                System.out.println("Pokemon no válido.");
            }else {
                // muestro el ataque especial del pokemon elejido
                System.out.println(equipoPokemon[pokemonElejido].ataqueEspecial());
            }
        }


    }
}