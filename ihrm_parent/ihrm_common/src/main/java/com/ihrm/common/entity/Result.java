package com.ihrm.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {

    private boolean success;    //是否成功
    private Integer code;       //返回码
    private String message;     //返回信息
    private Object data;        //返回数据

    public Result(ResultCode resultCode){
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
    }

    public Result(ResultCode resultCode, Object data){
        this.success = resultCode.success;
        this.code = resultCode.code;
        this.message = resultCode.message;
        this.data = data;
    }

    public Result(boolean success, Integer code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result ERROR(){
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }
}
