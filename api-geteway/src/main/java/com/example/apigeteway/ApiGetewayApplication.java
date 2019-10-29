package com.example.apigeteway;

import com.example.apigeteway.Filter.AccessFilter;
import com.example.apigeteway.Filter.ThrowExceptionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGetewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGetewayApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

//    @Bean
//    public ThrowExceptionFilter throwExceptionFilter() {
//        return new ThrowExceptionFilter();
//    }

    /**
     * 自定义路由映射规则
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
          "(?<name>^.+)-(?<version>v.+$)",
                "$(version)/$(name)"
        );
    }

}
