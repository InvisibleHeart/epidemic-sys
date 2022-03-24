package com.myq.epidemic_sys.common.exception;

import com.myq.epidemic_sys.common.enums.BaseResponseEnum;
import com.myq.epidemic_sys.common.enums.PageResponseEnum;

public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public BizException() {
        super();
    }


    // 用指定的详细信息和原因构造一个新的异常
    public BizException(String message, Throwable cause){

        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public BizException(Throwable cause) {

        super(cause);
    }

    public BizException(BaseResponseEnum baseResponseEnum) {
        super(baseResponseEnum.getCode());
        this.errorCode = baseResponseEnum.getCode();
        this.errorMsg = baseResponseEnum.getMessage();
    }

    public BizException(BaseResponseEnum baseResponseEnum, Throwable cause) {
        super(baseResponseEnum.getCode(), cause);
        this.errorCode = baseResponseEnum.getCode();
        this.errorMsg = baseResponseEnum.getMessage();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorCode = PageResponseEnum.PAGE_ERR.getCode();
        this.errorMsg = PageResponseEnum.PAGE_ERR.getMessage();
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
