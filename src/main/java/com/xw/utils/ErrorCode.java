package com.xw.utils;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

public enum ErrorCode implements IErrorCode {

    TEST(1000, "测试错误编码"),
    DATA_ERROR(2L,"参数错误"),
    DOT_LOGIN(-3,"未登录");

    private long code;
    private String msg;

    ErrorCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
