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
import pe.com.smartpro.repository.ClienteRepository;
import pe.com.smartpro.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<ClienteEntity> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteEntity update(Long id, ClienteEntity cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setIdCliente(id);
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
