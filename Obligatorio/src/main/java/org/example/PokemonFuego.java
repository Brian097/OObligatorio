package org.example;

public class PokemonFuego extends Pokemon{

    // Atributo que representa el poder de fuego del Pokémon
    private int poderFuego;

    /**
     * Constructores
     */

    //Constructor default que inicializa un objeto del tipo PokemonFuego
    public PokemonFuego() {
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
        return "\nEl pokemon " + getNombre() + " realiza un ataque de fuego con" + getPoderFuego() + " punto de pdoer";
    }
}