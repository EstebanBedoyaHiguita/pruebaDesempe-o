package com.Prueba.prueba.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prueba.prueba.domain.entities.Question;

public interface QuestionRepository  extends JpaRepository<Question,String>{
    
}
