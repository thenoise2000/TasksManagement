package com.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Set;

@Slf4j
public class CustomException extends RuntimeException {

        
    private static final long serialVersionUID = -9034816190742716963L;
    
    @Getter
    private Set<ExceptionsError> errors;

    public CustomException() {
        super();
    }

    public CustomException(final String msg) {
        super(msg);
    }

    public CustomException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    private static String getMsg(final String tagging, final String[] args) {
        MessageSource messageSource = new ResourceBundleMessageSource();
        ((ResourceBundleMessageSource) messageSource).setDefaultEncoding("UTF-8");
        ((ResourceBundleMessageSource) messageSource).setBasename("messages/messages");
        return messageSource.getMessage(tagging, args, LocaleContextHolder.getLocale());
    }
}