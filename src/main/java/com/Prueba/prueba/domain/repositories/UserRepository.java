package com.Prueba.prueba.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Prueba.prueba.domain.entities.User;

public interface UserRepository extends JpaRepository< User,String> {
    
}
