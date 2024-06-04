package com.Prueba.prueba.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prueba.prueba.domain.entities.OptionQuestion;

public interface OptionRepository extends JpaRepository<OptionQuestion,String> {
    
}
