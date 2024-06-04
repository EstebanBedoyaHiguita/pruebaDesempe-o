package com.Prueba.prueba.api.dto.Response;

import java.time.LocalDate;

import com.Prueba.prueba.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResponse {
    private String Id;
    private String title;
    private String description;
    private LocalDate creation_date;
    private UserResponse user_id;
    private Boolean active;
}
