package com.desafio.service;


import com.desafio.dto.DiretorioDto;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
class DiretorioServiceTest {

    @Autowired
    private DiretorioService diretorioService;

    @BeforeEach
    public void instanciarDependencias(){
       // diretorioService = mock
    }

    //@Test
    @DisplayName("Sucesso ao criar novo diretorio")
    void saveDiretorioSuccess() {
        var diretorioDto = this.createDiretorio();
        var response = diretorioService.saveDiretorio(diretorioDto);



    }

    //@Test
    void allDiretorios() {
    }

    //@Test
    void saveSubDiretorio() {
    }

    //@Test
    void findDiretorioById() {
    }

    //@Test
    void deleteDiretorio() {
    }

    //@Test
    void updateDiretorio() {
    }

    private DiretorioDto createDiretorio(){
        DiretorioDto diretorioDto = new DiretorioDto(null,"Novo diretorio",null,
                                               null,null,null);
        return diretorioDto;
    }
}
