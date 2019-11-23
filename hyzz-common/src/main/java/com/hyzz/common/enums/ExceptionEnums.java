package com.hyzz.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnums {

    CATEGORY_NOT_FOUND(30000,"该分类不存在"),
    CHECK_CODE_EXCEPTION(1000,"验证码错误"),
    NUMBER_ALREADY_EXISTS(10001,"手机号已存在"),
    EMAIL_ALREADY_EXISTS(10002,"邮箱已存在"),
    USER_IS_BAN(10003,"您已被封禁");

    private int code;
    private String msg;
}
