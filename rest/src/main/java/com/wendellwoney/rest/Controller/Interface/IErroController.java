package com.wendellwoney.rest.Controller.Interface;

import com.wendellwoney.rest.Model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@RequestMapping("${api.path}")
public interface IErroController {
    @RequestMapping(value = "/errors", method = RequestMethod.GET)
    ResponseEntity<ArrayList<ResponseModel>> errors ();

    @RequestMapping(value = "/error/{uuid}", method = RequestMethod.GET)
    ResponseEntity<ResponseModel> error (@PathVariable(required=false,name="uuid") String uuid);
}
