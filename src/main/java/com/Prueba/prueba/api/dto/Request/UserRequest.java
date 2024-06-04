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
public class UserRequest {
    
    private String id;
    @NotNull(message= "The name of the user is required")
    private String name;
    @NotNull(message = "The email of the user is required")
    private String email;
    @NotNull(message =  "The password of the user is required")
    private String password;
    private Boolean active;
}
