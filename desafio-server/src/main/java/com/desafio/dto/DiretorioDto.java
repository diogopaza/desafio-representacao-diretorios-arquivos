package com.desafio.dto;

import com.desafio.model.ArquivoModel;
import com.desafio.model.DiretorioModel;

import java.util.List;

public record DiretorioDto(String nomeDiretorio, List<ArquivoModel> arquivo,
                           Long paiDiretorio) {
}
