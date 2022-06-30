package com.wendellwoney.rest.Service;

import com.wendellwoney.queue.Exception.OperationException;
import com.wendellwoney.rest.Model.ResponseModel;

public interface IIndexService {

    ResponseModel sum(Double valueOne, Double valueTwo) throws OperationException;
    ResponseModel minus(Double valueOne,Double valueTwo) throws OperationException;
    ResponseModel multiply(Double valueOne,Double valueTwo) throws OperationException;
    ResponseModel division(Double valueOne,Double valueTwo) throws OperationException;

}
