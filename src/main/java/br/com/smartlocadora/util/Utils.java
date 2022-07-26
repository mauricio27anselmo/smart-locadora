package br.com.smartlocadora.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

import java.util.Locale;


public class Utils {
    private static Utils instance;

//    @Autowired
//    @Qualifier("messageSource")
//    private MessageSource messageSource;

    private Utils() {
    }

    public static synchronized Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

//    public String getMessageResource(String code) {
//        return messageSource.getMessage(code, null, Locale.getDefault());
//    }


}
