package com.api.encomendas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "saida_encomenda")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaidaEncomenda {

    @Id
    @Column(length = 255)
    private String id;
    
    @Column(length = 255, nullable = false)
    private String saida_enco;
    
    @Column(nullable = false)
    private LocalTime hora_saida;
    
    @Column(nullable = true)
    private LocalDate data_saida;
} 