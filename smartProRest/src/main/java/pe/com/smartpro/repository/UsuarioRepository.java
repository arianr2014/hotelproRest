/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.smartpro.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.smartpro.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    
    @Query("SELECT u FROM UsuarioEntity u WHERE u.email = ?1 AND u.password = ?2")
    Optional<UsuarioEntity> validarAcceso(String email, String password);
}
