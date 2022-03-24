
package com.myq.epidemic_sys.setting.config;


import com.myq.epidemic_sys.common.enums.PageResponseEnum;
import com.myq.epidemic_sys.common.exception.BizException;
import com.myq.epidemic_sys.common.model.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Priority;


@ControllerAdvice
@ConditionalOnWebApplication
@Priority(1)
//@ConditionalOnMissingBean(GlobalExceptionHandler.class)
public class GlobalExceptionHandler {
   private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResponseVO<String> BizExceptionHandler(BizException ex) throws Exception {
        logger.error("BizException info:{}", ex);
        ResponseVO<String> r = new ResponseVO<>();
        r.setMessage(ex.getErrorMsg());
        r.setCode(ex.getErrorCode());
        r.setData(ex.getMessage());
        return r;
    }

/**
     * 不可预知异常捕获 :捕获exception异常
     *
     * @return
     */

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseVO<String> exception(Exception ex) {
        logger.error("[GlobalExceptionHandler][exceptionHandler] exception",ex);
        ResponseVO<String> r = new ResponseVO<>();
        r.setMessage(PageResponseEnum.PAGE_ERR.getMessage());
        r.setCode(PageResponseEnum.PAGE_ERR.getCode());
        r.setData(ex.getMessage());
        return r;
    }

}

