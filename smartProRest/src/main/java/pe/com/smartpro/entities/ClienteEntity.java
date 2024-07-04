/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ClienteEntity")
@Table(name = "clientes")
public class ClienteEntity  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Long idCliente;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "nrodocumento")
    private String numeroDocumento;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "urlfoto")
    private String urlfoto;

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
    
    @Column(name = "id")
    private String id;

    
    @Transient
    private String fullName;

    @Transient
    private String lastName;
    
    
    @Transient
    private String country;
    
    @Transient
    private String location;
    
    @Transient
    private String passportOrID;
    
    @Transient
    private String phone;
            
            
    // Getters y setters
}
