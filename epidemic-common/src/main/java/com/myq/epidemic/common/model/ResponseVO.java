package com.myq.epidemic.common.model;


import com.myq.epidemic.common.enums.BaseResponseEnum;
import com.myq.epidemic.common.enums.PageResponseEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @描述:
 * @创建日期: 2021年11月26日 16:12
 */

public  class ResponseVO<T> implements Serializable
{
    protected String code;
    protected String message;
    protected T data;

    public ResponseVO() {
    }
   public static <T> ResponseVO<T> newInstance(BaseResponseEnum responseEnum, String message, T data) {
       return new ResponseVO<T>(responseEnum,message,data);
   }
    public static <T> ResponseVO<T> newInstance(BaseResponseEnum responseEnum) {
        return new ResponseVO<T>(responseEnum,null,null);
    }
    public static <T> ResponseVO<T> newInstance(BaseResponseEnum responseEnum, T data) {
        return new ResponseVO<T>(responseEnum,null,data);
    }

    public static <T> ResponseVO<T> success (T data) {
         ResponseVO<T > vo = new ResponseVO<>();
         vo.setCode(PageResponseEnum.PAGE_SUC.getCode());
         vo.setMessage(PageResponseEnum.PAGE_SUC.getMessage());
         vo.setData(data);
        return vo;
    }

    public static <T> ResponseVO<T> error (T data) {
        ResponseVO<T > vo = new ResponseVO<>();
        vo.setCode(PageResponseEnum.PAGE_ERR.getCode());
        vo.setMessage(PageResponseEnum.PAGE_ERR.getMessage());
        vo.setData(data);
        return vo;
    }


    public static <T> ResponseVO<T> error () {
        ResponseVO<T > vo = new ResponseVO<>();
        vo.setCode(PageResponseEnum.PAGE_ERR.getCode());
        vo.setMessage(PageResponseEnum.PAGE_ERR.getMessage());
        return vo;
    }


    public ResponseVO(BaseResponseEnum responseEnum, String message, T data)
    {
        super();
        this.code = responseEnum.getCode();
        if(StringUtils.isBlank(message)){
            this.message = responseEnum.getMessage();
        }else {
            this.message = message;
        }

        this.data = data;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }





}

