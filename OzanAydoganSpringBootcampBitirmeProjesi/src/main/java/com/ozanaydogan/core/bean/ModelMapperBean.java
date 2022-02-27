package com.ozanaydogan.core.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {

    @Bean(name="modelMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
