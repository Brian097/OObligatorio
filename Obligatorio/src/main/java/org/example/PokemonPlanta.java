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

//Clase PokemonPlanta que extiende de la clase base Pokemon.

public class PokemonPlanta extends Pokemon {
    // Atributo que representa el poder de planta del Pokémon
    private int poderPlanta;
    private String ataqueEspecial;

    /**
     * Códigos de color ANSI para la salida de consola.
     */
    final static String COLOR_AMARILLO = "\u001B[33m";
    final static String COLOR_AZUL = "\u001B[34m";
    final static String COLOR_BLANCO = "\u001B[37m";
    final static String COLOR_ROJO = "\u001B[31m";
    final static String COLOR_VERDE = "\u001B[32m";
    final static String COLOR_RESET = "\u001B[0m";

    /**
     * Constructores
     */
    //Constructor default que inicializa un objeto del tipo PokemonPlanta.
    public PokemonPlanta() {
        super();
        this.poderPlanta = 0;
    }

    //Constructor especifico que inicializa un objeto PokemonPlanta con atributos ingresados.
    public PokemonPlanta(String nombre, int nivel, int puntosDeVida, String tipo, int poderPlanta, String ataqueEspecial) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon
        this.poderPlanta = poderPlanta; // Inicializa el poder de planta
        this.ataqueEspecial = ataqueEspecial; // Inicializa el ataque especial
    }

    /**
     * GETTERS AND SETTER
     */
    //Getter para obtener poderPlanta.
    public int getPoderPlanta(){
        return poderPlanta;
    }

    //Setter para setear el poderPlanta.
    public void setPoderPlanta(int poderPlanta) {
        this.poderPlanta = poderPlanta;
    }

    //Getter para obteber el ataque especial
    public String getAtaqueEspecial() {
        return ataqueEspecial;
    }

    //Setter para settear el araque especial
    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    /**
     * METODOS
     */
    //Metodo absracto para realzar un ataque especial
    @Override
    public String ataqueEspecial() {
        return  "╔═════════════════════════════════════════════════════════\n" +
                "║ El Pokémon " + getNombre() + " realiza su ataque especial " + getAtaqueEspecial() + "!\n" +
                "║ Ha infringido un total de " + getPoderPlanta() + " puntos de daño.\n" +
                "╚═════════════════════════════════════════════════════════\n";
    }

    @Override
    public String toString() {
        return super.toString() +
                COLOR_BLANCO + "| Poder de Planta: " + getPoderPlanta() + "\n" +
                "| Ataque Especial: " + getAtaqueEspecial() + "\n" +
                COLOR_ROJO + "+-------------------------------+\n" + COLOR_RESET;
    }

}