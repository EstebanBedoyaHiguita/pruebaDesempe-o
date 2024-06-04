package com.Prueba.prueba.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba.prueba.api.dto.Request.QuestionRequest;
import com.Prueba.prueba.api.dto.Response.QuestionResponse;
import com.Prueba.prueba.api.dto.errors.ErrorResponse;
import com.Prueba.prueba.api.dto.errors.ErrorsResponse;
import com.Prueba.prueba.infrastructure.abstract_services.IQuestionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/question")
@AllArgsConstructor
public class QuestionController {
    
    private final IQuestionService questionService;


    @Operation(summary = "this method allows get all the list of Messages in paginated form")
    @ApiResponse(responseCode = "400", description = "When the connection with the data base fail", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))})
    @GetMapping
    public ResponseEntity<Page<QuestionResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size){
            return ResponseEntity.ok(this.questionService.getAll(page -1, size));
    }

    @Operation(summary = "This method allows you modify a Message for a id especific")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> get (
        @PathVariable String id ){
            return ResponseEntity.ok(this.questionService.finById(id));
    }

    @Operation(summary = "This method allows create a Message with the dates sent")
    @ApiResponse(responseCode = "400", description = "When there is an error in the date sent to the datebase", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))})
    @PostMapping
    public ResponseEntity<QuestionResponse> insert(
        @Validated @RequestBody QuestionRequest question){
            return ResponseEntity.ok(this.questionService.create(question));
    }

    @Operation(summary = "This method allows you modify a Message for a id especific")
    @ApiResponse(responseCode = "400", description = "When the id it's not valid", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id){
            this.questionService.delete(id);
            return ResponseEntity.noContent().build();
    }



    @Operation(summary = "This method allows create a Message with the dates sent")
    @ApiResponse(responseCode = "400", description = "When there is an error in the date sent to the datebase", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResponse.class))})
    @PutMapping("/{id}")
    final ResponseEntity<QuestionResponse> update(
        @Validated @PathVariable String id,
        @RequestBody QuestionRequest question){
            return ResponseEntity.ok(this.questionService.update(question,id));
        }


}
