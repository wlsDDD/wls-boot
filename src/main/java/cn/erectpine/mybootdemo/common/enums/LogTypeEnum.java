package cn.erectpine.mybootdemo.common.enums;

import lombok.Getter;

/**
 * 日志类型枚举
 *
 * @Author wls
 * @Date 2021/1/14 14:13
 */
@Getter
public enum LogTypeEnum {
    /**
     * 日志类型,分隔符
     */
    INFO("\n\n=====================================================接口请求成功=================================================="),
    ERROR("\n\n=====================================================接口请求失败=================================================="),
    ;
    
    private final String delimiter;
    
    LogTypeEnum(String delimiter) {
        this.delimiter = delimiter;
    }
}
