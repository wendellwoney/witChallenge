package com.wendellwoney.rest.Queue;

import com.wendellwoney.queue.Dto.ResultDto;
import com.wendellwoney.rest.Model.ResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Result {

    public static HashMap<String, ResultDto> results = new HashMap<String, ResultDto>();

    public static HashMap<String, ResultDto> getAll() {
        return results;
    }

    public static ResponseModel getResult(String uuid) {
        ResultDto result = results.get(uuid);
        if (result != null) {
            return new ResponseModel(false, uuid, result.getResult());
        }

        return null;
    }

    public static void setResult(String uuid, ResultDto result) {
        results.put(uuid, result);
    }

    public static ArrayList<ResponseModel> getResultResponse() {
        ArrayList<ResponseModel> arrayResponseModel = new ArrayList<ResponseModel>();

        if (results == null) {
            return arrayResponseModel;
        }

        for (Map.Entry<String,ResultDto> result : results.entrySet()) {
            arrayResponseModel.add(new ResponseModel(false, result.getKey(), result.getValue().getResult()));
        }

        return arrayResponseModel;
    }
}
