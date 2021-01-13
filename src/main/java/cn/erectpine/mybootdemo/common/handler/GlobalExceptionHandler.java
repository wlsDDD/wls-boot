package cn.erectpine.mybootdemo.common.handler;

import cn.erectpine.mybootdemo.common.exception.BaseException;
import cn.erectpine.mybootdemo.common.web.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
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
    
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseTemplate caughtException(HttpServletRequest request, HttpServletResponse response, Throwable e) {
        
        if ((e instanceof BaseException)) {
            log.error("【全局异常拦截】BaseException", e);
            return ResponseTemplate.error(((BaseException) e).getCode(), e.getMessage());
        }
        
        if ((e instanceof RuntimeException)) {
            log.error("【全局异常拦截】RuntimeException", e);
            return ResponseTemplate.error(5000, e.getMessage());
        }
        
        if ((e instanceof SQLRecoverableException)) {
            log.error("【全局异常拦截】SQLRecoverableException", e);
            return ResponseTemplate.error(5001, "数据库连接超时!, 请稍后重试! " + e.getMessage());
        }
        
        log.error("【全局异常拦截】未知异常", e);
        return ResponseTemplate.error(5000, "服务器错误!, 请联系管理员! " + e);
    }
    
}
