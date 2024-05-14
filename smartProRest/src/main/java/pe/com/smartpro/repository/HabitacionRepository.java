
package pe.com.smartpro.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.smartpro.entities.HabitacionEntity;

public interface HabitacionRepository extends JpaRepository<HabitacionEntity,Long> {
  @Query("select c from HabitacionEntity c where c.estado=true") 
   List<HabitacionEntity> findAllHabitaciones();
}
