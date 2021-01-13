package cn.erectpine.mybootdemo.common.annotation;


import cn.erectpine.mybootdemo.common.enums.BusinessType;

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
     * 模块
     */
    String title() default "";
    
    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;
    
}
