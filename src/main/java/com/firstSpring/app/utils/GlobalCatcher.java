package com.firstSpring.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice // 모든 컨트롤러에서 발생하는 예외 처리 가능
public class GlobalCatcher {

//    @ResponseStatus(HttpStatus.ACCEPTED) // 상태 코드 변경
    @ExceptionHandler(Exception.class)
    public String exceptionCatcher(Exception e){
        return "error";
    }
}
