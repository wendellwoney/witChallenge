package com.wendellwoney.Controller;

import com.wendellwoney.Model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements IRestController {
    @Override
    public ResponseEntity<ResponseModel> sum(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(new ResponseModel(false,"Request Sent"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }
}
