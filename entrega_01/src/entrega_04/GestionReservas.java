package entrega_04;


import entrega_04.clases.Reserva;
import entrega_04.enums.TipoReserva;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionReservas {

    private static final MyScanner sc = new MyScanner();

    private static Reserva[] reservas = new Reserva[30];
    private static int contador = 0;

    public static void main(String[] args) {
        boolean salir;
        do {
            salir = false;
            int opcion = sc.pedirNumero("-----Reservas------" +
                    "\n1. Añadir Reserva" +
                    "\n2. Mostrar Reservas" +
                    "\n3. Filtrar por año" +
                    "\n4. Filtrar por mes" +
                    "\n5. Filtrar por rango" +
                    "\n6. Salir" +
                    "\nIngrese la opción");
            switch (opcion){
                case 1:
                    addReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 3:
                    filtroYear();
                    break;
                case 4:
                    filtroMonth();
                    break;
                case 5:
                    filtroRango();
                    break;
                case 6:
                    System.out.println("Cerrando programa");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (!salir);
    }

    public static void addReserva() {
        boolean correcto;
        LocalDate fecha_creacion = null;
        do {
            correcto = true;
            try {
                String fecha = sc.pideTexto("Ingresa la fecha de creación (YYYY-MM-DD): ");
                fecha_creacion = LocalDate.parse(fecha);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        TipoReserva tipo_reserva = Utilidades.pedirEnum(TipoReserva.class, "Selecciona el tipo de reserva: ");

        String nombreCliente = sc.pideTexto("Ingresa el nombre del cliente: ");

        String idReserva = "R" + (contador+1) ;

        if (contador < reservas.length) {
            reservas[contador] = new Reserva(fecha_creacion, tipo_reserva, nombreCliente, idReserva);
            contador++;
        } else {
            System.out.println("La lista de registros ya esta llena.");
        }
    }

    public static void mostrarReservas() {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                System.out.println(reservas[i]);
            }
        }
    }

    public static void filtroYear() {
        int year = sc.pedirNumero("Ingrese el año a filtrar: ");
        System.out.println(obtenerRegistroPorAnio(year));
    }

    public static void filtroMonth() {
        int month = sc.pedirNumero("Ingrese el mes a filtrar: ");
        System.out.println(obtenerReservasPorMes(month));
    }

    public static void filtroRango() {
        int min_year = sc.pedirNumero("Ingrese el año mínimo: ");
        int max_year = sc.pedirNumero("Ingrese el año máximo: ");
        System.out.println(obtenerRegistroEnRango(min_year, max_year));
    }

    public static Reserva obtenerRegistroPorAnio(int year) {
        for (int i = 0; i < reservas.length ; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFechaCreacion().getYear() == year) {
                    return reservas[i];
                }
                System.out.println("No hay reservas ese año");
            }
        }
        return null;
    }

    public static Reserva obtenerReservasPorMes(int month) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                if (reservas[i].getFechaCreacion().getMonthValue() == month) {
                    return reservas[i];
                }
                System.out.println("No hay reservas ese mes");
            }
        }
        return null;
    }

    public static Reserva obtenerRegistroEnRango (int min_year, int max_year) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                int year = reservas[i].getFechaCreacion().getYear();
                if (min_year < year && year > max_year) {
                    return reservas[i];
                }
                System.out.println("No hay reservas en ese rango");
            }
        }
        return null;
    }
}
