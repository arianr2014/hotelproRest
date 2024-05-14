/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.smartpro.service;

/**
 *
 * @author Arian
 */
import java.util.List;
import java.util.Optional;
import pe.com.smartpro.entities.UsuarioEntity;

public interface UsuarioService {
    List<UsuarioEntity> findAll();

    Optional<UsuarioEntity> findById(Long id);

    Optional<UsuarioEntity> validarAcceso(String email, String password);
     
    UsuarioEntity save(UsuarioEntity usuario);

    UsuarioEntity update(Long id, UsuarioEntity usuario);

    void deleteById(Long id);
}
