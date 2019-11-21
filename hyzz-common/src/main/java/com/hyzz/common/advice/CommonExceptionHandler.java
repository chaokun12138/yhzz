package com.hyzz.common.advice;

import com.hyzz.common.enums.ExceptionEnums;
import com.hyzz.common.exception.HyzzException;
import com.hyzz.common.pojo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    //该方法表示处理的异常类型
    @ExceptionHandler(HyzzException.class)
    public ResponseEntity<ExceptionResult> handleException(HyzzException e){
        ExceptionEnums exceptionEnums =e.getExceptionEnums();
        //我们暂定返回状态码为400，然后从异常中获取的提示信息
        ExceptionResult result = new ExceptionResult(exceptionEnums);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
