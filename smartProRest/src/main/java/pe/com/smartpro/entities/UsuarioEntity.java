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
import java.io.Serializable;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "UsuarioEntity")
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "estado")
    private Boolean estado;
        
    @Column(name = "usrcreacion")
    private String usrCreacion;

    @Column(name = "fechcreacion")
    private String fechCreacion;

    @Column(name = "usredicion")
    private String usrEdicion;

    @Column(name = "fechedicion")
    private String fechEdicion;
    
    @Column(name = "id")
    private String id;
    
    @Column(name = "first_name")
    private String first_name;
    
    
     @Column(name = "last_name")
    private String last_name;
    
     
      @Column(name = "image_url")
    private String image_url;
    
    
    
    
    

    // Constructor, getters y setters
}
