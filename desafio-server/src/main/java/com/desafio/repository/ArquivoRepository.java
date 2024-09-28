package com.desafio.repository;

import com.desafio.model.ArquivoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<ArquivoModel, Long> {
}
