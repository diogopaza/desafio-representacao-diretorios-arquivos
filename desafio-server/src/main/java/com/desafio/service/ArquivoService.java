package com.desafio.service;

import com.desafio.dto.ArquivoDto;
import com.desafio.dto.DiretorioDto;
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

    public ArquivoModel saveArquivo(ArquivoDto arquivoDto) throws Exception {
        var arquivo = new ArquivoModel();
        if(arquivoDto.diretorio() != null){
            var diretorio = diretorioService.findDiretorioById(arquivoDto.diretorio());
            arquivo.setDiretorio(diretorio);
        }
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        BeanUtils.copyProperties(arquivoDto, arquivo);
        arquivo.setDataCriacaoArquivo(LocalDateTime.now().format(dateFormatter));

        return arquivoRepository.save(arquivo);
    }
    public List<ArquivoModel> allArquivos() throws Exception{
        try{
            return arquivoRepository.findAll();
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public List<ArquivoModel> allArquivosNaRaiz() throws Exception{
        try{
            return arquivoRepository.allArquivosRaiz();
        } catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public Object deleteArquivo(Long id) throws Exception {
        arquivoRepository.findById(id).orElseThrow(() ->
                new Exception("Arquivo não localizado"));
        arquivoRepository.deleteById(id);
        return null;
    }

    public Object updateArquivo(Long id, ArquivoDto arquivoDto) throws Exception{
        try{
            var arquivo = arquivoRepository.findById(id);
            if(!arquivo.isPresent()){
                throw new Exception("Arquivo não localizado!");
            }
            if(arquivoDto.diretorio() != null){
                var novoDiretorio = diretorioService.findDiretorioById(arquivoDto.diretorio());
                arquivo.get().setDiretorio(novoDiretorio);
            }
            if(arquivoDto.nomeArquivo() != null){
                arquivo.get().setNomeArquivo(arquivoDto.nomeArquivo());
            }
            arquivoRepository.save(arquivo.get());
            return arquivo.get();
        }catch (Exception ex){
            throw new Exception("Erro ao atualizar arquivo");
        }
    }
}



