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
    public DiretorioModel saveDiretorio(DiretorioDto diretorioDto) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        var diretorio = DiretorioModel.builder()
                .nomeDiretorio(diretorioDto.nomeDiretorio())
                .dataCriacaoDiretorio(LocalDateTime.now().format(dateFormatter))
                .build();
        return diretorioRepository.save(diretorio);
    }

    public List<DiretorioModel> allDiretorios() {
        try {
            return diretorioRepository.findAll();
        } catch (Exception ex) {
            new Exception(ex.getMessage());
        }
        return null;
    }

    @Transactional
    public DiretorioModel saveSubDiretorio(DiretorioDto diretorioDto) throws Exception {

        var diretorioPai = findDiretorioById(diretorioDto.paiDiretorio());
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        var subDiretorio = DiretorioModel.builder()
                .nomeDiretorio(diretorioDto.nomeDiretorio())
                .dataCriacaoDiretorio(LocalDateTime.now().format(dateFormatter))
                .paiDiretorio(diretorioPai)
                .build();
        return diretorioRepository.save(subDiretorio);
    }

    public DiretorioModel findDiretorioById(Long id) throws Exception {
            return diretorioRepository.findById(id).orElseThrow(() ->
                    new Exception("Diretório não localizado"));
    }

    public Object deleteDiretorio(Long id) throws Exception {
        diretorioRepository.findById(id).orElseThrow(() ->
                new Exception("Diretório não localizado"));
       diretorioRepository.deleteById(id);
       return null;
    }

    public Object updateDiretorio(Long id, DiretorioDto diretorioDto) throws Exception{
        try{
            var diretorio = diretorioRepository.findById(id);
            if(!diretorio.isPresent()){
                throw new Exception("Diretório não localizado!");
            }
            if(diretorioDto.paiDiretorio() != null){
                var novoDiretorio = findDiretorioById(diretorioDto.paiDiretorio());
                diretorio.get().setPaiDiretorio(novoDiretorio);
            }
            if(diretorioDto.nomeDiretorio() != null){
                diretorio.get().setNomeDiretorio(diretorioDto.nomeDiretorio());
            }
            diretorioRepository.save(diretorio.get());
            return diretorio.get();
        }catch (Exception ex){
            throw new Exception("Erro ao atualizar diretório");
        }
    }
}
