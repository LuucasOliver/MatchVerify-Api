package com.api.encomendas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "entrada_encomenda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaEncomenda {

    @Id
    @Column(length = 255)
    private String id;
    
    @Column(length = 255, nullable = false)
    private String entrada_encomenda;
    
    @Column(nullable = false)
    private LocalTime horario_entrada;
    
    @Column(nullable = true)
    private LocalDate data_entrada;
} 