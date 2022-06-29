package com.wendellwoney.rest.Controller;

import com.wendellwoney.rest.Model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("${api.path}")
public interface IIndexController {

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    ResponseEntity<ResponseModel> sum(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);

    @RequestMapping(value = "/minus", method = RequestMethod.GET)
    ResponseEntity<ResponseModel> minus(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);

    @RequestMapping(value = "/mutiply", method = RequestMethod.GET)
    ResponseEntity<ResponseModel> mutiply(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);

    @RequestMapping(value = "/division", method = RequestMethod.GET)
    ResponseEntity<ResponseModel> division(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);
}
