package com.myq.epidemic_sys.common.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public enum AIMMResponseEnum implements BaseResponseEnum {
    PAGE_SUC("200", "操作成功"),
    PAGE_ERR("300", "操作失败");
    // 以上是枚举的成员，必须先定义，而且使用分号结束
    private final String message;
    private final String code;

    AIMMResponseEnum(String code, String message) {
        this.message = message;
        this.code = code;
    }

    //获取code
    @Override
    public String  getCode() {
        return code;
    }

    //获取描述
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public BaseResponseEnum getSuccess() {
        return PAGE_SUC;
    }

    //返回json 详细描述
    public String getJsonString() {
        Map<String, Object> map = new HashMap<>();
        map.put(String.valueOf(code), message);
        return JSONObject.toJSONString(map);
    }

    //返回map 详细描述
    public Map DescriptionMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(String.valueOf(code), message);
        return map;
    }

    //根据code获取描述
    public  String getDescriptionByCode(Integer code) {
        AIMMResponseEnum[] values = AIMMResponseEnum.values();
        for (AIMMResponseEnum value : values) {
            if (value.code .equals(code) ) {
                return value.message;
            }
        }
        return null;
    }

}
