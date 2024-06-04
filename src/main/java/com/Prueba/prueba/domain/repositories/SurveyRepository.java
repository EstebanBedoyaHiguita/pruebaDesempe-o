package com.Prueba.prueba.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prueba.prueba.domain.entities.Survey;

public interface SurveyRepository extends JpaRepository<Survey,String>  {
    
}
