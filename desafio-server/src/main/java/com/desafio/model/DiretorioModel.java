package com.desafio.model;

import com.fasterxml.jackson.annotation.*;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class DiretorioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nomeDiretorio;

    @Column(nullable = false)
    private String dataCriacaoDiretorio;
    @OneToMany(mappedBy = "diretorio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArquivoModel> arquivos;

    @OneToMany(mappedBy = "paiDiretorio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiretorioModel> subDiretorios;

    @ManyToOne
    @JoinColumn(name = "diretorio_pai_id")
    private DiretorioModel paiDiretorio;


}
