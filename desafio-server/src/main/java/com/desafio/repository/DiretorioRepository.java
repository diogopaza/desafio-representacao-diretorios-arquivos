package com.desafio.repository;

import com.desafio.model.DiretorioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorioRepository extends JpaRepository<DiretorioModel, Long> {
}
