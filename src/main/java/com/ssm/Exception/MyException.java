package com.ssm.Exception;

import com.ssm.entity.BizError;
import org.springframework.util.StringUtils;

public class MyException extends RuntimeException{

    private BizError bizError;
    private String message;

    public MyException(BizError bizError){
        super(bizError.getErrorMessage());
        this.bizError = bizError;
    }

    public MyException(BizError bizError,String message){
        super(StringUtils.isEmpty(bizError)?message:bizError.getErrorMessage());
        this.bizError=bizError;
        this.message=message;
    }

    public BizError getBizError() {
        return bizError;
    }

    public void setBizError(BizError bizError) {
        this.bizError = bizError;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
