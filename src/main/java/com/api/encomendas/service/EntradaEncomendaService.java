package com.api.encomendas.service;

import com.api.encomendas.exception.ResourceNotFoundException;
import com.api.encomendas.model.EntradaEncomenda;
import com.api.encomendas.repository.EntradaEncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EntradaEncomendaService {

    private final EntradaEncomendaRepository entradaEncomendaRepository;

    @Autowired
    public EntradaEncomendaService(EntradaEncomendaRepository entradaEncomendaRepository) {
        this.entradaEncomendaRepository = entradaEncomendaRepository;
    }

    public List<EntradaEncomenda> findAll() {
        return entradaEncomendaRepository.findAll();
    }

    public EntradaEncomenda findById(String id) {
        return entradaEncomendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrada de Encomenda", "id", id));
    }

    public EntradaEncomenda save(EntradaEncomenda entradaEncomenda) {
        if (entradaEncomenda.getId() == null || entradaEncomenda.getId().isEmpty()) {
            entradaEncomenda.setId(UUID.randomUUID().toString());
        }
        return entradaEncomendaRepository.save(entradaEncomenda);
    }

    public EntradaEncomenda update(String id, EntradaEncomenda entradaEncomenda) {
        // Verifica se a entrada existe
        findById(id);
        
        entradaEncomenda.setId(id);
        return entradaEncomendaRepository.save(entradaEncomenda);
    }

    public void delete(String id) {
        // Verifica se a entrada existe
        findById(id);
        
        entradaEncomendaRepository.deleteById(id);
    }
} 