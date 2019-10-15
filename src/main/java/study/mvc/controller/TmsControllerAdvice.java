package study.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;
import study.core.exception.ArgumentResolverException;
import study.mvc.exception.UserNotFoundException;
import study.mvc.model.ApiError;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class TmsControllerAdvice {

    @ExceptionHandler(ArgumentResolverException.class)
    protected ResponseEntity<Void> handleArgumentResolver() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof UserNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            UserNotFoundException notFoundException = (UserNotFoundException) ex;

            return handleUserNotFoundException(notFoundException, headers, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExcepionInternal(ex, null, headers, status, request);
        }


    }

    public ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException ex,
                                                       HttpHeaders headers,
                                                       HttpStatus status,
                                                       WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getUserId());
        return handleExcepionInternal(ex, new ApiError(errors), headers, status, request);
    }


    public ResponseEntity<ApiError> handleExcepionInternal(Exception ex,
                                                               ApiError body,
                                                               HttpHeaders header,
                                                               HttpStatus status,
                                                               WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, header, status);
    }
}
