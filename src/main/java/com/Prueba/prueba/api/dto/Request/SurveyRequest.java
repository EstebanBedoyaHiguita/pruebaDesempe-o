package com.Prueba.prueba.api.dto.Request;

import java.time.LocalDate;

import com.Prueba.prueba.api.dto.Response.UserResponse;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {
    
    private String Id;
    @NotNull(message = "The survey title is required")
    private String title;
    @NotNull(message = "The survey description is required")
    private String description;
    @NotNull(message = "The creator id is required")
    private String creator_id;
    private Boolean active;

}
