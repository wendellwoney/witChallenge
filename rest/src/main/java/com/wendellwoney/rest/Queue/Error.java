package com.wendellwoney.rest.Queue;

import com.wendellwoney.queue.Dto.ErrorDto;
import com.wendellwoney.queue.Dto.ResultDto;
import com.wendellwoney.rest.Model.ResponseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Error {
    public static HashMap<String, ErrorDto> errors = new HashMap<String, ErrorDto>();

    public static HashMap<String, ErrorDto> getAll() {
        return errors;
    }

    public static ResponseModel getError(String uuid) {
        ErrorDto error = errors.get(uuid);
        if (error != null) {
            return new ResponseModel(error);
        }
        return null;
    }

    public static void setError(String uuid, ErrorDto error) {
        errors.put(uuid, error);
    }

    public static ArrayList<ResponseModel> getErrorResponse() {
        ArrayList<ResponseModel> arrayResponseModel = new ArrayList<ResponseModel>();

        if (errors == null) {
            return arrayResponseModel;
        }

        for (Map.Entry<String, ErrorDto> error : errors.entrySet()) {
            arrayResponseModel.add(new ResponseModel(error.getValue()));
        }

        return arrayResponseModel;
    }
}
