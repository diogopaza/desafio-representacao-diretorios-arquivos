package com.desafio.controller;

import com.desafio.dto.ArquivoDto;
import com.desafio.dto.DiretorioDto;
import com.desafio.model.ArquivoModel;
import com.desafio.model.DiretorioModel;
import com.desafio.service.ArquivoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arquivo")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ArquivoController {

    private final ArquivoService arquivoService;

    @GetMapping
    public List<ArquivoModel> allArquivos(){
        var arquivos = arquivoService.allArquivos();
        return arquivos;
    }
    @PostMapping
    public ResponseEntity<Object> createArquivo(@RequestBody ArquivoDto arquivoDto){
        try{
            return ResponseEntity.ok().body(arquivoService.saveArquivo(arquivoDto));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Não foi possível criar o arquivo");
        }
    }

}

