package com.api.encomendas.controller;

import com.api.encomendas.model.SaidaEncomenda;
import com.api.encomendas.service.SaidaEncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saidas")
public class SaidaEncomendaController {

    private final SaidaEncomendaService saidaEncomendaService;

    @Autowired
    public SaidaEncomendaController(SaidaEncomendaService saidaEncomendaService) {
        this.saidaEncomendaService = saidaEncomendaService;
    }

    @GetMapping
    public ResponseEntity<List<SaidaEncomenda>> getAllSaidas() {
        List<SaidaEncomenda> saidas = saidaEncomendaService.findAll();
        return ResponseEntity.ok(saidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaidaEncomenda> getSaidaById(@PathVariable String id) {
        SaidaEncomenda saida = saidaEncomendaService.findById(id);
        return ResponseEntity.ok(saida);
    }

    @PostMapping
    public ResponseEntity<SaidaEncomenda> createSaida(@RequestBody SaidaEncomenda saidaEncomenda) {
        SaidaEncomenda savedSaida = saidaEncomendaService.save(saidaEncomenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSaida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaidaEncomenda> updateSaida(@PathVariable String id, @RequestBody SaidaEncomenda saidaEncomenda) {
        SaidaEncomenda updatedSaida = saidaEncomendaService.update(id, saidaEncomenda);
        return ResponseEntity.ok(updatedSaida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSaida(@PathVariable String id) {
        saidaEncomendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 