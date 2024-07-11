/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.dto;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Arian
 */
public class FechaReserva {
    private String fechaInicio;
    private String fechaFin;
    private Long idCliente;
    private String nombres;
    private String apellidos;
    private String idUsuario;
    private String foto;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return idUsuario;
    }

    public void setId(String id) {
        this.idUsuario = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }
  
    public FechaReserva(String fechaInicio, String fechaFin, Long idCliente, 
            String foto, String nombres, String apellidos, String idUsuario) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idCliente = idCliente;
        this.idUsuario=idUsuario;
        this.nombres= nombres;
        this.apellidos=apellidos;
        this.foto=foto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
