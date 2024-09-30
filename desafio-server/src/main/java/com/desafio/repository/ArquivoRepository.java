package com.desafio.repository;

import com.desafio.model.ArquivoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquivoRepository extends JpaRepository<ArquivoModel, Long> {

    @Query(value = "SELECT * FROM tb_arquivo tb_a \n" +
            "WHERE tb_a.diretorio_id IS NULL ", nativeQuery = true)
    List<ArquivoModel> allArquivosRaiz();


    /*@Query(value = "UPDATE tb_arquivo tb_a \n" +
            "SET tb_a.diretorio_id = ?2 \n" +
            "WHERE tb_a.id = ?1  ", nativeQuery = true)
    void updateArquivo(Long id, Long novoDiretorio);*/
}
