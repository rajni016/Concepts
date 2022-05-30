package com.java_springboot.java_springboot.configuration;

import com.java_springboot.java_springboot.Response.regresponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonErrorHandling {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>getError(Exception e){
        regresponse res=new regresponse();
        res.setResponse(e.getMessage());
        return ResponseEntity.badRequest().body(res);

    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?>getErrorCustomException(Exception e){
        regresponse res=new regresponse();
        res.setResponse(e.getMessage());
        return ResponseEntity.badRequest().body(res);

    }


}
