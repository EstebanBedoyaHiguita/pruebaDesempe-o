package com.Prueba.prueba.api.dto.Response;

import java.util.List;

import com.Prueba.prueba.Utils.enums.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private String id;
    private String text;
    private Type type;
    private SurveyResponse survey;
    private List<OptionquestionResponse> options;
    
}
