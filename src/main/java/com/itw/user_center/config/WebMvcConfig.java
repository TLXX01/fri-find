package com.itw.user_center.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                //当**Credentials为true时，**Origin不能为星号，需为具体的ip地址【如果接口不带cookie,ip无需设成具体ip】
                //.allowedOrigins("http://localhost:8080", "http://127.0.0.1:8080", "http://127.0.0.1:8081", "http://localhost:5173")
                //"http://43.136.19.202:8080", "http://43.136.19.202:80","http://127.0.0.1:8080","http://127.0.0.1:80"
                .allowedOrigins("http://43.136.19.202:8080/*", "http://43.136.19.202:80/*","http://127.0.0.1:8080/","http://127.0.0.1:80/","http://43.136.19.202")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("*")
                //跨域允许时间
                .maxAge(3600);
    }



}
