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

    /**
     * Opciones del Menú
     */

    final static int SALIR = 0;
    final static int AGREGAR_POKEMON = 1;
    final static int MOSTRAR_POKEMON = 2;
    final static int ATAQUE_ESPECIAL = 3;
    final static int PROMEDIO_NIVEL = 4;

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
     * Límites constantes para los valores del Pokémon.
     */
    private final static int NIVEL_MINIMO = 1;
    private final static int NIVEL_MAXIMO = 100;
    private final static int VIDA_MINIMA = 0;
    private final static int VIDA_MAXIMA = 100;
    private final static int PODER_MINIMO = 0;
    private final static int PODER_MAXIMO = 100;

    /**
     * Variables para almacenar los datos del Pokémon actual.
     */
    private static String nombre;
    private static int nivel;
    private static int puntosDeVida;
    private static String nombreDeAtaque;
    private static int poderDeAtaque;
    private static String tipoPokemon;

    /**
     * Opción seleccionada del menú.
     */
    static int opcion;

    /**
     * Contador de Pokémon en el equipo.
     */
    static int contador = 0;

    /**
     * Objetos Scanner para la entrada de datos del usuario.
     */
    static Scanner entradaDeTexto = new Scanner(System.in);
    static Scanner entradaDeNumeros = new Scanner(System.in);

    /**
     * Bandera para controlar la validez de la entrada del usuario.
     */
    static boolean entradaValida;

    /**
     * Arreglo que almacena los Pokémon del equipo.
     */
    static Pokemon[] equipoPokemon = new Pokemon[6];


    /**
     * Método que muestra los Pokémon en el equipo con un formato colorido
     */
    public static void mostrarEquipoPokemon() {
        if (contador == 0) {
            System.out.println("El equipo esta vacío.");
        } else {
            // Mostrar encabezado una sola vez con colores
            System.out.println(COLOR_ROJO +     "+-------------------------------+" + COLOR_RESET);
            System.out.println(COLOR_BLANCO +   "|          INFO POKÉMON         |" + COLOR_RESET);
            System.out.println(COLOR_AMARILLO + "+-------------------------------+" + COLOR_RESET);

            for (int i = 0; i < contador; i++) {
                System.out.print(equipoPokemon[i]);
            }
        }
    }
    /**
     * Metodo que permite al usuario elegir un Pokémon y realizar su ataque especial.
     */
    public static void realizarAtaqueEspecial() {
        // Muestro los nombres de los pokémon, si no hay ninguno no imprime nada
        for (int i = 0; i < contador; i++) {
            System.out.println(COLOR_AZUL + (i+1) + ". " + COLOR_RESET +COLOR_VERDE + equipoPokemon[i].getNombre() + COLOR_RESET);
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
     * Metodo que calcula y muestra el promedio de nivel del equipo
     */
    public static String calcularPromedioNivel() {
        if (contador == 0) {
            return "No hay Pokémon en tu equipo. Debes añadir al menos uno.";
        }

        float sumaNiveles = 0;
        for (int i = 0; i < contador; i++) {
            sumaNiveles += equipoPokemon[i].getNivel();
        }
        float promedio = sumaNiveles / contador;
        return "El promedio de nivel de tu equipo es: " + promedio;
    }


    /**
     * Metodos para solicitar y valirad datos del Pokémon
     */

    // Solicita el nombre del pokemon
    private static String solicitarNombrePokemon(){
        System.out.println(COLOR_BLANCO + "| Ingrese el nombre del Pokémon: |" + COLOR_RESET);
        System.out.print("| > ");
        nombre = entradaDeTexto.nextLine().toUpperCase();

        if (nombre != ""){
            return nombre;
        } else {
            System.out.println(COLOR_BLANCO + "| ERROR. El nombre no puede ser vacío." + COLOR_RESET);
            return "";
        }

    }

    // Solicit el nivel del Pokémon y lo valida
    private static int solicitarNivelPokemon(){
        nivel = -1;
        entradaValida = false; // Restablezco entradaValida a false para usarla nuevamente

        do {
            System.out.println(COLOR_BLANCO + "| Ingrese el nivel:              |" + COLOR_RESET);
            System.out.print("| > ");

            try {
                Scanner entradaParaTryCatch = new Scanner(System.in);
                nivel = entradaParaTryCatch.nextInt();  // Intenta leer el número

                if ((nivel >= NIVEL_MINIMO) && (nivel <= NIVEL_MAXIMO)){ //Limito el nivel
                    entradaValida = true;  // Si se ingresó el dato de manera correcta marca la entrada como válida, y retorna nivel
                } else {
                    System.out.println(COLOR_BLANCO + "| Solo se puede ingresar numeros del 1 al 100" + COLOR_RESET);
                }
            } catch (Exception e) {
                System.out.println(COLOR_BLANCO + "| Error: Solo se permiten números del 1 al 100." + COLOR_RESET);
            }
        } while (!entradaValida); //Si no se ha ingresado el dato de manera correcta se repite el metodo

        return nivel;
    }

    // Solicita los puntos de vida del Pokémon  y los valida
    private static int solicitarPuntosDeVidaPokemon(){
        puntosDeVida = 0;
        entradaValida = false; // Restablezco entradaValida a false para usarla nuevamente

        do {
            System.out.println(COLOR_BLANCO + "| Ingrese los puntos de vida:    |" + COLOR_RESET);
            System.out.print("| > ");

            try {
                Scanner entradaParaTryCatch = new Scanner(System.in);
                puntosDeVida = entradaParaTryCatch.nextInt();

                if ((puntosDeVida >= VIDA_MINIMA) && (puntosDeVida <= VIDA_MAXIMA)){
                    entradaValida = true;  // Si se ingresa el dato de manera correcta marca la entrada como valida y retorna puntosDeVida
                } else {
                    System.out.println(COLOR_BLANCO + "| Solo se puede ingresar numeros del 0 al 100" + COLOR_RESET);
                }
            } catch (Exception e) {
                System.out.println(COLOR_BLANCO + "| Error: Solo se permiten números del 0 al 100." + COLOR_RESET);
            }
        } while (!entradaValida); //Si no se ha ingresado el dato de manera correcta se repite el metodo

        return puntosDeVida;
    }
    
    // Solicita el tipo de Pokémon
    private static String solicitarTipoPokemon(){
        tipoPokemon = "";
        entradaValida = false; // Restablezco entradaValida a false para usarla nuevamente

        do {
            System.out.println(COLOR_BLANCO + "| Ingrese el tipo (fuego, agua,  |" + COLOR_RESET);
            System.out.println(COLOR_BLANCO + "| electrico o planta):           |" + COLOR_RESET);
            System.out.print("| > ");
            try {
                tipoPokemon = entradaDeTexto.nextLine().toUpperCase();

                //Verifico que el tipo sea valido
                switch (tipoPokemon){
                    case "FUEGO", "AGUA", "ELECTRICO", "PLANTA":
                        entradaValida = true; //Establezo como valida el ingreso del dato, para que no se siga repitiendo
                        break;

                    default:
                        System.out.println(COLOR_BLANCO + "| Tipo de Pokemon invalido" + COLOR_RESET);
                }
            } catch (Exception ex) {
                System.out.println(COLOR_BLANCO + "| ERROR. Debes ingresar una de las opciones disponibles." + COLOR_RESET);
            }
        }while(!entradaValida); //Si el dato ingresado no es valido se repite el metodo

        return tipoPokemon;
    }

    // Solicita el Poder de Ataque del Pokémon
    private static int solicitarPoderDeAtaquePokemon(){
        poderDeAtaque = 0;
        entradaValida = false; // Restablezco entradaValida a false para usarla nuevamente

        do {
            System.out.println(COLOR_BLANCO + "| Ingrese el poder del Pokémon:  |" + COLOR_RESET);
            System.out.print("| > ");

            try {
                Scanner entradaParaTryCatch = new Scanner(System.in);
                poderDeAtaque = entradaParaTryCatch.nextInt();

                if ((poderDeAtaque >= PODER_MINIMO) && (poderDeAtaque <= PODER_MAXIMO)) {
                    entradaValida = true;
                }else{
                    System.out.println(COLOR_BLANCO + "| Solo se puede ingresar numeros enteros entre 0 y 100" + COLOR_RESET);
                }
            } catch (Exception e) {
                System.out.println(COLOR_BLANCO + "| ERROR: Solo se permiten números." + COLOR_RESET);
            }
        } while(!entradaValida); //Si el dato ingresado no es valido se repite el metodo

        return poderDeAtaque;
    }

    // Solicito el Nombre del Ataque del Pokemon
    private static String solicitarNombreDeAtaquePokemon(){
        nombreDeAtaque = "";

        System.out.println(COLOR_BLANCO + "| Ingresa el nombre del ataque:  |" + COLOR_RESET);
        System.out.print("| > ");
        nombreDeAtaque = entradaDeTexto.nextLine().toUpperCase();

        if (nombreDeAtaque == "") {
            System.out.println("ERROR. El nombre del ataque no puede ser vacío.");
        }
        return nombreDeAtaque;
    }

    /**
     * Verfica si hay espacio en el equipo de Pokémon
     */
    private static boolean equipoTieneEspacio(Pokemon[] equipoPokemon){
        boolean hayEspacio = false; //Inicializo hayEspacio en false para que si no hay espacio se retorne false

        //Se recorre los espacios del vector en vusca de un lugar libre
        for (int i = 0; i < equipoPokemon.length; i++) {
            //Si encuentra un lugar vacio (null) devuelve true
            if(equipoPokemon[i] == null){
                hayEspacio = true;
            }
        }

        return hayEspacio;
    }

    /**
     *  Solicita y almacena los datos de de un nuevo pokemon
     */
    public static void solicitarDatosPokemon(){
        //Imprimo la cabecera del menú para Agregar Pókemon
        System.out.println(COLOR_AMARILLO + "+-------------------------------+" + COLOR_RESET);
        System.out.println(COLOR_BLANCO + "|       AGREGAR NUEVO POKÉMON    |" + COLOR_RESET);
        System.out.println(COLOR_AMARILLO + "+-------------------------------+" + COLOR_RESET);

        //Solicito nombre del Pokemon
        do {
            nombre = solicitarNombrePokemon();
        } while (nombre == "");

        //Solicito nivel del Pokemon
        nivel = solicitarNivelPokemon();

        //Solicito los puntos de vida del Pokemon
        puntosDeVida = solicitarPuntosDeVidaPokemon();

        //Solicito tipo del Pokemon
        tipoPokemon = solicitarTipoPokemon();

        //Solicito poderDeAtaque
        poderDeAtaque = solicitarPoderDeAtaquePokemon();

        //Solicito el ataque especial del pokemon
        do{
            nombreDeAtaque = solicitarNombreDeAtaquePokemon();
        } while (nombreDeAtaque == ""); //Se repite mientras se ingrese un nombre de ataque vacío

        //Luego de pedir los datos termino el diseño del munú
        System.out.println(COLOR_AMARILLO + "+-------------------------------+" + COLOR_RESET);


        //Verifico si hay espacio en el equipo y agrego el pokemon
        if (equipoTieneEspacio(equipoPokemon)){
            añadirPokemonAlEquipo();
        } else {
            System.out.println(COLOR_ROJO + "El equipo está lleno, no se puede agregar más Pokémon." + COLOR_RESET);
        }

    }

    /**
     * Añade el POkémon al equipo.
     */
    private static void añadirPokemonAlEquipo(){

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
        System.out.println(COLOR_ROJO + "Pokémon agregado exitosamente!" + COLOR_RESET);
    }

    /**
     * Método que muestra la bienvenida al programa
     * utilizando un arte ASCII. Se utiliza para dar
     * una presentación visual del programa.
     */

    private static void mostrarBienvenidaPokemonASCII(){
        System.out.println(COLOR_AMARILLO +
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
                COLOR_RESET
        );
    }

    /**
     * Metodo que muestra el Menú Principal
     */
    private static void mostrarMenuPrincipal(){
        System.out.println(COLOR_BLANCO +                          "+++++++++++++++++++++++++++++++++++++++++" + COLOR_RESET);
        System.out.println(COLOR_ROJO   + "+" + COLOR_RESET + COLOR_BLANCO + "                                       " + COLOR_RESET + COLOR_ROJO   + "+" + COLOR_RESET );
        System.out.println(COLOR_BLANCO + "+" + COLOR_RESET + COLOR_BLANCO + "   -- Menú de Gestión de Pokémon--     " + COLOR_RESET + COLOR_BLANCO + "+" + COLOR_RESET );
        System.out.println(COLOR_ROJO   + "+" + COLOR_RESET + COLOR_BLANCO + "   1. Agregar un Pokémon               " + COLOR_RESET + COLOR_ROJO   + "+" + COLOR_RESET );
        System.out.println(COLOR_BLANCO + "+" + COLOR_RESET + COLOR_BLANCO + "   2. Mostrar Pokémon                  " + COLOR_RESET + COLOR_BLANCO + "+" + COLOR_RESET );
        System.out.println(COLOR_ROJO   + "+" + COLOR_RESET + COLOR_BLANCO + "   3. Realizar Ataque Especial         " + COLOR_RESET + COLOR_ROJO   + "+" + COLOR_RESET );
        System.out.println(COLOR_BLANCO + "+" + COLOR_RESET + COLOR_BLANCO + "   4. Calcular Promedio de Nivel       " + COLOR_RESET + COLOR_BLANCO + "+" + COLOR_RESET );
        System.out.println(COLOR_ROJO   + "+" + COLOR_RESET + COLOR_BLANCO + "   0. Salir                            " + COLOR_RESET + COLOR_ROJO   + "+" + COLOR_RESET );
        System.out.println(COLOR_BLANCO + "+" + COLOR_RESET + COLOR_BLANCO + "                                       " + COLOR_RESET + COLOR_BLANCO + "+" + COLOR_RESET );
        System.out.println(COLOR_ROJO   +                          "+++++++++++++++++++++++++++++++++++++++++" + COLOR_RESET                    );
    }

    /**
     * Método que obtiene la opcion del menú ingresada por el usuario y la valida
     */
    private static int leerOpcionMenu(){
        entradaValida = false; // Reseteo entradavalida, esta se usa de bandera para cuando la opcion no es valida.
        do {
            System.out.print("Seleccione una opción: ");

            try {
                Scanner entradaDeNumeros2 = new Scanner(System.in);
                opcion = entradaDeNumeros2.nextInt();

                if ((opcion >= 0) && (opcion <= 4)){
                    entradaValida = true;
                } else {
                    System.out.println("ERROR, Ingrese una opcion valida (0-4).");
                }
            } catch (Exception ex) {
                System.out.println("ERROR, Ingrese una opcion valida (0-4).");
            }
        } while(!entradaValida);
        return opcion;
    }

    /**
     * Método que procesa la opcion del menu, es decir recibe la opcion y llama al metodo correspondiente
     */
    private static void procesarOpcionMenu(int opcion){
        switch(opcion){
            case AGREGAR_POKEMON:
                //LLamo al metodo usado para agregar un pokemon
                solicitarDatosPokemon();
                break;
            case MOSTRAR_POKEMON:
                //LLamo al metodo mostar pokemon
                mostrarEquipoPokemon();
                break;
            case ATAQUE_ESPECIAL:
                //LLamo al metodo ralizar un ataque especial
                realizarAtaqueEspecial();
                break;
            case PROMEDIO_NIVEL:
                //LLamo al metodo calcular promedio
                System.out.println(calcularPromedioNivel());
                break;
            case SALIR:
                //Salgo del programa
                break;
            default:
                System.out.println("Ingresa un numero válido.");
        }
    }

    /**
     *  Método principal del programa
     */
    public static void main(String[] args) {

        mostrarBienvenidaPokemonASCII();

        do {
            mostrarMenuPrincipal();
            opcion = leerOpcionMenu();
            procesarOpcionMenu(opcion);
        } while (opcion != 0);

        System.out.println("Saliendo...");
    }

}
