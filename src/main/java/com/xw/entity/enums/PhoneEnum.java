package com.xw.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 运营商联系电话枚举
 * @author geshijie
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PhoneEnum implements IEnum<String> {
    /**
     * CUCC 中国联通
     */
    CUCC("10010", "中国联通"),
    /**
     * CT 中国电信
     */
    CT("10000", "中国电信"),
    /**
     * CMCC 中国移动
     */
    CMCC("10086", "中国移动");

    private String value;
    private String desc;

    PhoneEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }
}
