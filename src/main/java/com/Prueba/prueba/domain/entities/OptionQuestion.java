package com.Prueba.prueba.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
    
    private Boolean active;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id",
    referencedColumnName = "id")
    private Question question;
}
