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

//Clase PokemonElectrico que extiende de la clase base Pokemon.

public class PokemonElectrico extends Pokemon {
    // Atributo que representa el poder de eléctrico del Pokémon
    private int poderElectrico;
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
    //Constructor default que inicializa un objeto del tipo PokemonElectrico.
    public PokemonElectrico() {
        super();
        this.poderElectrico = 0;
    }


     //Constructor especifico que inicializa un objeto PokemonElectrico con atributos ingresados.

    public PokemonElectrico(String nombre, int nivel, int puntosDeVida, String tipo, int poderElectrico,String ataqueEspecial) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon
        this.poderElectrico = poderElectrico; // Inicializa el poder de electrico
        this.ataqueEspecial = ataqueEspecial; // Inicializa el ataque especial
    }


     //Getter para obtener poderElectrico.
    public int getPoderElectrico(){
        return poderElectrico;
    }


     //Setter para setear el poderElectrico.
    public void setPoderElectrico(int poderElectrico) {
        this.poderElectrico = poderElectrico;
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
                "║ Ha infringido un total de " + getPoderElectrico() + " puntos de daño.\n" +
                "╚═════════════════════════════════════════════════════════\n";
    }

    @Override
    public String toString() {
        return super.toString() +
                COLOR_BLANCO + "| Poder Eléctrico: " + getPoderElectrico() + "\n" +
                "| Ataque Especial: " + getAtaqueEspecial() + "\n" +
                COLOR_ROJO + "+-------------------------------+\n" + COLOR_RESET;
    }
}

