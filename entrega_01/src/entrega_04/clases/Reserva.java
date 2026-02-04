package entrega_04.clases;


import entrega_04.enums.TipoReserva;

import java.time.LocalDate;

public class Reserva {
    private LocalDate fechaCreacion;
    private TipoReserva tipoReserva;
    private String nombreCliente;
    private String idReserva;

    public Reserva(LocalDate fechaCreacion, TipoReserva tipoReserva, String nombreCliente, String idReserva) {
        this.fechaCreacion = fechaCreacion;
        this.tipoReserva = tipoReserva;
        this.nombreCliente = nombreCliente;
        this.idReserva = idReserva;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdReserva() {return idReserva;}

    public void setIdReserva(String idReserva) {this.idReserva = idReserva;}

    @Override
    public String toString() {
        return String.format("Reserva: %s, tipo: %s, fecha de creación: %10s, a nombre de: %s",idReserva, tipoReserva, fechaCreacion, nombreCliente);
    }
}
