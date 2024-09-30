package com.desafio.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "TB_ARQUIVO")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArquivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nomeArquivo;

    @Column(nullable = false)
    private String dataCriacaoArquivo;

    @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "diretorio_id", nullable = true)
    private DiretorioModel diretorio;
}
