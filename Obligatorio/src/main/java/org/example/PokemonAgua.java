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
        final String RESET = "\u001B[0m";
        final String BLUE = "\u001B[34m";

        return BLUE +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "🌊 ¡El poder del agua fluye sin fin! 🌊\n" +
                "Pokemon: " + getNombre() + "\n" +
                "Ataque Especial: " + getAtaqueEspecial() + "\n" +
                "Puntos de Poder: " + getPoderAgua() + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
                RESET;
    }

    @Override
    public String toString() {
        return super.toString() +
                WHITE + "| Poder de Fuego     : " + getPoderAgua() + "\n" +
                "| Ataque Especial    : " + getAtaqueEspecial() + "\n" +
                RED + "+-------------------------------+\n" + RESET;
    }
}