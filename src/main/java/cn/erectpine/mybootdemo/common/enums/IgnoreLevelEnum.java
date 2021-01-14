package cn.erectpine.mybootdemo.common.enums;

/**
 * 日志忽略级别
 *
 * @author wls
 * @date 2021/01/13
 */
public enum IgnoreLevelEnum {
    /**
     * 全部
     */
    ALL,
    
    /**
     * 请求
     */
    REQUEST,
    
    /**
     * 返回
     */
    RESPONSE,
    
    /**
     * 堆栈
     */
    STACKTRACE,
    
    /**
     * 无
     */
    NONE
}
