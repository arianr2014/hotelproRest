/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.smartpro.service;

import java.util.List;
import java.util.Optional;
import pe.com.smartpro.entities.ClienteEntity;

public interface ClienteService {
    List<ClienteEntity> findAll();

    Optional<ClienteEntity> findById(Long id);

    ClienteEntity save(ClienteEntity cliente);

    ClienteEntity update(Long id, ClienteEntity cliente);

    void delete(Long id);
}
