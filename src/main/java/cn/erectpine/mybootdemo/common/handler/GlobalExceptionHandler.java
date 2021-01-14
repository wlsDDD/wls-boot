package cn.erectpine.mybootdemo.common.handler;

import cn.erectpine.mybootdemo.common.exception.BaseException;
import cn.erectpine.mybootdemo.common.exception.BusinessException;
import cn.erectpine.mybootdemo.common.web.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLRecoverableException;

/**
 * 全局异常处理程序
 *
 * @author wls
 * @date 2021/01/13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @Value("${spring.profiles.active}")
    private String environment;
    
    private static final String DEV  = "dev";
    private static final String BETA = "beta";
    private static final String PROD = "prod";
    
    
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseTemplate caughtException(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        
        if ((e instanceof BusinessException)) {
            log.error("【全局异常拦截】业务类异常");
            return ResponseTemplate.error(((BaseException) e).getCode(), e.getMessage());
        }
        
        if ((e instanceof BaseException)) {
            log.error("【全局异常拦截】基础异常", e);
            return ResponseTemplate.error(((BaseException) e).getCode(), e.getMessage());
        }
        
        if ((e instanceof SQLRecoverableException)) {
            log.error("【全局异常拦截】SQLRecoverableException", e);
            return ResponseTemplate.error(5001, "数据库连接超时!, 请稍后重试! " + e.getMessage());
        }
        
        log.error("【全局异常拦截】 未定义拦截", e);
        if (PROD.equals(environment)) {
            return ResponseTemplate.error(500, "服务器繁忙!, 晴稍后重试! ");
        } else {
            return ResponseTemplate.error(500, "服务错误!, 请联系开发人员! " + e);
        }
    }
    
}
