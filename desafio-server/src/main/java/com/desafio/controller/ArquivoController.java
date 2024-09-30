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
@RequestMapping("/arquivos")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ArquivoController {

    private final ArquivoService arquivoService;

    @GetMapping
    public List<ArquivoModel> allArquivos() throws Exception{
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

    @GetMapping("/todosarquivosnaraiz")
    public List<ArquivoModel> allArquivosNaRaiz() throws Exception{
        var arquivos = arquivoService.allArquivosNaRaiz();
        return arquivos;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArquivo(@PathVariable Long id) throws Exception {
        try{
            arquivoService.deleteArquivo(id);
            return ResponseEntity.ok().body("Arquivo excluído com sucesso!");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateArquivo(@PathVariable Long id,
                                                  @RequestBody ArquivoDto arquivoDto) throws Exception{
        try{
            return ResponseEntity.ok().body(arquivoService.updateArquivo(id, arquivoDto));
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}

