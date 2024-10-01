package com.desafio.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiretorioModelTest {

    @Test
    @DisplayName("Criar DiretorioModel")
    void testCriarDiretorioModel(){

        List<ArquivoModel> arquivos = new ArrayList<>();
        List<DiretorioModel> subDiretorios = new ArrayList<>();

        var diretorio = new DiretorioModel(1L, "Diretorio teste",
                LocalDateTime.now().toString(), arquivos, subDiretorios,
                null);
        assertNotNull(diretorio);
        assertEquals(1L, diretorio.getId());
        assertEquals("Diretorio teste", diretorio.getNomeDiretorio());
        assertNotNull(diretorio.getDataCriacaoDiretorio());
        assertTrue(diretorio.getArquivos().isEmpty());
        assertTrue(diretorio.getSubDiretorios().isEmpty());
        assertNull(diretorio.getPaiDiretorio());
    }

}
