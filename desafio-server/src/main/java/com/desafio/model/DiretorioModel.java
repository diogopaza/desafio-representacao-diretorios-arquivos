package com.desafio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "TB_DIRETORIO")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiretorioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nomeDiretorio;
    @Column(nullable = false)
    private LocalDateTime dataCriacaoDiretorio;
    @OneToMany(mappedBy = "diretorio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArquivoModel> arquivos;



}
