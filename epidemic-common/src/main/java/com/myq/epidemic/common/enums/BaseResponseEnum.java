package com.myq.epidemic.common.enums;

public interface BaseResponseEnum {
    //获取code
    public String  getCode();
    //获取描述
    public String getMessage();
    BaseResponseEnum getSuccess();
    public  String getDescriptionByCode(Integer code);
}
