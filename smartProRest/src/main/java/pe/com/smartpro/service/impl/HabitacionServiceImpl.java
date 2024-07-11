/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.crypto.AEADBadTagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.smartpro.dto.FechaReserva;
import pe.com.smartpro.entities.HabitacionEntity;
import pe.com.smartpro.entities.ImagenesHabitacionEntity;
import pe.com.smartpro.entities.ReservaEntity;
import pe.com.smartpro.entities.ServiciosHabitacionEntity;
import pe.com.smartpro.repository.HabitacionRepository;
import pe.com.smartpro.repository.ImagenesHabitacionRepository;
import pe.com.smartpro.repository.ReservaRepository;
import pe.com.smartpro.repository.ServiciosHabitacionRepository;
import pe.com.smartpro.service.HabitacionService;

@Service
public class HabitacionServiceImpl implements HabitacionService{

    @Autowired
    private HabitacionRepository repositorio;
    
    @Autowired
    private ImagenesHabitacionRepository repositorioImagenes;
    
    @Autowired
    private ServiciosHabitacionRepository repositorioServicios;
      
    @Autowired
    private ReservaRepository reservaRepository;
            
    @Override
    public List<HabitacionEntity> findAll() {
         List<HabitacionEntity> lista= repositorio.findAll();
          for(HabitacionEntity habitacion : lista){
            List<ReservaEntity> listaFechasReserva = reservaRepository.findFechasByHabitacion(habitacion.getCodigo());
            List<FechaReserva> listaFechas = new ArrayList<>();
                for (ReservaEntity fecha : listaFechasReserva) {
               
                
                 String fechaInicio = fecha.getFechaIngreso().toString();
                 String fechaFin = fecha.getFechaSalida().toString();
                 String nombres=fecha.getCliente().getNombres();
                 String apellidos=fecha.getCliente().getApellidos();
                 String idUsuario=fecha.getCliente().getId();
                 String foto=fecha.getCliente().getUrlfoto();
                 FechaReserva f= new FechaReserva(fechaInicio, fechaFin,fecha.getCliente().getIdCliente(),foto, nombres, apellidos, idUsuario);
             
                 listaFechas.add(f);
                 
            }
           habitacion.setFechas(listaFechas);
            
        
        }  
         
        return lista;
    }
/*
    @Override
    public List<HabitacionEntity> findAllHabitaciones() {
        return repositorio.findAllHabitaciones();
    }
*/
    @Override
    public Optional<HabitacionEntity> findById(long id) {
        Optional<HabitacionEntity>  optionalHabitacion = repositorio.findById(id);
        //List<ImagenesHabitacionEntity> listado = repositorioImagenes.findAllImagenesHabitacion(id);
        optionalHabitacion.ifPresent(habitacion -> {
            List<ImagenesHabitacionEntity> listado = repositorioImagenes.findAllImagenesHabitacion(id);
            habitacion.setImagenesHabitacion(listado);
            
            List<ServiciosHabitacionEntity> listadoServicios = repositorioServicios.findAllServiciosHabitacion(id);
            habitacion.setServiciosHabitacion(listadoServicios); 
        
           List<ReservaEntity> listaFechasReserva = reservaRepository.findFechasByHabitacion(id);
            List<FechaReserva> listaFechas = new ArrayList<>();
            
           for (ReservaEntity fecha : listaFechasReserva) {
               
                
                 String fechaInicio = fecha.getFechaIngreso().toString();
                 String fechaFin = fecha.getFechaSalida().toString();
                 String nombres=fecha.getCliente().getNombres();
                 String apellidos=fecha.getCliente().getApellidos();
                 String idUsuario=fecha.getCliente().getId();
                 String foto=fecha.getCliente().getUrlfoto();
                 FechaReserva f= new FechaReserva(fechaInicio, fechaFin,fecha.getCliente().getIdCliente(),foto, nombres, apellidos, idUsuario);
                 
                 listaFechas.add(f);
                 
            }
            habitacion.setFechas(listaFechas);
 
            
        });
        
        
       
        return optionalHabitacion;
    }
    
    /*
    @Override
     public List<HabitacionEntity> findAllHabitaciones(double precioinicial, double preciofinal, String clasificacion) {
        return repositorio.findAllHabitaciones(precioinicial, preciofinal, clasificacion);
    }*/
        
     @Override
     public List<HabitacionEntity> findAllHabitaciones(String preciovalor, String clasificacion) {
         
        List<HabitacionEntity> lista= repositorio.findAllHabitaciones(preciovalor, clasificacion);
        for(HabitacionEntity habitacion : lista){
            List<ReservaEntity> listaFechasReserva = reservaRepository.findFechasByHabitacion(habitacion.getCodigo());
            List<FechaReserva> listaFechas = new ArrayList<>();
                for (ReservaEntity fecha : listaFechasReserva) {
               
                
                 String fechaInicio = fecha.getFechaIngreso().toString();
                  String fechaFin = fecha.getFechaSalida().toString();
                    String nombres=fecha.getCliente().getNombres();
                 String apellidos=fecha.getCliente().getApellidos();
                 String idUsuario=fecha.getCliente().getId();
                 String foto=fecha.getCliente().getUrlfoto();
                 FechaReserva f= new FechaReserva(fechaInicio, fechaFin,fecha.getCliente().getIdCliente(),foto, nombres, apellidos, idUsuario);
             
                 
                 listaFechas.add(f);
                 
            }
           habitacion.setFechas(listaFechas);
            
        
        }  
        return lista;
    }
     
}
