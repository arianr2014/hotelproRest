/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "HabitacionEntity")
@Table (name = "habitacion")
public class HabitacionEntity implements Serializable{

    private static final long serialVersionUID=1L;
    @Id
    @Column(name = "idhabitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
   @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "estado")
    private Boolean  estado;

    @Column(name = "usrcreacion")
    private String usrcreacion;

    @Column(name = "usredicion")
    private String usredicion;
    
    @Column(name = "contadorreserva")
    private Long contadorreserva;
    
    @Column(name = "clasificacion")
    private String clasificacion;
    
     @Column(name = "cantidad")
    private Long cantidad;


    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    @JsonManagedReference // Indica que este lado de la relación será serializado
    private List<ServiciosHabitacionEntity> serviciosHabitacion;
    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    @JsonManagedReference // Indica que este lado de la relación será serializado
    private List<ImagenesHabitacionEntity> imagenesHabitacion;
 
}
