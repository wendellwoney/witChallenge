package com.wendellwoney.rest.Controller;

import com.wendellwoney.rest.Controller.Interface.IErroController;
import com.wendellwoney.rest.Model.ResponseModel;
import com.wendellwoney.rest.Queue.Error;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "Operation Erros", position = 3)
@Tag(name = "Operation Erros", description = "Handle With Operations Errors")
@RestController
public class ErrorController implements IErroController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "Return all operations erros")
    @Override
    public ResponseEntity<ArrayList<ResponseModel>> errors () {
        return ResponseEntity.ok(Error.getErrorResponse());
    }


    @ApiOperation(value = "Return error operation")
    @Override
    public ResponseEntity<ResponseModel> error(String uuid) {
        try {
            ResponseModel result = Error.getError(uuid);
            if (result == null) {
                return ResponseEntity.badRequest().body(new ResponseModel(true, "Error operation not found"));
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }

}
