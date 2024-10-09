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
//Clase principal
public class Principal {
    //Variable Códigos de color ANSI
    final static String amarillo = "\u001B[33m";  // Color amarillo
    final static String azul = "\u001B[34m";      // Color azul
    final static String blanco = "\u001B[37m";   // Color blanco
    final static String rojo = "\u001B[31m";     // Color rojo
    final static String verde = "\u001B[32m"; // Color verde
    final static String reset = "\u001B[0m";      // Restablecer color

    // Creamos los objetos del tipo Scanner para entrada de Datos
    static Scanner entradaDeTexto = new Scanner(System.in);
    static Scanner entradaDeNumeros = new Scanner(System.in);

    // Creaemos contador para saber cuántos Pokémon hay en el arreglo
    static int contador = 0;

    // Creamos el arreglo que almacenará los Pokémon
    static Pokemon[] equipoPokemon = new Pokemon[6];

    public static void main(String[] args) {

        //Variables
        int opcion; //Bandera

        //Pokemon en ASCII
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

        //DO-WHILE para Menú
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

            System.out.print("Seleccione una opción: ");
            opcion = entradaDeNumeros.nextInt();

            switch(opcion){
                case 1:
                    //LLamo al metodo agregar un pokemon
                    agregarPokemon();
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
    //Metodos

    // Método usado para agregar un objeto Pokémon al arreglo.
    public static void agregarPokemon() {
        //variables
        String ataqueEspecial;

        if (contador < equipoPokemon.length) { //Uso if para verifiicar que aun haya espacio en el vector
            int bandera = 0;
            //MENU PARA AGREGAR POKÉMON

            System.out.println(amarillo + "+-------------------------------+" + reset);
            System.out.println(blanco + "|       AGREGAR NUEVO POKÉMON    |" + reset);
            System.out.println(amarillo + "+-------------------------------+" + reset);

            // Solicitar nombre
            System.out.println(blanco + "| Ingrese el nombre del Pokémon: |" + reset);
            System.out.print("| > ");
            String nombre;
            nombre = entradaDeTexto.nextLine().toUpperCase();

            // Solicitar nivel (1-100)
            int nivel = 0;
            boolean entradaValida = false;
            do {
                System.out.println(blanco + "| Ingrese el nivel:              |" + reset);
                System.out.print("| > ");
                try {
                    Scanner entradaDeNumero2 = new Scanner(System.in);
                    nivel = entradaDeNumero2.nextInt();  // Intenta leer el número

                    if ((nivel >= 1) && (nivel <= 100)){
                        entradaValida = true;  // Si la lectura es exitosa, marca la entrada como válida
                    } else {
                        System.out.println("Solo se puede ingresar numeros del 1 al 100");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Solo se permiten números.");
                }
            } while (!entradaValida);

            // Solicitar puntos de vida (0-100)
            int puntosDeVida = 0;
            entradaValida = false; // Reseteo entradavalida para volver a usarla
            do {
                System.out.println(blanco + "| Ingrese los puntos de vida:    |" + reset);
                System.out.print("| > ");

                try {
                    Scanner entradaDeNumero2 = new Scanner(System.in);
                    puntosDeVida = entradaDeNumero2.nextInt();

                    if ((puntosDeVida >= 0) && (puntosDeVida <= 100)){
                        entradaValida = true;  // Si la lectura es exitosa, marca la entrada como válida
                    } else {
                        System.out.println("Solo se puede ingresar numeros del 0 al 100");
                    }
                } catch (Exception e) {
                    System.out.println("Error: Solo se permiten números.");
                }
            } while (!entradaValida);

            do {
                System.out.println(blanco + "| Ingrese el tipo (fuego, agua,  |" + reset);
                System.out.println(blanco + "| electrico o planta):           |" + reset);
                System.out.print("| > ");
                String tipo = entradaDeTexto.nextLine().toUpperCase();

                switch (tipo) {
                    case "FUEGO":
                        int poderFuego = 0;
                        entradaValida = false; // Reseteo entradavalida para volver a usarla
                        do {
                            // Solicitar poder del Pokémon
                            System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                            System.out.print("| > ");
                            try {
                                Scanner entradaDeNumero2 = new Scanner(System.in);
                                poderFuego = entradaDeNumero2.nextInt();

                                if ((poderFuego >= 0) && (poderFuego <= 100)){
                                    entradaValida = true;
                                } else {
                                    System.out.println("Solo se puede ingresar nnumeros del 0 al 100.");
                                }
                            } catch (Exception e){
                                System.out.println("Error: Solo se permiten números");
                            }
                        } while (!entradaValida);

                        // Solicitar ataque del Pokémon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");
                        ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();

                        //Creo el objeto pokemon con sus atributos
                        equipoPokemon[contador] = new PokemonFuego(nombre, nivel, puntosDeVida, "FUEGO", poderFuego, ataqueEspecial);

                        bandera = 1;
                        break;

                    case "PLANTA":
                        // Solicitar poder del Pokémon
                        int poderPlanta = 0;
                        entradaValida = false; // Reseteo entradavalida para volver a usarla
                        do {
                            System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                            System.out.print("| > ");

                            try {
                                poderPlanta = entradaDeNumeros.nextInt();
                                if ((poderPlanta >= 0) && (poderPlanta <= 100)) {
                                    entradaValida = true;
                                } else {
                                    System.out.println("Solo se permiten números del 0 al 100.");
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR: Solo se permiten números.");
                            }
                        } while(!entradaValida);

                        // Solicitar ataque del Pokémon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");
                        ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();

                        //Creo el objeto pokemon con sus atributos
                        equipoPokemon[contador] = new PokemonPlanta(nombre, nivel, puntosDeVida, "PLANTA", poderPlanta, ataqueEspecial);

                        bandera = 1;
                        break;

                    case "ELECTRICO":
                        // Solicitar poder del Pokémon
                        int poderElectrico = 0;
                        entradaValida = false; // Reseteo entradavalida para volver a usarla
                        do {
                            System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                            System.out.print("| > ");

                            try {
                                Scanner entradaDeNumero2 = new Scanner(System.in);
                                poderElectrico = entradaDeNumero2.nextInt();

                                if ((poderElectrico >= 0) && (poderElectrico <= 100)) {
                                    entradaValida = true;
                                } else {
                                    System.out.println("Solo se premiten números del 0 al 100.");
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR: Solo se permiten números.");
                            }
                        } while(!entradaValida);
                        // Solicitar ataque del Pokémon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");
                        ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();

                        //Creo el objeto pokemon con sus atributos
                        equipoPokemon[contador] = new PokemonElectrico(nombre, nivel, puntosDeVida, "ELECTRICO", poderElectrico, ataqueEspecial);

                        bandera = 1;
                        break;

                    case "AGUA":
                        // Solicitar poder del Pokémon
                        int poderAgua = 0;
                        entradaValida=false; // Reseteo entradavalida para volver a usarla
                        do {
                            System.out.println(blanco + "| Ingrese el poder del Pokémon:  |" + reset);
                            System.out.print("| > ");

                            try {
                                Scanner entradaDeNumero2 = new Scanner(System.in);
                                poderAgua = entradaDeNumero2.nextInt();

                                if ((poderAgua >= 0) && (poderAgua <= 100)) {
                                    entradaValida = true;
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR: Solo se permiten números.");
                            }
                        } while(!entradaValida);

                        // Solicitar ataque del Pokémon
                        System.out.println(blanco + "| Ingrese el ataque del Pokémon: |" + reset);
                        System.out.print("| > ");
                        ataqueEspecial = entradaDeTexto.nextLine().toUpperCase();

                        //Creo el objeto pokemon con sus atributos
                        equipoPokemon[contador] = new PokemonAgua(nombre, nivel, puntosDeVida, "AGUA", poderAgua, ataqueEspecial);

                        bandera = 1;
                        break;

                    default:
                        System.out.println(rojo + "Tipo de Pokémon inválido, por favor ingrese un tipo válido." + reset);
                }
            } while (bandera != 1);

            //Si bandera vale uno, es decir el pokemon fue agregado, muestro mensaje
            System.out.println(amarillo + "+-------------------------------+" + reset);
            System.out.println(rojo + "Pokémon agregado exitosamente!" + reset);
            contador++;

        } else {
            System.out.println(rojo + "El equipo está lleno, no se puede agregar más Pokémon." + reset);
        }
    }

    /**
     * Método Mostrar Informacion
     */
    public static void mostrarInformacion() {
        if (contador == 0) {
            System.out.println("El equipo esta vacío.");
        } else {
            // Mostrar encabezado una sola vez con colores
            System.out.println(rojo + "+-------------------------------+" + reset);
            System.out.println(blanco + "|          INFO POKÉMON         |" + reset);
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
            return "El promedio de nivel de tu equipo es:"+promedio;
        } else{
            return "No hay pokemons en tu equipo. Debes añadir al menos un pokemon.";
        }
    }
}