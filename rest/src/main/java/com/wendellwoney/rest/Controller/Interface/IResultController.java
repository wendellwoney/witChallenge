package com.wendellwoney.rest.Controller.Interface;

import com.wendellwoney.rest.Model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@RequestMapping("${api.path}")
public interface IResultController {
    @RequestMapping(value = "/results", method = RequestMethod.GET)
    ResponseEntity<ArrayList<ResponseModel>> results ();
    @RequestMapping(value = "/result/{uuid}", method = RequestMethod.GET)
    ResponseEntity<ResponseModel> result (@PathVariable(required=false,name="uuid") String uuid);
}
