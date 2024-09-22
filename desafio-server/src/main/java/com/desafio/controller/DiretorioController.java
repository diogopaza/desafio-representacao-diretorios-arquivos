package com.desafio.controller;

import com.desafio.dto.DiretorioDto;
import com.desafio.service.DiretorioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diretorio")
@AllArgsConstructor
public class DiretorioController {

    private final DiretorioService diretorioService;

    @GetMapping
    public ResponseEntity<Object> allDiretorios(){
        return ResponseEntity.ok().body(diretorioService.allDiretorios());
    }
    @PostMapping
    public ResponseEntity<Object> createDiretorio(@RequestBody DiretorioDto diretorioDto){
        try{
            return ResponseEntity.ok().body(diretorioService.saveDiretorio(diretorioDto));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Não foi possível criar o Diretótio");
        }
    }



}
