package com.desafio.dto;

import com.desafio.model.ArquivoModel;
import com.desafio.model.DiretorioModel;

import java.util.List;

public record DiretorioDto(Long id, String nomeDiretorio, String dataCriacaoDiretorio,
                           List<ArquivoModel> arquivos, List<DiretorioModel> subDiretorios,

                           Long paiDiretorio) {
}
