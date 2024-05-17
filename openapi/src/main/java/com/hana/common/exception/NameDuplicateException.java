package com.hana.common.exception;

import lombok.Getter;

@Getter
public class NameDuplicateException extends RuntimeException{

    private ErrorCode errorCode;

    public NameDuplicateException(String message, ErrorCode errorCode){
        super(message);
        //this.errorCode.se
        this.errorCode = errorCode;
    }
}