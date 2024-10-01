package com.desafio.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArquivoModelTest {

    @Test
    @DisplayName("Criar ArquivoModel")
    void testCriarArquivoModel(){

        var arquivo = new ArquivoModel(1L, "Arquivo.teste",
                LocalDateTime.now().toString(), null);
        assertNotNull(arquivo);
        assertEquals(1L, arquivo.getId());
        assertEquals("Arquivo.teste", arquivo.getNomeArquivo());
        assertNotNull(arquivo.getDataCriacaoArquivo());
        assertNull(arquivo.getDiretorio());
    }
}
