/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

@Entity
@Table(name = "imageneshabitacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagenesHabitacionEntity  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idimghabitacion")
    private Long idImgHabitacion;

    @ManyToOne
    @JoinColumn(name = "idhabitacion")
    @JsonBackReference 
    private HabitacionEntity habitacion;

    @Column(name = "urlimagen")
    private String urlImagen;

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
}
