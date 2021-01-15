package cn.erectpine.mybootdemo.common.yml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

/**
 * 项目相关配置
 *
 * @Author wls
 * @Date 2021/1/12 15:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "wls")
public class WlsYml {
    
    /**
     * 服务名
     */
    private String  serviceName;
    /**
     * 版本
     */
    private String  version;
    /**
     * 版权年份
     */
    private String  copyrightYear;
    /**
     * 文件路径
     */
    private String  profile;
    /**
     * 获取ip地址开关
     */
    private boolean addressEnabled;
    /**
     * 日志文件地址
     */
    private String  logsPath;
    /**
     * 日志级别
     */
    private String  logLevel;
    
    private Map<String, String> demo;
    
    private ArrayList<String> demoArray;
    
    @Data
    static class Demo {
        private String demo1;
        private String demo2;
    }
    
}
