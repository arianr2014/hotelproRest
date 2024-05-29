
package pe.com.smartpro.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.smartpro.entities.HabitacionEntity;

public interface HabitacionRepository extends JpaRepository<HabitacionEntity,Long> {
  
    /*
    @Query("SELECT c FROM HabitacionEntity c WHERE  c.precio " + 
      " BETWEEN :precioinicial AND :preciofinal AND c.contadorreserva < c.cantidad " +
       "AND (:clasificacion ='' OR c.clasificacion = :clasificacion)")
     List<HabitacionEntity> findAllHabitaciones(@Param("precioinicial") 
            double precioinicial, @Param("preciofinal") 
            double preciofinal, @Param("clasificacion") String clasificacion);
    
    */
    
    @Query("SELECT c FROM HabitacionEntity c WHERE  c.preciovalor = :preciovalor " + 
     "AND (:clasificacion ='' OR c.clasificacion = :clasificacion)")
    List<HabitacionEntity> findAllHabitaciones(@Param("preciovalor") 
            String preciovalor, @Param("clasificacion") String clasificacion);
    
}
