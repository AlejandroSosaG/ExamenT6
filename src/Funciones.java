import java.util.Scanner;

public class Funciones {
    // Esta variable es el array donde se guardan las distintas palabras que pueden salir.
    public static String[] palabras = {"humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza", "brazo", "familia"};
    public static int NUMINTENTOS = 7; // Este es el número de intentos que tiene el usuario.
    public static String palabraSecreta; // Esta variable es la palabra que el usuario debe adivinar.
    public static String palabraPista = ""; // En esta variable se irán guardando todas las letras que el usuario
    // vaya acertando de la palabra secreta.
    public static String noAcertadas = ""; // En esta variable se irán guardando todas las letras que el usuario
    // ha probado y no están en la palabra secreta.

    /**
     * Este método asigna aleatoriamenta a palabraSecreta uno de los valores del array palabras y asigna a
     * palabraPista la logitud que tiene la palabra a adivinar.
     */
    public static void generaPalabra(){
        int random = (int) (Math.random()*(palabras.length-1));
        palabraSecreta = palabras[random];
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraPista += "_";
        }
    }

    /**
     * Este método se encarga de mostrar las opciones que el usuario posee y le pide que elija.
     * @return Devuelve la opción elegida por el usuario.
     */
    public static int menu(){
        int opc;
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione una de las siguientes opciones:\n" +
                "1. Introducir letra.\n" +
                "2. Introducir palabra.");
        opc = sc.nextInt();
        return opc;
    }

    /**
     * Este métoda se encarga de modificar palabraPista, NUMINTENTOS y noAcertadas en función de si el usuario
     * acierta o no, y si repite una palabra que ya ha acertado o no.
     * @param letra Se le pasa por parámetro una letra introducida por el usuario.
     */
    public static void compruebaLetra(String letra){
        boolean repetida = false;
        boolean encontrada = false;
        char[] pista = palabraPista.toCharArray();
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (pista[i] == letra.toLowerCase().charAt(0)){
                    repetida = true;
                }
                if (palabraSecreta.charAt(i)==letra.toLowerCase().charAt(0)){
                    encontrada = true;
                    pista[i] = letra.charAt(0);
                }
            }
            if (encontrada == false){
                noAcertadas += letra.toLowerCase().charAt(0);
            }
            if (repetida == false){
                NUMINTENTOS--;
            }
            palabraPista = String.valueOf(pista);
    }

    /**
     * Esta función iguala la palabra que se le pasa por parámetro y la secreta y si son iguales la asigna a
     * palabraPista.
     * @param palabra
     */
    public static void compruebaPalabra(String palabra){
        if (palabra.equalsIgnoreCase(palabraSecreta)){
            palabraPista = palabraSecreta;
        }
    }

    /**
     * La función pintaPista se encarga de mostrar por pantalla las letras introducidas que el usuario no ha acertado
     * y la variable palabraPista.
     */
    public static void pintaPista(){
        System.out.println(noAcertadas);
        System.out.println(palabraPista);
    }
}
