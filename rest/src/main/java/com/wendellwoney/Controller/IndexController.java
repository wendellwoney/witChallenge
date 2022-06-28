package com.wendellwoney.Controller;

import com.wendellwoney.Model.ResponseModel;
import com.wendellwoney.Service.IIndexService;
import com.wendellwoney.Service.IndexService;
import com.wendellwoney.Service.OperationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements IIndexController {
    @Override
    public ResponseEntity<ResponseModel> sum(Double valueOne, Double valueTwo) {
        try {
            IIndexService service =  new IndexService();
            return ResponseEntity.ok(service.sum(valueOne, valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ResponseModel> minus(Double valueOne, Double valueTwo) {
        try {
            IIndexService service =  new IndexService();
            return ResponseEntity.ok(service.minus(valueOne,valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ResponseModel> mutiply(Double valueOne, Double valueTwo) {
        try {
            IIndexService service =  new IndexService();
            return ResponseEntity.ok(service.mutiply(valueOne,valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ResponseModel> division(Double valueOne, Double valueTwo) {
        try {
            IIndexService service =  new IndexService();
            return ResponseEntity.ok(service.division(valueOne, valueTwo));
        } catch (OperationException e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

}
