/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import pe.com.smartpro.entities.ClienteEntity;
import pe.com.smartpro.entities.HabitacionEntity;
import pe.com.smartpro.entities.ReservaEntity;
import pe.com.smartpro.repository.ClienteRepository;
import pe.com.smartpro.repository.HabitacionRepository;
import pe.com.smartpro.repository.ReservaRepository;
import pe.com.smartpro.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
      @Autowired
    private HabitacionRepository habitacionRepository;
      
    @Override
    public List<ReservaEntity> findAll() {
        return reservaRepository.findAll();
    }
    
   @Override
    public List<ReservaEntity> findReservasCliente(Long id) {
        return reservaRepository.findReservasCliente(id);
    }

    @Override
    public Optional<ReservaEntity> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public ReservaEntity save(ReservaEntity reserva) {
        


        // Obtener el cliente y la habitación asociados a la reserva
        //reserva.setIdReserva(8L);
  
        ClienteEntity cliente = clienteRepository.findById(reserva.getCliente().getIdCliente()).orElseThrow(); // Obtener el cliente de la base de datos
        HabitacionEntity habitacion = habitacionRepository.findById(reserva.getHabitacion().getCodigo()).orElseThrow(); // Obtener la habitación de la base de datos
        // Asignar el cliente y la habitación a la reserva (sin guardarlos nuevamente)
        
        
       //ClienteEntity cliente = clienteRepository.findById(1L).orElseThrow(); // Obtener el cliente de la base de datos
       // HabitacionEntity habitacion = habitacionRepository.findById(1L).orElseThrow(); // Obtener la habitación de la base de datos
        
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);

        // Guardar la reserva en la base de datos
        return reservaRepository.save(reserva);

    }

    @Override
    public ReservaEntity update(Long id, ReservaEntity reserva) {
        if (reservaRepository.existsById(id)) {
            reserva.setIdReserva(id);
            return reservaRepository.save(reserva);
        } else {
            throw new RuntimeException("Reserva no encontrada");
        }
    }

    @Override
    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}
