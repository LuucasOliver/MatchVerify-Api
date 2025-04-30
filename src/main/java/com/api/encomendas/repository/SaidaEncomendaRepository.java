package com.api.encomendas.repository;

import com.api.encomendas.model.SaidaEncomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaidaEncomendaRepository extends JpaRepository<SaidaEncomenda, String> {
} 