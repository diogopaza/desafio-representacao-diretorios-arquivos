package com.desafio.service;

import com.desafio.dto.DiretorioDto;
import com.desafio.model.DiretorioModel;
import com.desafio.repository.DiretorioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class DiretorioService {

    DiretorioRepository diretorioRepository;

    @Transactional
    public DiretorioModel saveDiretorio(DiretorioDto diretorioDto){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        var diretorio = DiretorioModel.builder()
                        .nomeDiretorio(diretorioDto.nomeDiretorio())
                        .dataCriacaoDiretorio(LocalDateTime.now().format(dateFormatter))
                        .build();
        return diretorioRepository.save(diretorio);
    }
    public List<DiretorioModel> allDiretorios(){
        try{
            return diretorioRepository.findAll();
        } catch (Exception ex){
            new Exception(ex.getMessage());
        }
        return null;
    }

    @Transactional
    public DiretorioModel saveSubDiretorio(DiretorioDto diretorioDto){

        var diretorioPai = findDiretorioById(diretorioDto.paiDiretorio());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        var subDiretorio = DiretorioModel.builder()
                .nomeDiretorio(diretorioDto.nomeDiretorio())
                .dataCriacaoDiretorio(LocalDateTime.now().format(dateFormatter))
                .paiDiretorio(diretorioPai)
                .build();
        return diretorioRepository.save(subDiretorio);
    }

    public DiretorioModel findDiretorioById(Long id){
        try{
            return diretorioRepository.findById(id).orElseThrow(() ->
                    new Exception("Diretório não localizado"));
        } catch (Exception ex){
            new Exception(ex.getMessage());
        }
        return null;
    }

}
