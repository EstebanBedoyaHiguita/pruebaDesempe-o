package com.Prueba.prueba.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="optionquestion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Lob
    private String text;
    @Column(nullable = false)
    private String question_id;
    private Boolean active;
    
}
