package libreria;

import java.util.Scanner;

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
            char c = cadena.charAt(i);
            c = Character.toLowerCase(c);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            } else if (c >= 'a' && c <= 'z') {
                consonantes++;
            }
        }//for
        return "La cadena '" + cadena + "' tiene " + vocales + " vocales y " + consonantes + " consonantes.";

    }

    public static String invertirCadena(String cadena){
        String invertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida += cadena.charAt(i);
        }//for
        return "La cadena '" + cadena + "' invertida es: '" + invertida + "'";
    }

    public static String palabraPalindroma(String cadena){
        String original = "";
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c == ' ') continue;
            original += Character.toLowerCase(c);
        }//for
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
        int palabras = 0;
        boolean enPalabra = false;
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c != ' ' && c != '\t' && c != '\n' && c != '\r') {
                if (!enPalabra) {
                    palabras++;
                    enPalabra = true;
                }
            } else {
                enPalabra = false;
            }
        }//for i
        return "La cadena '" + cadena + "' tiene " + palabras + " palabras.";
    }
   

    //4. operaciones con listas 

    public static String mayorYmenorElemento(int[] lista){
        if (lista.length == 0) {
            return "La lista está vacía.";
        }
        int mayor = lista[0];
        int menor = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] > mayor) {
                mayor = lista[i];
            }
            if (lista[i] < menor) {
                menor = lista[i];
            }
        }//for
        return "El mayor elemento de la lista es: " + mayor + " y el menor elemento es: " + menor;
    }

    public static String promedioLista(int[] lista){
        if (lista.length == 0) {
            return "La lista está vacía.";
        }
        int suma = 0;
        for (int i = 0; i < lista.length; i++) {
            suma += lista[i];
        }//for
        double promedio = (double) suma / lista.length;
        return "El promedio de la lista es: " + promedio;
    }

    public static String eliminarDuplicados(int[] lista){
        if (lista.length == 0) {
            return "La lista está vacía.";
        }
        String resultado = "La lista sin duplicados es: ";
        for (int i = 0; i < lista.length; i++) {
            boolean duplicado = false;
            for (int j = 0; j < i; j++) {
                if (lista[i] == lista[j]) {
                    duplicado = true;
                    break;
                }//for j
            }
            if (!duplicado) {
                resultado += lista[i] + " ";
            }
        }//for i
        return resultado.trim();
    }

    public static int[] ordenarLista(int[] lista){
        
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            boolean intercambiado = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                    intercambiado = true;
                }
            }//forj
           
            if (!intercambiado) {
                break;
            }
        }//fori
        return lista;
    }

    // 5. Conversor de Unidades
    public static void menuConversor(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Menú de Conversor de Unidades ===");
            System.out.println("1) Temperatura (Celsius, Fahrenheit, Kelvin)");
            System.out.println("2) Longitud (metros, kilómetros, millas)");
            System.out.println("3) Peso (kilogramos, libras, onzas)");
            System.out.println("4) Tiempo (segundos, minutos, horas)");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    menuTemperatura(scanner);
                    break;
                case "2":
                    menuLongitud(scanner);
                    break;
                case "3":
                    menuPeso(scanner);
                    break;
                case "4":
                    menuTiempo(scanner);
                    break;
                case "0":
                    System.out.println("Saliendo del conversor de unidades.");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void menuTemperatura(Scanner scanner) {
        System.out.println("\n--- Conversión de Temperatura ---");
        System.out.println("1) Celsius -> Fahrenheit");
        System.out.println("2) Celsius -> Kelvin");
        System.out.println("3) Fahrenheit -> Celsius");
        System.out.println("4) Fahrenheit -> Kelvin");
        System.out.println("5) Kelvin -> Celsius");
        System.out.println("6) Kelvin -> Fahrenheit");
        System.out.print("Elija una conversión: ");
        String opcion = scanner.nextLine().trim();
        System.out.print("Ingrese el valor: ");
        double valor = parseDoubleInput(scanner.nextLine());

        switch (opcion) {
            case "1":
                System.out.printf("%.2f °C = %.2f °F\n", valor, celsiusToFahrenheit(valor));
                break;
            case "2":
                System.out.printf("%.2f °C = %.2f K\n", valor, celsiusToKelvin(valor));
                break;
            case "3":
                System.out.printf("%.2f °F = %.2f °C\n", valor, fahrenheitToCelsius(valor));
                break;
            case "4":
                System.out.printf("%.2f °F = %.2f K\n", valor, fahrenheitToKelvin(valor));
                break;
            case "5":
                System.out.printf("%.2f K = %.2f °C\n", valor, kelvinToCelsius(valor));
                break;
            case "6":
                System.out.printf("%.2f K = %.2f °F\n", valor, kelvinToFahrenheit(valor));
                break;
            default:
                System.out.println("Opción inválida de temperatura.");
        }
    }

    private static void menuLongitud(Scanner scanner) {
        System.out.println("\n--- Conversión de Longitud ---");
        System.out.println("1) Metros -> Kilómetros");
        System.out.println("2) Metros -> Millas");
        System.out.println("3) Kilómetros -> Metros");
        System.out.println("4) Kilómetros -> Millas");
        System.out.println("5) Millas -> Metros");
        System.out.println("6) Millas -> Kilómetros");
        System.out.print("Elija una conversión: ");
        String opcion = scanner.nextLine().trim();
        System.out.print("Ingrese el valor: ");
        double valor = parseDoubleInput(scanner.nextLine());

        switch (opcion) {
            case "1":
                System.out.printf("%.2f m = %.4f km\n", valor, valor / 1000.0);
                break;
            case "2":
                System.out.printf("%.2f m = %.4f mi\n", valor, valor / 1609.34);
                break;
            case "3":
                System.out.printf("%.2f km = %.2f m\n", valor, valor * 1000.0);
                break;
            case "4":
                System.out.printf("%.2f km = %.4f mi\n", valor, valor / 1.60934);
                break;
            case "5":
                System.out.printf("%.2f mi = %.2f m\n", valor, valor * 1609.34);
                break;
            case "6":
                System.out.printf("%.2f mi = %.4f km\n", valor, valor * 1.60934);
                break;
            default:
                System.out.println("Opción inválida de longitud.");
        }
    }

    private static void menuPeso(Scanner scanner) {
        System.out.println("\n--- Conversión de Peso ---");
        System.out.println("1) Kilogramos -> Libras");
        System.out.println("2) Kilogramos -> Onzas");
        System.out.println("3) Libras -> Kilogramos");
        System.out.println("4) Libras -> Onzas");
        System.out.println("5) Onzas -> Kilogramos");
        System.out.println("6) Onzas -> Libras");
        System.out.print("Elija una conversión: ");
        String opcion = scanner.nextLine().trim();
        System.out.print("Ingrese el valor: ");
        double valor = parseDoubleInput(scanner.nextLine());

        switch (opcion) {
            case "1":
                System.out.printf("%.2f kg = %.2f lb\n", valor, valor * 2.20462);
                break;
            case "2":
                System.out.printf("%.2f kg = %.2f oz\n", valor, valor * 35.274);
                break;
            case "3":
                System.out.printf("%.2f lb = %.2f kg\n", valor, valor / 2.20462);
                break;
            case "4":
                System.out.printf("%.2f lb = %.2f oz\n", valor, valor * 16.0);
                break;
            case "5":
                System.out.printf("%.2f oz = %.4f kg\n", valor, valor / 35.274);
                break;
            case "6":
                System.out.printf("%.2f oz = %.4f lb\n", valor, valor / 16.0);
                break;
            default:
                System.out.println("Opción inválida de peso.");
        }
    }

    private static void menuTiempo(Scanner scanner) {
        System.out.println("\n--- Conversión de Tiempo ---");
        System.out.println("1) Segundos -> Minutos");
        System.out.println("2) Segundos -> Horas");
        System.out.println("3) Minutos -> Segundos");
        System.out.println("4) Minutos -> Horas");
        System.out.println("5) Horas -> Segundos");
        System.out.println("6) Horas -> Minutos");
        System.out.print("Elija una conversión: ");
        String opcion = scanner.nextLine().trim();
        System.out.print("Ingrese el valor: ");
        double valor = parseDoubleInput(scanner.nextLine());

        switch (opcion) {
            case "1":
                System.out.printf("%.2f s = %.4f min\n", valor, valor / 60.0);
                break;
            case "2":
                System.out.printf("%.2f s = %.6f h\n", valor, valor / 3600.0);
                break;
            case "3":
                System.out.printf("%.2f min = %.2f s\n", valor, valor * 60.0);
                break;
            case "4":
                System.out.printf("%.2f min = %.4f h\n", valor, valor / 60.0);
                break;
            case "5":
                System.out.printf("%.2f h = %.2f s\n", valor, valor * 3600.0);
                break;
            case "6":
                System.out.printf("%.2f h = %.2f min\n", valor, valor * 60.0);
                break;
            default:
                System.out.println("Opción inválida de tiempo.");
        }
    }

    private static double parseDoubleInput(String input) {
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Se usará 0.");
            return 0.0;
        }
    }

    private static double celsiusToFahrenheit(double c) {
        return c * 9.0 / 5.0 + 32;
    }

    private static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    private static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5.0 / 9.0;
    }

    private static double fahrenheitToKelvin(double f) {
        return celsiusToKelvin(fahrenheitToCelsius(f));
    }

    private static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    private static double kelvinToFahrenheit(double k) {
        return celsiusToFahrenheit(kelvinToCelsius(k));
    }



    

  



    






    



}
