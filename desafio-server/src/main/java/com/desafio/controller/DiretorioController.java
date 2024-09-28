package com.desafio.controller;

import com.desafio.dto.DiretorioDto;
import com.desafio.model.DiretorioModel;
import com.desafio.service.DiretorioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretorio")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DiretorioController {

    private final DiretorioService diretorioService;

    @GetMapping
    public List<DiretorioModel> allDiretorios(){
        var diretorios = diretorioService.allDiretorios();
        return diretorios;
    }
    @PostMapping
    public ResponseEntity<Object> createDiretorio(@RequestBody DiretorioDto diretorioDto){
        try{
            return ResponseEntity.ok().body(diretorioService.saveDiretorio(diretorioDto));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Não foi possível criar o Diretório");
        }
    }
    @PostMapping("/subdiretorio")
    public ResponseEntity<Object> createSubDiretorio(@RequestBody DiretorioDto diretorioDto){
        try{
            return ResponseEntity.ok().body(diretorioService.saveSubDiretorio(diretorioDto));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Não foi possível criar o Diretório");
        }
    }



}
