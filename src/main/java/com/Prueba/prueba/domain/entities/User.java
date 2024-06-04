package com.Prueba.prueba.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 100, nullable = false)
    private String name;
    @Email(message = "The email must be valide")
    @Column(length = 100, nullable= false)
    private String email;
    @Column(length = 255, nullable= false)
    private String password;

    private Boolean active;
}
