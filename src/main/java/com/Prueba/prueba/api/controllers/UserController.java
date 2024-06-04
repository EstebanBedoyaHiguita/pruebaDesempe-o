package com.Prueba.prueba.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba.prueba.api.dto.Request.UserRequest;
import com.Prueba.prueba.api.dto.Response.UserResponse;
import com.Prueba.prueba.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {
    
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
        @RequestParam(defaultValue =  "1") int page,
        @RequestParam(defaultValue = "5") int size){
            return ResponseEntity.ok(this.userService.getAll(page -1, size));
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable String id){
        return ResponseEntity.ok(this.userService.finById(id));
    }


    @PostMapping
    public ResponseEntity<UserResponse> insert(
        @Validated @RequestBody UserRequest user ){
            return ResponseEntity.ok(this.userService.create(user));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id
    ){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> update(
        @Validated @PathVariable String id,
        @RequestBody UserRequest user){
            return ResponseEntity.ok(this.userService.update(user, id));
        }



    



}
