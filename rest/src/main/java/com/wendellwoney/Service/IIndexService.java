package com.wendellwoney.Service;

import com.wendellwoney.Model.ResponseModel;

public interface IIndexService {

    ResponseModel sum(Double valueOne,Double valueTwo) throws OperationException;
    ResponseModel minus(Double valueOne,Double valueTwo) throws OperationException;
    ResponseModel mutiply(Double valueOne,Double valueTwo) throws OperationException;
    ResponseModel division(Double valueOne,Double valueTwo) throws OperationException;

}
