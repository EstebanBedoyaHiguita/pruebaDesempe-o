package com.Prueba.prueba.api.dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionquestionRequest {
    
    @NotNull(message = "The option id is required")
    private String id;
    @NotNull(message = "The option text is required")
    private String text;
    @NotNull(message = "The question id is required")
    private String question_id;
    private Boolean active;

}
