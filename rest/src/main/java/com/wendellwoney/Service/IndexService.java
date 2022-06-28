package com.wendellwoney.Service;

import com.wendellwoney.Model.ResponseModel;

public class IndexService implements IIndexService{
    @Override
    public ResponseModel sum(Double valueOne, Double valueTwo) throws OperationException {
        try {
            return new ResponseModel(false,"Request Sum Sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation sun!");
        }
    }

    @Override
    public ResponseModel minus(Double valueOne, Double valueTwo) throws OperationException {
        try {
            return new ResponseModel(false,"Request Sum Sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation minus!");
        }
    }

    @Override
    public ResponseModel mutiply(Double valueOne, Double valueTwo) throws OperationException {
        try {
            return new ResponseModel(false,"Request Sum Sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation mutiply!");
        }
    }

    @Override
    public ResponseModel division(Double valueOne, Double valueTwo) throws OperationException {
        try {
            return new ResponseModel(false,"Request Sum Sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation division!");
        }
    }
}
