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
     * Constructores:
     *  Por defecto
     *  Especifico
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
        final String GREEN = "\u001B[32m";

        return GREEN +
                "++++++++++++++++++++++++++++++++++++\n" +
                "🌱 ¡La fuerza de la naturaleza crece! 🌱\n" +
                "Pokemon: " + getNombre() + "\n" +
                "Ataque Especial: " + getAtaqueEspecial() + "\n" +
                "Puntos de Poder: " + getPoderPlanta() + "\n" +
                "++++++++++++++++++++++++++++++++++++" +
                RESET;
    }

    @Override
    public String toString() {
        return super.toString() +
                WHITE + "| Poder de Planta     : " + getPoderPlanta() + "\n" +
                "| Ataque Especial    : " + getAtaqueEspecial() + "\n" +
                RED + "+-------------------------------+\n" + RESET;
    }

}