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
    private String ataqueEspecial;
    //Constructores
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
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";

        return RED +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                "🔥 ¡El poder del fuego arde intensamente! 🔥\n" +
                "Pokemon: " + getNombre() + "\n" +
                "Ataque Especial: " + getAtaqueEspecial() + "\n" +
                "Puntos de Poder: " + getPoderFuego() + "\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" +
                RESET;
    }

    public String toString() {
        return super.toString() +
                WHITE + "| Poder de Fuego     : " + getPoderFuego() + "\n" +
                "| Ataque Especial    : " + getAtaqueEspecial() + "\n" +
                RED + "+-------------------------------+ \n" + RESET;
    }
}