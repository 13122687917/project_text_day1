package com.qt.springbootnew;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qt.pojo.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GloablExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GloablExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handlerException(Exception e){
        logger.error(e.getMessage());
        return  new ResultBean("success","当前服务器繁忙，请稍后再试");
    }
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException ex) throws JsonProcessingException {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        HashMap<String , String > map = new HashMap<>();
        for (FieldError error: fieldErrors ) {
            map.put(error.getField(),error.getDefaultMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return new ResultBean("success",objectMapper.writeValueAsString(map));
    }
}
