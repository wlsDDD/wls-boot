package cn.erectpine.mybootdemo.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目相关配置
 *
 * @Author wls
 * @Date 2021/1/12 15:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "wls")
public class ApplicationConfig {
    
    /**
     * 名称
     */
    private String  name;
    /**
     * 版本
     */
    private String  version;
    /**
     * 版权年份
     */
    private String  copyrightYear;
    /**
     * 获取ip地址开关
     */
    private boolean addressEnabled;
    
}
