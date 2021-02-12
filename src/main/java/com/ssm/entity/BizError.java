package com.ssm.entity;


public enum BizError {
    SYSTEM_ERROR("000","系统异常"),
    INVALID_ERROR("001","非法参数"),
    NOT_AUTHRIOZED("002","未授权");

    //异常码
    private String errorCode;
    //异常信息
    private String errorMessage;

    private BizError(String errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
