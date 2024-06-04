package com.Prueba.prueba.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
    private String creator_id;
    private Boolean active;
}
