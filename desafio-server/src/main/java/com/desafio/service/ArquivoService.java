package com.desafio.service;

import com.desafio.dto.ArquivoDto;
import com.desafio.model.ArquivoModel;
import com.desafio.model.DiretorioModel;
import com.desafio.repository.ArquivoRepository;
import com.desafio.repository.DiretorioRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class ArquivoService {

    private final ArquivoRepository arquivoRepository;
    private final DiretorioService diretorioService;

    public ArquivoModel saveArquivo(ArquivoDto arquivoDto){
        var diretorio = diretorioService.findDiretorioById(arquivoDto.diretorio());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        /*var arquivo = ArquivoModel.builder()
                .nomeArquivo(arquivoDto.nomeArquivo())
                .dataCriacaoArquivo(LocalDateTime.now().format(dateFormatter))
                .diretorio(diretorio)
                .build();*/
        var arquivo = new ArquivoModel();
        BeanUtils.copyProperties(arquivoDto, arquivo);
        arquivo.setDataCriacaoArquivo(LocalDateTime.now().format(dateFormatter));
        if(diretorio != null){
            arquivo.setDiretorio(diretorio);
        }
        return arquivoRepository.save(arquivo);
    }
    public List<ArquivoModel> allArquivos(){
        try{
            return arquivoRepository.findAll();
        } catch (Exception ex){
            new Exception(ex.getMessage());
        }
        return null;
    }
}



