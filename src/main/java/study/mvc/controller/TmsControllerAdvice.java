package study.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import study.core.exception.ArgumentResolverException;

@ControllerAdvice
public class TmsControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArgumentResolverException.class)
    protected ResponseEntity<Void> handleArgumentResolver() {
        return ResponseEntity.badRequest().build();
    }

}
