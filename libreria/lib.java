package libreria;
public class lib {

    //1.calculadora de operaciones
    public static int sumar(int a, int b) {
        return a + b;
    }

     public static int restar(int a, int b) {
        return a - b;
    }

     public static int multiplicar(int a, int b) {
        return a * b;
    }

     public static String dividir(int a, int b) {
        if (b==0){
            return "No se puede dividir por cero";
        } else {
            return "El resultado de la división es: " + (a / b);
        }
    }

    public static String potencia ( int a, int b) {
        
        return "El resultado de la potencia es: " + Math.pow(a, b);
    }

    public static String raiz (int a) {
        if (a < 0) {
            return "No se puede calcular la raíz cuadrada de un número negativo";
        } else {
        return "El resultado de la raíz cuadrada es: " + Math.sqrt(a);
        }
    }

    //2 validador de numeros 
    public  static String ParImpar(int a){
        if (a % 2 == 0) {
            return "El "+ a + " número es par";
        } else {
            return "El "+a+" número es impar";
        }
    }

    public static String primo(int a){
        boolean primo= true;
        int i = 2;
        if (a <=1){
            return "el numero es negativo, no es primo";
        }
        while(primo && i <= Math.sqrt(a)){
            if (a % i==0){
                primo = false;
                return "El número "+a+" no es primo";
            }else{
                i++;
            }
        }//whilw
        return "El número "+a+" es primo";
    }

    public static String perfecto(int a){
        int suma = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                suma += i;
            }
        }
        if (suma == a) {
            return "El número " + a + " es un número perfecto.";
        } else {
            return "El número " + a + " no es un número perfecto.";
        }
    }

    public static String numeroPalindromo(int a){
            int original = a;
        int invertido = 0;
        while (a != 0) {
            int digito = a % 10;          // extrae ultima cifra
            invertido = invertido * 10 + digito;
            a /= 10;                      // quita la ultima cifra
        }//while
        if (original == invertido) {
            return "El número " + original + " es un palíndromo.";
        } else {
            return "El número " + original + " no es un palíndromo.";
        }


    }

    //3- manipulacion de cadenas
    public static String  contadorVocalesConsonantes(String cadena){
        int vocales = 0;
        int consonantes = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char c = Character.toLowerCase(cadena.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            } else if (Character.isLetter(c)) {
                consonantes++;
            }
        }
        return "La cadena '" + cadena + "' tiene " + vocales + " vocales y " + consonantes + " consonantes.";

    }

    public static String invertirCadena(String cadena){
        String invertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida += cadena.charAt(i);
        }
        return "La cadena '" + cadena + "' invertida es: '" + invertida + "'";
    }

    public static String palabraPalindroma(String cadena){
        String original = cadena.replaceAll("\\s+", "").toLowerCase();
        String invertida = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            invertida += original.charAt(i);
        }
        if (original.equals(invertida)) {
            return "La palabra '" + cadena + "' es un palíndromo.";
        } else {
            return "La palabra '" + cadena + "' no es un palíndromo.";
        }
    } 

    public static String contarPalabras(String cadena){
         String[] palabras = cadena.split("\\s+");
         return "La cadena '" + cadena + "' tiene " + palabras.length + " palabras.";
    }
   




    



}
