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
import com.Prueba.prueba.api.dto.errors.ErrorResponse;
import com.Prueba.prueba.api.dto.errors.ErrorsResponse;
import com.Prueba.prueba.infrastructure.abstract_services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {
    
    private final IUserService userService;

    @Operation(summary = "this method allows get all the list of bookings in paginated form")
    @ApiResponse(responseCode = "400", description = "When the connection with the data base fail", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))})
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
        @RequestParam(defaultValue =  "1") int page,
        @RequestParam(defaultValue = "5") int size){
            return ResponseEntity.ok(this.userService.getAll(page -1, size));
    }


    @Operation(summary = "This method allows you modify a booking for a id especific")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable String id){
        return ResponseEntity.ok(this.userService.finById(id));
    }


    @Operation(summary = "This method allows create a booking with the dates sent")
    @ApiResponse(responseCode = "400", description = "When there is an error in the date sent to the datebase", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))})
    @PostMapping
    public ResponseEntity<UserResponse> insert(
        @Validated @RequestBody UserRequest user ){
            return ResponseEntity.ok(this.userService.create(user));
    }

    @Operation(summary = "This method allows you modify a booking for a id especific")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id
    ){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "This method allows create a booking with the dates sent")
    @ApiResponse(responseCode = "400", description = "When there is an error in the date sent to the datebase", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))})
    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> update(
        @Validated @PathVariable String id,
        @RequestBody UserRequest user){
            return ResponseEntity.ok(this.userService.update(user, id));
        }



    



}
