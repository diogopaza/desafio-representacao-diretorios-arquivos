package com.desafio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "TB_ARQUIVO")
@Getter
@Setter
public class ArquivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nomeArquivo;
    @Column(nullable = false)
    private LocalDateTime dataCriacaoArquivo;
    @ManyToOne
    @JoinColumn(name = "diretorio_id")
    private DiretorioModel diretorio;
}
