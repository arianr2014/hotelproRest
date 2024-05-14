/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.smartpro.entities.HabitacionEntity;
import pe.com.smartpro.repository.HabitacionRepository;
import pe.com.smartpro.service.HabitacionService;

@Service
public class HabitacionServiceImpl implements HabitacionService{

    @Autowired
    private HabitacionRepository repositorio;
            
    @Override
    public List<HabitacionEntity> findAll() {
        return repositorio.findAll();
    }
/*
    @Override
    public List<HabitacionEntity> findAllHabitaciones() {
        return repositorio.findAllHabitaciones();
    }
*/
    @Override
    public Optional<HabitacionEntity> findById(long id) {
        return repositorio.findById(id);
    }
    
}
