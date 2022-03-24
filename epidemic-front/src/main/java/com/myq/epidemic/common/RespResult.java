package com.myq.epidemic.common;

public class RespResult {

    private Integer code = 0;
    private String errorMessage;
    private long count;
    private Object data;

    public void error(String errorMessage) {
        this.code = -1;
        this.errorMessage = errorMessage;
    }

    public void success(Object data) {
        this.data = data;
    }

    public void success(Object data, long count) {
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
