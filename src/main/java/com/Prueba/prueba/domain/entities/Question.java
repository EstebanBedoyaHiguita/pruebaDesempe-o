package com.Prueba.prueba.domain.entities;

import java.util.List;

import com.Prueba.prueba.Utils.enums.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Lob
    private String text;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(nullable = false)
    
    private Boolean active;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id",
    referencedColumnName = "id")
    private Survey survey;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "question",
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<OptionQuestion> optionQuestions;
    
}
