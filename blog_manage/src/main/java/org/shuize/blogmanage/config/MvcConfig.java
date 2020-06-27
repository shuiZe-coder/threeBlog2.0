package org.shuize.blogmanage.config;

import org.shuize.blogmanage.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MvcConfig implements WebMvcConfigurer {
    // 后台登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        interceptorRegistration.excludePathPatterns("/admin/login", "/admin/verify");
        interceptorRegistration.addPathPatterns("/admin/**");
    }
}
