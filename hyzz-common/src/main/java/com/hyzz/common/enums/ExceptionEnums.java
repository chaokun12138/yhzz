package com.hyzz.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnums {

    CATEGORY_NOT_FOUND(30000,"该分类不存在");

    private int code;
    private String msg;
}
