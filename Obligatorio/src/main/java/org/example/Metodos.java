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

public class Metodos {
    // Creamos los Scanner para entrada de Datos
    public static Scanner entradaDeTexto = new Scanner(System.in);
    public static Scanner entradaDeNumero = new Scanner(System.in);

    // Códigos de color ANSI
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String WHITE = "\u001B[37m";
    public static final String YELLOW = "\u001B[33m";

    // Creamos contador para saber cuántos Pokémon hay en el arreglo
    private static int contador = 0;

    // Creamos el arreglo que almacenará los Pokémon
    private static Pokemon[] equipoPokemon = new Pokemon[6];

    // Método usado para agregar un objeto Pokémon al arreglo.
    public static void agregarPokemon() {
        if (contador < equipoPokemon.length) {
            int bandera = 0;
            do {
                System.out.println(YELLOW + "+-------------------------------+" + RESET);
                System.out.println(WHITE + "|       AGREGAR NUEVO POKÉMON    |" + RESET);
                System.out.println(YELLOW + "+-------------------------------+" + RESET);

                // Solicitar nombre
                System.out.println(WHITE + "| Ingrese el nombre del Pokémon: |" + RESET);
                System.out.print("| > ");
                String nombre = entradaDeTexto.nextLine();

                // Solicitar nivel (0-100)
                System.out.println(WHITE + "| Ingrese el nivel:              |" + RESET);
                System.out.print("| > ");
                int nivel = entradaDeNumero.nextInt();

                // Solicitar puntos de vida (1-100)
                System.out.println(WHITE + "| Ingrese los puntos de vida:    |" + RESET);
                System.out.print("| > ");
                int puntosDeVida = entradaDeNumero.nextInt();

                // Solicitar tipo
                System.out.println(WHITE + "| Ingrese el tipo (fuego, agua,  |" + RESET);
                System.out.println(WHITE + "| eléctrico o planta):           |" + RESET);
                System.out.print("| > ");
                String tipo = entradaDeTexto.nextLine();

                if (tipo.equals("fuego")) {
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderFuego = entradaDeNumero.nextInt();
                    equipoPokemon[contador] = new PokemonFuego(nombre, nivel, puntosDeVida, "fuego", poderFuego);
                    bandera = 1;
                } else if (tipo.equals("planta")) {
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderPlanta = entradaDeNumero.nextInt();
                    equipoPokemon[contador] = new PokemonPlanta(nombre, nivel, puntosDeVida, "planta", poderPlanta);
                    bandera = 1;
                } else if (tipo.equals("electrico")) {
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderElectrico = entradaDeNumero.nextInt();
                    equipoPokemon[contador] = new PokemonElectrico(nombre, nivel, puntosDeVida, "eléctrico", poderElectrico);
                    bandera = 1;
                } else if (tipo.equals("agua")) {
                    System.out.println(WHITE + "| Ingrese el poder del Pokémon:  |" + RESET);
                    System.out.print("| > ");
                    int poderAgua = entradaDeNumero.nextInt();
                    equipoPokemon[contador] = new PokemonAgua(nombre, nivel, puntosDeVida, "agua", poderAgua);
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
}