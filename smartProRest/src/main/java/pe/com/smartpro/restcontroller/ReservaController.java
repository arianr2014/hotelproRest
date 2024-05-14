/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import pe.com.smartpro.entities.ReservaEntity;
import pe.com.smartpro.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<ReservaEntity>> findAll() {
        List<ReservaEntity> reservas = reservaService.findAll();
        return ResponseEntity.ok(reservas);
    }

    
   @GetMapping("/findReservasCliente/{id}")
    public ResponseEntity<List<ReservaEntity>> findReservasCliente(@PathVariable Long id) {
        List<ReservaEntity> reservas = reservaService.findReservasCliente(id);
        return ResponseEntity.ok(reservas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ReservaEntity> findById(@PathVariable Long id) {
        Optional<ReservaEntity> reserva = reservaService.findById(id);
        return reserva.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservaEntity> save(@RequestBody ReservaEntity reserva) {
        ReservaEntity savedReserva = reservaService.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaEntity> update(@PathVariable Long id, @RequestBody ReservaEntity reserva) {
        ReservaEntity updatedReserva = reservaService.update(id, reserva);
        return ResponseEntity.ok(updatedReserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}