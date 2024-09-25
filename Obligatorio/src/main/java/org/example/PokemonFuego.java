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

/**
 * Clase PokemonFuego que extiende de la clase base Pokemon.
 */

public class PokemonFuego extends Pokemon{

    // Atributo que representa el poder de fuego del Pokémon
    private int poderFuego;

    //Constructores
    //Constructor default que inicializa un objeto del tipo PokemonFuego
    public PokemonFuego() {
        super("", 0, 0, "electrico");
        poderFuego = 0;
    }

    //Constructor especifico que inicializa un objeto PokemonFuego con atributos ingresados.
    public PokemonFuego(String nombre, int nivel, int puntosDeVida, String tipo, int poderFuego) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon con tipo
        this.poderFuego = poderFuego; // Inicializa el poder de fuego
    }

    public int getPoderFuego() {
        return poderFuego;
    }

    public void setPoderFuego(int poderFuego) {
        this.poderFuego = poderFuego;
    }

    /**
     *Metodo absracto para realzar un ataque especial
     */
    @Override
    public String ataqueEspecial() {
        return "\nEl pokemon " + getNombre() + " realiza un ataque de fuego con" + getPoderFuego() + " punto de poder";
    }
}