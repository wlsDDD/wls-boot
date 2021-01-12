package cn.erectpine.mybootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wls
 */
@SpringBootApplication
public class MyBootDemoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MyBootDemoApplication.class, args);
        System.err.println("启动完成!!");
    }
    
}
