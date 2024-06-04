package com.Prueba.prueba.infrastructure.abstract_services;

import com.Prueba.prueba.api.dto.Request.UserRequest;
import com.Prueba.prueba.api.dto.Response.UserResponse;

public interface IUserService extends ICrudService<UserRequest,UserResponse,String>{
    
}
