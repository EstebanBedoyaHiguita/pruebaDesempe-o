package com.Prueba.prueba.api.dto.Response;

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
    private User user;
    private Boolean active;
}
