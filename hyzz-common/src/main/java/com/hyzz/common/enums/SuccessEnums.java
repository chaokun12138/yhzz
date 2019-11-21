package com.hyzz.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SuccessEnums {
    ADD_OK(1111,"添加成功"),
    UPDATE_OK(2222,"修改成功"),
    DEL_OK(3333,"删除成功");

    private int code;
    private String msg;

}
