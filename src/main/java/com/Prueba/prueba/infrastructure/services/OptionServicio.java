package com.Prueba.prueba.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Prueba.prueba.api.dto.Request.OptionquestionRequest;
import com.Prueba.prueba.api.dto.Response.OptionquestionResponse;
import com.Prueba.prueba.api.dto.Response.QuestionResponse;
import com.Prueba.prueba.domain.entities.OptionQuestion;
import com.Prueba.prueba.domain.repositories.OptionRepository;
import com.Prueba.prueba.domain.repositories.QuestionRepository;
import com.Prueba.prueba.infrastructure.abstract_services.IOptionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OptionServicio implements IOptionService{

    @Autowired
    private final OptionRepository optionRepository;

    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public Page<OptionquestionResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public OptionquestionResponse finById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finById'");
    }

    @Override
    public OptionquestionResponse create(OptionquestionRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public OptionquestionResponse update(OptionquestionRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
