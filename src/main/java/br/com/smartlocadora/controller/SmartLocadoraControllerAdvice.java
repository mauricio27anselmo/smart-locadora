package br.com.smartlocadora.controller;

import br.com.smartlocadora.exception.NotFoundObjectException;
import br.com.smartlocadora.exception.SmartLocadoraErrors;
import br.com.smartlocadora.exception.BusinessRuleException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class SmartLocadoraControllerAdvice {

    @ResponseBody
    @ExceptionHandler(BusinessRuleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SmartLocadoraErrors handleBusinessException(BusinessRuleException ex){
        String errorMessage = ex.getMessage();
        return new SmartLocadoraErrors(errorMessage);
    }

    @ResponseBody
    @ExceptionHandler(NotFoundObjectException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public SmartLocadoraErrors handleNotFoundException(NotFoundObjectException ex){
        String errorMessage = ex.getMessage();
        return new SmartLocadoraErrors(errorMessage);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SmartLocadoraErrors handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<String> errorMessages = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return new SmartLocadoraErrors(errorMessages);
    }
}
