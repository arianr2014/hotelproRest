/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.service.impl;

import java.util.Collections;
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
    public List<ReservaEntity> findReservasCliente(String id) {
        try {
            ClienteEntity cliente = clienteRepository.findByIdCustom(id);

            // Si el cliente no se encuentra, devolver un listado vacío
            if (cliente == null) {
                return Collections.emptyList();
            }

            return reservaRepository.findReservasCliente(cliente.getIdCliente());
        } catch (Exception e) {
            // Manejar la excepción y devolver un listado vacío
            return Collections.emptyList();
        }
}

    @Override
    public Optional<ReservaEntity> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public ReservaEntity save(ReservaEntity reserva) {
        
    String clienteId = reserva.getId(); // Suponiendo que el id aquí es el id del cliente a buscar o crear

        ClienteEntity cliente = clienteRepository.findByIdCustom(clienteId);
        if (cliente == null) {
            cliente = new ClienteEntity();
            // Configurar los datos del cliente desde la reserva o donde sea necesario
            cliente.setId(clienteId);
            cliente.setNombres(reserva.getCliente().getFullName()!= null ? reserva.getCliente().getFullName() : "");
            cliente.setApellidos(reserva.getCliente().getLastName()!= null ? reserva.getCliente().getLastName() : "");
            cliente.setNumeroDocumento(reserva.getCliente().getPassportOrID() != null ? reserva.getCliente().getPassportOrID() : "");
            cliente.setEmail(reserva.getCliente().getEmail() != null ? reserva.getCliente().getEmail() : "");
            cliente.setTelefono(reserva.getCliente().getPhone() != null ? reserva.getCliente().getPhone() : "");
            cliente.setCiudad(reserva.getCliente().getCountry()!= null ? reserva.getCliente().getCountry() : "");
            cliente.setDireccion(reserva.getCliente().getLocation()!= null ? reserva.getCliente().getLocation() : "");
            cliente.setUrlfoto("");
            cliente.setUsuarioCreacion("admin");
            cliente.setUsuarioEdicion("admin");
            cliente.setId(clienteId);
            cliente.setEstado(true); // Por defecto, se puede configurar según sea necesario
            // Guardar el nuevo cliente
            cliente = clienteRepository.save(cliente);
        }

        //ClienteEntity cliente = clienteRepository.findById(reserva.getCliente().getIdCliente()).orElseThrow(); // Obtener el cliente de la base de datos
        HabitacionEntity habitacion = habitacionRepository.findById(reserva.getHabitacion().getCodigo()).orElseThrow(); // Obtener la habitación de la base de datos
        
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);
        reserva.setUsuarioCreacion("admin");
        reserva.setUsuarioEdicion("admin");
        habitacion.setContadorreserva(habitacion.getContadorreserva() + 1);
        habitacionRepository.save(habitacion);
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
