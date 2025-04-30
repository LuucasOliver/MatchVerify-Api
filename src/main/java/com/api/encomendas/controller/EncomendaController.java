package com.api.encomendas.controller;

import com.api.encomendas.model.Encomenda;
import com.api.encomendas.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encomendas")
public class EncomendaController {

    private final EncomendaService encomendaService;

    @Autowired
    public EncomendaController(EncomendaService encomendaService) {
        this.encomendaService = encomendaService;
    }

    @GetMapping
    public ResponseEntity<List<Encomenda>> getAllEncomendas() {
        List<Encomenda> encomendas = encomendaService.findAll();
        return ResponseEntity.ok(encomendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encomenda> getEncomendaById(@PathVariable Integer id) {
        Encomenda encomenda = encomendaService.findById(id);
        return ResponseEntity.ok(encomenda);
    }

    @PostMapping
    public ResponseEntity<Encomenda> createEncomenda(@RequestBody Encomenda encomenda) {
        Encomenda savedEncomenda = encomendaService.save(encomenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEncomenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encomenda> updateEncomenda(@PathVariable Integer id, @RequestBody Encomenda encomenda) {
        Encomenda updatedEncomenda = encomendaService.update(id, encomenda);
        return ResponseEntity.ok(updatedEncomenda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncomenda(@PathVariable Integer id) {
        encomendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 