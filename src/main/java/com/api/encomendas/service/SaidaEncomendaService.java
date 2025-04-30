package com.api.encomendas.service;

import com.api.encomendas.exception.ResourceNotFoundException;
import com.api.encomendas.model.SaidaEncomenda;
import com.api.encomendas.repository.SaidaEncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SaidaEncomendaService {

    private final SaidaEncomendaRepository saidaEncomendaRepository;

    @Autowired
    public SaidaEncomendaService(SaidaEncomendaRepository saidaEncomendaRepository) {
        this.saidaEncomendaRepository = saidaEncomendaRepository;
    }

    public List<SaidaEncomenda> findAll() {
        return saidaEncomendaRepository.findAll();
    }

    public SaidaEncomenda findById(String id) {
        return saidaEncomendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Saída de Encomenda", "id", id));
    }

    public SaidaEncomenda save(SaidaEncomenda saidaEncomenda) {
        if (saidaEncomenda.getId() == null || saidaEncomenda.getId().isEmpty()) {
            saidaEncomenda.setId(UUID.randomUUID().toString());
        }
        return saidaEncomendaRepository.save(saidaEncomenda);
    }

    public SaidaEncomenda update(String id, SaidaEncomenda saidaEncomenda) {
        // Verifica se a saída existe
        findById(id);
        
        saidaEncomenda.setId(id);
        return saidaEncomendaRepository.save(saidaEncomenda);
    }

    public void delete(String id) {
        // Verifica se a saída existe
        findById(id);
        
        saidaEncomendaRepository.deleteById(id);
    }
} 