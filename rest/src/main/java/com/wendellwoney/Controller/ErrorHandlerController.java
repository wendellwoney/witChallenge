package com.wendellwoney.Controller;

import com.wendellwoney.Model.ResponseModel;
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

    @ExceptionHandler(value={NoHandlerFoundException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseModel> badRequest(Exception e, HttpServletRequest request, HttpServletResponse response) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body(new ResponseModel(true, "Request not found"));
    }
}
