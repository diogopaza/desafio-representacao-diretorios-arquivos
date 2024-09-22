package com.desafio.dto;

import com.desafio.model.ArquivoModel;

import java.util.List;

public record DiretorioDto(String nomeDiretorio, List<ArquivoModel> arquivo) {
}
