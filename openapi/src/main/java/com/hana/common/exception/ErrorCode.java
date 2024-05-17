package com.hana.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum ErrorCode {
    NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND"),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
    EMAIL_DUPLICATION(400,"MEMBER-ERR-400","EMAIL DUPLICATED"),
    NAME_DUPLICATION(401,"MEMBER-ERR-401","NAME DUPLICATED"),
    ;

    private int status;
    private String errorCode;
    private String message;
}
