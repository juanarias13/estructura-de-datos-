package ap;
import libreria.lib;
public class app {
    public static void main(String[] args) {
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

        

        




    }

}
