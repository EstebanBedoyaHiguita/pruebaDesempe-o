package com.Prueba.prueba.infrastructure.abstract_services;

import com.Prueba.prueba.api.dto.Request.QuestionRequest;
import com.Prueba.prueba.api.dto.Response.QuestionResponse;

public interface IQuestionService  extends ICrudService<QuestionRequest,QuestionResponse,String>{
    
}
