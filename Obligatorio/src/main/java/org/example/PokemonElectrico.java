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
 * Clase PokemonElectrico que extiende de la clase base Pokemon.
 */
public class PokemonElectrico extends Pokemon {
    // Atributo que representa el poder de agua del Pokémon
    private int poderElectrico;


     //Constructor default que inicializa un objeto del tipo PokemonElectrico.

    public PokemonElectrico() {
    }


     //Constructor especifico que inicializa un objeto PokemonAgua con atributos ingresados.

    public PokemonElectrico(String nombre, int nivel, int puntosDeVida, String tipo, int poderElectrico) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon
        this.poderElectrico = poderElectrico; // Inicializa el poder de electrico
    }


     //Getter para obtener poderElectrico.
    public int getPoderElectrico(){
        return poderElectrico;
    }


     //Setter para setear el poderElectrico.
    public void setPoderElectrico(int poderElectrico) {
        this.poderElectrico = poderElectrico;
    }

     //Metodo absracto para realzar un ataque especial
     @Override
     public String ataqueEspecial() {
         return "\nEl pokemon " + getNombre() + " realiza un ataque de fuego con" + getPoderElectrico() + " punto de pdoer";
     }

}

