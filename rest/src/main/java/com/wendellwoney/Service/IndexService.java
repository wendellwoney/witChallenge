package com.wendellwoney.Service;

import com.wendellwoney.Model.ResponseModel;
import com.wendellwoney.Tool;

public class IndexService implements IIndexService{
    @Override
    public ResponseModel sum(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();

            return new ResponseModel(false, uuid, "Request sum sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation sun!");
        }
    }

    @Override
    public ResponseModel minus(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();

            return new ResponseModel(false, uuid, "Request minus sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation minus!");
        }
    }

    @Override
    public ResponseModel mutiply(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();

            return new ResponseModel(false, uuid, "Request mutiply sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation mutiply!");
        }
    }

    @Override
    public ResponseModel division(Double valueOne, Double valueTwo) throws OperationException {
        try {
            String uuid = Tool.uuid();

            return new ResponseModel(false, uuid, "Request division sent");
        } catch (Exception e) {
            throw new OperationException("Erro to send operation division!");
        }
    }
}
