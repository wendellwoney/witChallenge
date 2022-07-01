package com.wendellwoney.rest.Controller;

import com.wendellwoney.rest.Controller.Interface.IResultController;
import com.wendellwoney.rest.Model.ResponseModel;
import com.wendellwoney.rest.Queue.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "Operation Results", position = 2)
@Tag(name = "Operation Results", description = "Handle With Operations Results")
@RestController
public class ResultController implements IResultController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "Return results for all operations sent")
    @Override
    public ResponseEntity<ArrayList<ResponseModel>> results () {
        return ResponseEntity.ok(Result.getResultResponse());
    }

    @ApiOperation(value = "Return result operation")
    @Override
    public ResponseEntity<ResponseModel> result(String uuid) {
        try {
            ResponseModel result = Result.getResult(uuid);
            if (result == null) {
                return ResponseEntity.badRequest().body(new ResponseModel(true, "Operation not found"));
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseModel(true, e.getMessage()));
        }
    }
}
