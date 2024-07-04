/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.restcontroller;

/**
 *
 * @author Arian
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.com.smartpro.dto.ValidarAccesoDto;
import pe.com.smartpro.entities.UsuarioEntity;
import pe.com.smartpro.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

     
    @GetMapping
    public List<UsuarioEntity> findAll() {
        return usuarioService.findAll();
    }
 
    @GetMapping("/{id}")
    public Optional<UsuarioEntity> findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
 
    @PostMapping
    public UsuarioEntity v(@RequestBody UsuarioEntity usuario) {
        return usuarioService.save(usuario);
    }
 
    @PutMapping("/{id}")
    public UsuarioEntity update(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        return usuarioService.update(id, usuario);
    }
 
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
    
 
    @PostMapping("/validarAcceso")
    public ResponseEntity<?> validarAcceso(@RequestBody ValidarAccesoDto request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Optional<UsuarioEntity> usuario = usuarioService.validarAcceso(email, password);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
    
    
    
}
