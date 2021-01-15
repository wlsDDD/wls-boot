package cn.erectpine.mybootdemo.common.annotation;


import cn.erectpine.mybootdemo.common.enums.BusinessEnum;

import java.lang.annotation.*;

/**
 * 自定义记录接口日志注解
 *
 * @author wls
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    
    /**
     * 请求数据类型
     */
    BusinessEnum value() default BusinessEnum.OTHER;
    
    /**
     * 模块
     */
    String title() default "";
    
}
