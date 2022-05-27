package com.myq.epidemic.common.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 合成状态枚举
 */
public enum CreateVideoStatueEnum  {
    SUCCESS (1, "成功"),
    INIT (0, "未合成"),
    FAIL(-1, "失败"),
    DOING(2, "合成中");
    // 以上是枚举的成员，必须先定义，而且使用分号结束
    private final String message;
    private final Integer code;

    CreateVideoStatueEnum(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    //获取code
    public Integer  getCode() {
        return code;
    }

    //获取描述
    public String getMessage() {
        return message;
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
        CreateVideoStatueEnum[] values = CreateVideoStatueEnum.values();
        for (CreateVideoStatueEnum value : values) {
            if (value.code .equals(code) ) {
                return value.message;
            }
        }
        return null;
    }

}
