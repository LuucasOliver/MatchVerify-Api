package com.api.encomendas.service;

import com.api.encomendas.exception.ResourceNotFoundException;
import com.api.encomendas.model.Encomenda;
import com.api.encomendas.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncomendaService {

    private final EncomendaRepository encomendaRepository;

    @Autowired
    public EncomendaService(EncomendaRepository encomendaRepository) {
        this.encomendaRepository = encomendaRepository;
    }

    public List<Encomenda> findAll() {
        return encomendaRepository.findAll();
    }

    public Encomenda findById(Integer id) {
        return encomendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Encomenda", "id", id));
    }

    public Encomenda save(Encomenda encomenda) {
        return encomendaRepository.save(encomenda);
    }

    public Encomenda update(Integer id, Encomenda encomenda) {
        // Verifica se a encomenda existe
        findById(id);
        
        encomenda.setId(id);
        return encomendaRepository.save(encomenda);
    }

    public void delete(Integer id) {
        // Verifica se a encomenda existe
        findById(id);
        
        encomendaRepository.deleteById(id);
    }
} 