package cn.erectpine.mybootdemo.common.annotation;


import cn.erectpine.mybootdemo.common.enums.BusinessTypeEnum;

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
    BusinessTypeEnum value() default BusinessTypeEnum.OTHER;
    
    /**
     * 模块
     */
    String title() default "";
    
}
