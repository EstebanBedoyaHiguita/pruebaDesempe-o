package com.Prueba.prueba.api.dto.Request;



import com.Prueba.prueba.Utils.enums.Type;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    @NotNull(message = "The question id is required")
    private String id;
    @NotNull(message = "The question text is required")
    private String text;
    private Type type;
    @NotNull(message = "The survey id is required")
    private String survey_id;
    private Boolean active;
}
