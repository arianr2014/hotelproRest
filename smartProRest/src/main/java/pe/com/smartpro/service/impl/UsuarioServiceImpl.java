/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.service.impl;

/**
 *
 * @author Arian
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import pe.com.smartpro.entities.UsuarioEntity;
import pe.com.smartpro.repository.UsuarioRepository;
import pe.com.smartpro.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> validarAcceso(String email, String password) {
        return usuarioRepository.validarAcceso(email, password);
    }
    
    
    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        usuario.setPassword("");
        usuario.setEstado(Boolean.TRUE);
        usuario.setFechCreacion(formattedDate);
        
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity update(Long id, UsuarioEntity usuario) {
        
        if(usuarioRepository.existsById(id)){
            usuario.setIdUsuario(id);
            return usuarioRepository.save(usuario);
        
        }else{
         throw new RuntimeException("Usuario no encontrado");
        
        }
    }
    
    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
