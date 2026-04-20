package ap;
import java.util.Arrays;
import java.util.Scanner;
import libreria.HerenciaPolimorfismo;
import libreria.SistemaGestion;
import libreria.lib;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        // 1- calculadora de operaciones basicas 
        System.out.println("----------Calculadora de operaciones básicas:------------");
        System.out.println(lib.sumar(5, 3));
        System.out.println(lib.restar(5, 3));
        System.out.println(lib.multiplicar(5, 3));
        System.out.println(lib.dividir(5, 0));
        System.out.println(lib.potencia(5, 3));
        System.out.println(lib.raiz(25));

        // 2- validador de numeros
         System.out.println("----------Validador de numeros:------------");
        System.out.println(lib.ParImpar(5));
        System.out.println(lib.primo(8));
        System.out.println(lib.perfecto(8));
        System.out.println(lib.numeroPalindromo(12121));

        //3- manipulacion de cadenas
        System.out.println("----------Manipulación de cadenas:------------");
        System.out.println(lib.contadorVocalesConsonantes("Hola Mundo"));
        System.out.println(lib.invertirCadena("Hola Mundo"));
        System.out.println(lib.palabraPalindroma("lol"));
        System.out.println(lib.contarPalabras("Hola Mundo, ¿cómo estás?"));

        // 4.Operaciones con Listas
        System.out.println("----------Operaciones con Listas:------------");
        int [] numeros = {5, 3, 8, 1, 4};
        int [] numeros2 = {5, 8, 8, 4, 4};
        System.out.println(lib.mayorYmenorElemento(numeros));
        System.out.println(lib.promedioLista(numeros));
        System.out.println(lib.eliminarDuplicados(numeros2));
        System.out.println(Arrays.toString(lib.ordenarLista(numeros)));

        // 5. Conversor de Unidades
        System.out.println("----------Conversor de Unidades:------------");
        System.out.println("¿Desea entrar al menú de conversión de unidades? (si/no)");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        if (respuesta.equals("si") || respuesta.equals("s")) {
            lib.menuConversor(scanner);
        } else {
            System.out.println("Gracias por usar el programa.");
        }

        //-----------------------------NIVEL2: ESTRUCTURA DE DATOS Y CLASES BASICAS------------------------------

        SistemaGestion.iniciarSistema(scanner);

        //-----------------------------NIVEL3: HERENCIA Y POLIMORFISMO------------------------------
        HerenciaPolimorfismo.iniciarHerenciaPolimorfismo(scanner);
        
    }
}
