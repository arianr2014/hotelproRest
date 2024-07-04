/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ReservaEntity")
@Table(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private Long idReserva;

     @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcliente")
    private ClienteEntity cliente;

     @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idhabitacion")
    private HabitacionEntity habitacion;

    @Column(name = "fechaingreso")
    private Date fechaIngreso;

    @Column(name = "fechasalida")
    private Date fechaSalida;

    @Column(name = "totaldias")
    private Integer totalDias;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Column(name = "igv")
    private BigDecimal igv;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "usrcreacion")
    private String usuarioCreacion;

    @Column(name = "fechcreacion")
    private String fechaCreacion;

    @Column(name = "usredicion")
    private String usuarioEdicion;

    @Column(name = "fechedicion")
    private String fechaEdicion;
    
    @Transient
    private String id;

    // Getters y setters
}
