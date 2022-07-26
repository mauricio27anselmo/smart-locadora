package br.com.smartlocadora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

import java.util.Locale;

public abstract class IServiceImpl {

    @Autowired
    @Qualifier("messageSource")
    protected MessageSource messageSource;

    protected String getMessage(String code){
        return messageSource.getMessage(code, null, Locale.getDefault());
    }
}
