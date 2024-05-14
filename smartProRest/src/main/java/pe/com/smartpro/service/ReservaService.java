/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.smartpro.service;

import java.util.List;
import java.util.Optional;
import pe.com.smartpro.entities.ReservaEntity;

public interface ReservaService {
    List<ReservaEntity> findAll();

    Optional<ReservaEntity> findById(Long id);
    
    List<ReservaEntity> findReservasCliente(Long id);
     
    ReservaEntity save(ReservaEntity reserva);

    ReservaEntity update(Long id, ReservaEntity reserva);

    void delete(Long id);
}
