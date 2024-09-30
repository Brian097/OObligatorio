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
    // Creamos los Scanner para entrada de Datos
    public static Scanner entradaDeTexto = new Scanner(System.in);
    public static Scanner entradaDeNumero = new Scanner(System.in);

    // Códigos de color ANSI
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String WHITE = "\u001B[37m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";

    // Creamos contador para saber cuántos Pokémon hay en el arreglo
    private static int contador = 0;

    // Creamos el arreglo que almacenará los Pokémon
    private static Pokemon[] equipoPokemon = new Pokemon[6];

    // Método usado para agregar un objeto Pokémon al arreglo.
    public static void agregarPokemon() {
        if (contador < equipoPokemon.length) { //Uso if para verifiicar que aun haya espacio en el vector
            int bandera = 0;
            do {
                System.out.println(YELLOW + "+-------------------------------+" + RESET);
                System.out.println(WHITE + "|       AGREGAR NUEVO POKÉMON    |" + RESET);
                System.out.println(YELLOW + "+-------------------------------+" + RESET);

                // Solicitar nombre
                System.out.println(WHITE + "| Ingrese el nombre del Pokémon: |" + RESET);
                System.out.print("| > ");
                String nombre = "";
                nombre = entradaDeTexto.nextLine().toUpperCase();

                // Solicitar nivel (0-100)
                int nivel = 0;
                boolean entradaValida = false;
                do {
                    System.out.println(WHITE + "| Ingrese el nivel:              |" + RESET);
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
                        System.out.println(WHITE + "| Ingrese los puntos de vida:    |" + RESET);
                        System.out.print("| > ");
                        puntosDeVida = entradaDeNumero.nextInt();
                        entradaValida = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Solo se permiten números.");
                        entradaDeNumero.next();  // Limpia la entrada no válida
                    }
                } while (!entradaValida);

                // Solicitar tipo
                System.out.println(WHITE + "| Ingrese el tipo (fuego, agua,  |" + RESET);
                System.out.println(WHITE + "| electrico o planta):           |" + RESET);
                System.out.print("| > ");
                String tipo = entradaDeTexto.nextLine().toUpperCase();
                if (tipo.equals("FUEGO")) {
                    //Pedir poder
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderFuego = entradaDeNumero.nextInt();
                    //Pedir ataque
                    System.out.println(WHITE + "| Ingrese el ataque del Pokémon: |" + RESET);
                    System.out.print("| > ");
                    String ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();
                    equipoPokemon[contador] = new PokemonFuego(nombre, nivel, puntosDeVida, "fuego", poderFuego, ataqueEspecial);
                    bandera = 1;
                } else if (tipo.equals("PLANTA")) {
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderPlanta = entradaDeNumero.nextInt();
                    System.out.println(WHITE + "| Ingrese el ataque del Pokémon: |" + RESET);
                    System.out.print("| > ");
                    String ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();
                    equipoPokemon[contador] = new PokemonPlanta(nombre, nivel, puntosDeVida, "planta", poderPlanta, ataqueEspecial);
                    bandera = 1;
                } else if (tipo.equals("ELECTRICO")) {
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderElectrico = entradaDeNumero.nextInt();
                    System.out.println(WHITE + "| Ingrese el ataque del Pokémon: |" + RESET);
                    System.out.print("| > ");
                    String ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();
                    equipoPokemon[contador] = new PokemonElectrico(nombre, nivel, puntosDeVida, "eléctrico", poderElectrico, ataqueEspecial);
                    bandera = 1;
                } else if (tipo.equals("AGUA")) {
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderAgua = entradaDeNumero.nextInt();
                    System.out.println(WHITE + "| Ingrese el ataque del Pokémon: |" + RESET);
                    System.out.print("| > ");
                    String ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();
                    equipoPokemon[contador] = new PokemonAgua(nombre, nivel, puntosDeVida, "agua", poderAgua, ataqueEspecial);
                    bandera = 1;
                } else {
                    System.out.println(RED + "Tipo de Pokémon inválido" + RESET);
                }

                if (bandera == 1) {
                    System.out.println(YELLOW + "+-------------------------------+" + RESET);
                    System.out.println(RED + "Pokémon agregado exitosamente!" + RESET);
                    contador++;
                }
            } while (bandera != 1);

        } else {
            System.out.println(RED + "El equipo está lleno, no se puede agregar más Pokémon." + RESET);
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
            System.out.println(RED + "+-------------------------------+" + RESET);
            System.out.println(WHITE + "|          INFO POKÉMON         |" + RESET);
            System.out.println(YELLOW + "+-------------------------------+" + RESET);

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
            System.out.println(BLUE + (i+1) + ". " + RESET + GREEN + equipoPokemon[i].getNombre() + RESET);
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