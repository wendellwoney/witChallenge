package com.wendellwoney.rest.Controller;

import com.wendellwoney.rest.Model.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ErrorHandlerController implements ErrorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value={NoHandlerFoundException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> badRequest(Exception e, HttpServletRequest request, HttpServletResponse response) {
        logger.warn("Request not found");
        return ResponseEntity.badRequest().body(new ResponseModel(true, "Request not found"));
    }
}
