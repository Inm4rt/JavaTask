package com.example.task.ControllerAdvice;

import com.example.task.TaskApplication;
import com.example.task.exceptions.AddException;
import com.example.task.exceptions.BusinessException;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApiHandler {
    private static final Logger log = LoggerFactory.getLogger(TaskApplication.class);
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleException(BusinessException exception) {
        log.error("человек не найден");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @ExceptionHandler(AddException.class)
    public ResponseEntity<String> addException(BusinessException exception) {
        log.error("ошибка при добавлении");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> onConstraintValidationException(ConstraintViolationException e) {
        log.error("данные не коректны");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("не коректные данные");
    }
}
