package com.ll.wagesmanager;


import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(formModelMethodArgumentResolver());
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(webLoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/static/**", // 静态文件
//                        // api 文档
//                        "/swagger*",
//                        "/swagger*/**",
//                        "/v2/**",
//                        // info
//                        "/info",
//                        "/health",
//                        "/refresh",
//                        "/config",
//                        "/jsjb*/**",
//                        "/brand**",
//                        "/carseries**",
//                        "/wxsc*/**",
//                        "/cms*/**",
//                        "/catalog/**"
//                );
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    public void addCorsMappings(CorsRegistry registry){
//        registry
//                .addMapping("/**")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .allowedHeaders("*");
//    }


//    @Bean
//    public FormModelMethodArgumentResolver formModelMethodArgumentResolver() {
//        return new FormModelMethodArgumentResolver();
//    }
//
//    @Bean
//    public WebLoginInterceptor webLoginInterceptor() {
//        return new WebLoginInterceptor();
//    }
}
