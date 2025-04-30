package com.api.encomendas.repository;

import com.api.encomendas.model.EntradaEncomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaEncomendaRepository extends JpaRepository<EntradaEncomenda, String> {
} 