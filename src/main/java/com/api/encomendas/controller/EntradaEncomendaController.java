package com.api.encomendas.controller;

import com.api.encomendas.model.EntradaEncomenda;
import com.api.encomendas.service.EntradaEncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaEncomendaController {

    private final EntradaEncomendaService entradaEncomendaService;

    @Autowired
    public EntradaEncomendaController(EntradaEncomendaService entradaEncomendaService) {
        this.entradaEncomendaService = entradaEncomendaService;
    }

    @GetMapping
    public ResponseEntity<List<EntradaEncomenda>> getAllEntradas() {
        List<EntradaEncomenda> entradas = entradaEncomendaService.findAll();
        return ResponseEntity.ok(entradas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaEncomenda> getEntradaById(@PathVariable String id) {
        EntradaEncomenda entrada = entradaEncomendaService.findById(id);
        return ResponseEntity.ok(entrada);
    }

    @PostMapping
    public ResponseEntity<EntradaEncomenda> createEntrada(@RequestBody EntradaEncomenda entradaEncomenda) {
        EntradaEncomenda savedEntrada = entradaEncomendaService.save(entradaEncomenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaEncomenda> updateEntrada(@PathVariable String id, @RequestBody EntradaEncomenda entradaEncomenda) {
        EntradaEncomenda updatedEntrada = entradaEncomendaService.update(id, entradaEncomenda);
        return ResponseEntity.ok(updatedEntrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable String id) {
        entradaEncomendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 