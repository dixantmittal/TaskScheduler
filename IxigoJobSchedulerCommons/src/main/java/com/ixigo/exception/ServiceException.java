package com.ixigo.exception;

public class ServiceException extends GenericException {
    public ServiceException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
