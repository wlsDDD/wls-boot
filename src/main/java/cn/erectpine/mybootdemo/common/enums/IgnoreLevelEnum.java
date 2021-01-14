package cn.erectpine.mybootdemo.common.enums;

/**
 * 日志忽略级别
 *
 * @author wls
 * @date 2021/01/13
 */
public enum IgnoreLevelEnum {
    /**
     * 请求,返回,堆栈 全忽略
     */
    ALL,
    
    /**
     * 请求数据
     */
    REQUEST_DATA,
    
    /**
     * 返回数据
     */
    RESPONSE_DATA,
    
    /**
     * 堆栈日志
     */
    STACKTRACE,
    
}
