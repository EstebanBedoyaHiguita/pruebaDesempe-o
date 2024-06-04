package com.Prueba.prueba.domain.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity(name = "survey")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    @Column(nullable = false)
    private String title;
    @Lob
    private String description;
    @Column(nullable = false)
    private LocalDate creation_date;
    @Column(nullable = false)
    
    private Boolean active;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id",
    referencedColumnName = "id")
    private User creator_id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "survey",
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<Question> questions;
}
