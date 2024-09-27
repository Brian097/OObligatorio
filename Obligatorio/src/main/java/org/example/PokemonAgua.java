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
 * Clase PokemonAgua que extiende de la clase base Pokemon.
 */
public class PokemonAgua extends Pokemon {
    // Atributo que representa el poder de agua del Pokémon
    private int poderAgua;


    //Constructor default que inicializa un objeto del tipo PokemonAgua.

    public PokemonAgua() {
        super();
        this.poderAgua = 0;
    }


    //Constructor especifico que inicializa un objeto PokemonAgua con atributos ingresados.

    public PokemonAgua(String nombre, int nivel, int puntosDeVida, String tipo, int poderAgua) {
        super(nombre, nivel, puntosDeVida, tipo); // Llamada al constructor de la clase base Pokemon
        this.poderAgua = poderAgua; // Inicializa el poder de agua
    }

    //Getter para obtener poderAgua.
    public int getPoderAgua(){
        return poderAgua;
    }

    //Setter para setear el poderAgua.
    public void setPoderAgua(int poderAgua) {
        this.poderAgua = poderAgua;
    }

    //Metodo absracto para realzar un ataque especial
    @Override
    public String ataqueEspecial() {
        return "\nEl pokemon " + getNombre() + " realiza un ataque de agua con" + getPoderAgua() + " punto de poder";
    }
}