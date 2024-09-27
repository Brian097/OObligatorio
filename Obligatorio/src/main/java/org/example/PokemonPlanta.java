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
 * Clase PokemonPlanta que extiende de la clase base Pokemon.
 */
public class PokemonPlanta extends Pokemon {
    // Atributo que representa el poder de planta del Pokémon
    private int poderPlanta;


    //Constructor default que inicializa un objeto del tipo PokemonPlanta.

    public PokemonPlanta() {
        super();
        this.poderPlanta = 0;
    }


    //Constructor especifico que inicializa un objeto PokemonPlanta con atributos ingresados.

    public PokemonPlanta(String nombre, int nivel, int puntosDeVida, String tipo, int poderPlanta) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon
        this.poderPlanta = poderPlanta; // Inicializa el poder de planta
    }


    //Getter para obtener poderPlanta.
    public int getPoderPlanta(){
        return poderPlanta;
    }


    //Setter para setear el poderPlanta.
    public void setPoderPlanta(int poderPlanta) {
        this.poderPlanta = poderPlanta;
    }

    //Metodo absracto para realzar un ataque especial
    @Override
    public String ataqueEspecial() {
        return "\nEl pokemon " + getNombre() + " realiza un ataque de planta con" + getPoderPlanta() + " punto de poder";
    }

}