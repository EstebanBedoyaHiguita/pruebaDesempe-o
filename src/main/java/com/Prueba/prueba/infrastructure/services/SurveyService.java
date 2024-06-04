package com.Prueba.prueba.infrastructure.services;

import java.time.LocalDate;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Prueba.prueba.Utils.exceptions.IdNotFoundException;
import com.Prueba.prueba.api.dto.Request.SurveyRequest;
import com.Prueba.prueba.api.dto.Response.SurveyResponse;
import com.Prueba.prueba.api.dto.Response.UserResponse;
import com.Prueba.prueba.domain.entities.Survey;
import com.Prueba.prueba.domain.entities.User;
import com.Prueba.prueba.domain.repositories.SurveyRepository;
import com.Prueba.prueba.domain.repositories.UserRepository;
import com.Prueba.prueba.infrastructure.abstract_services.ISurveyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SurveyService  implements ISurveyService{

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final SurveyRepository surveyRepository;


    @Override
    public Page<SurveyResponse> getAll(int page, int size) {
        if(page < 0)
        page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.surveyRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public SurveyResponse finById(String id) {
        Survey survey = this.find(id);

        return this.entityToResponse(survey);
    }

    @Override
    public SurveyResponse create(SurveyRequest request) {
        User user = this.userRepository.findById(request.getCreator_id())
        .orElseThrow(()-> new IdNotFoundException("user"));

        Survey survey = this.requestToEntity(request, new Survey());
        survey.setCreator_id(user);
        return this.entityToResponse(this.surveyRepository.save(survey));
    }

    @Override
    public SurveyResponse update(SurveyRequest request, String id) {
        
        Survey surveyupdate = this.find(id);

        Survey survey = this.requestToEntity(request, surveyupdate);

        return this.entityToResponse(this.surveyRepository.save(survey));
    }

    @Override
    public void delete(String id) {
        Survey survey = this.find(id);

        this.surveyRepository.delete(survey);
    }

    private SurveyResponse entityToResponse(Survey entity){
        SurveyResponse response = new SurveyResponse();

        BeanUtils.copyProperties(entity, response);

        UserResponse userDto = new UserResponse();
        BeanUtils.copyProperties(entity.getCreator_id(), userDto);
        response.setUser_id(userDto);

        return response;
    }

    private Survey requestToEntity (SurveyRequest request, Survey survey){
        BeanUtils.copyProperties(request, survey);
        survey.setCreation_date(LocalDate.now());


        return survey;
    }


    private Survey find(String id){
        return this.surveyRepository.findById(id).orElseThrow(()-> new IdNotFoundException(id));
    }
    
}
