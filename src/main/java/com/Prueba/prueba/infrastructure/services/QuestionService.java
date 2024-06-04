package com.Prueba.prueba.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Prueba.prueba.Utils.exceptions.IdNotFoundException;
import com.Prueba.prueba.api.dto.Request.QuestionRequest;
import com.Prueba.prueba.api.dto.Response.QuestionResponse;
import com.Prueba.prueba.api.dto.Response.SurveyResponse;
import com.Prueba.prueba.domain.entities.Question;
import com.Prueba.prueba.domain.entities.Survey;
import com.Prueba.prueba.domain.repositories.QuestionRepository;
import com.Prueba.prueba.domain.repositories.SurveyRepository;
import com.Prueba.prueba.infrastructure.abstract_services.IQuestionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {
    @Autowired
    public final SurveyRepository surveyRepository;

    @Autowired
    public final QuestionRepository questionRepository;

    @Override
    public Page<QuestionResponse> getAll(int page, int size) {
        if(page < 0)
        page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.questionRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public QuestionResponse finById(String id) {
        Question question = this.find(id);

        return this.entityToResponse(question);
    }

    @Override
    public QuestionResponse create(QuestionRequest request) {
        Survey survey = this.surveyRepository.findById(request.getSurvey_id())
        .orElseThrow(()-> new IdNotFoundException("survey"));

        Question question = this.requestToEntity(request, new Question());
        question.setSurvey(survey);

        return this.entityToResponse(this.questionRepository.save(question));
    }

    @Override
    public QuestionResponse update(QuestionRequest request, String id) {
        Question questionUpdate = this.find(id);

        Question question = this.requestToEntity(request, questionUpdate);

        return this.entityToResponse(this.questionRepository.save(question));

    }

    @Override
    public void delete(String id) {
        Question question = this.find(id);

        this.questionRepository.delete(question);

    }

    private QuestionResponse entityToResponse(Question entity){
        QuestionResponse response = new QuestionResponse();
        BeanUtils.copyProperties(entity, response);

        SurveyResponse surveyDto = new SurveyResponse();
        BeanUtils.copyProperties(response, surveyDto);
        response.setSurvey(surveyDto);

        return response;
    
    }

    private Question requestToEntity (QuestionRequest request, Question question){
        BeanUtils.copyProperties(request, question);

        return question;
    }

    private Question find(String id){
        return this.questionRepository.findById(id).orElseThrow(()-> new IdNotFoundException(id));
    }
    
}
