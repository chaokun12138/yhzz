package com.hyzz.common.exception;

import com.hyzz.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HyzzException extends RuntimeException{
    private ExceptionEnums exceptionEnums;

}
