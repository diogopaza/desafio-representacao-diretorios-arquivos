package com.desafio.service;

import com.desafio.dto.DiretorioDto;
import com.desafio.model.DiretorioModel;
import com.desafio.repository.DiretorioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DiretorioService {

    DiretorioRepository diretorioRepository;

    @Transactional
    public DiretorioModel saveDiretorio(DiretorioDto diretorioDto){
        var diretorio = DiretorioModel.builder()
                        .nomeDiretorio(diretorioDto.nomeDiretorio())
                        .dataCriacaoDiretorio(LocalDateTime.now())
                        .build();
        return diretorioRepository.save(diretorio);
    }
    public List<DiretorioModel> allDiretorios(){
        return diretorioRepository.findAll();
    }
}
