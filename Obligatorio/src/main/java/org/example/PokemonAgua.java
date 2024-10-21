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

//Clase PokemonAgua que extiende de la clase base Pokemon.
public class PokemonAgua extends Pokemon {
    // Atributo que representa el poder de agua del Pokémon
    private int poderAgua;
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
    //Constructor default que inicializa un objeto del tipo PokemonAgua.
    public PokemonAgua() {
        super();
        this.poderAgua = 0;
    }


    //Constructor especifico que inicializa un objeto PokemonAgua con atributos ingresados.

    public PokemonAgua(String nombre, int nivel, int puntosDeVida, String tipo, int poderAgua, String ataqueEspecial) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon
        this.poderAgua = poderAgua; // Inicializa el poder de agua
        this.ataqueEspecial = ataqueEspecial; // Inicializa el especial
    }

    //Getter para obtener poderAgua.
    public int getPoderAgua(){
        return poderAgua;
    }

    //Setter para setear el poderAgua.
    public void setPoderAgua(int poderAgua) {
        this.poderAgua = poderAgua;
    }

    public String getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    //Metodo absracto para realzar un ataque especial
    @Override
    public String ataqueEspecial() {
        return  "╔═════════════════════════════════════════════════════════\n" +
                "║ El Pokémon " + getNombre() + " realiza su ataque especial " + getAtaqueEspecial() + "!\n" +
                "║ Ha infringido un total de " + getPoderAgua() + " puntos de daño.\n" +
                "╚═════════════════════════════════════════════════════════\n";
    }

    @Override
    public String toString() {
        return super.toString() +
                COLOR_BLANCO + "| Poder de Agua  : " + getPoderAgua() + "\n" +
                "| Ataque Especial: " + getAtaqueEspecial() + "\n" +
                COLOR_ROJO + "+-------------------------------+\n" + COLOR_RESET;
    }
}