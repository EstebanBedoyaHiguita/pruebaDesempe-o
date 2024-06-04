package com.Prueba.prueba.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Prueba.prueba.Utils.exceptions.IdNotFoundException;
import com.Prueba.prueba.api.dto.Request.UserRequest;
import com.Prueba.prueba.api.dto.Response.UserResponse;
import com.Prueba.prueba.domain.entities.User;
import com.Prueba.prueba.domain.repositories.UserRepository;
import com.Prueba.prueba.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if(page < 0)
        page=0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public UserResponse finById(String id) {
        User user = find(id);

        return
         this.entityToResponse(user);
    }

    @Override
    public UserResponse create(UserRequest request) {
        User user = this.requestToEntity(request,new User());

        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse update(UserRequest request, String id) {
        User userUpdate = this.find(id);
        
        User user = this.requestToEntity(request, userUpdate);
        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public void delete(String id) {
        User user = this.find(id);

        this.userRepository.delete(user);
    }

    private User requestToEntity(UserRequest request, User user){
        BeanUtils.copyProperties(request, user);
        System.out.println(user);
        return user;
    }

    private UserResponse entityToResponse(User entity){
        UserResponse response = new UserResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }


    private User find(String id){
        return this.userRepository.findById(id).orElseThrow(()-> new IdNotFoundException("user"));
    }
    
}
