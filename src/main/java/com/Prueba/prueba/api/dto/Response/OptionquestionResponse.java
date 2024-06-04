package com.Prueba.prueba.api.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionquestionResponse {
    
    private String id;
    private String text;
    private String question_id;
    
}
