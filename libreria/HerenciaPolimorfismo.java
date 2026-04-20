package libreria;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HerenciaPolimorfismo {

    private static Scanner sc = new Scanner(System.in);
    private static final List<Vehiculo> vehiculos = new ArrayList<>();
    private static final List<Figura> figuras = new ArrayList<>();
    private static final Biblioteca biblioteca = new Biblioteca();
    private static final Hotel hotel = new Hotel();
    private static Usuario usuarioBiblioteca;
    private static boolean datosInicializados = false;

    public static void iniciarHerenciaPolimorfismo() {
        iniciarHerenciaPolimorfismo(sc);
    }

    public static void iniciarHerenciaPolimorfismo(Scanner scanner) {
        sc = scanner;
        inicializarDatos();

        int opcion = 0;
        System.out.println("\n==============================================");
        System.out.println("     SISTEMA DE HERENCIA Y POLIMORFISMO");
        System.out.println("==============================================");

        while (opcion != 6) {
            mostrarMenuPrincipal();
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    menuVehiculos();
                    break;
                case 2:
                    menuFiguras();
                    break;
                case 3:
                    menuBiblioteca();
                    break;
                case 4:
                    menuHotel();
                    break;
                case 5:
                    menuJuego();
                    break;
                case 6:
                    System.out.println("Gracias por explorar el modulo de herencia y polimorfismo.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
    }

    private static void inicializarDatos() {
        if (datosInicializados) {
            return;
        }

        vehiculos.add(new Auto("Toyota", "Corolla", 2020, 4));
        vehiculos.add(new Moto("Yamaha", "R6", 2021, 600));
        vehiculos.add(new Camion("Volvo", "FH", 2018, 10));

        figuras.add(new Circulo(5));
        figuras.add(new Rectangulo(4, 6));
        figuras.add(new Triangulo(3, 4, 5));

        biblioteca.agregarLibro(new Libro("Java Basico", "Autor1", "123"));
        biblioteca.agregarLibro(new Libro("POO Avanzada", "Autor2", "456"));
        biblioteca.agregarLibro(new Libro("Estructuras de Datos", "Autor3", "789"));

        hotel.agregarHabitacion(new Habitacion(101, "Simple", 50000));
        hotel.agregarHabitacion(new Habitacion(102, "Doble", 80000));
        hotel.agregarHabitacion(new Habitacion(201, "Suite", 150000));

        datosInicializados = true;
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n============== MENU PRINCIPAL ==============");
        System.out.println("1. Vehiculos");
        System.out.println("2. Figuras");
        System.out.println("3. Biblioteca");
        System.out.println("4. Hotel");
        System.out.println("5. Juego de Dados");
        System.out.println("6. Salir");
        System.out.println("============================================");
    }

    private static void menuVehiculos() {
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--------------- MENU VEHICULOS ---------------");
            System.out.println("1. Registrar auto");
            System.out.println("2. Registrar moto");
            System.out.println("3. Registrar camion");
            System.out.println("4. Ver vehiculos y costos de mantenimiento");
            System.out.println("5. Volver");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarAuto();
                    break;
                case 2:
                    registrarMoto();
                    break;
                case 3:
                    registrarCamion();
                    break;
                case 4:
                    mostrarVehiculos();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private static void registrarAuto() {
        System.out.println("\nRegistro de auto");
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        int anio = leerEntero("Anio: ");
        int puertas = leerEntero("Numero de puertas: ");

        vehiculos.add(new Auto(marca, modelo, anio, puertas));
        System.out.println("Auto registrado exitosamente.");
    }

    private static void registrarMoto() {
        System.out.println("\nRegistro de moto");
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        int anio = leerEntero("Anio: ");
        int cilindrada = leerEntero("Cilindrada (cc): ");

        vehiculos.add(new Moto(marca, modelo, anio, cilindrada));
        System.out.println("Moto registrada exitosamente.");
    }

    private static void registrarCamion() {
        System.out.println("\nRegistro de camion");
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        int anio = leerEntero("Anio: ");
        double carga = leerDouble("Capacidad de carga en toneladas: ");

        vehiculos.add(new Camion(marca, modelo, anio, carga));
        System.out.println("Camion registrado exitosamente.");
    }

    private static void mostrarVehiculos() {
        System.out.println("\n--------------- LISTA DE VEHICULOS ---------------");
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            System.out.printf("%d. %s | Mantenimiento: $%.2f%n", i + 1, v.descripcion(), v.calcularCostoMantenimiento());
        }
    }

    private static void menuFiguras() {
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--------------- MENU FIGURAS ---------------");
            System.out.println("1. Registrar circulo");
            System.out.println("2. Registrar rectangulo");
            System.out.println("3. Registrar triangulo");
            System.out.println("4. Ver figuras, areas y perimetros");
            System.out.println("5. Volver");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarCirculo();
                    break;
                case 2:
                    registrarRectangulo();
                    break;
                case 3:
                    registrarTriangulo();
                    break;
                case 4:
                    mostrarFiguras();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private static void registrarCirculo() {
        double radio = leerDouble("Ingrese el radio del circulo: ");
        if (radio <= 0) {
            System.out.println("El radio debe ser mayor que 0.");
            return;
        }
        figuras.add(new Circulo(radio));
        System.out.println("Circulo registrado correctamente.");
    }

    private static void registrarRectangulo() {
        double base = leerDouble("Ingrese la base: ");
        double altura = leerDouble("Ingrese la altura: ");
        if (base <= 0 || altura <= 0) {
            System.out.println("Las medidas deben ser mayores que 0.");
            return;
        }
        figuras.add(new Rectangulo(base, altura));
        System.out.println("Rectangulo registrado correctamente.");
    }

    private static void registrarTriangulo() {
        double ladoA = leerDouble("Lado A: ");
        double ladoB = leerDouble("Lado B: ");
        double ladoC = leerDouble("Lado C: ");

        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            System.out.println("Todos los lados deben ser mayores que 0.");
            return;
        }

        if (ladoA + ladoB <= ladoC || ladoA + ladoC <= ladoB || ladoB + ladoC <= ladoA) {
            System.out.println("Las medidas no forman un triangulo valido.");
            return;
        }

        figuras.add(new Triangulo(ladoA, ladoB, ladoC));
        System.out.println("Triangulo registrado correctamente.");
    }

    private static void mostrarFiguras() {
        System.out.println("\n--------------- LISTA DE FIGURAS ---------------");
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras registradas.");
            return;
        }

        for (int i = 0; i < figuras.size(); i++) {
            Figura figura = figuras.get(i);
            System.out.printf(
                "%d. %s | Area: %.2f | Perimetro: %.2f%n",
                i + 1,
                figura.descripcion(),
                figura.calcularArea(),
                figura.calcularPerimetro()
            );
        }

        System.out.printf("Area total acumulada: %.2f%n", UtilFigura.areaTotal(figuras));
    }

    private static void menuBiblioteca() {
        if (usuarioBiblioteca == null) {
            String nombre = leerTexto("\nIngrese su nombre para usar la biblioteca: ");
            usuarioBiblioteca = new Usuario(nombre);
            System.out.println("Bienvenido, " + usuarioBiblioteca.n + ".");
        }

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n--------------- MENU BIBLIOTECA ---------------");
            System.out.println("1. Ver catalogo");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Ver mis libros prestados");
            System.out.println("5. Volver");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    biblioteca.mostrarCatalogo();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 4:
                    mostrarPrestados();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private static void prestarLibro() {
        List<Libro> disponibles = biblioteca.obtenerDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay libros disponibles en este momento.");
            return;
        }

        System.out.println("\nLibros disponibles:");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).descripcion());
        }

        int opcion = leerEntero("Seleccione el libro que desea prestar: ");
        if (opcion < 1 || opcion > disponibles.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        String mensaje = biblioteca.prestarLibro(usuarioBiblioteca, disponibles.get(opcion - 1));
        System.out.println(mensaje);
    }

    private static void devolverLibro() {
        if (usuarioBiblioteca.prestados.isEmpty()) {
            System.out.println("No tienes libros prestados.");
            return;
        }

        System.out.println("\nTus libros prestados:");
        for (int i = 0; i < usuarioBiblioteca.prestados.size(); i++) {
            System.out.println((i + 1) + ". " + usuarioBiblioteca.prestados.get(i).descripcion());
        }

        int opcion = leerEntero("Seleccione el libro que desea devolver: ");
        if (opcion < 1 || opcion > usuarioBiblioteca.prestados.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        Libro libro = usuarioBiblioteca.prestados.get(opcion - 1);
        String mensaje = biblioteca.devolverLibro(usuarioBiblioteca, libro);
        System.out.println(mensaje);
    }

    private static void mostrarPrestados() {
        System.out.println("\n--------------- MIS LIBROS PRESTADOS ---------------");
        if (usuarioBiblioteca.prestados.isEmpty()) {
            System.out.println("No tienes libros prestados.");
            return;
        }

        for (int i = 0; i < usuarioBiblioteca.prestados.size(); i++) {
            System.out.println((i + 1) + ". " + usuarioBiblioteca.prestados.get(i).descripcion());
        }
    }

    private static void menuHotel() {
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n--------------- MENU HOTEL ---------------");
            System.out.println("1. Ver habitaciones");
            System.out.println("2. Reservar habitacion");
            System.out.println("3. Ver reservas realizadas");
            System.out.println("4. Volver");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    hotel.mostrarHabitaciones();
                    break;
                case 2:
                    reservarHabitacion();
                    break;
                case 3:
                    hotel.mostrarReservas();
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    private static void reservarHabitacion() {
        List<Habitacion> disponibles = hotel.obtenerHabitacionesDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay habitaciones disponibles.");
            return;
        }

        System.out.println("\nHabitaciones disponibles:");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i).descripcion());
        }

        int opcion = leerEntero("Seleccione una habitacion: ");
        if (opcion < 1 || opcion > disponibles.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        String cliente = leerTexto("Nombre del cliente: ");
        String fechaEntrada = leerTexto("Fecha de entrada: ");
        String fechaSalida = leerTexto("Fecha de salida: ");
        int dias = leerEntero("Numero de dias de reserva: ");
        if (dias <= 0) {
            System.out.println("Los dias deben ser mayores que 0.");
            return;
        }

        String mensaje = hotel.reservar(cliente, disponibles.get(opcion - 1), fechaEntrada, fechaSalida, dias);
        System.out.println(mensaje);
    }

    private static void menuJuego() {
        System.out.println("\n--------------- JUEGO DE DADOS ---------------");
        int cantidad = leerEntero("Numero de jugadores: ");

        if (cantidad < 2) {
            System.out.println("Deben participar al menos 2 jugadores.");
            return;
        }

        Juego juego = new Juego();
        for (int i = 0; i < cantidad; i++) {
            String nombre = leerTexto("Nombre del jugador " + (i + 1) + ": ");
            juego.jugadores.add(new Jugador(nombre));
        }

        juego.jugar();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            }
            System.out.println("Entrada invalida. Ingrese un numero entero.");
            sc.nextLine();
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            }
            System.out.println("Entrada invalida. Ingrese un numero valido.");
            sc.nextLine();
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("La entrada no puede estar vacia.");
        }
    }
}

abstract class Vehiculo {
    String marca;
    String modelo;
    int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    abstract double calcularCostoMantenimiento();

    abstract String descripcion();
}

class Auto extends Vehiculo {
    int puertas;

    public Auto(String marca, String modelo, int anio, int puertas) {
        super(marca, modelo, anio);
        this.puertas = puertas;
    }

    double calcularCostoMantenimiento() {
        int anioActual = Year.now().getValue();
        return 200 + (anioActual - anio) * 10;
    }

    String descripcion() {
        return "Auto " + marca + " " + modelo + " (" + anio + "), puertas: " + puertas;
    }
}

class Moto extends Vehiculo {
    int cilindrada;

    public Moto(String marca, String modelo, int anio, int cilindrada) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    double calcularCostoMantenimiento() {
        return 100 + cilindrada * 0.05;
    }

    String descripcion() {
        return "Moto " + marca + " " + modelo + " (" + anio + "), cilindrada: " + cilindrada + "cc";
    }
}

class Camion extends Vehiculo {
    double carga;

    public Camion(String marca, String modelo, int anio, double carga) {
        super(marca, modelo, anio);
        this.carga = carga;
    }

    double calcularCostoMantenimiento() {
        return 500 + carga * 20;
    }

    String descripcion() {
        return "Camion " + marca + " " + modelo + " (" + anio + "), carga: " + carga + " ton";
    }
}

abstract class Figura {
    abstract double calcularArea();

    abstract double calcularPerimetro();

    abstract String descripcion();
}

class Circulo extends Figura {
    double r;

    public Circulo(double r) {
        this.r = r;
    }

    double calcularArea() {
        return Math.PI * r * r;
    }

    double calcularPerimetro() {
        return 2 * Math.PI * r;
    }

    String descripcion() {
        return "Circulo de radio " + r;
    }
}

class Rectangulo extends Figura {
    double a;
    double b;

    public Rectangulo(double a, double b) {
        this.a = a;
        this.b = b;
    }

    double calcularArea() {
        return a * b;
    }

    double calcularPerimetro() {
        return 2 * (a + b);
    }

    String descripcion() {
        return "Rectangulo base " + a + ", altura " + b;
    }
}

class Triangulo extends Figura {
    double a;
    double b;
    double c;

    public Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double calcularArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double calcularPerimetro() {
        return a + b + c;
    }

    String descripcion() {
        return "Triangulo lados " + a + ", " + b + ", " + c;
    }
}

class UtilFigura {
    static double areaTotal(List<Figura> figuras) {
        double total = 0;
        for (Figura figura : figuras) {
            total += figura.calcularArea();
        }
        return total;
    }
}

class Libro {
    String t;
    String a;
    String i;
    boolean disponible = true;

    public Libro(String titulo, String autor, String isbn) {
        t = titulo;
        a = autor;
        i = isbn;
    }

    String descripcion() {
        String estado = disponible ? "Disponible" : "Prestado";
        return t + " - " + a + " | ISBN: " + i + " | " + estado;
    }
}

class Usuario {
    String n;
    List<Libro> prestados = new ArrayList<>();

    public Usuario(String nombre) {
        n = nombre;
    }
}

class Biblioteca {
    private final List<Libro> catalogo = new ArrayList<>();

    void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    List<Libro> obtenerDisponibles() {
        List<Libro> disponibles = new ArrayList<>();
        for (Libro libro : catalogo) {
            if (libro.disponible) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    void mostrarCatalogo() {
        System.out.println("\n--------------- CATALOGO ---------------");
        if (catalogo.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (int i = 0; i < catalogo.size(); i++) {
            System.out.println((i + 1) + ". " + catalogo.get(i).descripcion());
        }
    }

    String prestarLibro(Usuario usuario, Libro libro) {
        if (!libro.disponible) {
            return "El libro no esta disponible.";
        }
        if (usuario.prestados.size() >= 3) {
            return "Has alcanzado el limite de 3 libros prestados.";
        }
        libro.disponible = false;
        usuario.prestados.add(libro);
        return "Prestamo realizado con exito: " + libro.t;
    }

    String devolverLibro(Usuario usuario, Libro libro) {
        if (usuario.prestados.remove(libro)) {
            libro.disponible = true;
            return "Libro devuelto correctamente: " + libro.t;
        }
        return "No se pudo devolver el libro seleccionado.";
    }
}

class Habitacion {
    int n;
    String t;
    double p;
    boolean o;

    public Habitacion(int numero, String tipo, double precio) {
        n = numero;
        t = tipo;
        p = precio;
    }

    String descripcion() {
        String estado = o ? "Ocupada" : "Disponible";
        return "Habitacion " + n + " | Tipo: " + t + " | Precio por noche: $" + p + " | " + estado;
    }
}

class Reserva {
    String c;
    Habitacion h;
    String fechaEntrada;
    String fechaSalida;
    int d;

    public Reserva(String cliente, Habitacion habitacion, String fechaEntrada, String fechaSalida, int dias) {
        c = cliente;
        h = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        d = dias;
    }

    double calcularCosto() {
        return d * h.p;
    }

    String descripcion() {
        return "Cliente: " + c
            + " | Habitacion: " + h.n
            + " | Entrada: " + fechaEntrada
            + " | Salida: " + fechaSalida
            + " | Dias: " + d
            + " | Total: $" + calcularCosto();
    }
}

class Hotel {
    List<Habitacion> habitaciones = new ArrayList<>();
    List<Reserva> reservas = new ArrayList<>();

    void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    List<Habitacion> obtenerHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.o) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }

    void mostrarHabitaciones() {
        System.out.println("\n--------------- HABITACIONES ---------------");
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones registradas.");
            return;
        }

        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println((i + 1) + ". " + habitaciones.get(i).descripcion());
        }
    }

    String reservar(String cliente, Habitacion habitacion, String fechaEntrada, String fechaSalida, int dias) {
        if (habitacion.o) {
            return "La habitacion ya se encuentra ocupada.";
        }

        habitacion.o = true;
        Reserva reserva = new Reserva(cliente, habitacion, fechaEntrada, fechaSalida, dias);
        reservas.add(reserva);
        return "Reserva creada con exito. Costo total: $" + reserva.calcularCosto();
    }

    void mostrarReservas() {
        System.out.println("\n--------------- RESERVAS ---------------");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
            return;
        }

        for (int i = 0; i < reservas.size(); i++) {
            System.out.println((i + 1) + ". " + reservas.get(i).descripcion());
        }
    }
}

class Dado {
    private int valor;

    int lanzar() {
        valor = (int) (Math.random() * 6) + 1;
        return valor;
    }

    int obtenerValor() {
        return valor;
    }
}

class Jugador {
    String n;
    int p;

    public Jugador(String nombre) {
        n = nombre;
    }
}

class Juego {
    List<Jugador> jugadores = new ArrayList<>();
    Dado d = new Dado();

    void jugar() {
        System.out.println("\nResultados de la partida:");
        for (int turno = 0; turno < jugadores.size(); turno++) {
            Jugador jugador = jugadores.get(turno);
            int suma = 0;
            System.out.print("Turno " + (turno + 1) + " - " + jugador.n + " lanza: ");
            for (int i = 0; i < 3; i++) {
                d.lanzar();
                suma += d.obtenerValor();
                System.out.print(d.obtenerValor() + (i < 2 ? " - " : ""));
            }
            jugador.p = suma;
            System.out.println(" | Total: " + suma);
        }

        Jugador ganador = jugadores.get(0);
        boolean empate = false;
        for (Jugador jugador : jugadores) {
            if (jugador.p > ganador.p) {
                ganador = jugador;
                empate = false;
            } else if (jugador != ganador && jugador.p == ganador.p) {
                empate = true;
            }
        }

        if (empate) {
            System.out.println("La partida termino en empate con " + ganador.p + " puntos.");
        } else {
            System.out.println("Ganador: " + ganador.n + " con " + ganador.p + " puntos.");
        }
    }
}
