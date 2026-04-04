package libreria;

import java.util.Scanner;

public class SistemaGestion {
    
    // ==================== CLASE ESTUDIANTE ====================
    public static class Estudiante {
        String nombre;
        int edad;
        double[] calificaciones;
        int cantidadCalificaciones;

        public Estudiante(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
            this.calificaciones = new double[100];
            this.cantidadCalificaciones = 0;
        }

        void agregarCalificacion(double calificacion) {
            if (cantidadCalificaciones < calificaciones.length) {
                calificaciones[cantidadCalificaciones] = calificacion;
                cantidadCalificaciones++;
                System.out.println("✓ Calificación agregada: " + calificacion);
            } else {
                System.out.println("✗ No se pueden agregar más calificaciones");
            }
        }

        double calcularPromedio() {
            if (cantidadCalificaciones == 0) {
                return 0;
            }
            double suma = 0;
            for (int i = 0; i < cantidadCalificaciones; i++) {
                suma = suma + calificaciones[i];
            }
            return suma / cantidadCalificaciones;
        }

        String obtenerEstado() {
            double promedio = calcularPromedio();
            if (promedio >= 3.0) {
                return "APROBADO";
            } else {
                return "REPROBADO";
            }
        }

        void mostrarInformacion() {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║   INFORMACIÓN DEL ESTUDIANTE   ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Cantidad de calificaciones: " + cantidadCalificaciones);
            System.out.print("Calificaciones: ");
            for (int i = 0; i < cantidadCalificaciones; i++) {
                System.out.print(calificaciones[i] + " ");
            }
            System.out.println();
            System.out.println("Promedio: " + calcularPromedio());
            System.out.println("Estado: " + obtenerEstado());
            System.out.println();
        }
    }

    // ==================== CLASE CONTACTO ====================
    public static class Contacto {
        String nombre;
        String telefono;
        String email;

        public Contacto(String nombre, String telefono, String email) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
        }

        void mostrarInfo() {
            System.out.println("  • Nombre: " + nombre + " | Tel: " + telefono + " | Email: " + email);
        }
    }

    // ==================== CLASE CUENTA BANCARIA ====================
    public static class CuentaBancaria {
        String titular;
        double saldo;
        String numeroCuenta;

        public CuentaBancaria(String titular, double saldoInicial, String numeroCuenta) {
            this.titular = titular;
            this.saldo = saldoInicial;
            this.numeroCuenta = numeroCuenta;
        }

        void depositar(double cantidad) {
            if (cantidad > 0) {
                saldo = saldo + cantidad;
                System.out.println("✓ Depósito realizado: $" + cantidad);
                System.out.println("  Saldo actual: $" + saldo);
            } else {
                System.out.println("✗ La cantidad debe ser mayor a 0");
            }
        }

        void retirar(double cantidad) {
            if (cantidad > 0 && (saldo - cantidad) >= 0) {
                saldo = saldo - cantidad;
                System.out.println("✓ Retiro realizado: $" + cantidad);
                System.out.println("  Saldo actual: $" + saldo);
            } else if (cantidad <= 0) {
                System.out.println("✗ La cantidad debe ser mayor a 0");
            } else {
                System.out.println("✗ Saldo insuficiente. Disponible: $" + saldo);
            }
        }

        void consultarSaldo() {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      CONSULTA DE SALDO         ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("Titular: " + titular);
            System.out.println("Número de Cuenta: " + numeroCuenta);
            System.out.println("Saldo: $" + saldo);
            System.out.println();
        }
    }

    // ==================== CLASE PRODUCTO ====================
    public static class Producto {
        String nombre;
        double precio;
        int cantidad;

        public Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        double calcularSubtotal() {
            return precio * cantidad;
        }

        void mostrarInfo() {
            System.out.println("  • " + nombre + " - Precio: $" + precio + " x " + cantidad + " = $" + calcularSubtotal());
        }
    }

    // ==================== CLASE EMPLEADO ====================
    public static class Empleado {
        String nombre;
        String id;
        double salario;
        String departamento;

        public Empleado(String nombre, String id, double salario, String departamento) {
            this.nombre = nombre;
            this.id = id;
            this.salario = salario;
            this.departamento = departamento;
        }

        double calcularSalarioAnual() {
            return salario * 12;
        }

        void aplicarAumento(double porcentaje) {
            double aumento = (salario * porcentaje) / 100;
            salario = salario + aumento;
            System.out.println("✓ Aumento aplicado. Nuevo salario: $" + salario);
        }

        void mostrarInfo() {
            System.out.println("  • Nombre: " + nombre + " | ID: " + id + " | Salario: $" + salario + " | Depto: " + departamento);
        }
    }

    // ==================== VECTORES PARA ALMACENAR DATOS ====================
    private static Estudiante[] estudiantes = new Estudiante[100];
    private static int cantEstudiantes = 0;

    private static Contacto[] contactos = new Contacto[100];
    private static int cantContactos = 0;

    private static CuentaBancaria[] cuentas = new CuentaBancaria[100];
    private static int cantCuentas = 0;

    private static Producto[] carrito = new Producto[100];
    private static int cantProductos = 0;

    private static Empleado[] empleados = new Empleado[100];
    private static int cantEmpleados = 0;

    // ==================== SCANNER GLOBAL ====================
    private static Scanner entrada = new Scanner(System.in);

    // ==================== MÉTODO PRINCIPAL ====================
    public static void iniciarSistema() {
        int opcionPrincipal = 0;

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   BIENVENIDO AL SISTEMA DE GESTIÓN        ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        while (opcionPrincipal != 6) {
            mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = entrada.nextInt();
            entrada.nextLine();

            switch (opcionPrincipal) {
                case 1:
                    menuEstudiantes();
                    break;
                case 2:
                    menuContactos();
                    break;
                case 3:
                    menuCuentaBancaria();
                    break;
                case 4:
                    menuCarrito();
                    break;
                case 5:
                    menuEmpleados();
                    break;
                case 6:
                    System.out.println("¡Gracias por usar el sistema! Hasta luego.");
                    break;
                default:
                    System.out.println("✗ Opción inválida. Intente de nuevo.");
            }
        }
    }

    // ==================== MENÚ PRINCIPAL ====================
    private static void mostrarMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           MENÚ PRINCIPAL                   ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ 1. Sistema de Estudiantes                  ║");
        System.out.println("║ 2. Sistema de Contactos                    ║");
        System.out.println("║ 3. Cuenta Bancaria                         ║");
        System.out.println("║ 4. Carrito de Compras                      ║");
        System.out.println("║ 5. Registro de Empleados                   ║");
        System.out.println("║ 6. Salir                                   ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    // ==================== MENÚ ESTUDIANTES ====================
    private static void menuEstudiantes() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║    MENÚ ESTUDIANTES            ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Crear nuevo estudiante      ║");
            System.out.println("║ 2. Agregar calificación        ║");
            System.out.println("║ 3. Ver información estudiante  ║");
            System.out.println("║ 4. Volver al menú principal    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Ingrese edad: ");
                    int edad = entrada.nextInt();
                    entrada.nextLine();
                    
                    if (cantEstudiantes < estudiantes.length) {
                        estudiantes[cantEstudiantes] = new Estudiante(nombre, edad);
                        cantEstudiantes++;
                        System.out.println("✓ Estudiante creado exitosamente");
                    } else {
                        System.out.println("✗ Límite de estudiantes alcanzado");
                    }
                    break;

                case 2:
                    if (cantEstudiantes > 0) {
                        System.out.println("\nEstudiantes registrados:");
                        for (int i = 0; i < cantEstudiantes; i++) {
                            System.out.println((i + 1) + ". " + estudiantes[i].nombre);
                        }
                        System.out.print("Seleccione número del estudiante: ");
                        int numEst = entrada.nextInt() - 1;
                        entrada.nextLine();
                        
                        if (numEst >= 0 && numEst < cantEstudiantes) {
                            System.out.print("Ingrese calificación: ");
                            double calificacion = entrada.nextDouble();
                            entrada.nextLine();
                            estudiantes[numEst].agregarCalificacion(calificacion);
                        } else {
                            System.out.println("✗ Estudiante no encontrado");
                        }
                    } else {
                        System.out.println("✗ No hay estudiantes registrados");
                    }
                    break;

                case 3:
                    if (cantEstudiantes > 0) {
                        System.out.println("\nEstudiantes registrados:");
                        for (int i = 0; i < cantEstudiantes; i++) {
                            System.out.println((i + 1) + ". " + estudiantes[i].nombre);
                        }
                        System.out.print("Seleccione número del estudiante: ");
                        int numEst = entrada.nextInt() - 1;
                        entrada.nextLine();
                        
                        if (numEst >= 0 && numEst < cantEstudiantes) {
                            estudiantes[numEst].mostrarInformacion();
                        } else {
                            System.out.println("✗ Estudiante no encontrado");
                        }
                    } else {
                        System.out.println("✗ No hay estudiantes registrados");
                    }
                    break;

                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("✗ Opción inválida");
            }
        }
    }

    // ==================== MENÚ CONTACTOS ====================
    private static void menuContactos() {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║    MENÚ CONTACTOS              ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Agregar contacto            ║");
            System.out.println("║ 2. Eliminar contacto           ║");
            System.out.println("║ 3. Buscar contacto             ║");
            System.out.println("║ 4. Listar todos los contactos  ║");
            System.out.println("║ 5. Volver al menú principal    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    if (cantContactos < contactos.length) {
                        System.out.print("Ingrese nombre: ");
                        String nombre = entrada.nextLine();
                        System.out.print("Ingrese teléfono: ");
                        String telefono = entrada.nextLine();
                        System.out.print("Ingrese email: ");
                        String email = entrada.nextLine();
                        
                        contactos[cantContactos] = new Contacto(nombre, telefono, email);
                        cantContactos++;
                        System.out.println("✓ Contacto agregado exitosamente");
                    } else {
                        System.out.println("✗ Agenda llena");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese nombre del contacto a eliminar: ");
                    String nombreElim = entrada.nextLine();
                    boolean encontrado = false;
                    
                    for (int i = 0; i < cantContactos; i++) {
                        if (contactos[i].nombre.equals(nombreElim)) {
                            for (int j = i; j < cantContactos - 1; j++) {
                                contactos[j] = contactos[j + 1];
                            }
                            cantContactos--;
                            encontrado = true;
                            System.out.println("✓ Contacto eliminado");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("✗ Contacto no encontrado");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese nombre del contacto a buscar: ");
                    String nombreBuscar = entrada.nextLine();
                    boolean encontradoBuscar = false;
                    
                    for (int i = 0; i < cantContactos; i++) {
                        if (contactos[i].nombre.equals(nombreBuscar)) {
                            System.out.println("\n✓ Contacto encontrado:");
                            contactos[i].mostrarInfo();
                            encontradoBuscar = true;
                            break;
                        }
                    }
                    if (!encontradoBuscar) {
                        System.out.println("✗ Contacto no encontrado");
                    }
                    break;

                case 4:
                    System.out.println("\n╔════════════════════════════════╗");
                    System.out.println("║   LISTA DE CONTACTOS           ║");
                    System.out.println("╚════════════════════════════════╝");
                    if (cantContactos == 0) {
                        System.out.println("✗ No hay contactos");
                    } else {
                        for (int i = 0; i < cantContactos; i++) {
                            System.out.print((i + 1) + ". ");
                            contactos[i].mostrarInfo();
                        }
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("✗ Opción inválida");
            }
        }
    }

    // ==================== MENÚ CUENTA BANCARIA ====================
    private static void menuCuentaBancaria() {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║   MENÚ CUENTA BANCARIA         ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Crear nueva cuenta          ║");
            System.out.println("║ 2. Depositar                   ║");
            System.out.println("║ 3. Retirar                     ║");
            System.out.println("║ 4. Consultar saldo             ║");
            System.out.println("║ 5. Volver al menú principal    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    if (cantCuentas < cuentas.length) {
                        System.out.print("Ingrese nombre del titular: ");
                        String titular = entrada.nextLine();
                        System.out.print("Ingrese saldo inicial: ");
                        double saldoInicial = entrada.nextDouble();
                        entrada.nextLine();
                        System.out.print("Ingrese número de cuenta: ");
                        String numeroCuenta = entrada.nextLine();
                        
                        cuentas[cantCuentas] = new CuentaBancaria(titular, saldoInicial, numeroCuenta);
                        cantCuentas++;
                        System.out.println("✓ Cuenta creada exitosamente");
                    } else {
                        System.out.println("✗ Límite de cuentas alcanzado");
                    }
                    break;

                case 2:
                    if (cantCuentas > 0) {
                        System.out.println("\nCuentas disponibles:");
                        for (int i = 0; i < cantCuentas; i++) {
                            System.out.println((i + 1) + ". " + cuentas[i].titular + " - " + cuentas[i].numeroCuenta);
                        }
                        System.out.print("Seleccione número de cuenta: ");
                        int numCuenta = entrada.nextInt() - 1;
                        entrada.nextLine();
                        
                        if (numCuenta >= 0 && numCuenta < cantCuentas) {
                            System.out.print("Ingrese cantidad a depositar: ");
                            double deposito = entrada.nextDouble();
                            entrada.nextLine();
                            cuentas[numCuenta].depositar(deposito);
                        } else {
                            System.out.println("✗ Cuenta no encontrada");
                        }
                    } else {
                        System.out.println("✗ No hay cuentas registradas");
                    }
                    break;

                case 3:
                    if (cantCuentas > 0) {
                        System.out.println("\nCuentas disponibles:");
                        for (int i = 0; i < cantCuentas; i++) {
                            System.out.println((i + 1) + ". " + cuentas[i].titular + " - " + cuentas[i].numeroCuenta);
                        }
                        System.out.print("Seleccione número de cuenta: ");
                        int numCuenta = entrada.nextInt() - 1;
                        entrada.nextLine();
                        
                        if (numCuenta >= 0 && numCuenta < cantCuentas) {
                            System.out.print("Ingrese cantidad a retirar: ");
                            double retiro = entrada.nextDouble();
                            entrada.nextLine();
                            cuentas[numCuenta].retirar(retiro);
                        } else {
                            System.out.println("✗ Cuenta no encontrada");
                        }
                    } else {
                        System.out.println("✗ No hay cuentas registradas");
                    }
                    break;

                case 4:
                    if (cantCuentas > 0) {
                        System.out.println("\nCuentas disponibles:");
                        for (int i = 0; i < cantCuentas; i++) {
                            System.out.println((i + 1) + ". " + cuentas[i].titular + " - " + cuentas[i].numeroCuenta);
                        }
                        System.out.print("Seleccione número de cuenta: ");
                        int numCuenta = entrada.nextInt() - 1;
                        entrada.nextLine();
                        
                        if (numCuenta >= 0 && numCuenta < cantCuentas) {
                            cuentas[numCuenta].consultarSaldo();
                        } else {
                            System.out.println("✗ Cuenta no encontrada");
                        }
                    } else {
                        System.out.println("✗ No hay cuentas registradas");
                    }
                    break;

                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("✗ Opción inválida");
            }
        }
    }

    // ==================== MENÚ CARRITO ====================
    private static void menuCarrito() {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║   MENÚ CARRITO DE COMPRAS      ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Agregar producto            ║");
            System.out.println("║ 2. Eliminar producto           ║");
            System.out.println("║ 3. Ver carrito                 ║");
            System.out.println("║ 4. Calcular total              ║");
            System.out.println("║ 5. Aplicar descuento           ║");
            System.out.println("║ 6. Volver al menú principal    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    if (cantProductos < carrito.length) {
                        System.out.print("Ingrese nombre del producto: ");
                        String nombre = entrada.nextLine();
                        System.out.print("Ingrese precio: ");
                        double precio = entrada.nextDouble();
                        System.out.print("Ingrese cantidad: ");
                        int cantidad = entrada.nextInt();
                        entrada.nextLine();
                        
                        boolean existe = false;
                        for (int i = 0; i < cantProductos; i++) {
                            if (carrito[i].nombre.equals(nombre)) {
                                carrito[i].cantidad = carrito[i].cantidad + cantidad;
                                existe = true;
                                System.out.println("✓ Producto actualizado en el carrito");
                                break;
                            }
                        }
                        
                        if (!existe) {
                            carrito[cantProductos] = new Producto(nombre, precio, cantidad);
                            cantProductos++;
                            System.out.println("✓ Producto agregado al carrito");
                        }
                    } else {
                        System.out.println("✗ Carrito lleno");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese nombre del producto a eliminar: ");
                    String nombreElim = entrada.nextLine();
                    boolean encontrado = false;
                    
                    for (int i = 0; i < cantProductos; i++) {
                        if (carrito[i].nombre.equals(nombreElim)) {
                            for (int j = i; j < cantProductos - 1; j++) {
                                carrito[j] = carrito[j + 1];
                            }
                            cantProductos--;
                            encontrado = true;
                            System.out.println("✓ Producto eliminado del carrito");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("✗ Producto no encontrado");
                    }
                    break;

                case 3:
                    System.out.println("\n╔════════════════════════════════╗");
                    System.out.println("║   CARRITO DE COMPRAS           ║");
                    System.out.println("╚════════════════════════════════╝");
                    if (cantProductos == 0) {
                        System.out.println("✗ El carrito está vacío");
                    } else {
                        double total = 0;
                        for (int i = 0; i < cantProductos; i++) {
                            System.out.print((i + 1) + ". ");
                            carrito[i].mostrarInfo();
                            total = total + carrito[i].calcularSubtotal();
                        }
                        System.out.println("─────────────────────────────────");
                        System.out.println("Total: $" + total);
                    }
                    System.out.println();
                    break;

                case 4:
                    double total = 0;
                    for (int i = 0; i < cantProductos; i++) {
                        total = total + carrito[i].calcularSubtotal();
                    }
                    System.out.println("\n✓ Total del carrito: $" + total + "\n");
                    break;

                case 5:
                    System.out.print("Ingrese el porcentaje de descuento: ");
                    double descuento = entrada.nextDouble();
                    entrada.nextLine();
                    
                    double totalCarrito = 0;
                    for (int i = 0; i < cantProductos; i++) {
                        totalCarrito = totalCarrito + carrito[i].calcularSubtotal();
                    }
                    
                    double montoDescuento = (totalCarrito * descuento) / 100;
                    double totalConDescuento = totalCarrito - montoDescuento;
                    
                    System.out.println("\n─ Total sin descuento: $" + totalCarrito);
                    System.out.println("─ Descuento (" + descuento + "%): $" + montoDescuento);
                    System.out.println("─ Total con descuento: $" + totalConDescuento + "\n");
                    break;

                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("✗ Opción inválida");
            }
        }
    }

    // ==================== MEN�� EMPLEADOS ====================
    private static void menuEmpleados() {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║   MENÚ REGISTRO DE EMPLEADOS   ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Agregar empleado            ║");
            System.out.println("║ 2. Buscar empleado por ID      ║");
            System.out.println("║ 3. Listar todos los empleados  ║");
            System.out.println("║ 4. Ver salarios anuales        ║");
            System.out.println("║ 5. Aplicar aumento             ║");
            System.out.println("║ 6. Volver al menú principal    ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    if (cantEmpleados < empleados.length) {
                        System.out.print("Ingrese nombre del empleado: ");
                        String nombre = entrada.nextLine();
                        System.out.print("Ingrese ID: ");
                        String id = entrada.nextLine();
                        System.out.print("Ingrese salario: ");
                        double salario = entrada.nextDouble();
                        entrada.nextLine();
                        System.out.print("Ingrese departamento: ");
                        String departamento = entrada.nextLine();
                        
                        empleados[cantEmpleados] = new Empleado(nombre, id, salario, departamento);
                        cantEmpleados++;
                        System.out.println("✓ Empleado agregado exitosamente");
                    } else {
                        System.out.println("✗ Límite de empleados alcanzado");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese ID del empleado a buscar: ");
                    String idBuscar = entrada.nextLine();
                    boolean encontrado = false;
                    
                    for (int i = 0; i < cantEmpleados; i++) {
                        if (empleados[i].id.equals(idBuscar)) {
                            System.out.println("\n✓ Empleado encontrado:");
                            empleados[i].mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("✗ Empleado no encontrado");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("\n╔════════════════════════════════╗");
                    System.out.println("║   REGISTRO DE EMPLEADOS        ║");
                    System.out.println("╚════════════════════════════════╝");
                    if (cantEmpleados == 0) {
                        System.out.println("✗ No hay empleados registrados");
                    } else {
                        for (int i = 0; i < cantEmpleados; i++) {
                            System.out.print((i + 1) + ". ");
                            empleados[i].mostrarInfo();
                        }
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("\n╔════════════════════════════════╗");
                    System.out.println("║      SALARIOS ANUALES          ║");
                    System.out.println("╚════════════════════════════════╝");
                    if (cantEmpleados == 0) {
                        System.out.println("✗ No hay empleados registrados");
                    } else {
                        for (int i = 0; i < cantEmpleados; i++) {
                            System.out.println("  • " + empleados[i].nombre + ": $" + empleados[i].calcularSalarioAnual());
                        }
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Ingrese ID del empleado: ");
                    String idEmpleado = entrada.nextLine();
                    boolean encontradoAumento = false;
                    
                    for (int i = 0; i < cantEmpleados; i++) {
                        if (empleados[i].id.equals(idEmpleado)) {
                            System.out.print("Ingrese porcentaje de aumento: ");
                            double porcentaje = entrada.nextDouble();
                            entrada.nextLine();
                            empleados[i].aplicarAumento(porcentaje);
                            encontradoAumento = true;
                            break;
                        }
                    }
                    if (!encontradoAumento) {
                        System.out.println("✗ Empleado no encontrado");
                    }
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;

                default:
                    System.out.println("✗ Opción inválida");
            }
        }
    }
}
