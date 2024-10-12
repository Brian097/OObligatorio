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
//Creamos la clase abstracta
public abstract class Pokemon{
    private String nombre; // Atributo que representa el nombre del Pokemon
    private int nivel; //Atributo que representa el nivel del Pokemon
    private int puntosDeVida; //Atributo que representa los puntos de vida del Pokemon
    private String tipo; //Atributo que representa el tipo de Pokemon

    //Colores
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String WHITE = "\u001B[37m";
    public static final String YELLOW = "\u001B[33m";

    //Creamos el constructor default que inicializa un objeto del tipo Pokemon con valores por defecto.
    public Pokemon(){
        this.nombre = "";
        this.nivel = 1;
        this.puntosDeVida = 100;
        this.tipo = "fuego";
    }
    // Constructor específico que inicializa un objeto Pokemon con los atributos ingresados.
    public Pokemon(String nombre,int nivel,int puntosDeVida,String tipo){
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
        this.tipo = tipo;
    }
    // Creamos los getters & setters de los atributos
    public String getNombre() { //Getter de Nombre
        return nombre;
    }

    public void setNombre(String nombre) {  //Setter de Nombre
        this.nombre = nombre;
    }

    public int getNivel() { //Getter de Nivel
        return nivel;
    }

    public void setNivel(int nivel) {   //Setter de Nivel
        this.nivel = nivel;
    }

    public int getPuntosDeVida() {  //Getter de Puntos de Vida
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) { //Setter de Puntos de Vida
        this.puntosDeVida = puntosDeVida;
    }

    public String getTipo() {   //Getter de Tipo de Pokémon
        return tipo;
    }

    public void setTipo(String tipo) {  //Setter de Tipo de Pokémon
        this.tipo = tipo;
    }
    /**
     * Metodo abstactro para realizar ataque especial
     */
    public abstract String ataqueEspecial();

    /**
     * Metodo Mostrar Informacion
     */
    @Override
    public String toString() {
        // Imprimir la información de cada Pokémon
        return WHITE +
                "| Nombre         : " + getNombre() + "\n" +
                "| Nivel          : " + getNivel() + "\n" +
                "| Puntos de vida : " + getPuntosDeVida() + "\n" +
                "| Tipo           : " + getTipo() + "\n";


    }
}