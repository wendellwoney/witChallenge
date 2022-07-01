package com.wendellwoney.rest.Controller;

import com.wendellwoney.rest.Controller.Interface.IIndexController;
import com.wendellwoney.rest.Model.ResponseModel;
import com.wendellwoney.queue.Exception.OperationException;
import com.wendellwoney.rest.Service.IIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Api(tags = "Operations")
@Tag(name = "Operations", description = "Rest for operations math")
@RestController
public class IndexController implements IIndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IIndexService service;

    @ApiOperation(value = "Send mathematical sum operation")
    @Override
    public ResponseEntity<ResponseModel> sum(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.sum(valueOne, valueTwo));
        } catch (OperationException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @ApiOperation(value = "Send mathematical minus operation")
    @Override
    public ResponseEntity<ResponseModel> minus(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.minus(valueOne,valueTwo));
        } catch (OperationException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @ApiOperation(value = "Send mathematical multiply operation")
    @Override
    public ResponseEntity<ResponseModel> multiply(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.multiply(valueOne,valueTwo));
        } catch (OperationException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

    @ApiOperation(value = "Send mathematical division operation")
    @Override
    public ResponseEntity<ResponseModel> division(Double valueOne, Double valueTwo) {
        try {
            return ResponseEntity.ok(service.division(valueOne, valueTwo));
        } catch (OperationException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }
}
