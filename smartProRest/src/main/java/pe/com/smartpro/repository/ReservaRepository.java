/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.smartpro.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.smartpro.dto.FechaReserva;

import pe.com.smartpro.entities.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    
  @Query("select c from ReservaEntity c where c.estado=true and c.cliente.idCliente=:idCliente") 
   List<ReservaEntity> findReservasCliente(long idCliente);
   
   
   @Query("select c from ReservaEntity c where c.habitacion.codigo=:idHabitacion")
   List<ReservaEntity> findFechasByHabitacion(@Param("idHabitacion") long idHabitacion);
}
