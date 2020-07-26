package com.ihrm.common.exception;

import com.ihrm.common.entity.ResultCode;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ResultCode resultCode = ResultCode.SERVER_ERROR;

    public CommonException(){}

    public CommonException(ResultCode resultCode){
        super(resultCode.message());
        this.resultCode = resultCode;
    }
}
