package com.wendellwoney.rest.Controller;

import com.wendellwoney.rest.Model.ResponseModel;
import com.wendellwoney.rest.Service.IndexService;
import com.wendellwoney.rest.Service.OperationException;
import com.wendellwoney.rest.Service.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements IIndexController {

    @Autowired
    private IIndexService service;

    @Override
    public ResponseEntity<ResponseModel> sum(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.sum(valueOne, valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ResponseModel> minus(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.minus(valueOne,valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ResponseModel> mutiply(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.mutiply(valueOne,valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ResponseModel> division(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.division(valueOne, valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

}
