/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.smartpro.service;

import java.util.List;
import java.util.Optional;
import pe.com.smartpro.entities.HabitacionEntity;

/**
 *
 * @author Arian
 */
public interface HabitacionService {
    List<HabitacionEntity> findAll();
   /* List<HabitacionEntity> findAllHabitaciones();*/
    Optional<HabitacionEntity> findById(long id);
    
    public List<HabitacionEntity> findAllHabitaciones(double precioinicial, 
            double preciofinal, String clasificacion);
}
