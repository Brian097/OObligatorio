package org.example;

import java.util.Scanner;

/**
 *
 * ESCUELA TÉCNICA DE ROCHA
 * BT - TECNOLOGÍAS DE LA INFORMACIÓN
 * @author BRIAN BALDIVIESO - 57237477
 * @author ENZO MAGNONE - 54785814
 * OBLIGATORIO - Gestión de un equipo de Pokémon.
 *
 **/

public class Principal {
    /*
      Variables Globales
     */

    //Variable Global Códigos de color ANSI
    final static String amarillo = "\u001B[33m";  // Color amarillo
    final static String azul = "\u001B[34m";      // Color azul
    final static String blanco = "\u001B[37m";   // Color blanco
    final static String rojo = "\u001B[31m";     // Color rojo
    final static String verde = "\u001B[32m"; // Color verde
    final static String reset = "\u001B[0m";      // Restablecer color

    //Variables globales - Atrubutos
    private static String nombre;
    private static int nivel;
    private static int puntosDeVida;
    private static String nombreDeAtaque;
    private static int poderDeAtaque;
    private static String tipoPokemon;

    //Variable opcion - bandera
    static int opcion;

    // Creaemos variable contador para saber cuántos Pokémon hay en el arreglo
    static int contador = 0;

    // Creamos los objetos globales del tipo Scanner para entrada de Datos
    static Scanner entradaDeTexto = new Scanner(System.in);
    static Scanner entradaDeNumeros = new Scanner(System.in);

    //Creamos la variable entradaValida para salir de los do-while cuando se ingrese el dato de manera correcta
    static boolean entradaValida;

    // Creamos el arreglo que almacenará los Pokémon
    static Pokemon[] equipoPokemon = new Pokemon[6];

    public static void main(String[] args) {

        //Se imprime Pokemon en ASCII
        System.out.println(amarillo +
                "                               .::.                           \n"+
                "                              .;:**'                          \n"+
                "                              `                               \n"+
                "  .:XHHHHk.              db.   .;;.     dH  MX                \n"+
                "oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN     \n"+
                "QMMMMMb  'MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM\n"+
                "  `MMMM.  )M> :X!Hk. MMMM   XMM.o'  .  MMMMMMM X?XMMM MMM>!MMP\n"+
                "   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `' MX MMXXMM \n"+
                "    ~MMMMM~ XMM. .XM XM`'MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP \n"+
                "     ?MMM>  YMMMMMM! MM   `?MMRb.    `MM   !L'MMMMM XM IMMM   \n"+
                "      MMMX   'MMMM'  MM       ~%:           !Mh.''' dMI IMMP  \n"+
                "      'MMM.                                             IMX   \n"+
                "       ~M!M                                             IM    \n"+
                reset
        );

        /**
         * MENÚ
         */
        do {
            //Menu con borde de color
            System.out.println(blanco +                          "+++++++++++++++++++++++++++++++++++++++++" + reset);
            System.out.println(rojo   + "+" + reset + blanco + "                                       " + reset + rojo   + "+" + reset  );
            System.out.println(blanco + "+" + reset + blanco + "   -- Menú de Gestión de Pokémon--     " + reset + blanco + "+" + reset );
            System.out.println(rojo   + "+" + reset + blanco + "   1. Agregar un Pokémon               " + reset + rojo   + "+" + reset );
            System.out.println(blanco + "+" + reset + blanco + "   2. Mostrar Pokémon                  " + reset + blanco + "+" + reset );
            System.out.println(rojo   + "+" + reset + blanco + "   3. Realizar Ataque Especial         " + reset + rojo   + "+" + reset );
            System.out.println(blanco + "+" + reset + blanco + "   4. Calcular Promedio de Nivel       " + reset + blanco + "+" + reset );
            System.out.println(rojo   + "+" + reset + blanco + "   0. Salir                            " + reset + rojo   + "+" + reset );
            System.out.println(blanco + "+" + reset + blanco + "                                       " + reset + blanco + "+" + reset );
            System.out.println(rojo   +                          "+++++++++++++++++++++++++++++++++++++++++" + reset                        );

            entradaValida = false; // Reseteo entradavalida, esta se usa de bandera para cuando la opcion no es valida.
            do {

                System.out.print("Seleccione una opción: ");

                try {
                    Scanner entradaDeNumeros2 = new Scanner(System.in);
                    opcion = entradaDeNumeros2.nextInt();

                    switch (opcion){
                        case 0, 1, 2, 3, 4:
                            entradaValida = true;
                            break;
                        default:
                            System.out.println("ERROR, Ingrese una opcion valida (0-4).");
                    }
                } catch (Exception ex) {
                    System.out.println("ERROR, Ingrese una opcion valida (0-4).");
                }
            } while(!entradaValida);

            switch(opcion){
                case 1:
                    //LLamo al metodo agregar un pokemon si hay espacio en el equipo
                    if (verificarEspacio(equipoPokemon)){
                        agregarPokemon();
                    } else {
                        System.out.println(rojo + "El equipo está lleno, no se puede agregar más Pokémon." + reset);
                    }

                    break;
                case 2:
                    //LLamo al metodo mostar pokemon
                    mostrarInformacion();
                    break;
                case 3:
                    //LLamo al metodo ralizar un ataque especial
                    ataqueEspecial();
                    break;
                case 4:
                    //LLamo al metodo calcular promedio
                    System.out.println(promedioNivel());
                    break;
                case 0:
                    //Salgo del programa
                    break;
                default:
                    System.out.println("Ingresa un numero válido.");
            }
        } while (opcion != 0);

        System.out.println("Saliendo..."); //Sale del programa
    }

    /**
     * Métodos
     */

    //Metodo para mostrar informacion llamando a los getters de forma
    public static void mostrarInformacion() {
        if (contador == 0) {
            System.out.println("El equipo esta vacío.");
        } else {
            // Mostrar encabezado una sola vez con colores
            System.out.println(rojo +     "+-------------------------------+" + reset);
            System.out.println(blanco +   "|          INFO POKÉMON         |" + reset);
            System.out.println(amarillo + "+-------------------------------+" + reset);

            for (int i = 0; i < contador; i++) {
                System.out.print(equipoPokemon[i]);
            }
        }
    }
    /**
     * Metodo para elejir un pokemon y realizar un ataque especial
     */
    public static void ataqueEspecial() {
        // Muestro una lista de los pokemon y el usuario elije uno
        for (int i = 0; i < contador; i++) {
            System.out.println(azul + (i+1) + ". " + reset +verde + equipoPokemon[i].getNombre() + reset);
        }
        if (contador == 0){  //verifico que haya pokemon en el equipo
            System.out.println("No hay Pokémon en el equipo.");
        } else {
            // pregunto cual pokemon va a realizar el ataque
            System.out.print("Elige un pokemon para realizar un ataque especial: ");
            int pokemonElejido = entradaDeTexto.nextInt() - 1;

            if (pokemonElejido >= contador || pokemonElejido < 0){ //verifico que se haya elejido un pokemon existente
                System.out.println("Pokemon no válido.");
            }else {
                // muestro el ataque especial del pokemon elejido
                System.out.println(equipoPokemon[pokemonElejido].ataqueEspecial());
            }
        }
    }

    /**
     * Metodo para calcular y mostrar el promedio de nivel
     */
    public static String promedioNivel() {
        float sumaNiveles = 0;
        float promedio;

        //Suma los niveles y los guarda para poder calcular promedio
        for (int i = 0; i < contador; i++) {
            sumaNiveles += equipoPokemon[i].getNivel();
        }
        //Si hay pokemon en el equipo calculo
        if(contador != 0) {
            promedio = sumaNiveles / contador;
            return "El promedio de nivel de tu equipo es: " + promedio;
        } else{
            return "No hay pokemons en tu equipo. Debes añadir al menos un pokemon.";
        }
    }

    /**
     * Metodos para agregar informacion del pokemon
     */

    //Metodo para solicitar el nombre del pokemon
    private static String ingresarNombre(){
        System.out.println(blanco + "| Ingrese el nombre del Pokémon: |" + reset);
        System.out.print("| > ");
        nombre = entradaDeTexto.nextLine().toUpperCase();

        if (nombre == ""){
            System.out.println(blanco + "| ERROR. El nombre no puede ser vacío." + reset);
            return "";
        } else {
            return nombre;
        }

    }

    //Metodo para ingresar nivel del pokemonz
    private static int ingresarNivel(){
        nivel = 0;
        entradaValida = false;

        do {
            System.out.println(blanco + "| Ingrese el nivel:              |" + reset);
            System.out.print("| > ");

            try {
                Scanner entradaDeNumero2 = new Scanner(System.in);
                nivel = entradaDeNumero2.nextInt();  // Intenta leer el número

                if ((nivel >= 1) && (nivel <= 100)){ //Limito el nivel
                    entradaValida = true;  // Si se ingresó el dato de manera correcta marca la entrada como válida, y retorna nivel
                } else {
                    System.out.println(blanco + "| Solo se puede ingresar numeros del 1 al 100" + reset);
                }
            } catch (Exception e) {
                System.out.println(blanco + "| Error: Solo se permiten números del 1 al 100." + reset);
            }
        } while (!entradaValida); //Si no se ha ingresado el dato de manera correcta se repite el metodo

        return nivel;
    }

    private static int ingresarPuntosDeVida(){
        puntosDeVida = 0;
        entradaValida = false; // Reseteo entradavalida para volver a usarla

        do {
            System.out.println(blanco + "| Ingrese los puntos de vida:    |" + reset);
            System.out.print("| > ");

            try {
                Scanner entradaDeNumero2 = new Scanner(System.in);
                puntosDeVida = entradaDeNumero2.nextInt();

                if ((puntosDeVida >= 0) && (puntosDeVida <= 100)){
                    entradaValida = true;  // Si se ingresa el dato de manera correcta marca la entrada como valida y retorna puntosDeVida
                } else {
                    System.out.println(blanco + "| Solo se puede ingresar numeros del 0 al 100" + reset);
                }
            } catch (Exception e) {
                System.out.println(blanco + "| Error: Solo se permiten números del 0 al 100." + reset);
            }
        } while (!entradaValida); //Si no se ha ingresado el dato de manera correcta se repite el metodo

        return puntosDeVida;
    }
    
    //Metodo para agregar tipo de pokemon
    private static String ingresarTipo(){
        tipoPokemon = "";
        entradaValida = false;

        do {
            System.out.println(blanco + "| Ingrese el tipo (fuego, agua,  |" + reset);
            System.out.println(blanco + "| electrico o planta):           |" + reset);
            System.out.print("| > ");
            try {
                tipoPokemon = entradaDeTexto.nextLine().toUpperCase();

                //Verifico que el tipo sea valido
                switch (tipoPokemon){
                    case "FUEGO", "AGUA", "ELECTRICO", "PLANTA":
                        entradaValida = true; //Establezo como valida el ingreso del dato, para que no se siga repitiendo
                        break;

                    default:
                        System.out.println(blanco + "| Tipo de Pokemon invalido" + reset);
                }
            } catch (Exception ex) {
                System.out.println(blanco + "| ERROR. Debes ingresar una de las opciones disponibles." + reset);
            }
        }while(!entradaValida); //Si el dato ingresado no es valido se repite el metodo

        return tipoPokemon;
    }

    private static int ingresarPoderDeAtaque(){
        poderDeAtaque = 0;
        entradaValida = false; // Reseteo entradavalida para volver a usarla

        do {
            System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
            System.out.print("| > ");

            try {
                Scanner entradaDeNumero2 = new Scanner(System.in);
                poderDeAtaque = entradaDeNumero2.nextInt();

                if ((poderDeAtaque >= 0) && (poderDeAtaque <= 100)) {
                    entradaValida = true;
                }else{
                    System.out.println(blanco + "| Solo se puede ingresar numeros enteros entre 0 y 100" + reset);
                }
            } catch (Exception e) {
                System.out.println(blanco + "| ERROR: Solo se permiten números." + reset);
            }
        } while(!entradaValida);

        return poderDeAtaque;
    }

    private static String ingresarNombreDeAtaque(){
        nombreDeAtaque = "";

        System.out.println(blanco + "| Ingresa el nombre del ataque:  |" + reset);
        System.out.print("| > ");
        nombreDeAtaque = entradaDeTexto.nextLine().toUpperCase();

        if (nombreDeAtaque == "") {
            System.out.println("ERROR. El nombre del ataque no puede ser vacío.");
        }
        return nombreDeAtaque;
    }

    //Metodo para verificar si hay espacio en el equipo
    private static boolean verificarEspacio(Pokemon[] equipoPokemon){
        boolean hayEspacio = false; //Inicializo hayEspacio en false para que si no hay espacio se retorne false

        //Se recorre los espacios del vector en vusca de un lugar libre
        for (int i = 0; i < equipoPokemon.length; i++) {
            //Si encuentra un lugar vacio (null) devuelve true
            if(equipoPokemon[i] == null){
                hayEspacio = true;
            }
        }

        //Retorno hayEspacio
        return hayEspacio;
    }

    //Metodo para agregar pokemon, aca llamo a los metodos necesarios
    private static void agregarPokemon(){
        //Imprimo la cabecera del menú para Agregar Pókemon
        System.out.println(amarillo + "+-------------------------------+" + reset);
        System.out.println(blanco + "|       AGREGAR NUEVO POKÉMON    |" + reset);
        System.out.println(amarillo + "+-------------------------------+" + reset);

        //Solicito nombre del Pokemon
        do {
            nombre = ingresarNombre();
        } while (nombre == "");

        //Solicito nivel del Pokemon
        nivel = ingresarNivel();

        //Solicito los puntos de vida del Pokemon
        puntosDeVida = ingresarPuntosDeVida();

        //Solicito tipo del Pokemon
        tipoPokemon = ingresarTipo();

        //Solicito poderDeAtaque
        poderDeAtaque = ingresarPoderDeAtaque();

        //SOlicito el ataque especial del pokemon
        do{
            nombreDeAtaque = ingresarNombreDeAtaque();
        } while (nombreDeAtaque == ""); //Se repite mientras se ingrese un nombre de ataque vacío

        //Luegog de pedir los datos termino el diseño del munú
        System.out.println(amarillo + "+-------------------------------+" + reset);

        //Creo el objeto pokemon segun su tipo con los datos ingresados, si hay espacio
        switch (tipoPokemon) {
            case "FUEGO":
                equipoPokemon[contador] = new PokemonFuego(nombre, nivel, puntosDeVida, tipoPokemon, poderDeAtaque, nombreDeAtaque);
                break;
            case "AGUA":
                equipoPokemon[contador] = new PokemonAgua(nombre, nivel, puntosDeVida, tipoPokemon, poderDeAtaque, nombreDeAtaque);
                break;
            case "PLANTA":
                equipoPokemon[contador] = new PokemonPlanta(nombre, nivel, puntosDeVida, tipoPokemon, poderDeAtaque, nombreDeAtaque);
                break;
            case "ELECTRICO":
                equipoPokemon[contador] = new PokemonElectrico(nombre, nivel, puntosDeVida, tipoPokemon, poderDeAtaque, nombreDeAtaque);
                break;
        }
        contador++; //Se suma uno al contador cuando se agrega un pokemon
        System.out.println(rojo + "Pokémon agregado exitosamente!" + reset);
    }
}
