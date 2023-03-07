import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        int opc; // Esta es la opción que el usuario elegirá.
        // Generación de escaner.
        Scanner sc = new Scanner(System.in);
        // LLamamos a la función generaPalabra de la clase Funciones.
        Funciones.generaPalabra();
        // LLamamos a la función pintaPista de la clase Funciones.
        Funciones.pintaPista();
        /*
        * Recorremos el bucle mientras el usuario no acierte la palabra y tenga intentos disponibles.
        */
        while (!Funciones.palabraSecreta.equals(Funciones.palabraPista) && Funciones.NUMINTENTOS>0){
            // Asignamos a opc el valor que devuelve la función menu de la clase Funciones.
            opc = Funciones.menu();
            // Dependiendo de la opción elegida por el usuario el programa hará una cosa u otra.
            switch (opc){
                // Si el usuario elige la opción 1 le pediremos que introduzca una letra y llamaremos a la
                // clase comprobarLetra pasándole por parámetro la letra introducida.
                case 1:
                    String letra;
                    System.out.println("Introduzca una letra");
                    letra = sc.next();
                    Funciones.compruebaLetra(letra);
                    break;
                // Si el usuario elige la opción 2, le pedimos que escriba una palabra y llamamos al método
                // compruebaPalabra pasándole como parámetro la palabra introducida.
                case 2:
                    String palabra;
                    System.out.println("Introduzca una palabra");
                    palabra = sc.next();
                    Funciones.compruebaPalabra(palabra);
                    break;
                // Si el usuario no elige ninguna de las opciones se le mostrará por pantalla un mensaje de error.
                default:
                    System.out.println("Opción no válida");
            }
            // LLamamos a la función pintaPista de la clase Funciones.
            Funciones.pintaPista();
            // Mostramos por pantalla la cantidad de intentos totales que le quedan al usuario.
            System.out.println(Funciones.NUMINTENTOS);
        }
        // Si el usuario acierta la palabra, mostramos por pantalla un mensaje de que ha ganado.
        if (Funciones.palabraPista.equals(Funciones.palabraSecreta)){
            System.out.println("¡¡ENHORABUENA!! HAS ACERTADO");
        // Si el usuario no acierta la palabra y se queda sin intentos se le muestra un mensaje de fin.
        }else if (Funciones.NUMINTENTOS==0){
            System.out.println("GAME OVER");
        }
        // Cerramos el escaner.
        sc.close();
    }
}
