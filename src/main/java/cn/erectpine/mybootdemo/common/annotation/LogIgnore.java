package cn.erectpine.mybootdemo.common.annotation;

import cn.erectpine.mybootdemo.common.enums.IgnoreLevelEnum;

import java.lang.annotation.*;

/**
 * 日志忽略
 *
 * @author wls
 * @date 2021/01/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogIgnore {
    /**
     * 默认不忽略日志
     */
    IgnoreLevelEnum[] ignores() default { IgnoreLevelEnum.NONE };
}