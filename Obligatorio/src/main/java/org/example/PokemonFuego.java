package org.example;

/**
 *
 * ESCUELA TÉCNICA DE ROCHA
 * BT - TECNOLOGÍAS DE LA INFORMACIÓN
 * @author BALDIVIESO - 57237477
 * @author MAGNONE - 54785814
 * OBLIGATORIO - Gestión de un equipo de Pokémon.
 *
 **/

//Clase PokemonFuego que extiende de la clase base Pokemon.

public class PokemonFuego extends Pokemon{

    // Atributo que representa el poder de fuego del Pokémon y ataque especial
    private int poderFuego;
    private String ataqueEspecial;

    /**
     * Códigos de color ANSI para la salida de consola.
     */
    final static String COLOR_ROJO = "\u001B[31m";
    final static String COLOR_RESET = "\u001B[0m";

    /**
     * Constructores
     */
    //Constructor default que inicializa un objeto del tipo PokemonFuego
    public PokemonFuego() {
        super();
        this.poderFuego = 0;
    }

    //Constructor especifico que inicializa un objeto PokemonFuego con atributos ingresados.
    public PokemonFuego(String nombre, int nivel, int puntosDeVida, String tipo, int poderFuego, String ataqueEspecial) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon con tipo
        this.poderFuego = poderFuego; // Inicializa el poder de fuego
        this.ataqueEspecial = ataqueEspecial; //Inicializa el ataque especial
    }

    /**
     * Getters y setters
     */
    public  int getPoderFuego() {
        return poderFuego;
    }

    public void setPoderFuego(int poderFuego) {
        this.poderFuego = poderFuego;
    }

    public String getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    /**
     *Metodo absracto para realzar un ataque especial
     */
    @Override
    public String ataqueEspecial() {
        return  "╔═════════════════════════════════════════════════════════\n" +
                "║ El Pokémon " + COLOR_ROJO + getNombre() + COLOR_RESET + " realiza su ataque especial " + COLOR_ROJO + getAtaqueEspecial() + COLOR_RESET + "!\n" +
                "║ Ha infringido un total de " + COLOR_ROJO + getPoderFuego() + COLOR_RESET + " puntos de daño.\n" +
                "╚═════════════════════════════════════════════════════════\n" ;
    }

    public String toString() {
        return super.toString() +
                COLOR_BLANCO + "| Poder de Fuego : " + getPoderFuego() + "\n" +
                "| Ataque Especial: " + getAtaqueEspecial() + "\n" +
                COLOR_ROJO + "+-------------------------------+ \n" + COLOR_RESET;
    }
}