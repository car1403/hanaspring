package com.hana.common.exception;

import com.hana.common.dto.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final Response response;
    @ExceptionHandler(NameDuplicateException.class)
    public ResponseEntity<?> handleEmailDuplicateException(NameDuplicateException ex){
        log.error("NameDuplicateException",ex);

        return response.fail(ex.getMessage()+ex.getErrorCode().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex){
        log.error("AccessDeniedException",ex);

        return response.fail("접근 거부 입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex){
        log.error("IllegalArgumentException",ex);

        return response.fail(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex){
        log.error("handleException----------------",ex);
        return response.fail("시스템 오류 입니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}