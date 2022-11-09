package com.eric.excel.exception;

import com.eric.excel.dto.ApiError;
import com.eric.excel.dto.ErrorDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<ErrorDTO> errorDTOList = fieldErrors.stream().map(error -> new ErrorDTO.Builder()
                .errorCode(error.getCode())
                .errorMessage(error.getDefaultMessage())
                .build()).collect(Collectors.toList());
        ApiError apiError = new ApiError.Builder()
                .errorDTOList(errorDTOList)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrityViolation(DataIntegrityViolationException exception) {
        String message = exception.getMessage();
        List<ErrorDTO> errorDTOList = new ArrayList<>();
        errorDTOList.add(new ErrorDTO(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),exception.getMessage()));
        ApiError apiError = new ApiError.Builder()
                .errorDTOList(errorDTOList)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}
