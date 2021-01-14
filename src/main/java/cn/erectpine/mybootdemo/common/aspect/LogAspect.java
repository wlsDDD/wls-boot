package cn.erectpine.mybootdemo.common.aspect;

import cn.erectpine.mybootdemo.common.annotation.LogIgnore;
import cn.erectpine.mybootdemo.common.enums.CodeMsgEnum;
import cn.erectpine.mybootdemo.common.enums.LogTypeEnum;
import cn.erectpine.mybootdemo.common.util.Assert;
import cn.erectpine.mybootdemo.common.util.IpUtils;
import cn.erectpine.mybootdemo.common.util.ServletUtils;
import cn.erectpine.mybootdemo.common.web.ApiLog;
import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 日志切面
 *
 * @author 16269
 * @date 2021/01/13
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    
    /**
     * 配置织入点
     */
    @Pointcut("execution(* cn.erectpine.mybootdemo.project.*.controller..*.*(..))")
    public void logPointCut() {
    }
    
    @Around("logPointCut()")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable {
        LogIgnore logIgnore = getAnnotationLog(joinPoint, LogIgnore.class);
    
        // 开始记录日志
        ApiLog apiLog = new ApiLog();
        if (logIgnore == null) {
            apiLog.setRequestData(JSON.toJSONString(joinPoint.getArgs()));
        } else if (logIgnore.ignoreRequestData()) {
            apiLog.setRequestData(JSON.toJSONString(joinPoint.getArgs()));
        }
        
        Object proceed = null;
        // 调用方法
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            // 记录异常日志
            if (logIgnore == null) {
                apiLog.setStacktrace(JSON.toJSONString(e, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
            } else if (logIgnore.ignoreStacktrace()) {
                apiLog.setStacktrace(JSON.toJSONString(e, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
            }
            apiLog.setStatus(CodeMsgEnum.FAIL.getCode())
                  .setErrorMessage(e.getMessage());
            throw e;
        } finally {
            if (logIgnore == null) {
                apiLog.setResponseData((JSON.toJSONString(proceed)));
            } else if (logIgnore.ignoreResponseData()) {
                apiLog.setResponseData((JSON.toJSONString(proceed)));
            }
            HttpServletRequest request = ServletUtils.getRequest();
            if (apiLog.getResponseData() == null) {
                apiLog.setResponseData((JSON.toJSONString(proceed)));
            }
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            // 记录日志
            Assert.notNull(request, "请求对象不能为空");
            apiLog.setEndTime(LocalDateTime.now())
                  .setExecutionTime(Duration.between(apiLog.getStartTime(), apiLog.getEndTime()).toMillis())
                  .setIp(IpUtils.getIpAddr(request))
                  .setUrl(request.getRequestURL().toString())
                  .setAuthorization(request.getHeader("Authorization"))
                  .setMethod(className + "." + methodName + "()");
            consoleLog(apiLog);
        }
        
        return proceed;
    }
    
    /**
     * 将日志输出到控制台
     * TODO 将日志保存到数据库
     *
     * @param apiLog 日志信息
     */
    @Async
    public void consoleLog(ApiLog apiLog) {
        Map<String, Object> logMap = BeanUtil.beanToMap(apiLog, false, true);
        if (CodeMsgEnum.SUCCESS.getCode().equals(apiLog.getStatus())) {
            log.info(LogTypeEnum.INFO.getDelimiter());
            logMap.forEach((s, o) -> log.info(s + ": {}", o));
        } else {
            log.warn(LogTypeEnum.ERROR.getDelimiter());
            logMap.forEach((s, o) -> log.warn(s + ": {}", o));
        }
        
    }
    
    /**
     * 是否存在注解，如果存在就获取
     */
    private <T extends Annotation> T getAnnotationLog(JoinPoint joinPoint, Class<T> clazz) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        
        if (method != null) {
            return method.getAnnotation(clazz);
        }
        return null;
    }
    
}
