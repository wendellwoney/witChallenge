package com.wendellwoney.Controller;

import com.wendellwoney.Model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("${api.path}")
public interface IRestController {

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> sum(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);

    @RequestMapping(value = "/minus", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> minus(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);

    @RequestMapping(value = "/mutiply", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> mutiply(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);

    @RequestMapping(value = "/division", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> division(@RequestParam(value = "a") Double valueOne, @RequestParam(value = "b") Double valueTwo);
}
