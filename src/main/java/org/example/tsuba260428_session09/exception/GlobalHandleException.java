package org.example.tsuba260428_session09.exception;

import org.example.tsuba260428_session09.model.dto.response.ApiResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ApiResponse
                .<Map<String, String>>builder()
                .status(400)
                .message("Dữ liệu gửi lên không hợp lệ")
                .data(errors)
                .build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ApiResponse<String>  handleNoSuchElementException(NoSuchElementException ex) {
        return ApiResponse
                .<String>builder()
                .status(404)
                .message("Lỗi Hệ Thống")
                .data(ex.getMessage())
                .build();
    }
}
