/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.com.smartpro.entities.HabitacionEntity;
import pe.com.smartpro.service.HabitacionService;

@RestController
@RequestMapping("/habitacion")
public class HabitacionRestController {
    
    @Autowired
    private HabitacionService servicio;
    
    
    @GetMapping
    public List<HabitacionEntity> findAll(){
        return servicio.findAll();
    
    }
 
   
    @GetMapping("/findById/{id}")
    public Optional<HabitacionEntity> findById(@PathVariable Long id){
        return servicio.findById(id);
    
    }
 
    
    @GetMapping("/buscar")
    public List<HabitacionEntity> buscarHabitaciones(@RequestParam String preciovalor, @RequestParam String clasificacion) {
        return servicio.findAllHabitaciones(preciovalor, clasificacion);
    }
    
}
