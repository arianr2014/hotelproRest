/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.smartpro.entities.ServiciosHabitacionEntity;
/**
 *
 * @author Arian
 */
public interface ServiciosHabitacionRepository  extends JpaRepository<ServiciosHabitacionEntity,Long>{
    
     @Query("select c from ServiciosHabitacionEntity c where c.estado=true and c.habitacion.codigo=:idhabitacion") 
   List<ServiciosHabitacionEntity> findAllServiciosHabitacion(long idhabitacion); 
    
}
