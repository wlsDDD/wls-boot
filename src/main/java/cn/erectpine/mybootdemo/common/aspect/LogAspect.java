package cn.erectpine.mybootdemo.common.aspect;

import cn.erectpine.mybootdemo.common.enums.CodeMsgEnum;
import cn.erectpine.mybootdemo.common.enums.LogTypeEnum;
import cn.erectpine.mybootdemo.common.util.IpUtils;
import cn.erectpine.mybootdemo.common.util.ServletUtils;
import cn.erectpine.mybootdemo.common.web.ApiLog;
import cn.erectpine.mybootdemo.common.web.ResponseTemplate;
import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
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
        ApiLog apiLog = new ApiLog();
        apiLog.setRequestData(JSON.toJSONString(joinPoint.getArgs()));
        
        Object proceed = null;
        // 调用方法
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            // 记录异常日志
            apiLog.setStatus(CodeMsgEnum.FAIL.getCode())
                  .setResponseData(JSON.toJSONString(ResponseTemplate.error()))
                  .setErrorMessage(e.getMessage())
                  .setStacktrace(JSON.toJSONString(e, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
            throw e;
        } finally {
            HttpServletRequest request = ServletUtils.getRequest();
            if (apiLog.getResponseData() == null) {
                apiLog.setResponseData((JSON.toJSONString(proceed)));
            }
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            // 记录日志
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

//        boolean stacktraceLogRequired = Boolean.TRUE;
//        boolean requestLogRequired = Boolean.TRUE;
//        boolean responseLogRequired = Boolean.TRUE;

//        Class<?> clazz = joinPoint.getTarget().getClass();
//        String methodName = joinPoint.getSignature().getName();
//        Class<?>[] args = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
//        Method method = clazz.getMethod(methodName, args);
    
    // 日志过滤判断
//        if (method.isAnnotationPresent(LogIgnore.class)) {
//            LogIgnore logIgnore = method.getAnnotation(LogIgnore.class);
//            List<IgnoreLevelEnum> ignores = Arrays.asList(logIgnore.ignores());
//            if (ignores.contains(STACKTRACE)) {
//                stacktraceLogRequired = Boolean.FALSE;
//            }
//            if (ignores.contains(REQUEST)) {
//                requestLogRequired = Boolean.FALSE;
//            }
//            if (ignores.contains(RESPONSE)) {
//                responseLogRequired = Boolean.FALSE;
//            }
//            if (ignores.contains(ALL)) {
//                stacktraceLogRequired = Boolean.FALSE;
//                requestLogRequired = Boolean.FALSE;
//                responseLogRequired = Boolean.FALSE;
//            }
//        }

//        MDC.put(IS_LOG_STACKTRACE, String.valueOf(stacktraceLogRequired));
//        MDC.put(IS_LOG_REQUEST, String.valueOf(requestLogRequired));
//        MDC.put(IS_LOG_RESPONSE, String.valueOf(responseLogRequired));

//        // 记录日志参数
//        MDC.put(START_TIME_KEY, String.valueOf(System.currentTimeMillis()));
//        String invokeInterface = joinPoint.getSignature().getDeclaringType().getSimpleName() + "." +
//                                 joinPoint.getSignature().getName();
//        MDC.put(INVOKE_INTERFACE_KEY, invokeInterface);
//        MDC.put(AUTHORIZATION_KEY, request.getHeader("Authorization"));
//        MDC.put(REMOTE_IP_KEY, request.getRemoteAddr());
//        MDC.put(URL_KEY, request.getRequestURL().toString());
//        CurrentManager manager = ManagerUtils.manager(false);
//        String managerInfo = "管理员信息为空";
//        if (null != manager) {
//            managerInfo = manager.getManagerName()
//                          + "-" + manager.getAccount()
//                          + "-" + manager.getManagerId()
//                          + "-" + manager.getGroupCode()
//                          + "-" + manager.getEmail()
//                          + "-" + (1 == manager.getManagerType() ? "超级管理员" : "普通管理员");
//        }
//        MDC.put(MANAGER_INFO_KEY, managerInfo);
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            MDC.put(REQUEST_INFO_KEY, JSONArray.toJSONString(joinPoint.getArgs()));
//        } catch (Exception e) {
//            log.error("记录请求体日志异常");
//        }
//        // 业务逻辑处理
//        Object result = joinPoint.proceed();
//
//        // 记录处理结果
//        MDC.put(RESPONSE_INFO_KEY,
//            mapper.writeValueAsString(null == result ? HttpResult.success() : result));
//
//        // 打印日志
//        LogUtils.info();

//        return result;


}
