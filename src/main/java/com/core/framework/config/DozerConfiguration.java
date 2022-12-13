package com.core.framework.config;


import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DozerConfiguration {

    @Value("classpath*:dozerMapping/**/*.xml")
    private Resource[] resources;


    public DozerConfiguration() {
    }

    @Bean()
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() throws Exception {
        DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        dozerBeanMapperFactoryBean.setMappingFiles(this.resources);
        return dozerBeanMapperFactoryBean;
    }
}