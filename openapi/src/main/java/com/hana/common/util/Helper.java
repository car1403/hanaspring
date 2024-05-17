package com.hana.common.util;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.LinkedHashMap;
import java.util.LinkedList;

@Service
public class Helper {


    // @Validated @RequestBody  검증 시 RequestDto의 제약 사항에 대한 오류가 있을 시 오류 메시지를 동시에 여러개 만들어 전송

    public static LinkedList<LinkedHashMap<String, String>> refineErrors(Errors errors) {
        LinkedList errorList = new LinkedList<LinkedHashMap<String, String>>();
        errors.getFieldErrors().forEach(e-> {
            LinkedHashMap<String, String> error = new LinkedHashMap<>();
            error.put("field", e.getField());
            error.put("message", e.getDefaultMessage());
            errorList.push(error);
        });
        return errorList;
    }
}
