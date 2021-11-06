package com.api.persik.Configs;

import com.api.persik.Utils.Consts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

// Configuration for upload images to server
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {

    private static final long MAX_SIZE = 600000000;

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(MAX_SIZE);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("file:"+ Consts.FILE_STORAGE_ROOT+"/images/");
        super.addResourceHandlers(registry);
    }
}